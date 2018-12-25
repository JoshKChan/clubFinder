package ca.clubFinder.club;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Club {
    private final long id;
    private final String name;
}
