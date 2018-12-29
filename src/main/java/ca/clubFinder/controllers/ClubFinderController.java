package ca.clubFinder.controllers;

import ca.clubFinder.club.Club;
import ca.clubFinder.event.ClubEvent;
import ca.clubFinder.repositories.ClubRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(path = "/clubs")
    public Club newClub(@RequestParam String name) {
        log.info("Adding new club, {}", name);
        Club club = new Club();
        club.setName(name);
        return clubRepository.save(club);
    }

    @GetMapping("/event")
    public ClubEvent event(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new ClubEvent(counter.incrementAndGet(), name);
    }

}
