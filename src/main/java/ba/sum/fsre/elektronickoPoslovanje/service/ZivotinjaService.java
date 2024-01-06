package ba.sum.fsre.elektronickoPoslovanje.service;

import ba.sum.fsre.elektronickoPoslovanje.dto.ZivotinjaDto;
import ba.sum.fsre.elektronickoPoslovanje.model.ZivotinjaEntity;
import ba.sum.fsre.elektronickoPoslovanje.repository.ZivotinjaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ZivotinjaService {
    private final ZivotinjaRepository zivotinjaRepository;

    @Autowired
    public ZivotinjaService(ZivotinjaRepository zivotinjaRepository) {
        this.zivotinjaRepository = zivotinjaRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<ZivotinjaDto> findAllDtos() {
        List<ZivotinjaEntity> zivotinjaEntities = zivotinjaRepository.findAll();
        return zivotinjaEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<ZivotinjaDto> findDtoById(int id) {
        Optional<ZivotinjaEntity> zivotinjaEntity = zivotinjaRepository.findById(id);
        return zivotinjaEntity.map(this::convertToDto);
    }

    private ZivotinjaDto convertToDto(ZivotinjaEntity zivotinjaEntity) {
        ZivotinjaDto zivotinjaDto = new ZivotinjaDto();
        zivotinjaDto = modelMapper.map(zivotinjaEntity, ZivotinjaDto.class);
        zivotinjaDto.setNazivVrste(zivotinjaEntity.getVrstaId().getNazivVrste());

        return zivotinjaDto;
    }


    public ZivotinjaEntity create(ZivotinjaEntity zivotinja) {
        return zivotinjaRepository.save(zivotinja);
    }

    public List<ZivotinjaEntity> findAll() {
        List<ZivotinjaEntity> ZivotinjaEntitys = new ArrayList<>();
        zivotinjaRepository.findAll().forEach(ZivotinjaEntitys::add);

        return ZivotinjaEntitys;
    }

    public Optional<ZivotinjaEntity> findById(int id) {
        return zivotinjaRepository.findById(id);
    }

    public ZivotinjaEntity update(ZivotinjaEntity ZivotinjaEntityToUpdate) {
        return zivotinjaRepository.save(ZivotinjaEntityToUpdate);
    }

    public void delete(int id) {
        zivotinjaRepository.deleteById(id);
    }
}
