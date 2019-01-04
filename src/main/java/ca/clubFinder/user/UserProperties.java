package ca.clubFinder.user;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel
public class UserProperties {
    private String email;
    private String name;
    private String phoneNumber;
}
