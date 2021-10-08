package delicious.delicious.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Recipe")
@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Data
@With
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = true)
    private String recipeName;

    @Column(nullable = true)
    private String image;

    @Column(nullable = true)
    private double price;

    @Column(nullable = true)
    private String type;

    @OneToOne
    private Recipe_stepsEntity steps;

    @Column(columnDefinition = "TEXT", length = 4000)
    private String imgrate;

    @ManyToMany(targetEntity = UserEntity.class)
    @JoinTable(name = "user_favorites", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnore 
    private List<UserEntity> users_added_to_favorite= new ArrayList();

    @ManyToMany(targetEntity = UserEntity.class)
    @JoinTable(name = "users_clicks", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> user_clicks;

    @OneToOne
    private Recipe_stepsEntity users_clicked_recipe;

}
