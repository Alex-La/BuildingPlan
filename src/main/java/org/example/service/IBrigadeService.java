package org.example.service;

import org.example.entity.Brigade;
import org.example.exception.EntityAlreadyExistException;
import org.example.exception.EntityNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IBrigadeService {
    List<Brigade> getAllBrigades();

    Brigade createBrigade(Brigade brigade) throws EntityAlreadyExistException;

    Brigade getBrigade(Long id) throws EntityNotFoundException;

    Brigade getBrigade(String title) throws EntityNotFoundException;

    String deleteBrigade(Long id) throws EntityNotFoundException;

    Brigade updateBrigade(Brigade brigade, Long id) throws EntityNotFoundException;
}
