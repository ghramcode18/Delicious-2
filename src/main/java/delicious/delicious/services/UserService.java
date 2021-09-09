package delicious.delicious.services;

    

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import delicious.delicious.entities.UserEntity;
import delicious.delicious.exceptions.UserException;
import delicious.delicious.mappers.RecipeMapper;
import delicious.delicious.mappers.UserMapper;
import delicious.delicious.models.RecipeModel;
import delicious.delicious.models.UserModel;
import delicious.delicious.models.userFav;
import delicious.delicious.repositories.RecipeRepo;
import delicious.delicious.repositories.UserRepo;

@Service
public class UserService {
    
    @Autowired
    UserRepo userRepo;
    @Autowired
    RecipeRepo recipeRepo;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RecipeMapper recipeMapper;
    
  
    @Bean
    public UserModel registerUser(UserModel user) throws UserException 
    {
        if(user.getEmail() != null && user.getPassword() != null && user.getUserName()!= null)
        {
            if(userRepo.findByEmail(user.getEmail()).isEmpty())
            {
                UserEntity entity = userRepo.save(userMapper.UserModelToUserEntity(user));
                 return user.builder().id(entity.getId()).build();
            }else{
                throw new UserException("this email is already exist");
            }
        }else{
            throw new UserException("required fields are null");

        }
    }

  
    
    public UserModel signIn(UserModel user) throws UserException
    {
        Optional<UserEntity> entity;
        if((entity = userRepo.findByEmail(user.getEmail())).isEmpty())
        {
            throw new UserException("no user with this email");
        }else{
            if(entity.get().getPassword().equals(user.getPassword()))
            {
                return userMapper.UserEntityToUserModel(entity.get());
            }else{
                throw new UserException("wrong password");
            }

        }
    }



    public UserModel addFavorite(Integer id,RecipeModel rModel ){
        if(id == null)
            throw new UserException("can't  user  or recipe with this id");

        UserEntity entity = userRepo.findById(id).orElseThrow(()-> new UserException("no user with this id"));
                entity.getFavorites().add( recipeMapper.RecipeModelToRecipeEntity(rModel));
        userRepo.save(entity);
        return userMapper.UserEntityToUserModel(entity); 

      
    }

    //  public  List<RecipeModel>  getFavorite (Integer id )
    //  {  if(id == null)
    //     throw new UserException("can't  user with this id");
    //     UserEntity entity = userRepo.findById(id).orElseThrow(()-> new UserException("no user with this id"));
    //     return  recipeMapper.RecipeEntityToRecipeModelAsList(entity.getFavorites());
        
    //  }

          public  List<RecipeModel>  getFavorite (Integer id )
          {     {  if(id == null)
                    throw new UserException("can't  user with this id");
                 userRepo.findById(id).orElseThrow(()-> new UserException("no user with this id"))
                 .getFavorites()
                 

          }

    //       public List<PostResponse> getPosts(Long userID)
    // {
    //     return userRepo.findById(userID).orElseThrow(
    //         () -> new UserErrorException("no user with this id"))
    //         .getPosts()
    //         .stream()
    //         .map(PostMapper.mapper::PostToResponse)
    //         .toList();
        
        
    // }

}