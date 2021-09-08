package delicious.delicious.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import delicious.delicious.entities.FireBaseEntity;

@Repository
public interface FirebaseRepo extends JpaRepository<FireBaseEntity,Integer> {
    
}
