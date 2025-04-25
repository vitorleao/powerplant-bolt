package dev.bolt.powerplant.controller;

import dev.bolt.powerplant.model.Usina;
import dev.bolt.powerplant.repository.UsinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usinas")
public class UsinaController {

    @Autowired
    private UsinaRepository repository;

    @GetMapping("/top5")
    public List<Usina> getTop5Usinas() {
        return repository.findTop5ByPotencia();
    }
}