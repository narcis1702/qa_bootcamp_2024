public class PrimeNumbers {
    public static void main(String[] args) {
          for (int number = 2; number < 1000000; number++) {

            if (isPrime(number)) {
                System.out.println(number);
            }
        }
    }

        public static boolean isPrime(int number) {
             for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
