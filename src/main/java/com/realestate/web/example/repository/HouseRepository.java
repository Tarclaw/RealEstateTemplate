package com.realestate.web.example.repository;

import com.realestate.web.example.domain.House;
import org.springframework.data.repository.CrudRepository;

public interface HouseRepository extends CrudRepository<House, Long> {
}
