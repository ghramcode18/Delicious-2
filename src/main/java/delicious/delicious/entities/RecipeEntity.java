package delicious.delicious.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RecipeEntity")
public class RecipeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    
    private double price;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String steps;

    @Column(nullable = false)
    private String  imgrate;

    private int click_user;
 







}
