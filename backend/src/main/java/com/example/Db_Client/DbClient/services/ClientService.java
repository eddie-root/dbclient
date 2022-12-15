package com.example.Db_Client.DbClient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Db_Client.DbClient.entities.Client;
import com.example.Db_Client.DbClient.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository client;

	
	public List<Client> findAll(){
		return client.findAll();
	}
}
