package ba.sum.fsre.elektronickoPoslovanje.controller;

import ba.sum.fsre.elektronickoPoslovanje.model.VrstaEntity;
import ba.sum.fsre.elektronickoPoslovanje.service.VrstaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vrsta")
public class VrstaController {
    @Autowired
    private VrstaService vrstaService;

    @PostMapping
    public VrstaEntity createUser(@RequestBody VrstaEntity vrsta) {
        return vrstaService.create(vrsta);
    }

    @GetMapping
    public List<VrstaEntity> getAllVrstas() {
        return vrstaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<VrstaEntity> getVrstaById(@PathVariable Integer id) {
        return vrstaService.findById(id);
    }

    @PutMapping("/{id}")
    public VrstaEntity updateUser(@PathVariable Integer id, @RequestBody VrstaEntity vrsta) {
        return vrstaService.update(vrsta);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        vrstaService.delete(id);
    }
}
