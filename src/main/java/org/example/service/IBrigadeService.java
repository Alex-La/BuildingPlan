package org.example.service;

import org.example.entity.BrigadeEntity;
import org.example.exception.EntityAlreadyExistException;
import org.example.exception.EntityNotFoundException;
import org.example.model.Brigade;

import java.util.List;

public interface IBrigadeService {
    List<Brigade> getAllBrigades();

    Brigade createBrigade(BrigadeEntity brigade) throws EntityAlreadyExistException;

    Brigade getBrigade(Long id) throws EntityNotFoundException;

    Brigade getBrigade(String title) throws EntityNotFoundException;

    String deleteBrigade(Long id) throws EntityNotFoundException;

    BrigadeEntity updateBrigade(BrigadeEntity brigade, Long id) throws EntityNotFoundException;
}
