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
    @Mapping (source = "",target = "")
    static
    UserEntity UserModelToUserEntity(UserModel UserModel) {
        // TODO Auto-generated method stub
        return null;
    }
    static UserModel UserEntityToUserModel(UserEntity UserEntity) {
        // TODO Auto-generated method stub
        return null;
    }
    List<UserEntity> UserModelToUserEntityAslist(List<UserModel> UserModel);
    List<UserModel> UserEntityToUserModelAsList(List<UserEntity> userEntities);

}
 
// //source the name in Entity and target the name in Model.

