import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor@AllArgsConstructor @Getter@Setter
public class Person {
    private String name;
    private String Surname;
    private String dateOfBirth;

    public void eat(){
        System.out.println("Eat an apple");
    }

}
