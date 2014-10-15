import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestMatrixClass {

    @Test
    public static void testFunctions() throws IOException {

        BufferedReader objectForBuffer = new BufferedReader(new InputStreamReader(System.in));
        Matrix objectForMatrix = new Matrix();

        int row, column;
        System.out.println("Enter number of rows and columns");

        row = Integer.parseInt(objectForBuffer.readLine());
        column = Integer.parseInt(objectForBuffer.readLine());

        int arrayForInput[][] = objectForMatrix.generateMatrix(row,column);

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arrayForInput[i][j] = Integer.parseInt(objectForBuffer.readLine());
            }
        }

        System.out.println("Printing the input matrix");
        //Testing Display Method
        objectForMatrix.displayMatrix(arrayForInput);

        System.out.println("Printing the transposed matrix");
        //Testing Transpose Method
        int tempMatrix[][] = objectForMatrix.transposeMatrix(arrayForInput);
        objectForMatrix.displayMatrix(tempMatrix);

        //Testing the Trace Method
        try {
            System.out.println("Trace of Matrix is " + objectForMatrix.traceOfMatrix(arrayForInput));
        } catch (TraceException e) {

        }

        //Testing Norm Method
        System.out.println("Norm of the matrix is " + objectForMatrix.normOfMatrix(arrayForInput));

    }

    public static void testAdditionMultiplication() throws IOException {

        BufferedReader objectForBuffer = new BufferedReader(new InputStreamReader(System.in));
        Matrix objectForMatrix = new Matrix();

        System.out.println("Enter the rows and columns of first matrix");
        int row1 = Integer.parseInt(objectForBuffer.readLine());
        int column1 = Integer.parseInt(objectForBuffer.readLine());

        System.out.println("Enter rows and columns of 2nd matrix");
        int row2 = Integer.parseInt(objectForBuffer.readLine());
        int column2 = Integer.parseInt(objectForBuffer.readLine());

        int[][] matrixOne = objectForMatrix.generateMatrix(row1,column1);
        int[][] matrixTwo = objectForMatrix.generateMatrix(row2,column2);

        // Testing the addition function
        try {
            int[][] matrixThree = objectForMatrix.addTwoMatrix(matrixOne, matrixTwo);
            System.out.println("Added Matrix is " + matrixThree);

        } catch (AdditionException e) {

        }

        // Testing the multiplication
        int[][] matrixFour = objectForMatrix.multiplyTwoMatrix(matrixOne, matrixTwo);
        System.out.println("Multiplied Matrix is " + matrixFour);
    }

    public static void main(String args[]) {

        //Calling testFunctions
        try {
            testFunctions();
        } catch (IOException e) {

        }

        //Calling addition and multiplication functions
        try {
            testAdditionMultiplication();
        }
        catch (IOException e) {
        }
    }
}