package ca.clubFinder.controllers;

import ca.clubFinder.user.User;
import ca.clubFinder.user.UserProperties;
import ca.clubFinder.club.Club;
import ca.clubFinder.club.ClubProperties;
import ca.clubFinder.event.ClubEvent;
import ca.clubFinder.repositories.ClubRepository;
import ca.clubFinder.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Slf4j
@RestController
public class ClubFinderController {

    @Autowired
    private ClubRepository clubRepository;
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/clubs")
    public Iterable<Club> clubs() {
        return clubRepository.findAll();
    }

    @PostMapping(path = "/clubs/new")
    public Club newClub(@RequestParam long id, @RequestBody ClubProperties clubProps) {
        Optional<User> opUser = userRepository.findById(id);
        if (!opUser.isPresent()) {
            throw new RuntimeException("Error");
        }
        
        User user = opUser.get();

        Club club = new Club();
        club.setName(clubProps.getName());
        club.setDescription(clubProps.getDescription());
        club.setUser(user);
        club = clubRepository.save(club);

        log.info("Adding new club, ID: {}, {}", 
            club.getId(), club.getName());

        log.info("Adding new club, ID: {}, {} for user, ID: {}, {}", 
            club.getId(), club.getName(), user.getId(), user.getName());
        return club;
    }

    @PostMapping(path = "/clubs/update")
    public Club updateClub(@RequestParam long id, @RequestBody Club club) {
        log.info("Updating club, ID: {}", club.getId());
        return clubRepository.save(club);
    }

    @DeleteMapping("/clubs")
    public void deleteClub(@RequestParam long id) {
        log.info("Deleting club, ID:{}", id);
        clubRepository.deleteById(id);
    }

    @GetMapping("/event")
    public ClubEvent event(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new ClubEvent(counter.incrementAndGet(), name);
    }

    @PostMapping("/users")
    public User newUser(@RequestBody UserProperties userProps) {
        User user = new User();
        user.setName(userProps.getName());
        user.setEmail(userProps.getEmail());
        user.setPhoneNumber(userProps.getPhoneNumber());

        user = userRepository.save(user);
        log.info("Creating new user, ID: {}, {}", user.getId(), user.getName());
        return user;
    }

}
