package ca.clubFinder.controllers;

import ca.clubFinder.club.Club;
import ca.clubFinder.event.ClubEvent;
import ca.clubFinder.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ClubFinderController {

    @Autowired
    private ClubRepository clubRepository;
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/clubs")
    public Iterable<Club> clubs() {
        return clubRepository.findAll();
    }

    @RequestMapping(path = "/clubs", method = POST)
    public Club newClub(@RequestParam String name) {
        Club club = new Club();
        club.setName(name);
        return clubRepository.save(club);
    }

    @RequestMapping("/event")
    public ClubEvent event(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new ClubEvent(counter.incrementAndGet(), name);
    }

}
