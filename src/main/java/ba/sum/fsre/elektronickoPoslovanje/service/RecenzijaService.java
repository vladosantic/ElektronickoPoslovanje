package ba.sum.fsre.elektronickoPoslovanje.service;

import ba.sum.fsre.elektronickoPoslovanje.dto.RecenzijaDto;
import ba.sum.fsre.elektronickoPoslovanje.model.RecenzijaEntity;
import ba.sum.fsre.elektronickoPoslovanje.repository.RecenzijaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecenzijaService {
    private final RecenzijaRepository recenzijaRepository;

    @Autowired
    public RecenzijaService(RecenzijaRepository recenzijaRepository) {
        this.recenzijaRepository = recenzijaRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<RecenzijaDto> findAllDtos() {
        List<RecenzijaEntity> recenzijaEntities = recenzijaRepository.findAll();
        return recenzijaEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<RecenzijaDto> findDtoById(int id) {
        Optional<RecenzijaEntity> recenzijaEntity = recenzijaRepository.findById(id);
        return recenzijaEntity.map(this::convertToDto);
    }

    private RecenzijaDto convertToDto(RecenzijaEntity recenzijaEntity) {
        RecenzijaDto recenzijaDto = new RecenzijaDto();
        recenzijaDto = modelMapper.map(recenzijaEntity, RecenzijaDto.class);
        recenzijaDto.setKorisnikRecezentId(recenzijaEntity.getKorisnik_recezent_id().getId());
        recenzijaDto.setImePrezimeRecezenta(recenzijaEntity.getKorisnik_recezent_id().getName());
        recenzijaDto.setImePrezime(recenzijaEntity.getKorisnik_id().getName());

        return recenzijaDto;
    }


    public RecenzijaEntity create(RecenzijaEntity recenzija) {
        return recenzijaRepository.save(recenzija);
    }

    public List<RecenzijaEntity> findAll() {
        List<RecenzijaEntity> RecenzijaEntitys = new ArrayList<>();
        recenzijaRepository.findAll().forEach(RecenzijaEntitys::add);

        return RecenzijaEntitys;
    }

    public Optional<RecenzijaEntity> findById(int id) {
        return recenzijaRepository.findById(id);
    }

    public RecenzijaDto update(RecenzijaEntity RecenzijaEntityToUpdate) {
        return convertToDto(recenzijaRepository.save(RecenzijaEntityToUpdate));
    }

    public void delete(int id) {
        recenzijaRepository.deleteById(id);
    }
}
