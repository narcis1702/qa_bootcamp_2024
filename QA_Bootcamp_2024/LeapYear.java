import java.util.Scanner;
public class LeapYear { public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Type an year between 1900 and 2016:");

    int year= scanner.nextInt();


    if (year >= 1900 && year <= 2016) {

        if (isLeapYear(year)) {
            System.out.println("February in " + year + " had 29 days");
        } else {
            System.out.println("February in " + year + " had 28 days");
        }
    } else {
        System.out.println("Type an year between 1900 and 2016.");
    }
}


    public static boolean isLeapYear(int year) {

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
