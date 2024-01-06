package ba.sum.fsre.elektronickoPoslovanje.controller;

import ba.sum.fsre.elektronickoPoslovanje.dto.RezervacijaDto;
import ba.sum.fsre.elektronickoPoslovanje.model.RezervacijaEntity;
import ba.sum.fsre.elektronickoPoslovanje.service.RezervacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rezervacija")
public class RezervacijaController {

    @Autowired
    private RezervacijaService rezervacijaService;

    @PostMapping
    public RezervacijaEntity createRezervacija(@RequestBody RezervacijaEntity rezervacija) {
        return rezervacijaService.create(rezervacija);
    }

    @GetMapping
    public List<RezervacijaDto> getAllRezervacijas() {
        return rezervacijaService.findAllDtos();
    }

    @GetMapping("/{id}")
    public Optional<RezervacijaDto> getRezervacijaById(@PathVariable Integer id) {
        return rezervacijaService.findDtoById(id);
    }

    @PutMapping("/{id}")
    public RezervacijaEntity updateRezervacija(@PathVariable Integer id, @RequestBody RezervacijaEntity rezervacija) {
        return rezervacijaService.update(rezervacija);
    }

    @DeleteMapping("/{id}")
    public void deleteRezervacija(@PathVariable Integer id) {
        rezervacijaService.delete(id);
    }
}
