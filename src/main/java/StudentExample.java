import lombok.*;
import jakarta.persistence.*;
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
@NamedQuery(query = "SELECT s from StudentExample s where s.id = : id ", name = "find student by id ")
public class StudentExample {



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    public StudentExample(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }



}
