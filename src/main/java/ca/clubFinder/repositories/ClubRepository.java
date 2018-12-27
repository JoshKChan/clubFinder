package ca.clubFinder.repositories;

import ca.clubFinder.club.Club;
import org.springframework.data.repository.CrudRepository;

public interface ClubRepository extends CrudRepository<Club, Long> {
}
