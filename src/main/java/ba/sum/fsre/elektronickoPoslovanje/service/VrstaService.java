package ba.sum.fsre.elektronickoPoslovanje.service;

import ba.sum.fsre.elektronickoPoslovanje.model.VrstaEntity;
import ba.sum.fsre.elektronickoPoslovanje.repository.VrstaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VrstaService {
    private final VrstaRepository vrstaRepository;

    @Autowired
    public VrstaService(VrstaRepository vrstaRepository) {
        this.vrstaRepository = vrstaRepository;
    }

    public VrstaEntity create(VrstaEntity vrsta) {
        return vrstaRepository.save(vrsta);
    }

    public List<VrstaEntity> findAll() {
        List<VrstaEntity> VrstaEntitys = new ArrayList<>();
        vrstaRepository.findAll().forEach(VrstaEntitys::add);

        return VrstaEntitys;
    }

    public Optional<VrstaEntity> findById(int id) {
        return vrstaRepository.findById(id);
    }

    public VrstaEntity update(VrstaEntity VrstaEntityToUpdate) {
        return vrstaRepository.save(VrstaEntityToUpdate);
    }

    public void delete(int id) {
        vrstaRepository.deleteById(id);
    }
}
