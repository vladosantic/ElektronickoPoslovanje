package ba.sum.fsre.elektronickoPoslovanje.controller;

import ba.sum.fsre.elektronickoPoslovanje.model.LokacijaEntity;
import ba.sum.fsre.elektronickoPoslovanje.service.LokacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lokacija")
public class LokacijaController {
    @Autowired
    private LokacijaService lokacijaService;

    @PostMapping
    public LokacijaEntity createLokacija(@RequestBody LokacijaEntity lokacija) {
        return lokacijaService.create(lokacija);
    }

    @GetMapping
    public List<LokacijaEntity> getAllLokacijas() {
        return lokacijaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<LokacijaEntity> getLokacijaById(@PathVariable Integer id) {
        return lokacijaService.findById(id);
    }

    @PutMapping("/{id}")
    public LokacijaEntity updateLokacija(@PathVariable Integer id, @RequestBody LokacijaEntity lokacija) {
        return lokacijaService.update(lokacija);
    }

    @DeleteMapping("/{id}")
    public void deleteLokacija(@PathVariable Integer id) {
        lokacijaService.delete(id);
    }
}
