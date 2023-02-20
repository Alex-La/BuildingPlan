package org.example.service;

import org.example.entity.Brigade;
import org.example.exception.EntityAlreadyExistException;
import org.example.exception.EntityNotFoundException;
import org.example.repository.IBrigadeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrigadeService implements IBrigadeService {

    @Autowired
    private IBrigadeRepo brigadeRepo;

    @Override
    public List<Brigade> getAllBrigades() {
        return (List<Brigade>) brigadeRepo.findAll();
    }

    @Override
    public Brigade createBrigade(Brigade brigade) throws EntityAlreadyExistException {
        if (brigadeRepo.findByTitle(brigade.getTitle()) != null) {
            throw new EntityAlreadyExistException("Бригада с таким именем уже существует");
        }
        return brigadeRepo.save(brigade);
    }

    @Override
    public Brigade getBrigade(Long id) throws EntityNotFoundException {
        Brigade brigade = brigadeRepo.findById(id).get();
        if (brigade == null) {
            throw new EntityNotFoundException("Бригада не найдена");
        } else {
            return brigade;
        }
    }

    @Override
    public Brigade getBrigade(String title) throws EntityNotFoundException {
        Brigade brigade = brigadeRepo.findByTitle(title);
        if (brigade == null) {
            throw new EntityNotFoundException("Бригада не найдена");
        } else {
            return brigade;
        }
    }

    @Override
    public String deleteBrigade(Long id) throws EntityNotFoundException {
        Brigade brigade = brigadeRepo.findById(id).get();
        String nameBrigade = brigade.getTitle();
        if (brigade == null) {
            throw new EntityNotFoundException("Бригада не найдена");
        } else {
            brigadeRepo.deleteById(id);
            return "Бригада " + nameBrigade + " удалена.";
        }
    }

    @Override
    public Brigade updateBrigade(Brigade brigade, Long id) throws EntityNotFoundException {

        return brigadeRepo.findById(id)
                .map(oldBrigade -> {
                    oldBrigade.setTitle(brigade.getTitle());
                    oldBrigade.setDescription(brigade.getDescription());
                    return brigadeRepo.save(oldBrigade);
                })
                .orElseThrow(() -> new EntityNotFoundException("Бригада не найдена"));
    }


}
