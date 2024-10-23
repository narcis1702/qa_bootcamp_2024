public class Hello {

    public static void main(String[] args) {

        int myFirstVariable = 100;
        int mySecondVariable = 0;
        final int MAX_SIZE = 10;

        System.out.println("Hello world !");

        System.out.println("Seconds variable value is " + mySecondVariable);

        myFirstVariable = MAX_SIZE + 1;

        System.out.println(args[0] + args[1]);

        int operandLeft = Integer.parseInt(args[0]);
        int operandRight = Integer.parseInt(args[1]);
        System.out.println(operandLeft + operandRight);

        String currentDay = "Monday";

        switch (currentDay) {
            case "Monday": {
                System.out.println("Noooo Monday !!!");
                break;
            }
            case "Friday":{
                System.out.println("yeeeey Friday !!");
                break;
            }
            default: {
                System.out.println("meeeh");
            }
        }

        int currentNumber = 1;
        while (currentNumber <= MAX_SIZE) {
            System.out.println("Current number is " + currentNumber);
            currentNumber++;
        }

        currentNumber = 1;
        do {
            System.out.println("Current number is " + currentNumber);
            currentNumber++;
        }
        while(currentNumber <= MAX_SIZE);

        for (int i = 1; i <= MAX_SIZE; i++) {
            System.out.println("Current number is " + i);
        }

        for(String arg : args) {
            System.out.println(arg);
        }
/*
        for (int i=2; i<=1000000;i++) {
            boolean isPrime = true;
            for (int j=2; j <= i/2 ; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                System.out.println("Number " + i + " is prime.");
            }
        }

 */

    }

}