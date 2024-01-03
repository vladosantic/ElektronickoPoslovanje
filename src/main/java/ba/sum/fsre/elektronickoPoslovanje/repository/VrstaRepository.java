package ba.sum.fsre.elektronickoPoslovanje.repository;

import ba.sum.fsre.elektronickoPoslovanje.model.VrstaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VrstaRepository extends JpaRepository<VrstaEntity, Integer> {

}
