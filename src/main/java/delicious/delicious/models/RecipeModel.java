package delicious.delicious.models;

import delicious.delicious.entities.RecipeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class RecipeModel {

 private Integer id;
 private String name;
 private  double price;
 private String type;
 private String image;
 private Recipe_StepsModel Recipe_steps;
 private String  imgrate;
    
}
