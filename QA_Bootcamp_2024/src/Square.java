import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@Getter
@Setter
public class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    public void printCurrentSquare() {
        System.out.println("Square with side " + this.getLength() + " has an area of " + getArea());
    }

    public void draw() {
        System.out.println("Drawing a square");
    }

    @Override
    public String toString() {
        return "My square has 4 sides of length " + this.getLength();
    }

    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    public double getSide() {
        return this.getLength();
    }
}
