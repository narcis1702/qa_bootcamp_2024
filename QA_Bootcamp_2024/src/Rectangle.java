import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rectangle extends Shape {

    private double length;
    private double width;

    public double getArea() {
        return this.length * this.width;
    }

    public double getDiagonal() {
        return Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
    }

    public double getPerimeter() {
        return 2 * (this.length + this.width);
    }

    @Override
    public void draw() {
        super.draw(); //this calls the method from the superclass
        System.out.println("Drawing a rectangle with length " + this.length + " and width " + this.width);
    }
}



