public class JavaMethods {
    public static void main(String[] args) {
        float myFloat = myFirstMethod(50, 70);
        System.out.println(myFloat);

        System.out.println("Number is odd? " + isOddNumber(100));

        printMessage(100);

        // drawFullShape(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        addNumbers(1, 100);         // Adding two integers
        addNumbers(500f, 600f);     // Adding two float numbers
        addNumbers(185.6, 188.45);  // Adding two double numbers

        Shape myShape = new Shape();
        myShape.draw();
        myShape.erase();
        myShape.setColor("Green");
        System.out.println("The shape has color: " + myShape.getColor());

        Rectangle myRectangle = new Rectangle(4, 5);
        myRectangle.draw();

        Square mySquare = new Square(12);
        mySquare.draw();
        System.out.println("Length " + mySquare.getLength());

        Shape myShape1 = new Square();
        Shape myShape2 = new Triangle();
        Shape myShape3 = new Rectangle();
        Shape myShape4 = new Circle();

        myShape1.draw();
        myShape2.draw();
        myShape3.draw();
        myShape4.draw();

        Person teacher1 = new Teacher("UBB");
        teacher1.setName("Alex");
        teacher1.setSurname("Dumitru");
        teacher1.eat();
        ((Teacher) teacher1).teachCourse();

        Person student1 = new Student();
        student1.setName("Andrei");
        student1.setSurname("Narcis");
        student1.eat();

        if (student1.getName() == null) {
            throw new IllegalArgumentException("No name for the student");
        }

        try {
            myExceptionMethod();
        } catch (IllegalThreadStateException ex) {
            System.out.println("Oops, an exception occurred: " + ex.getMessage());
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Generic exception");
        }
        try {
            int argument = Integer.parseInt(args[0]);
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("No parses provided");
        }
        catch(NumberFormatException ex){
            System.out.println("Input is not an integer");
        }
        catch (Exception ex){
            System.out.println("Generic exception");
        }
        finally {
            System.out.println("This line will always execute");
        }
    }

    public static void myExceptionMethod() {
        Student s1 = new Student();

        if (s1.getName() == null) {
            throw new IllegalArgumentException("Exception: No Name for the student");
        }
    }

    private static void addNumbers(double v, double v1) {
        System.out.println("Adding 2 double numbers with sum: " + (v + v1));
    }

    private static void addNumbers(int i, int i1) {
        System.out.println("Adding 2 int numbers with sum: " + (i + i1));
    }

    private static void addNumbers(float f1, float f2) {
        System.out.println("Adding 2 float numbers with sum: " + (f1 + f2));
    }

    private static void drawFullShape(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static float myFirstMethod(float input1, float input2) {
        return input1 + input2;
    }

    public static boolean isOddNumber(int number) {
        return number % 2 != 0;
    }

    public static void printMessage(int number) {
        if (isOddNumber(number)) {
            System.out.println("Number " + number + " is odd");
        } else {
            System.out.println("Number " + number + " is even");
        }
    }
}
