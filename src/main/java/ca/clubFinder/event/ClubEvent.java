package ca.clubFinder.event;

public class ClubEvent {

    private final long id;
    private final String name;
//    private final String description;

    public ClubEvent(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }
}
