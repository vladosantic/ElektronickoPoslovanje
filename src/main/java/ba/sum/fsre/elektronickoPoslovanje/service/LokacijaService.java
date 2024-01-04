package ba.sum.fsre.elektronickoPoslovanje.service;

import ba.sum.fsre.elektronickoPoslovanje.model.LokacijaEntity;
import ba.sum.fsre.elektronickoPoslovanje.repository.LokacijaRepository;
import ba.sum.fsre.elektronickoPoslovanje.repository.VrstaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LokacijaService {
    private final LokacijaRepository lokacijaRepository;

    @Autowired
    public LokacijaService(LokacijaRepository lokacijaRepository) {
        this.lokacijaRepository = lokacijaRepository;
    }

    public LokacijaEntity create(LokacijaEntity lokacija) {
        return lokacijaRepository.save(lokacija);
    }

    public List<LokacijaEntity> findAll() {
        List<LokacijaEntity> LokacijaEntitys = new ArrayList<>();
        lokacijaRepository.findAll().forEach(LokacijaEntitys::add);

        return LokacijaEntitys;
    }

    public Optional<LokacijaEntity> findById(int id) {
        return lokacijaRepository.findById(id);
    }

    public LokacijaEntity update(LokacijaEntity LokacijaEntityToUpdate) {
        return lokacijaRepository.save(LokacijaEntityToUpdate);
    }

    public void delete(int id) {
        lokacijaRepository.deleteById(id);
    }
}
