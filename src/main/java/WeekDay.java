import java.util.Scanner;

public class WeekDay {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] actualDay = {"Sunday","Monday","Tuesday",
                "Wendesday","Thursday","Friday","Saturday"};

        introMessage();

        System.out.println("Enter Year\n");
        int y = console.nextInt();
        System.out.println("Enter Month\n");
        int m = console.nextInt();
        System.out.println("Enter Day");
        int d = console.nextInt();

        int dayNumber = getWeekDay(y,m,d);

        System.out.println("\nThe Day you were born was on : "+ actualDay[dayNumber]);

    }

    public static int getWeekDay(int yearOfBirth, int monthOfBirth, int dayOfBirth) {

        // Applying Gaussian Algorithm Formula for calculating day number

        int[] mo = new int[] {0,31,59,90,120,151,181,212,243,273,304,334};
        int af = monthOfBirth > 2 ? 0 : 1;
        int w = 5 + (yearOfBirth - 1700)*365 + (yearOfBirth - 1700 - af)/4 -
                (yearOfBirth - 1700 - af)/100 +(yearOfBirth - 1600 - af)/400 + mo[monthOfBirth-1] + (dayOfBirth-1);

        return w % 7;

    }

    public static void introMessage() {
        System.out.println("Enter your Birth Date");
    }
}