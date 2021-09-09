package delicious.delicious.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor  @Builder(toBuilder = true)
public class UserModel {
    

    Integer id;
    String userName;
    String email;
    String password;
}
