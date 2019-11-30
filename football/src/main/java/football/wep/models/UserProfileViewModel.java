package football.wep.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserProfileViewModel {

    private String username;
    private String firstName;
    private String lastName;
    private String email;

}
