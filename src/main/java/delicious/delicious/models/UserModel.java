package delicious.delicious.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import delicious.delicious.entities.RecipeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.With;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@With

public class UserModel {
    

    Integer id;
    String userName;
    String email;
    String password;
    Set <RecipeEntity>UserFav= new HashSet<>();

}
