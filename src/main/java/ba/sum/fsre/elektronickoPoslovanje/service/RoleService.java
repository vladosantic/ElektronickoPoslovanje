package ba.sum.fsre.elektronickoPoslovanje.service;

import ba.sum.fsre.elektronickoPoslovanje.dto.RoleDto;
import ba.sum.fsre.elektronickoPoslovanje.model.RoleEntity;
import ba.sum.fsre.elektronickoPoslovanje.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<RoleDto> findAllDtos() {
        List<RoleEntity> roleEntities = roleRepository.findAll();
        return roleEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<RoleDto> findDtoById(Long id) {
        Optional<RoleEntity> roleEntity = roleRepository.findById(id);
        return roleEntity.map(this::convertToDto);
    }

    private RoleDto convertToDto(RoleEntity roleEntity) {
        return modelMapper.map(roleEntity, RoleDto.class);
    }


    public RoleEntity create(RoleEntity role) {
        return roleRepository.save(role);
    }

    public List<RoleEntity> findAll() {
        List<RoleEntity> RoleEntitys = new ArrayList<>();
        roleRepository.findAll().forEach(RoleEntitys::add);

        return RoleEntitys;
    }

    public Optional<RoleEntity> findById(Long id) {
        return roleRepository.findById(id);
    }

    public RoleEntity update(RoleEntity RoleEntityToUpdate) {
        return roleRepository.save(RoleEntityToUpdate);
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
