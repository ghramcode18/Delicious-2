package delicious.delicious.DTO;

import java.util.HashSet;
import java.util.Set;

import delicious.delicious.entities.RecipeEntity;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class userDTO {
    private Integer id; 
    private String userName;
    private Set <String>recipe=new HashSet<>();
    
}
