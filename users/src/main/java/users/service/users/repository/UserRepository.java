package users.service.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.service.users.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
