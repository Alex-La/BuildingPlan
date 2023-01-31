package org.example.service;

import org.example.model.Brigade;

import java.util.List;

public interface IBrigadeService {
    List<Brigade> getAllBrigades();
    Long createBrigade(Brigade brigade);
    Brigade getBrigadeById(Long id);
    String deleteBrigade(Long id);

}
