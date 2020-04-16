package com.realestate.web.example.repository;

import com.realestate.web.example.domain.Apartment;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository extends CrudRepository<Apartment, Long> {
}
