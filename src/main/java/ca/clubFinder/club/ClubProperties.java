package ca.clubFinder.club;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel
public class ClubProperties {
    private String name;
    private String description;
}
