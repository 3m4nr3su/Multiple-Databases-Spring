package hodi.karibu.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hodi.karibu.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
