import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Teacher extends Person {

    private String job;

    public void teachCourse() {
        System.out.println("Teaching at " + this.job);
    }

}