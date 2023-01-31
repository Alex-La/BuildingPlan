package org.example.service;

import org.example.model.Brigade;
import org.example.repository.IBrigadeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//что угодно

@Service
public class BrigadeService implements IBrigadeService {

    @Autowired
    private IBrigadeRepo brigadeRepo;
    
    @Override
    public List<Brigade> getAllBrigades(){
        return (List<Brigade>) brigadeRepo.findAll();
    }

    @Override
    public Long createBrigade(Brigade brigade) {
        return brigadeRepo.save(brigade).getId();
    }

    @Override
    public Brigade getBrigadeById(Long id) {
        return brigadeRepo.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public String deleteBrigade(Long id) {
        brigadeRepo.deleteById(id);
        return "Пользователь удалён";
    }
}
