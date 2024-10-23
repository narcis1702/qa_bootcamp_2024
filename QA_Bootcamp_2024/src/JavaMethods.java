public class JavaMethods {

    public static void main(String[] args) {
//        System.out.println("Hello 2!!");
//        float myFloat = myFirstMethod(50, 70);
//        System.out.println(myFloat);
//        System.out.println("Number is odd ? " + isOddNumber(100));
//        printMessage(100);

//        drawFullShape(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
//        System.out.println("----------------------------------");
//        drawShapeOutline(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
//        System.out.println("----------------------------------");
//        drawShapeCorners(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

//        drawFullShape(Integer.parseInt(args[0]));

//        addNumbers(1, 100);
//        addNumbers(500f, 600f);
//        addNumbers(105.6, 88.45);

        Shape myShape = new Shape();
        myShape.draw();
        myShape.erase();
        myShape.setColor("Green");
        System.out.println("The shape has color: " + myShape.getColor());

        Rectangle myRectangle = new Rectangle(4, 5);
        myRectangle.draw();

        Square mySquare = new Square(12);
        mySquare.draw();
        System.out.println("length " + mySquare.getLength());
        System.out.println("Diagonal is " + mySquare.getDiagonal());

        Shape myShape1 = new Square();
        Shape myShape2 = new Triangle();
        Shape myShape3 = new Rectangle();
        Shape myShape4 = new Circle();

        myShape1.draw();
        myShape2.draw();
        myShape3.draw();
        myShape4.draw();

        Person teacher1 = new Teacher("UPB");
        teacher1.setName("Alex");
        teacher1.setSurname("G");
        teacher1.eat();
        ((Teacher)teacher1).teachCourse();

        Person student1 = new Student();
        student1.setName("Andrei");
        student1.setSurname("Studentila");
        student1.eat();

        if(student1.getName() == null) {
            throw new IllegalArgumentException("No name for the student");
        }

//        System.out.println(5/0);
//        System.out.println("After exception");
        try {
            myExceptionMethod();
        }
        catch (IllegalThreadStateException ex) {
            System.out.println("Oooops an exception " + ex.getMessage());
        }
        catch (IllegalArgumentException | MyException ex) {
            System.out.println(ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Generic exception");
        }

        try {
            int argument = Integer.parseInt(args[0]);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("No params provided");
        }
        catch (NumberFormatException nex) {
            System.out.println("Input is not an integer");
        }
        catch(Exception ex) {
            System.out.println("Generic exception");
        }
        finally {
            System.out.println("This line will always execute");
        }

    }

    public static void myExceptionMethod() throws IllegalArgumentException, MyException {
        Student s1 = new Student();

        if (s1.getName() == null) {
//            throw new IllegalArgumentException("Exception: No name for the student");
            throw new MyException("Exception: No name for the student");
        }
    }


    private static void addNumbers(int i, int j) {
        System.out.println("adding 2 int numbers with sum " + (i+j));
    }

    private static void addNumbers(float i, float j) {
        System.out.println("adding 2 float numbers with sum " + (i+j));
    }

    private static void addNumbers(double i, double j) {
        System.out.println("adding 2 double numbers with sum " + (i+j));
    }

    private static void drawShapeCorners(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i == 0 && j == 0) ||
                        (i==0 & j == width -1) ||
                        (i == height - 1 && j == 0) ||
                        (i==height-1 && j == width-1)) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void drawShapeCorners(int length) {
        drawShapeCorners(length, length);
    }

    private static void drawShapeOutline(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void drawShapeOutline(int length) {
        drawShapeOutline(length, length);
    }

    private static void drawFullShape(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void drawFullShape(int length) {
        drawFullShape(length, length);
    }


    public static float myFirstMethod(float input1, float input2) {
        return input1 + input2 ;
    }

    public static boolean isOddNumber(int number) {
        return number % 2 != 0;
    }

    public static void printMessage(int number) {
//        if (isOddNumber(number)) {
//            System.out.println("Number " + number + " is odd !");
//        }
//        else {
//            System.out.println("Number " + number + " is even !");
//        }
        String type = isOddNumber(number) ? "odd" : "even";
        System.out.println("Number " + number + " is " + type + " !");
    }

}