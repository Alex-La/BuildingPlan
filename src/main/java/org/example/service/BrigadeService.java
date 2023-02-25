package org.example.service;

import org.example.entity.BrigadeEntity;
import org.example.exception.EntityAlreadyExistException;
import org.example.exception.EntityNotFoundException;
import org.example.model.Brigade;
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
        return (List<Brigade>) Brigade.toModel((BrigadeEntity) brigadeRepo.findAll());
    }

    @Override
    public Brigade createBrigade(BrigadeEntity brigade) throws EntityAlreadyExistException {
        if (brigadeRepo.findByTitle(brigade.getTitle()) != null) {
            throw new EntityAlreadyExistException("Бригада с таким именем уже существует");
        }
        return Brigade.toModel(brigadeRepo.save(brigade));
    }

    @Override
    public Brigade getBrigade(Long id) throws EntityNotFoundException {
        BrigadeEntity brigade = brigadeRepo.findById(id).get();
        if (brigade == null) {
            throw new EntityNotFoundException("Бригада не найдена");
        } else {
            return Brigade.toModel(brigade);
        }
    }

    @Override
    public Brigade getBrigade(String title) throws EntityNotFoundException {
        BrigadeEntity brigade = brigadeRepo.findByTitle(title);
        if (brigade == null) {
            throw new EntityNotFoundException("Бригада не найдена");
        } else {
            return Brigade.toModel(brigade);
        }
    }

    @Override
    public String deleteBrigade(Long id) throws EntityNotFoundException {
        BrigadeEntity brigade = brigadeRepo.findById(id).get();
        String nameBrigade = brigade.getTitle();
        if (brigade == null) {
            throw new EntityNotFoundException("Бригада не найдена");
        } else {
            brigadeRepo.deleteById(id);
            return "Бригада " + nameBrigade + " удалена.";
        }
    }

    @Override
    public BrigadeEntity updateBrigade(BrigadeEntity brigade, Long id) throws EntityNotFoundException {

        return brigadeRepo.findById(id)
                .map(oldBrigade -> {
                    oldBrigade.setTitle(brigade.getTitle());
                    oldBrigade.setDescription(brigade.getDescription());
                    return brigadeRepo.save(oldBrigade);
                })
                .orElseThrow(() -> new EntityNotFoundException("Бригада не найдена"));
    }


}
