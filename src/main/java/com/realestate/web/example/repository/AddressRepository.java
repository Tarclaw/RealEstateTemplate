package com.realestate.web.example.repository;

import com.realestate.web.example.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
