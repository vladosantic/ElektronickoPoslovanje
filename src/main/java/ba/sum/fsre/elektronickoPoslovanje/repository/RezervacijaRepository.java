package ba.sum.fsre.elektronickoPoslovanje.repository;

import ba.sum.fsre.elektronickoPoslovanje.model.RezervacijaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezervacijaRepository extends JpaRepository<RezervacijaEntity, Integer> {

}
