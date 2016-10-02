package algoritms_data_structures;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {

	@Test
	public void testQuickSort() {
		
		//Arrange
		int[] array = {7,2,1,6,8,5,3,4};
		int[] sortedArray = {1,2,3,4,5,6,7,8};
		
		//Act
		Sort.quickSort(array, 0, 7);
		
		//Assert
		assertArrayEquals(sortedArray, array);
	}

	@Test
	public void testMergeSort() {
		
		//Arrange
		int[] array = {7,2,1,6,8,5,3,4};
		int[] sortedArray = {1,2,3,4,5,6,7,8};
		
		//Act
		Sort.mergeSort(array);
		
		//Assert
		assertArrayEquals(sortedArray, array);
	}
	
	@Test
	public void testMergeSortOdd() {
		
		//Arrange
		int[] array = {7,2,1,6,5,3,4};
		int[] sortedArray = {1,2,3,4,5,6,7};
		
		//Act
		Sort.mergeSort(array);
		
		//Assert
		assertArrayEquals(sortedArray, array);
	}
	
	@Test
	public void testSelectionSort() {
		
		//Arrange
		int[] array = {7,2,1,6,8,5,3,4};
		int[] sortedArray = {1,2,3,4,5,6,7,8};
		
		//Act
		Sort.selectionSort(array);
		
		//Assert
		assertArrayEquals(sortedArray, array);
	}
	
	@Test
	public void testBubbleSort() {
		
		//Arrange
		int[] array = {7,2,1,6,8,5,3,4};
		int[] sortedArray = {1,2,3,4,5,6,7,8};
		
		//Act
		Sort.bubbleSort(array);
		
		//Assert
		assertArrayEquals(sortedArray, array);
	}
	
	@Test
	public void testInsertionSort() {
		
		//Arrange
		int[] array = {7,2,1,6,8,5,3,4};
		int[] sortedArray = {1,2,3,4,5,6,7,8};
		
		//Act
		Sort.insertionSort(array);
		
		//Assert
		assertArrayEquals(sortedArray, array);
	}
}
