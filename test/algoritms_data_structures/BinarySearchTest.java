package algoritms_data_structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jyodroid on 1/14/17.
 */
public class BinarySearchTest {

    private static final int NOT_FOUND = -1;

    @Test
    public void binarySearchTest() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 77, 88, 100};
        BinarySearch binarySearch = new BinarySearch();

        //Act
        int searchPosition = binarySearch.binarySearch(array, 0, array.length - 1, 77);

        //Assert
        assertEquals(9, searchPosition);
    }

    @Test
    public void binarySearchNotFoundTest() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 77, 88, 100};
        BinarySearch binarySearch = new BinarySearch();

        //Act
        int searchPosition = binarySearch.binarySearch(array, 0, array.length - 1, 59);

        //Assert
        assertEquals(NOT_FOUND, searchPosition);
    }

    @Test
    public void binarySearchIterativeTest() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 77, 88, 100};
        BinarySearch binarySearch = new BinarySearch();

        //Act
        int searchPosition = binarySearch.binarySearchIterative(array, 77);

        //Assert
        assertEquals(9, searchPosition);
    }

    @Test
    public void binarySearchIterativeNotFoundTest() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 77, 88, 100};
        BinarySearch binarySearch = new BinarySearch();

        //Act
        int search = binarySearch.binarySearchIterative(array, 55);

        //Assert
        assertEquals(NOT_FOUND, search);
    }
}
