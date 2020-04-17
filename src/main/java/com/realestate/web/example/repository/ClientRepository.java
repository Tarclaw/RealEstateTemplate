package com.realestate.web.example.repository;

import com.realestate.web.example.domain.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
