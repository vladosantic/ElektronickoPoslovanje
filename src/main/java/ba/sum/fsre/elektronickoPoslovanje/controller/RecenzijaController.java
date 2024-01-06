package ba.sum.fsre.elektronickoPoslovanje.controller;

import ba.sum.fsre.elektronickoPoslovanje.dto.RecenzijaDto;
import ba.sum.fsre.elektronickoPoslovanje.model.RecenzijaEntity;
import ba.sum.fsre.elektronickoPoslovanje.service.RecenzijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recenzija")
public class RecenzijaController {

    @Autowired
    private RecenzijaService recenzijaService;

    @PostMapping
    public RecenzijaEntity createRecenzija(@RequestBody RecenzijaEntity recenzija) {
        return recenzijaService.create(recenzija);
    }

    @GetMapping
    public List<RecenzijaDto> getAllRecenzijas() {
        return recenzijaService.findAllDtos();
    }

    @GetMapping("/{id}")
    public Optional<RecenzijaDto> getRecenzijaById(@PathVariable Integer id) {
        return recenzijaService.findDtoById(id);
    }

    @PutMapping("/{id}")
    public RecenzijaEntity updateRecenzija(@PathVariable Integer id, @RequestBody RecenzijaEntity recenzija) {
        return recenzijaService.update(recenzija);
    }

    @DeleteMapping("/{id}")
    public void deleteRecenzija(@PathVariable Integer id) {
        recenzijaService.delete(id);
    }
}
