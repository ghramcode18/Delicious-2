package delicious.delicious.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delicious.delicious.entities.RecipeEntity;
import delicious.delicious.entities.UserEntity;
import delicious.delicious.exceptions.UserException;
import delicious.delicious.models.RecipeModel;
import delicious.delicious.models.UserModel;
import delicious.delicious.repositories.RecipeRepo;
import delicious.delicious.repositories.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    RecipeRepo recipeRepo;

    public UserModel registerUser(UserModel user) throws UserException {
        if (user.getEmail() != null && user.getPassword() != null && user.getUserName() != null) {
            if (userRepo.findByEmail(user.getEmail()).isEmpty()) {
                UserEntity entity = userRepo.save(UserModelToUserEntity(user));
                return user.builder().id(entity.getId()).password(entity.getPassword()).email(entity.getEmail())
                        .userName(entity.getUserName()).build();
            } else {
                throw new UserException("this email is already exist");
            }
        } else {
            throw new UserException("required fields are null");

        }
    }

    public UserEntity UserModelToUserEntity(UserModel user) {
        UserEntity entity = new UserEntity().builder().id(user.getId()).email(user.getEmail())
                .userName(user.getUserName()).password(user.getPassword()).favorites(user.getUserFav()).build();

        return entity;

    }

    public UserModel signIn(UserModel user) throws UserException {
        Optional<UserEntity> entity;
        if ((entity = userRepo.findByEmail(user.getEmail())).isEmpty()) {
            throw new UserException("no user with this email");
        } else {
            if (entity.get().getPassword().equals(user.getPassword())) {
                return UserEntityToUserModel(entity.get());
            } else {
                throw new UserException("wrong password");
            }

        }
    }

    public UserModel UserEntityToUserModel(UserEntity user) {
        UserModel entity = new UserModel().builder().id(user.getId()).email(user.getEmail())
                .userName(user.getUserName()).password(user.getPassword()).UserFav(user.getFavorites()).build();

        return entity;

    }

    public UserModel addFavorite(Integer id, RecipeModel rModel) {
        if (id == null)
            throw new UserException("can't user or recipe with this id");

        UserEntity entity = userRepo.findById(id).orElseThrow(() -> new UserException("no user with this id"));
      //  entity.builder().favorites(entity.getFavorites().add(RecipeModelToRecipeEntity(rModel))).build();
        entity.getFavorites().add(RecipeModelToRecipeEntity(rModel));
        userRepo.save(entity);
        return UserEntityToUserModel(entity);

    }

    private RecipeEntity RecipeModelToRecipeEntity(RecipeModel rModel) {
        RecipeEntity rEntity = new RecipeEntity();
        rEntity.builder().id(rModel.getId()).name(rModel.getName()).image(rModel.getImage()).type(rModel.getType())
                .price(rModel.getPrice()).imgrate(rModel.getImgrate()).build();
        return rEntity;
    }
    // public List<RecipeModel> getFavorite(Integer id) {
    // if (id == null)
    // throw new UserException("can't user with this id");
    // UserEntity entity = userRepo.findById(id).orElseThrow(() -> new
    // UserException("no user with this id"));
    // return RecipeMapper.RecipeEntityToRecipeModelAsList(entity.getFavorites());

    // }

}
