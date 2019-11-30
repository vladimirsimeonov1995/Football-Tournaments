package football.wep.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserEditPasswordViewModel {

    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;

}
