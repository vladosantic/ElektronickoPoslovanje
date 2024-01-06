package ba.sum.fsre.elektronickoPoslovanje.controller;

import ba.sum.fsre.elektronickoPoslovanje.dto.RoleDto;
import ba.sum.fsre.elektronickoPoslovanje.model.RoleEntity;
import ba.sum.fsre.elektronickoPoslovanje.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public RoleEntity createRole(@RequestBody RoleEntity role) {
        return roleService.create(role);
    }

    @GetMapping
    public List<RoleDto> getAllRoles() {
        return roleService.findAllDtos();
    }

    @GetMapping("/{id}")
    public Optional<RoleDto> getRoleById(@PathVariable Long id) {
        return roleService.findDtoById(id);
    }

    @PutMapping("/{id}")
    public RoleEntity updateRole(@PathVariable Long id, @RequestBody RoleEntity role) {
        return roleService.update(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.delete(id);
    }
}
