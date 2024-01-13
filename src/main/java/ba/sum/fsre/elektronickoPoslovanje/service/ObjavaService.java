package ba.sum.fsre.elektronickoPoslovanje.service;

import ba.sum.fsre.elektronickoPoslovanje.dto.KomentarDto;
import ba.sum.fsre.elektronickoPoslovanje.dto.ObjavaDto;
import ba.sum.fsre.elektronickoPoslovanje.model.KomentarEntity;
import ba.sum.fsre.elektronickoPoslovanje.model.ObjavaEntity;
import ba.sum.fsre.elektronickoPoslovanje.repository.ObjavaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ObjavaService {
    private final ObjavaRepository objavaRepository;

    @Autowired
    public ObjavaService(ObjavaRepository objavaRepository) {
        this.objavaRepository = objavaRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<ObjavaDto> findAllDtos() {
        List<ObjavaEntity> objavaEntities = objavaRepository.findAll();
        return objavaEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<ObjavaDto> findDtoById(int id) {
        Optional<ObjavaEntity> objavaEntity = objavaRepository.findById(id);
        return objavaEntity.map(this::convertToDto);
    }

    private ObjavaDto convertToDto(ObjavaEntity objavaEntity) {
        ObjavaDto objavaDto = new ObjavaDto();
        objavaDto = modelMapper.map(objavaEntity, ObjavaDto.class);
        objavaDto.setImePrezime(objavaEntity.getKorisnikId().getName());
        objavaDto.setImeLokacije(objavaEntity.getLokacijaId().getNaziv());
        objavaDto.setImeZivotinje(objavaEntity.getZivotinjaId().getIme());
        
        return objavaDto;
    }


    public ObjavaEntity create(ObjavaEntity objava) {
        return objavaRepository.save(objava);
    }

    public List<ObjavaEntity> findAll() {
        List<ObjavaEntity> ObjavaEntitys = new ArrayList<>();
        objavaRepository.findAll().forEach(ObjavaEntitys::add);

        return ObjavaEntitys;
    }

    public Optional<ObjavaEntity> findById(int id) {
        return objavaRepository.findById(id);
    }

    public ObjavaDto update(ObjavaEntity ObjavaEntityToUpdate) {
        return convertToDto(objavaRepository.save(ObjavaEntityToUpdate));
    }

    public void delete(int id) {
        objavaRepository.deleteById(id);
    }
}
