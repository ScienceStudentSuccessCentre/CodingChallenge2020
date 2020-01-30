import java.util.Scanner;

/**
 * Your goal is to take in a number and determine if it is prime.
 * 
 * If you don't know what a prime number is:
 * -->(https://en.wikipedia.org/wiki/Prime_number)<--
 *
 * Good luck!
 */
public class Prime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scan.nextInt();
        scan.close();

        boolean isPrime = checkIfPrime(num);
        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }

    public static boolean checkIfPrime(int num) {
        /**
         * Your code goes here!
         */
        return true;
    }
}
