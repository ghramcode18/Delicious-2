package delicious.delicious.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import delicious.delicious.entities.Recipe_stepsEntity;

@Repository
public interface Recipe_StepsRepo extends JpaRepository<Recipe_stepsEntity, Integer> {

}
