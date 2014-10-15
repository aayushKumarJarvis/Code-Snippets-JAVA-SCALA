
import org.junit.Test;
import static org.junit.Assert.*;

public class SparseMatrixTest {

    @Test
    public void testConstructMatrix() {
        int row = 3;
        int column = 3;
        SparseMatrix objectForSparseMatrix = new SparseMatrix(row,column);

        int[][] matrix = objectForSparseMatrix.constructMatrix();
        objectForSparseMatrix.display(matrix);
    }
}
