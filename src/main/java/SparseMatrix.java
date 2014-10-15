import java.util.Scanner;

public class SparseMatrix {

    int rows;
    int columns;

    public SparseMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int[][] constructMatrix() {

        int[][] matrix = new int[rows][columns];
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("Enter the elements of the matrix");

        for (int loop1 = 0; loop1 < rows; loop1++) {
            for (int loop2 = 0; loop2 < columns; loop2++) {
                matrix[loop1][loop2] = scannerObject.nextInt();
            }
        }

        return matrix;
    }

    public int[][] convert() {

        int[][] normalMatrix = constructMatrix();
        int[] rowIndex = new int[rows];
        int[] columnIndex = new int[columns];
        int[] valueAtIndex = new int[rows * columns];
        int rowCounter = 0;
        int columnCounter = 0;
        int valueCounter = 0;

        // Check for number of non-zero elements in the 2-D array
        for (int loop1 = 0; loop1 < rows; loop1++) {
            for (int loop2 = 0; loop2 < columns; loop2++) {

                if (normalMatrix[loop1][loop2] != 0) {

                    rowIndex[rowCounter] = loop1;
                    columnIndex[columnCounter] = loop2;
                    valueAtIndex[valueCounter] = normalMatrix[loop1][loop2];
                    rowCounter++;
                    columnCounter++;
                    valueCounter++;
                } else
                    continue;
            }
        }

        int sparseMatrix[][] = new int[rowCounter][3];

        for (int loopCounter = 0; loopCounter < rowCounter; loopCounter++) {
            sparseMatrix[loopCounter][0] = rowIndex[loopCounter];
            sparseMatrix[loopCounter][1] = columnIndex[loopCounter];
            sparseMatrix[loopCounter][2] = valueAtIndex[loopCounter];
        }

        return sparseMatrix;
    }

    public int[][] add() {

        Scanner scannerObject = new Scanner(System.in);

        System.out.println("Enter the rows and columns of matrix");
        int row1 = scannerObject.nextInt();
        int column1 = scannerObject.nextInt();

        SparseMatrix matrix1 = new SparseMatrix(row1,column1);
        int m1[][] = matrix1.constructMatrix();
        int sm1[][] = matrix1.convert();

        SparseMatrix matrix2 = new SparseMatrix(row1,column1);
        int m2[][] = matrix2.constructMatrix();
        int sm2[][] = matrix2.convert();

        int sm3[][] = new int[row1][column1];

        for(int loop1 = 0;loop1<row1;loop1++) {
            for(int loop2 = 0;loop2<column1;loop2++) {
                sm3[loop1][loop2] = sm1[loop1][loop2] + sm2[loop1][loop2];
            }
        }

        return sm3;
    }

    public int[][] subtract() {

        Scanner scannerObject = new Scanner(System.in);

        System.out.println("Enter the rows and columns of matrix");
        int row1 = scannerObject.nextInt();
        int column1 = scannerObject.nextInt();

        SparseMatrix matrix1 = new SparseMatrix(row1,column1);
        int m1[][] = matrix1.constructMatrix();
        int sm1[][] = matrix1.convert();

        SparseMatrix matrix2 = new SparseMatrix(row1,column1);
        int m2[][] = matrix2.constructMatrix();
        int sm2[][] = matrix2.convert();

        int sm3[][] = new int[row1][column1];

        for(int loop1 = 0;loop1<row1;loop1++) {
            for(int loop2 = 0;loop2<column1;loop2++) {
                sm3[loop1][loop2] = sm1[loop1][loop2] - sm2[loop1][loop2];
            }
        }

        return sm3;
    }

    public void display(int[][] matrix) {

        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        for(int loop1 = 0;loop1<rowLength;loop1++) {
            for(int loop2 = 0;loop2<columnLength;loop2++) {
                System.out.println(matrix[rowLength][columnLength]+" ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String args[]) {

        int row = 3;
        int column = 3;
        SparseMatrix objectForSparseMatrix = new SparseMatrix(row,column);

        int[][] matrix = objectForSparseMatrix.constructMatrix();
        objectForSparseMatrix.display(matrix);
    }
}
