package ba.sum.fsre.elektronickoPoslovanje.repository;

import ba.sum.fsre.elektronickoPoslovanje.model.KomentarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KomentarRepository extends JpaRepository<KomentarEntity, Integer> {

}
