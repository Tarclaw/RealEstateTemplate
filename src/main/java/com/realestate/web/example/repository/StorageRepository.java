package com.realestate.web.example.repository;

import com.realestate.web.example.domain.Storage;
import org.springframework.data.repository.CrudRepository;

public interface StorageRepository extends CrudRepository<Storage, Long> {
}
