package com.example.Db_Client.DbClient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Db_Client.DbClient.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
