package algoritms_data_structures;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by johntangarife on 10/10/17.
 */

public class MatrixRotationTest {
    @Test
    public void matrix1Test() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrixRotation matrixRotation = new MatrixRotation();
        int[][] rotatedMatrix = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};

        //Act
        matrix = matrixRotation.rotateMatrix(matrix);

        //Assert
        assertArrayEquals(rotatedMatrix, matrix);
    }

    @Test
    public void matrix2Test() {
        //Arrange
        int[][] matrix = {{1}};
        MatrixRotation matrixRotation = new MatrixRotation();
        int[][] rotatedMatrix = {{1}};

        //Act
        matrix = matrixRotation.rotateMatrix(matrix);

        //Assert
        assertArrayEquals(rotatedMatrix, matrix);
    }

    @Test
    public void matrix3Test() {
        //Arrange
        int[][] matrix = {{10,9,6,3,7}, {6,10,2,9,7}, {7,6,3,8,2}, {8,9,7,9,9}, {6,8,6,8,2}};
        MatrixRotation matrixRotation = new MatrixRotation();
        int[][] rotatedMatrix = {{6,8,7,6,10}, {8,9,6,10,9}, {6,7,3,2,6}, {8,9,8,9,3}, {2,9,2,7,7}};

        //Act
        matrix = matrixRotation.rotateMatrix(matrix);

        //Assert
        assertArrayEquals(rotatedMatrix, matrix);
    }
}
