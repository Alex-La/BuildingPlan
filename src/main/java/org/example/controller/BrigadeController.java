package org.example.controller;

import org.example.model.Brigade;
import org.example.service.BrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;;

@RestController
@RequestMapping("/brigade")
public class BrigadeController {

    @Autowired
    BrigadeService brigadeService;

    @GetMapping("/{id}")
    Brigade brigadeById(@PathVariable Long id){
        return brigadeService.getBrigadeById(id);
    }

    @GetMapping
    List<Brigade> brigades(){
        return brigadeService.getAllBrigades();
    }


    @PostMapping
    Long createBrigade(@RequestBody Brigade brigade){
        return brigadeService.createBrigade(brigade);
    }

    @DeleteMapping("/{id}")
    String deleteBrigade(@PathVariable Long id){
        return brigadeService.deleteBrigade(id);
    }
}
