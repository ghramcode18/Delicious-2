package delicious.delicious.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import delicious.delicious.entities.UserEntity;
import delicious.delicious.models.UserModel;


@Mapper
public interface UserMapper 
{//CAN I PUT ALL OF MAPPERIN ONE CLASSE?
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping (source = "",target = "")
    UserEntity UserModelToUserEntity(UserModel UserModel);
    UserModel UserEntityToUserModel(UserEntity UserEntity);
    List<UserEntity> UserModelToUserEntityAslist(List<UserModel> UserModel);
    List<UserModel> UserEntityToUserModelAsList(List<UserEntity> userEntities);

}
 
// //source the name in Entity and target the name in Model.

