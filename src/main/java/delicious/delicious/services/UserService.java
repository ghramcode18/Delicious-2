// package delicious.delicious.services;

    

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;
// import org.springframework.beans.factory.annotation.Autowired;

// import org.springframework.stereotype.Service;

// import delicious.delicious.entities.RecipeEntity;
// import delicious.delicious.entities.UserEntity;
// import delicious.delicious.exceptions.UserException;
// import delicious.delicious.models.RecipeModel;
// import delicious.delicious.models.UserModel;
// import delicious.delicious.repositories.RecipeRepo;
// import delicious.delicious.repositories.UserRepo;

// @Service
// public class UserService {
    
//     @Autowired
//     UserRepo userRepo;
//     @Autowired
//     RecipeRepo recipeRepo;
    
  
  
//     public UserModel registerUser(UserModel user) throws UserException 
//     {
//         if(user.getEmail() != null && user.getPassword() != null && user.getUserName()!= null)
//         {
//             if(userRepo.findByEmail(user.getEmail()).isEmpty())
//             {
//                 UserEntity entity = userRepo.save(UserModelToUserEntity(user));
//                  return user.//id(entity.getId());
//             }else{
//                 throw new UserException("this email is already exist");
//             }
//         }else{
//             throw new UserException("required fields are null");

//         }
//     }


  
    
// //     public UserModel signIn(UserModel user) throws UserException
// //     {
// //         Optional<UserEntity> entity;
// //         if((entity = userRepo.findByEmail(user.getEmail())).isEmpty())
// //         {
// //             throw new UserException("no user with this email");
// //         }else{
// //             if(entity.get().getPassword().equals(user.getPassword()))
// //             {
// //                 return UserEntityToUserModel(entity.get());
// //             }else{
// //                 throw new UserException("wrong password");
// //             }

// //         }
// //     }
    
// //     public  UserModel  UserEntityToUserModel(UserEntity user)
// //     {
// //         UserModel model = new UserModel()
// //         .email(user.getEmail())
// //         .name(user.getName())
// //         .id(user.getId())
// //         .password(user.getPassword())
// //         ;

// //         return model;


// //     }

//     public  UserEntity  UserModelToUserEntity(UserModel user)
//     {
//         UserEntity entity = new UserEntity()
//         .email(user.getEmail())
//         .name(user.getName())
//         .id(user.getId())
//         .password(user.getPassword());

//         return entity;


//     }


// //     public  UserEntity logout (UserModel userModel)
// //     {
// //         UserEntity entity = new UserEntity();
// //         if(userModel.getId()!= null)
// //         entity = userRepo.findById(userModel.getId()).orElseThrow(()-> new UserException("no user with this id"));
// //         userRepo.delete(entity);
// //         return entity;


// //     }

// //     public UserModel addFavorite(Integer id,RecipeModel rModel ){
// //         if(id == null)
// //             throw new UserException("can't  user  or recipe with this id");

// //         UserEntity entity = userRepo.findById(id).orElseThrow(()-> new UserException("no user with this id"));
// //                 entity.getFavorites().add(RecipeModelToRecipeEntity(rModel));
// //         userRepo.save(entity);
// //         return UserEntityToUserModel(entity); 

      
// //     }

// //      public  List<RecipeModel>  getFavorite (Integer id )
// //      {  if(id == null)
// //         throw new UserException("can't  user with this id");
// //         UserEntity entity = userRepo.findById(id).orElseThrow(()-> new UserException("no user with this id"));
// //         return  ListRecipeEntityToRecipeListModel(entity.getFavorites());
        
// //      }
// //         public List <RecipeModel> ListRecipeEntityToRecipeListModel (  List <RecipeEntity> recipeEntities)
// //         {
// //          List <RecipeModel >recipeModels  = new ArrayList<>();
// //          if (recipeEntities.size()>0) {
// //          for (RecipeEntity recipeEntity : recipeEntities) {
// //             RecipeModel rModel = new RecipeModel();
// //             rModel.id(recipeEntity.getId())
// //             .name(recipeEntity.getName())
// //             .image(recipeEntity.getImage())
// //             .imgrate(recipeEntity.getImgrate())
// //             .price(recipeEntity.getPrice())
// //             .type(recipeEntity.getType())
// //             .recipe_steps(recipeEntity.getSteps())
// //             .user_favorite(recipeEntity.getUsers_added_to_favorite())
// //             .user_clike(recipeEntity.getUser_clicks());
// //             recipeModels.add(rModel);
     
// //             }
// //             return recipeModels;
// //         }
// //             else return new ArrayList<RecipeModel>();
    
// //          }
        
// //          public List <RecipeEntity> ListRecipeModelToListRecipeMEntities  (  List <RecipeModel> recipeModels)
// //          {
// //           List <RecipeEntity >entity  = new ArrayList<>();
// //           if (recipeModels.size()>0) {
// //           for (RecipeEntity recipeEntity : entity) {
// //              RecipeModel rModel = new RecipeModel();
// //              rModel.id(recipeEntity.getId())
// //              .name(recipeEntity.getName())
// //              .image(recipeEntity.getImage())
// //              .imgrate(recipeEntity.getImgrate())
// //              .price(recipeEntity.getPrice())
// //              .type(recipeEntity.getType())
// //              .recipe_steps(recipeEntity.getSteps())
// //              .user_favorite(recipeEntity.getUsers_added_to_favorite())
// //              .user_clike(recipeEntity.getUser_clicks());
             
 
// //                entity.add(RecipeModelToRecipeEntity(rModel));
               
// //              }
// //              return entity;
// //          }
// //              else return new ArrayList<RecipeEntity>();
     
// //           }



// //         private RecipeEntity RecipeModelToRecipeEntity(RecipeModel rModel) {
// //         RecipeEntity rEntity = new RecipeEntity();
// //         rEntity.id(rModel.getId())
// //         .name(rModel.getName())
// //         .image(rModel.getImage())
// //         .type(rModel.getType())
// //         .price(rModel.getPrice())
// //         .user_clicks(rModel.getUser_clike())
// //         .imgrate(rModel.getImgrate())
// //         .users_added_to_favorite(rModel.getUser_favorite())
// //         .steps(rModel.getRecipe_steps());
// //             return rEntity;
// //         }

      

      
// // }
