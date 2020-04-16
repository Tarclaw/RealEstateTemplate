package com.realestate.web.example.repository;

import com.realestate.web.example.domain.Facility;
import org.springframework.data.repository.CrudRepository;

public interface FacilityRepository extends CrudRepository<Facility, Long> {
}
