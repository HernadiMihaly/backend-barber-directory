package hu.unideb.barbersdirectory.repository;

import hu.unideb.barbersdirectory.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

}
