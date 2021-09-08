package delicious.delicious.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "User")
@Setter @Getter @AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String userName ;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password ;

   
    @ManyToMany(mappedBy = "users_added_to_favorite")
    private List<RecipeEntity> favorites;

    @ManyToMany(mappedBy = "users_clicked_recipe")
    private List<RecipeEntity> clicks;

    @OneToMany(mappedBy = "user")
    private List<FireBaseEntity> firebase;


    
}
