// package delicious.delicious.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import delicious.delicious.repositories.RecipeRepo;
// import delicious.delicious.repositories.Recipe_StepsRepo;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import delicious.delicious.entities.RecipeEntity;
// import delicious.delicious.entities.Recipe_stepsEntity;
// import delicious.delicious.models.RecipeModel;
// import delicious.delicious.models.Recipe_StepsModel;
// @Service
// public class RecipeService {
//     @Autowired
//     RecipeRepo recipeRepo;

//     @Autowired
//     Recipe_StepsRepo recipe_StepsRepo;
    
//    public  List <RecipeModel>getFoodForType(String type)
//    {
//        List <RecipeEntity>recipeEntities = recipeRepo.findByType(type); 
//        return ListRecipeEntityToRecipeListModel(recipeEntities);
//    }

//    public List <RecipeModel> ListRecipeEntityToRecipeListModel (  List <RecipeEntity> recipeEntities)
//    {
//     List <RecipeModel >recipeModels  = new ArrayList<>();
//     if (recipeEntities.size()>0) {
//     for (RecipeEntity recipeEntity : recipeEntities) {
//        RecipeModel rModel = new RecipeModel();
//        rModel.id(recipeEntity.getId())
//        .name(recipeEntity.getName())
//        .image(recipeEntity.getImage())
//        .imgrate(recipeEntity.getImgrate())
//        .price(recipeEntity.getPrice())
//        .type(recipeEntity.getType())
//        .recipe_steps(recipeEntity.getSteps())
//        .user_favorite(recipeEntity.getUsers_added_to_favorite())
//        .user_clike(recipeEntity.getUser_clicks());
//        recipeModels.add(rModel);

//        }
//        return recipeModels;
//    }
//        else return new ArrayList<RecipeModel>();

//     }
   


// //    private RecipeEntity RecipeModelToRecipeEntity(RecipeModel rModel) {
// //            return null;
// //            //TODO PLEASE
// //        }
// //        private RecipeModel RecipeEntityToRecepeModel(Optional<RecipeEntity> findBytype) {
// //         return null;
// //     }
//     private Recipe_stepsEntity getrecipe_steps(Recipe_stepsEntity recipe_steps) {
//      Optional<Recipe_stepsEntity> recipe_stepsEntity= recipe_StepsRepo.findById(recipe_steps.getId());
//      Recipe_StepsModel rModel =new Recipe_StepsModel();
//      rModel.id(recipe_steps.getId())
//      .descripion(recipe_steps.getDescripion())
//      .step_number(recipe_steps.getStep_Number());
    
//         return recipe_StepsModelToRecipe_stepEntity(rModel);
//     }
    
    
//     private Recipe_StepsModel recipe_stepEntityToRecipe_StepsModel( Recipe_stepsEntity recipe_steps)
//     {  Recipe_StepsModel rModel =new Recipe_StepsModel();
//         rModel.id(recipe_steps.getId())
//         .descripion(recipe_steps.getDescripion())
//         .step_number(recipe_steps.getStep_Number());
    
//         return rModel;
    
    
//     }
//     private Recipe_stepsEntity recipe_StepsModelToRecipe_stepEntity( Recipe_StepsModel recipe_steps)
//     {  Recipe_stepsEntity entity =new Recipe_stepsEntity();
//         entity.Id(recipe_steps.getId())
//         .Descripion(recipe_steps.getDescripion())
//          .step_Number (recipe_steps.getStep_number());
//         return entity;
    
    
//     }
// }
  
