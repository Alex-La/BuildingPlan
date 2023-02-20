package org.example.repository;

import org.example.entity.Brigade;
import org.springframework.data.repository.CrudRepository;

public interface IBrigadeRepo extends CrudRepository<Brigade, Long> {
    Brigade findByTitle(String title);
}
