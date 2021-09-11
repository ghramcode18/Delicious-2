package delicious.delicious.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import delicious.delicious.entities.UserEntity;
import delicious.delicious.models.UserModel;


@Mapper
@Component

public interface UserMapper 
{//CAN I PUT ALL OF MAPPERIN ONE CLASSE?

    public static UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    // public static PostMapper mapper = Mappers.getMapper(PostMapper.class);

    @Mapping (source = "id",target = "userId")
   UserEntity UserModelToUserEntity(UserModel UserModel) ;
    public UserModel UserEntityToUserModel(UserEntity UserEntity) ;
    List<UserEntity> UserModelToUserEntityAslist(List<UserModel> UserModel);
    List<UserModel> UserEntityToUserModelAsList(List<UserEntity> userEntities);

}
 
// //source the name in Entity and target the name in Model.

