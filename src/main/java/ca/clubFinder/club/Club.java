package ca.clubFinder.club;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@Getter
public class Club {
    @Id
    @GeneratedValue
    private final long id;
    private final String name;
}
