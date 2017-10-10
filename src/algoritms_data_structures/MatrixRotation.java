package algoritms_data_structures;

/**
 * Created by johntangarife on 10/10/17.
 */

public class MatrixRotation {
    public int[][] rotateMatrix (int[][] matrix){

        for (int layer = 0; layer < Integer.valueOf(matrix.length/2); layer++){
            int first = layer;
            int last = matrix.length - layer - 1;

            for (int index = first; index < last; index++){
                int offset = index - first;

//                Save top
                int top = matrix[first][index];
//                left -> top
                matrix[first][index] = matrix[last - offset][first];
//                bottom -> left
                matrix[last - offset][first] = matrix[last][last-offset];
//                right -> bottom
                matrix[last][last - offset] = matrix[index][last];
//                top -> right
                matrix[index][last] = top;
            }
        }

        return matrix;
    }
}
