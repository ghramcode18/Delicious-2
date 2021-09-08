package delicious.delicious.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public class UserModel {
    

    Integer id;
    String userName;
    String email;
    String password;
}
