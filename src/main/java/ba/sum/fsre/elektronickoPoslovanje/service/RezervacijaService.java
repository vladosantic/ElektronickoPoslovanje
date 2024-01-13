package ba.sum.fsre.elektronickoPoslovanje.service;

import ba.sum.fsre.elektronickoPoslovanje.dto.RezervacijaDto;
import ba.sum.fsre.elektronickoPoslovanje.model.RezervacijaEntity;
import ba.sum.fsre.elektronickoPoslovanje.repository.RezervacijaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RezervacijaService {
    private final RezervacijaRepository rezervacijaRepository;

    @Autowired
    public RezervacijaService(RezervacijaRepository rezervacijaRepository) {
        this.rezervacijaRepository = rezervacijaRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<RezervacijaDto> findAllDtos() {
        List<RezervacijaEntity> rezervacijaEntities = rezervacijaRepository.findAll();
        return rezervacijaEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<RezervacijaDto> findDtoById(int id) {
        Optional<RezervacijaEntity> rezervacijaEntity = rezervacijaRepository.findById(id);
        return rezervacijaEntity.map(this::convertToDto);
    }

    private RezervacijaDto convertToDto(RezervacijaEntity rezervacijaEntity) {
        RezervacijaDto rezervacijaDto = new RezervacijaDto();
        rezervacijaDto = modelMapper.map(rezervacijaEntity, RezervacijaDto.class);
        rezervacijaDto.setKorisnikSkrbnikId(rezervacijaEntity.getKorisnik_skrbnik_id().getId());
        rezervacijaDto.setKorisnikUdomiteljId(rezervacijaEntity.getKorisnik_udomitelj_id().getId());
        rezervacijaDto.setImeSkrbnika(rezervacijaEntity.getKorisnik_skrbnik_id().getName());
        rezervacijaDto.setImeUdomitelja(rezervacijaEntity.getKorisnik_udomitelj_id().getName());
        rezervacijaDto.setImeZivotinje(rezervacijaEntity.getZivotinjaId().getIme());

        return rezervacijaDto;
    }


    public RezervacijaEntity create(RezervacijaEntity rezervacija) {
        return rezervacijaRepository.save(rezervacija);
    }

    public List<RezervacijaEntity> findAll() {
        List<RezervacijaEntity> RezervacijaEntitys = new ArrayList<>();
        rezervacijaRepository.findAll().forEach(RezervacijaEntitys::add);

        return RezervacijaEntitys;
    }

    public Optional<RezervacijaEntity> findById(int id) {
        return rezervacijaRepository.findById(id);
    }

    public RezervacijaDto update(RezervacijaEntity RezervacijaEntityToUpdate) {
        return convertToDto(rezervacijaRepository.save(RezervacijaEntityToUpdate));
    }

    public void delete(int id) {
        rezervacijaRepository.deleteById(id);
    }
}
