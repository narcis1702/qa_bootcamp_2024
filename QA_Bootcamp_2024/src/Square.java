import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 @NoArgsConstructor @AllArgsConstructor
public class Square {
     @Getter @Setter

    public double squareSide;

    public Square(double squareSide){
        this.squareSide = squareSide;
    }
    public Square(){

    }

    public void setSide(double squareSide){
        this.squareSide = squareSide;
    }

    public double getArea(){
        return Math.pow(this.squareSide, 2);

    }

    public void printCurrentSquare(){
        System.out.println("Square with side " + this.squareSide + " has area of " + getArea());
    }


}
