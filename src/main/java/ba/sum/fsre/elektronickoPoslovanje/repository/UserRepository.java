package ba.sum.fsre.elektronickoPoslovanje.repository;


import ba.sum.fsre.elektronickoPoslovanje.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

}