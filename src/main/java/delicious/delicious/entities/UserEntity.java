package delicious.delicious.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.With;

@Entity
@Table(name = "User")
@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Data
@With
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    @Column(nullable = true)
    private String userName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany(mappedBy = "users_added_to_favorite")
    private Set<RecipeEntity> favorites=new HashSet<>();
    public void addFavorite(RecipeEntity recipeEntity) {
        this.favorites.add(recipeEntity);
        recipeEntity.getUsers_added_to_favorite().add(this);
    }
    @ManyToMany(mappedBy = "users_clicked_recipe")
    private List<RecipeEntity> clicks;

    @OneToMany(mappedBy = "user")
    private List<FireBaseEntity> firebase;

}
