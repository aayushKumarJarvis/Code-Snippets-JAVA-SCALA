import java.util.*;
import java.io.*;

public class Matrix {

    protected static int[][] generateMatrix(int row, int column) {

        int [][] generatedMatrix = new int[row][column];
        return generatedMatrix;
    }

    protected static void displayMatrix(int arrayToBeDisplayed[][]) {

        for (int i = 0; i < arrayToBeDisplayed.length; i++) {
            for (int j = 0; j < arrayToBeDisplayed[0].length; j++) {
                System.out.print(arrayToBeDisplayed[i][j] + " ");
            }
            System.out.println();
        }
    }

    protected static int[][] transposeMatrix(int arrayToBeTransposed[][]) {

        int transposedArray[][] = new int[arrayToBeTransposed[0].length][arrayToBeTransposed.length];

        for (int i = 0; i < arrayToBeTransposed.length; i++) {
            for (int j = 0; j < arrayToBeTransposed[0].length; j++) {
                transposedArray[j][i] = arrayToBeTransposed[i][j];
            }
        }
        return transposedArray;
    }

    protected static int traceOfMatrix(int arrayToBeTraced[][]) throws TraceException {

        int trace = 0;
        if (arrayToBeTraced.length == arrayToBeTraced[0].length) {
            for (int i = 0; i < arrayToBeTraced.length; i++) {
                for (int j = 0; j < arrayToBeTraced[0].length; j++) {
                    if (i == j)
                        trace = trace + arrayToBeTraced[i][j];
                }
            }
        } else throw new TraceException();

        return (trace);
    }

    protected static double normOfMatrix(int arrayToBeNormed[][]) {

        double norm = 0, sum = 0;
        for (int i = 0; i < arrayToBeNormed.length; i++) {
            for (int j = 0; j < arrayToBeNormed[0].length; j++) {
                sum = sum + Math.pow(arrayToBeNormed[i][j], 2);
            }
        }
        norm = Math.sqrt(sum);
        return (norm);
    }

    protected static int[][] addTwoMatrix(int matrixOne[][], int matrixTwo[][]) throws AdditionException {

        int addedMatrix[][] = new int[matrixOne.length][matrixOne[0].length];
        if ((matrixOne.length == matrixTwo.length) && (matrixOne[0].length == matrixTwo[0].length)) {
            for (int i = 0; i < matrixOne.length; i++) {
                for (int j = 0; j < matrixOne[0].length; j++) {
                    addedMatrix[i][j] = matrixOne[i][j] + matrixTwo[i][j];
                }
            }
        } else throw new AdditionException();

        return addedMatrix;
    }

    protected static int[][] multiplyTwoMatrix(int matrixOne[][], int matrixTwo[][]) {

        int aRows = matrixOne.length;
        int aColumns = matrixOne[0].length;
        int bRows = matrixTwo.length;
        int bColumns = matrixTwo[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        int[][] multipliedMatrix = new int[aRows][bColumns];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                multipliedMatrix[i][j] = 0;
            }
        }

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                for (int k = 0; k < aColumns; k++) {
                    multipliedMatrix[i][j] += matrixOne[i][k] * matrixTwo[k][j];
                }
            }
        }

        return multipliedMatrix;
    }
}




