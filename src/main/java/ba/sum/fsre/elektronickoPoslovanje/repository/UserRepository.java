package ba.sum.fsre.elektronickoPoslovanje.repository;


import ba.sum.fsre.elektronickoPoslovanje.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}