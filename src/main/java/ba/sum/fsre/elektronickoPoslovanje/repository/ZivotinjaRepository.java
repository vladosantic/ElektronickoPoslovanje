package ba.sum.fsre.elektronickoPoslovanje.repository;

import ba.sum.fsre.elektronickoPoslovanje.model.ZivotinjaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZivotinjaRepository extends JpaRepository<ZivotinjaEntity, Integer> {
    
}
