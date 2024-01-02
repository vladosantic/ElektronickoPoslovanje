package ba.sum.fsre.elektronickoPoslovanje.service;

import ba.sum.fsre.elektronickoPoslovanje.model.Vrsta;
import ba.sum.fsre.elektronickoPoslovanje.repository.VrstaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VrstaService {
    @Autowired
    private VrstaRepository vrstaRepository;

    public List<Vrsta> getAll() {
        return vrstaRepository.findAll();
    }
}
