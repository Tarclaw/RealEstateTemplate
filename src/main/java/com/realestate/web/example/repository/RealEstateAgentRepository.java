package com.realestate.web.example.repository;

import com.realestate.web.example.domain.RealEstateAgent;
import org.springframework.data.repository.CrudRepository;

public interface RealEstateAgentRepository extends CrudRepository<RealEstateAgent, Long> {
}
