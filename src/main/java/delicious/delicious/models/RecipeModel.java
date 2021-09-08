package delicious.delicious.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public class RecipeModel {

 private Integer id;
 private String name;
 private  double price;
 private String type;
 private String steps;
 private String  imgrate;
    
}
