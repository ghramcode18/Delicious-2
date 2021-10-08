package delicious.delicious.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delicious.delicious.DTO.userDTO;
import delicious.delicious.entities.RecipeEntity;
import delicious.delicious.entities.UserEntity;
import delicious.delicious.exceptions.RecipeException;
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

    // private void mapDtoToEntity(userDTO userDTO, UserEntity userEntity) {
    //     userEntity.setUserName(userDTO.getUserName());
    //     if (null == userEntity.getFavorites()) {
    //         userEntity.setFavorites(new HashSet<>());
    //     }
    //     userDTO.getRecipe().stream().forEach(recipeName -> {
    //         RecipeEntity recipeEntity = recipeRepo.findByRecipeName(recipeName);
    //         if (null == recipeEntity) {
    //             recipeEntity = new RecipeEntity();
    //             recipeEntity.setUsers_added_to_favorite(new HashSet<>());
    //         }
    //         recipeEntity.setRecipeName(recipeName);
    //         userEntity.addFavorite(recipeEntity);
    //     });
    // }

    public void addFavorite(Integer userId, RecipeModel recipe) {
      
            UserEntity userEntity = userRepo.findById(userId)
                    .orElseThrow(() -> new UserException("no user with this id"));
        
            RecipeEntity recipeEntity  = recipeRepo.findById(recipe.getId())
            .orElseThrow(() -> new RecipeException("no recipe with this id"));
          //  List <RecipeEntity> recipeEntities= new ArrayList<>();
          //  recipeEntities.add(recipeEntity);
         //   userEntity.favorites(recipeEntities);
            // recipeEntity.users_added_to_favorite(userEntity.getFavorites());
         //   recipeRepo.save(recipeEntities.get(0));
           // userRepo.save(userEntity);
            List <UserEntity>
             userEntities =new ArrayList<>();       a                   
            userEntities.add(userEntity);
            recipeEntity.setUsers_added_to_favorite(userEntities );
            recipeRepo .save(recipeEntity);
    
        // mapDtoToEntity(userDTO, userEntity);
        // UserEntity savedUser = userRepo.save(userEntity);
    }

    /*
     * public StudentDto addStudent(StudentDto studentDto) { Student student = new
     * Student(); mapDtoToEntity(studentDto, student); Student savedStudent =
     * studentRepository.save(student); return mapEntityToDto(savedStudent); }
     */
    // public boolean addFavorite(Integer userId, Integer recipeId) {
    // UserEntity user = userRepo.findById(userId).orElseThrow(()->new
    // UserException("no user with this id"));
    // List <RecipeEntity>recipeEntities= user.getClicks();
    // RecipeEntity recipeEntity= recipeRepo.findById(recipeId).orElseThrow(()->new
    // RecipeException("no recipe with this id"));

    // boolean exist =
    // recipeEntities.stream().anyMatch((e)->e.getId().equals(recipeId));
    // if(exist) return false;
    // recipeEntities.add(recipeEntity);
    // user.setFavorites(recipeEntities);
    // userRepo.save(user);
    // return true;

    private userDTO mapEntityToDTO(UserEntity savedUser) {
        userDTO userDTO = new userDTO();
        userDTO.setId(savedUser.getId());
        userDTO.setUserName(savedUser.getUserName());
        userDTO.setRecipe(
                savedUser.getFavorites().stream().map(RecipeEntity::getRecipeName).collect(Collectors.toSet()));
        return userDTO;
    }

    // }
    /*
     * UserEntity user = userRepo.findById(userID).orElseThrow(()-> new
     * UserErrorException("no user with this id")); List<BoardEntity> boardEntities
     * = user.getBoards(); BoardEntity boardEntity =
     * boardRepository.findById(boardID).orElseThrow(() -> new
     * BoardErrorException("no board with this id")); boolean exist =
     * boardEntities.stream().anyMatch((e) -> e.getId().equals(boardID)); if(exist)
     * return false; boardEntities.add(boardEntity); user.setBoards(boardEntities);
     * userRepo.save(user); return true;
     * 
     * public BoardResponse addBoard(BoardModel boarderModel) { BoardEntity entity =
     * boardRepository.save( new BoardEntity()
     * .withDescription(boarderModel.getDescription())
     * .withName(boarderModel.getName()) .withImage(boarderModel.getImage()));
     * BoardResponse boarderResponse = new BoardResponse()
     * .withDescription(entity.getDescription()) .withImage(entity.getImage())
     * .withName(entity.getName()) .withId(entity.getId()); return boarderResponse;
     * }
     */ private RecipeEntity RecipeModelToRecipeEntity(RecipeModel rModel) {
        RecipeEntity rEntity = new RecipeEntity();
        rEntity.builder().id(rModel.getId()).recipeName(rModel.getName()).image(rModel.getImage())
                .type(rModel.getType()).price(rModel.getPrice()).imgrate(rModel.getImgrate()).build();
        return rEntity;
    }
    // public List<RecipeModel> getFavorite(Integer id)
    // {uuuuuuuuuuuuuiiuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu
    // if (id == null)
    // throw new UserException("can't user with this id");
    // UserEntity entity = userRepo.findById(id).orElseThrow(() -> new
    // UserException("no user with this id"));
    // return RecipeMapper.RecipeEntityToRecipeModelAsList(entity.getFavorites());

    // }

}
