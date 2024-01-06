package ba.sum.fsre.elektronickoPoslovanje.controller;


import ba.sum.fsre.elektronickoPoslovanje.dto.ZivotinjaDto;
import ba.sum.fsre.elektronickoPoslovanje.model.ZivotinjaEntity;
import ba.sum.fsre.elektronickoPoslovanje.service.ZivotinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/zivotinja")
public class ZivotinjaController {

    @Autowired
    private ZivotinjaService zivotinjaService;

    @PostMapping
    public ZivotinjaEntity createZivotinja(@RequestBody ZivotinjaEntity zivotinja) {
        return zivotinjaService.create(zivotinja);
    }

    @GetMapping
    public List<ZivotinjaDto> getAllZivotinjas() {
        return zivotinjaService.findAllDtos();
    }

    @GetMapping("/{id}")
    public Optional<ZivotinjaDto> getZivotinjaById(@PathVariable Integer id) {
        return zivotinjaService.findDtoById(id);
    }

    @PutMapping("/{id}")
    public ZivotinjaEntity updateZivotinja(@PathVariable Integer id, @RequestBody ZivotinjaEntity zivotinja) {
        return zivotinjaService.update(zivotinja);
    }

    @DeleteMapping("/{id}")
    public void deleteZivotinja(@PathVariable Integer id) {
        zivotinjaService.delete(id);
    }
}
