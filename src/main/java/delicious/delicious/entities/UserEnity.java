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
@Entity
@Table(name = "UserName")
public class UserEnity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = true)
    private String userName ;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password ;

    @ManyToMany
    private int clicks;

    @OneToMany(mappedBy = "user")
    private List<FireBaseEntity> firebase;




    
}
