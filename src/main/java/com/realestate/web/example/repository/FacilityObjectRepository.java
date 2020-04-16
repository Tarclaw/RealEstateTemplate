package com.realestate.web.example.repository;

import com.realestate.web.example.domain.FacilityObject;
import org.springframework.data.repository.CrudRepository;

public interface FacilityObjectRepository extends CrudRepository<FacilityObject, Long> {
}
