package com.example.Db_Client.DbClient.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Db_Client.DbClient.dto.ClientDTO;
import com.example.Db_Client.DbClient.entities.Client;
import com.example.Db_Client.DbClient.repositories.ClientRepository;
import com.example.Db_Client.DbClient.services.exceptions.ClientNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ClientNotFoundException("Cliente não cadastrado no banco de dados."));
		return new ClientDTO(entity);
	}
	
	
}
