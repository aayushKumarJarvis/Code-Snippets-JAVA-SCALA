
public class SudokuGenerator {

    public int[][] generateSolution() {
        final int gridNumber = 3;
        final int[][] gridPattern = new int[gridNumber * gridNumber][gridNumber * gridNumber];

        for (int loop1 = 0; loop1 < gridNumber * gridNumber; loop1++) {

            for (int loop2 = 0; loop2 < gridNumber * gridNumber; loop2++) {
                gridPattern[loop1][loop2] = (loop1 * gridNumber + loop1 / gridNumber + loop2) % (gridNumber * gridNumber) + 1;
            }
        }

        return gridPattern;
    }

    public void dispalyPattern(int[][] matrix) {

        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        for (int loop1 = 0; loop1 < rowLength; loop1++) {
            for (int loop2 = 0; loop2 < columnLength; loop2++) {

                System.out.print(matrix[loop1][loop2] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String args[]) {

        SudokuGenerator objectForSudoku = new SudokuGenerator();

        objectForSudoku.dispalyPattern(objectForSudoku.generateSolution());
    }
}
