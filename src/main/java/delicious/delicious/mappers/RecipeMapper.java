package delicious.delicious.mappers;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import delicious.delicious.entities.RecipeEntity;
import delicious.delicious.models.RecipeModel;


@Mapper
@Component

public interface RecipeMapper 
{//CAN I PUT ALL OF MAPPERIN ONE CLASSE?
    public static  RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);
    @Mapping (source = "",target = "")
    static
    RecipeEntity RecipeModelToRecipeEntity(RecipeModel RecipeModel) {
        // TODO Auto-generated method stub
        return null;
    }
    RecipeModel RecipeEntityToRecipeModel(RecipeEntity RecipeEntity);
    List<RecipeEntity> RecipeModelToRecipeEntityAslist(List<RecipeModel> RecipeModel);
    static List<RecipeModel> RecipeEntityToRecipeModelAsList(List<RecipeEntity> RecipeEntities) {
        // TODO Auto-generated method stub
        return null;
    }

 }
 
// //source the name in Entity and target the name in Model.

