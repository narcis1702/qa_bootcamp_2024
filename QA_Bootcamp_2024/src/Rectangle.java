public class Rectangle {

    public double length;
    public double width;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getArea(){
    return this.length * this.width;
    }

    public double getDiagonal(){
        return Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));

    }

    public double getPerimeter(){
        return this.length + this.width;

    }
}
