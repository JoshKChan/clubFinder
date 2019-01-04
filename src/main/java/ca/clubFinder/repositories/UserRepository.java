package ca.clubFinder.repositories;

import ca.clubFinder.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

