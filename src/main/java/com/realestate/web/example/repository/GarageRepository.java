package com.realestate.web.example.repository;

import com.realestate.web.example.domain.Garage;
import org.springframework.data.repository.CrudRepository;

public interface GarageRepository extends CrudRepository<Garage, Long> {
}
