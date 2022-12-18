package com.example.Db_Client.DbClient.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Db_Client.DbClient.dto.ClientDTO;
import com.example.Db_Client.DbClient.entities.Client;
import com.example.Db_Client.DbClient.repositories.ClientRepository;
import com.example.Db_Client.DbClient.services.exceptions.ClientNotFoundException;
import com.example.Db_Client.DbClient.services.exceptions.DatabaseException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ClientNotFoundException("Cliente não cadastrado no banco de dados."));
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client cli = new Client();
		cli.setName(dto.getName());
		cli.setCpf(dto.getCpf());
		cli.setIncome(dto.getIncome());
		cli.setChildren(dto.getChildren());
		cli.setBirthDate(dto.getBirthDate());
		cli = repository.save(cli);
		return new ClientDTO(cli);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
				Client cli = repository.getReferenceById(id);
				cli.setName(dto.getName());
				cli.setCpf(dto.getCpf());
				cli.setIncome(dto.getIncome());
				cli.setChildren(dto.getChildren());
				cli.setBirthDate(dto.getBirthDate());
				cli = repository.save(cli);
				return new ClientDTO(cli);			
		}
		catch (EntityNotFoundException e) {
			throw new ClientNotFoundException("Id inválido ou nao encontrado: " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ClientNotFoundException("Id inválido ou nao encontrado: " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}		
	}
	
	
}
