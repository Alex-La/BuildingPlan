package org.example.controller;

import org.example.entity.BrigadeEntity;
import org.example.exception.EntityAlreadyExistException;
import org.example.exception.EntityNotFoundException;
import org.example.service.BrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

;

@RestController
@RequestMapping("/brigade")
public class BrigadeController {

    @Autowired
    BrigadeService brigadeService;

    @GetMapping(params = {"id"})
    public ResponseEntity brigadeById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(brigadeService.getBrigade(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping(params = {"title"})
    public ResponseEntity brigadeByTitle(@RequestParam String title) {
        try {
            return ResponseEntity.ok(brigadeService.getBrigade(title));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity allBrigades() {
        try {
            return ResponseEntity.ok(brigadeService.getAllBrigades());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


    @PostMapping
    public ResponseEntity createBrigade(@RequestBody BrigadeEntity brigade) {
        try {
            brigadeService.createBrigade(brigade);
            return ResponseEntity.ok().body("Бригада добавлена");
        } catch (EntityAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBrigade(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(brigadeService.deleteBrigade(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBrigade(@RequestBody BrigadeEntity brigade, @PathVariable Long id) {
        try {
            brigadeService.updateBrigade(brigade, id);
            return ResponseEntity.ok().body("Бригада обновлена");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
