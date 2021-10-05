package delicious.delicious.models;

import java.util.ArrayList;
import java.util.List;

import delicious.delicious.entities.RecipeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString

public class UserModel {
    

    Integer id;
    String userName;
    String email;
    String password;
    List <RecipeEntity>UserFav= new ArrayList();

}
