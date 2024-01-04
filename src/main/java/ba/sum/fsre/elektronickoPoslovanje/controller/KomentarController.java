package ba.sum.fsre.elektronickoPoslovanje.controller;

import ba.sum.fsre.elektronickoPoslovanje.dto.KomentarDto;
import ba.sum.fsre.elektronickoPoslovanje.model.KomentarEntity;
import ba.sum.fsre.elektronickoPoslovanje.service.KomentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/komentar")
public class KomentarController {

    @Autowired
    private KomentarService komentarService;

    @PostMapping
    public KomentarEntity createKomentar(@RequestBody KomentarEntity komentar) {
        return komentarService.create(komentar);
    }

    @GetMapping
    public List<KomentarDto> getAllKomentars() {
        return komentarService.findAllDtos();
    }

    @GetMapping("/{id}")
    public Optional<KomentarDto> getKomentarById(@PathVariable Integer id) {
        return komentarService.findDtoById(id);
}

    @PutMapping("/{id}")
    public KomentarEntity updateKomentar(@PathVariable Integer id, @RequestBody KomentarEntity komentar) {
        return komentarService.update(komentar);
    }

    @DeleteMapping("/{id}")
    public void deleteKomentar(@PathVariable Integer id) {
        komentarService.delete(id);
    }
}
