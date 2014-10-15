import java.util.Scanner;

public class GCDUsingRecursion {

    public static void main(String args[]) {

        //Enter two number whose GCD needs to be calculated.      
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number to find GCD");
        int number1 = scanner.nextInt();

        System.out.println("Enter second number to find GCD");
        int number2 = scanner.nextInt();

        System.out.println("GCD of two numbers " + number1 +" and "
                + number2 +" is :" + getGCD(number1, number2));
    }


    public static int getGCD(int number1, int number2) {

        if(number2 == 0) {
            return number1;
        }
        return getGCD(number2, number1 % number2);
    }
}