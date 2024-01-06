package ba.sum.fsre.elektronickoPoslovanje.repository;

import ba.sum.fsre.elektronickoPoslovanje.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByName(String name);
}
