package delicious.delicious.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import delicious.delicious.entities.RecipeEntity;

@Repository
public interface RecipeRepo extends JpaRepository<RecipeEntity, Integer> {
    List<RecipeEntity> findByType(String type);

}
