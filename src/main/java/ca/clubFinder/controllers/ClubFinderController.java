package ca.clubFinder.controllers;

import ca.clubFinder.club.Club;
import ca.clubFinder.event.ClubEvent;
import ca.clubFinder.repositories.ClubRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
public class ClubFinderController {

    @Autowired
    private ClubRepository clubRepository;
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/clubs")
    public Iterable<Club> clubs() {
        return clubRepository.findAll();
    }

    @PostMapping(path = "/clubs/new")
    public Club newClub(@RequestParam String name) {
        log.info("Adding new club, {}", name);
        Club club = new Club();
        club.setName(name);
        return clubRepository.save(club);
    }

    @PostMapping(path = "/clubs/update")
    public Club updateClub(@RequestBody Club club) {
        log.info("Updating club, {}", club.getId());
        return clubRepository.save(club);
    }

    @DeleteMapping("/clubs")
    public void deleteClub(@RequestParam long id) {
        clubRepository.deleteById(id);
    }

    @GetMapping("/event")
    public ClubEvent event(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new ClubEvent(counter.incrementAndGet(), name);
    }

}
