package ba.sum.fsre.elektronickoPoslovanje.controller;

import ba.sum.fsre.elektronickoPoslovanje.model.Vrsta;
import ba.sum.fsre.elektronickoPoslovanje.service.VrstaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vrsta")
public class VrstaController {
    @Autowired
    private VrstaService vrstaService;

    @GetMapping
    public List<Vrsta> findAll() {
        return vrstaService.getAll();
    }
}

