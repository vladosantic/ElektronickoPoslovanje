package ba.sum.fsre.elektronickoPoslovanje.service;

import ba.sum.fsre.elektronickoPoslovanje.dto.KomentarDto;
import ba.sum.fsre.elektronickoPoslovanje.model.KomentarEntity;
import ba.sum.fsre.elektronickoPoslovanje.repository.KomentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KomentarService {
    private final KomentarRepository komentarRepository;

    @Autowired
    public KomentarService(KomentarRepository komentarRepository) {
        this.komentarRepository = komentarRepository;
    }

    public List<KomentarDto> findAllDtos() {
        List<KomentarEntity> komentarEntities = komentarRepository.findAll();
        return komentarEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<KomentarDto> findDtoById(int id) {
        Optional<KomentarEntity> komentarEntity = komentarRepository.findById(id);
        return komentarEntity.map(this::convertToDto);
    }

    private KomentarDto convertToDto(KomentarEntity komentarEntity) {
        KomentarDto komentarDto = new KomentarDto();
        komentarDto.setId(komentarEntity.getId());
        komentarDto.setTekstKomentara(komentarEntity.getTekstKomentara());
        komentarDto.setDatumKomentara(komentarEntity.getDatumKomentara());
        komentarDto.setKorisnikId(komentarEntity.getKorisnikId().getId());
        komentarDto.setObjavaId(komentarEntity.getObjavaId().getId());
        return komentarDto;
    }


    public KomentarEntity create(KomentarEntity komentar) {
        return komentarRepository.save(komentar);
    }

    public List<KomentarEntity> findAll() {
        List<KomentarEntity> KomentarEntitys = new ArrayList<>();
        komentarRepository.findAll().forEach(KomentarEntitys::add);

        return KomentarEntitys;
    }

    public Optional<KomentarEntity> findById(int id) {
        return komentarRepository.findById(id);
    }

    public KomentarEntity update(KomentarEntity KomentarEntityToUpdate) {
        return komentarRepository.save(KomentarEntityToUpdate);
    }

    public void delete(int id) {
        komentarRepository.deleteById(id);
    }
}
