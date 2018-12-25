package ca.clubFinder.controllers;

import ca.clubFinder.club.Club;
import ca.clubFinder.event.ClubEvent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ClubFinderController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/clubs")
    public Club clubs() {
        return Club.builder()
                .id(counter.incrementAndGet())
                .name("TestClub")
                .build();
    }

    @RequestMapping("/event")
    public ClubEvent event(@RequestParam(value="name", defaultValue="World") String name) {
        return new ClubEvent(counter.incrementAndGet(), name);
    }

}
