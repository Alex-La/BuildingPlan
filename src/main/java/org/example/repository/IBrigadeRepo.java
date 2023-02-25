package org.example.repository;

import org.example.entity.BrigadeEntity;
import org.springframework.data.repository.CrudRepository;

public interface IBrigadeRepo extends CrudRepository<BrigadeEntity, Long> {
    BrigadeEntity findByTitle(String title);
}
