package ba.sum.fsre.elektronickoPoslovanje.repository;

import ba.sum.fsre.elektronickoPoslovanje.model.Vrsta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VrstaRepository extends JpaRepository<Vrsta, Integer> {
}
