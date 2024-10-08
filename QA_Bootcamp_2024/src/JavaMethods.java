public class JavaMethods {
    public static void main(String[] args) {
         float myFloat = myFirstMethod(50, 70);
        System.out.println(myFloat);
        System.out.println("Number is odd? " + isOddNumber(100));
       printMessage(100);
         drawFullShape(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        addNumbers(1, 100);         // Adding two integers
        addNumbers(500f, 600f);     // Adding two float numbers
        addNumbers(185.6, 188.45);  // Adding two double numbers
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