package delicious.delicious.models;



import delicious.delicious.entities.RecipeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@AllArgsConstructor
@Builder
// @NoArgsConstructor
@ToString
@RequiredArgsConstructor

public class Recipe_StepsModel {
 
    private Integer id;
    private Integer step_number;
    private String descripion;
    private RecipeEntity recipeEntity;


}
