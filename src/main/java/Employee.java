import java.util.Scanner;

public class Employee {

    static double basicSalary;
    static int hours;
    static double ratePerHour;
    static double sales;
    static double salesPercentage;

    Employee(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    Employee(double basicSalary,int hours, double ratePerHour) {
        this.basicSalary = basicSalary;
        this.hours = hours;
        this.ratePerHour = ratePerHour;
    }

    Employee(double sales, double salesPercentage) {
        this.sales = sales;
        this.salesPercentage = salesPercentage;
    }

    Employee(double basicSalary, double sales,double salesPercentage) {
        this.basicSalary = basicSalary;
        this.sales = sales;
        this.salesPercentage = salesPercentage;
    }

    protected static String getEmployeeType() {

        System.out.println("Enter the type of Employee");
        Scanner objectForScanner = new Scanner(System.in);
        String employeeType = objectForScanner.nextLine();

        return employeeType;
    }

    protected static int getEmployeeCode() {

        String employeeType = getEmployeeType();

        if(employeeType.equalsIgnoreCase("salaried"))
            return 1;
        else if(employeeType.equalsIgnoreCase("hourly"))
            return 2;
        else if(employeeType.equalsIgnoreCase("commission"))
            return 3;
        else if(employeeType.equalsIgnoreCase("salaried-commission"))
            return 4;
        else
            return -1;

    }

    protected static double calculateEmployeeSalary() {

        Scanner objectForScanner = new Scanner(System.in);
        double salaryOfEmployee = 0;
        int employeeCode = getEmployeeCode();

        switch (employeeCode) {

            case 1 : System.out.println("Please enter the basic salary");
                     double basicSalary = objectForScanner.nextDouble();

                     Employee salariedEmployee = new Employee(basicSalary);
                     salaryOfEmployee = salariedEmployee.basicSalary;
                     break;

            case 2: System.out.println("Please enter basic salary");
                    double basicSalary1 = objectForScanner.nextDouble();
                    System.out.println("Please enter no. of hours");
                    int numberOfhours = objectForScanner.nextInt();
                    System.out.println("Please enter hourly rate");
                    double hourlyRate = objectForScanner.nextDouble();

                    Employee hourlyEmployee = new Employee(basicSalary1,numberOfhours,hourlyRate);
                    salaryOfEmployee = hourlyEmployee.basicSalary + (hourlyEmployee.hours - 40)*hourlyEmployee.ratePerHour;
                    break;

            case 3: System.out.println("Please enter sales");
                    double sales = objectForScanner.nextDouble();
                    System.out.println("Please enter sales percentage");
                    double salesPercentage = objectForScanner.nextDouble();

                    Employee commissionEmployee = new Employee(sales,salesPercentage);
                    salaryOfEmployee = commissionEmployee.sales*commissionEmployee.salesPercentage/100;
                    break;

            case 4: System.out.println("Please enter basic salary");
                    double basicSalary2 = objectForScanner.nextDouble();
                    System.out.println("Please enter sales");
                    double sales1 = objectForScanner.nextDouble();
                    System.out.println("Please enter sales percentage");
                    double salesPercentage1 = objectForScanner.nextDouble();

                    Employee salesCommissioned = new Employee(basicSalary2,sales1,salesPercentage1);
                    salaryOfEmployee = salesCommissioned.basicSalary + salesCommissioned.sales*salesCommissioned.salesPercentage;
                    break;

            case -1: System.out.println("Wrong Employee code");

        }

        return salaryOfEmployee;
    }

    public static void main(String args[]) {

        double salaryOfEmployee = calculateEmployeeSalary();
        System.out.println("Your Salary is " + salaryOfEmployee);
    }
}
