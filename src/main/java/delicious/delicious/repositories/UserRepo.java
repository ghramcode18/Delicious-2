package delicious.delicious.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import delicious.delicious.entities.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    
}
