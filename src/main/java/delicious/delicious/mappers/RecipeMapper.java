package delicious.delicious.mappers;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import delicious.delicious.entities.RecipeEntity;
import delicious.delicious.models.RecipeModel;


@Mapper
public interface RecipeMapper 
{//CAN I PUT ALL OF MAPPERIN ONE CLASSE?
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);
    @Mapping (source = "",target = "")
    RecipeEntity RecipeModelToRecipeEntity(RecipeModel RecipeModel);
    RecipeModel RecipeEntityToRecipeModel(RecipeEntity RecipeEntity);
    List<RecipeEntity> RecipeModelToRecipeEntityAslist(List<RecipeModel> RecipeModel);
    List<RecipeModel> RecipeEntityToRecipeModelAsList(List<RecipeEntity> RecipeEntities);

 }
 
// //source the name in Entity and target the name in Model.

