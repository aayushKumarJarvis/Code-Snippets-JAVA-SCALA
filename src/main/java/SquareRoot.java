import java.util.Scanner;

public class SquareRoot {

    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter the number");
       double numberForSquareRoot = scanner.nextDouble();

        //This method finds out the square root
        findSquareRoot(numberForSquareRoot);

    }

    public static void findSquareRoot(double number) {

        boolean isPositiveNumber = true;
        double guessNumber;

        if(number==0) {
          System.out.println("Square root of "+number+" = "+0);
        }

        else if(number<0) {
            number=-number;
            isPositiveNumber = false;
        }

        // Square Root Algorithm using guessing method
        double squareRoot = number/2;

        do {
            guessNumber=squareRoot;
            squareRoot = (guessNumber + (number/guessNumber))/2;
        }

        while((guessNumber-squareRoot)!=0);

        if(isPositiveNumber) {

            System.out.println("Square roots of "+number+" are ");
            squareRoot = (double)Math.round(squareRoot*100)/100;
            System.out.println(squareRoot);
        }
        //Displays square root in the case of a -ve number
        else {
            System.out.println("Square roots of -"+number+" are ");
            System.out.println("+"+squareRoot+" i");
            System.out.println("-"+squareRoot+" i");
        }
    }
}
