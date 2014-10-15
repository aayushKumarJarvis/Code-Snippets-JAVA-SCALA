
import java.util.Scanner;

public interface Shape {

    public double areaOfShape();
    public double perimeterOfShape();
    public void setSides(int numberOfSides);
    public void getResults();
}

class Triangle implements Shape {

    public static double[] arrayOfSides = new double[3];
    public void setSides(int numberOfSides) {

        System.out.println("Enter the three sides of a triangle");
        Scanner objectForScanner = new Scanner(System.in);

        for(int loopVariable = 0;loopVariable<numberOfSides;loopVariable++) {
            arrayOfSides[loopVariable] = objectForScanner.nextInt();
        }
    }

    public double areaOfShape() {

        double semiPerimeter = (arrayOfSides[0] + arrayOfSides[1] + arrayOfSides[2])/2;
        return Math.sqrt(semiPerimeter*(semiPerimeter-arrayOfSides[0])*(semiPerimeter-arrayOfSides[1])*(semiPerimeter-arrayOfSides[2]));

    }

    public double perimeterOfShape() {

        return (arrayOfSides[0] + arrayOfSides[1] + arrayOfSides[2])/3;
    }

    public void getResults() {

        System.out.println("Area of Triangle is "+areaOfShape());
        System.out.println("Perimeter of Triangle is "+perimeterOfShape());

    }
   }

class RightTriangle extends Triangle implements Shape {

    public void getResults() {

        System.out.println("This is a right angled triangle\n\n");
        System.out.println("Area of Triangle is "+areaOfShape());
        System.out.println("Perimeter of Triangle is "+perimeterOfShape());

    }
}

class Rectangle implements Shape {

    public static double[] arrayOfSides = new double[4];
    public void setSides(int numberOfSides) {

        System.out.println("Enter the length and breadth of rectangle");
        Scanner objectForScanner = new Scanner(System.in);
        for(int loopVariable=0;loopVariable<numberOfSides/2;loopVariable++) {
            arrayOfSides[loopVariable] = objectForScanner.nextInt();

        }

        arrayOfSides[2] = arrayOfSides[0];
        arrayOfSides[3] = arrayOfSides[1];
    }

    public double perimeterOfShape() {

        return 2*(arrayOfSides[0] + arrayOfSides[1]);
    }

    public double areaOfShape() {

        return arrayOfSides[0] * arrayOfSides[1];
    }

    public void getResults() {

        System.out.println("This is a rectangle\n\n");
        System.out.println("Area of rectangle "+areaOfShape());
        System.out.println("Perimeter of rectangle " + perimeterOfShape());
    }

}

class Square extends Rectangle implements Shape {

    public static int side;
    public void getResults() {

        System.out.println("This is a square");
        System.out.println("Area of square "+areaOfShape());
        System.out.println("Perimeter of square "+perimeterOfShape());
    }
}

class DriverProgram {

    public static void main(String args[]) {

        Shape InterfaceInstance;

        Scanner objectForScanner = new Scanner(System.in);
        System.out.println("Enter your choice of Shape 1-Triangle 2-Right-Triangle 3-Rectangle 4-Square");
        int choice = objectForScanner.nextInt();

        switch(choice) {

            case 1: InterfaceInstance = new Triangle();
                    InterfaceInstance.setSides(3);
                    InterfaceInstance.getResults();
                    break;

            case 2: InterfaceInstance = new RightTriangle();
                    InterfaceInstance.setSides(3);
                    InterfaceInstance.getResults();
                    break;

            case 3: InterfaceInstance = new Rectangle();
                    InterfaceInstance.setSides(4);
                    InterfaceInstance.getResults();
                    break;

            case 4: InterfaceInstance = new Square();
                    InterfaceInstance.setSides(4);
                    InterfaceInstance.getResults();
                    break;

            default: System.out.println("Wrong choice!! Select the correct option and try again");
        }

    }
}
