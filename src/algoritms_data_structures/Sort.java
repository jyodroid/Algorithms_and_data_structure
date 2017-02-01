package algoritms_data_structures;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort {
	/**
	 * Simplest sorting algorithm
	 *  O (n^2)
	 * @param array
	 */
	public static void selectionSort(int[] array){
		
		//compare each element to the others and let the lower at left
		for (int i = 0; i < array.length - 1; i++) {
			int smallestIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[smallestIndex]) {
					smallestIndex = j;
				}
			}
			swap(array, i, smallestIndex);
		}
	}
	
	/**
	 * Compare whit adjacent element
	 * push greatest element to the right of array
	 *  O (n^2)
	 * @param array
	 */
	public static void bubbleSort(int[] array){
		
		for (int i = array.length - 1 ; i > 1 ; i--) {
			//compare each element to the adjacent and swipe if is bigger
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}	
		}
	}
	
    public static void bubbleSort2(int[] array){
        // Track number of elements swapped during a single array traversal
        boolean sorted = false;
        int lastSorted = array.length - 1;
        do {
            sorted = true;
            for (int j = 0; j < lastSorted ; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    sorted = false;
                }
            }
            lastSorted --;
        }while(!sorted);
    }
	
	/**
	 * a little more efficient than selection and bubble sort in practical scenarios
	 * have two subsets of the array, the sorted part and unsorted part
	 * each element is inserted in the correct position in the sorted part
	 *  O (n) best case
	 *  O (n^2) worst case
	 * @param array
	 */
	public static void insertionSort(int[] array){
		for (int i = 1 ; i < array.length; i++) {
			int compValue = array[i];
			int sortedIndx = i;
			while (sortedIndx > 0 && array[sortedIndx - 1] > compValue) {
				array[sortedIndx] = array[sortedIndx - 1];
				sortedIndx = sortedIndx - 1;
			}
			array[sortedIndx] = compValue;
		}
	}
	
	/**
	 * O(n log n) in random case
	 * developed by Charles Antony Richard Hoare
	 * Based on "divide and conquer"
	 * Sorting occurs in the same array
	 * @param array
	 * @param start of sort segment in array
	 * @param end of sort segment in array
	 */
	public static void quickSort(int[] array, int start, int end){
		
		//If array segment is size 1 then array is sorted (stop condition for recursion) 
		if(start < end){
			//Order smaller numbers than pivot to the left and bigger to the right
			int partitionIndex = partition(array, start, end);
			
			//divide array in left and right array if possible
			//left part
			quickSort(array, start, partitionIndex - 1);
			
			//right part
			quickSort(array, partitionIndex + 1, end);
		}	
	}
	
	/**
	 * O(n log n) in random case
	 * developed by Charles Antony Richard Hoare
	 * Based on "divide and conquer"
	 * Sorting occurs in the same array
	 * @param array
	 * @param startIndex of sort segment in array
	 * @param endIndex of sort segment in array
	 */
	public static void quickSort2(int[] array, int startIndex, int endIndex){
		
		if(startIndex > endIndex ){
			return;
		}
		
		int pivot = array[(endIndex + startIndex)/2];
		int partitionIndex = partition2(array, startIndex, endIndex, pivot);
		//divide array in left and right array if possible
		//left part
		quickSort(array, startIndex, partitionIndex - 1);
		
		//right part
		quickSort(array, partitionIndex, endIndex);
	}

	private static int partition2(int [] array, int startIndex, int endIndex, int pivot){
		//Choose a pivot
		while(startIndex <= endIndex){
			while(array[startIndex] < pivot){
				startIndex++;
			}
			
			while(array[endIndex] > pivot){
				endIndex--;
			}
			
			if(startIndex <= endIndex){
				swap(array, startIndex, endIndex);
				startIndex ++;
				endIndex --;
			}
		}
		return startIndex;
	}
	
	private static int partition(int [] array, int start, int end){
		//Choose a pivot
		int pivot = array[end];
		int partitionIndex = start;
		
		for (int i = start; i < end; i++) {
			//Swap values if is element is less than pivot
			if(array[i] <= pivot){
				swap(array, i, partitionIndex);
				partitionIndex ++;
			}
		}
		
		//Swap element at partition index with pivot
		swap(array, end, partitionIndex);
		
		return partitionIndex;
	}

	private static void swap(int [] array, int indexElement1, int indexElement2){
		int vessel = array[indexElement1];
		array[indexElement1] = array[indexElement2];
		array[indexElement2] = vessel;
	}
	
	/**
	 * This Algorithm construct from array multiple sub arrays in memory
	 * O(n log n) in worst case
	 * @param array
	 */
	public static void mergeSort(int[] array){
		int arraySize = array.length;
		if(arraySize > 1){
			//divide in two the array
			int middle;
			if(array.length%2 == 0){
				middle = arraySize/2;
			}else{
				middle =  Integer.valueOf(arraySize/2);
			}
			
			int[] leftArray = Arrays.copyOf(array, middle);
			
			int[] rightArray = new int[arraySize - middle];
            System.arraycopy(array, middle, rightArray, 0, rightArray.length);
			
			//Sort each subArray
			mergeSort(rightArray);
			mergeSort(leftArray);
			
			//merge each subArray
			mergeArrays(leftArray, rightArray, array);
		}
	}
	
	private static void mergeArrays(int[] leftArray, int[] rigthArray, int[] array){
		//smallest unpicked at left
		int leftPosition = 0;
		
		//smallest unpicked at right
		int rightPosition = 0;
		
		//Position that needs to be filled in array
		int arrayPosition = 0;
		
		while(leftPosition < leftArray.length && rightPosition < rigthArray.length){
			if (leftArray[leftPosition] <= rigthArray[rightPosition]) {
				array[arrayPosition] = leftArray[leftPosition];
				leftPosition ++;
			}else{
				array[arrayPosition] = rigthArray[rightPosition];
				rightPosition ++;
			}
			arrayPosition++;
		}
		
		while (leftPosition < leftArray.length) {
			array[arrayPosition] = leftArray[leftPosition];
			leftPosition ++;
			arrayPosition++;
		}
		
		while (rightPosition < rigthArray.length) {
			array[arrayPosition] = rigthArray[rightPosition];
			rightPosition ++;
			arrayPosition++;
		}
	} 
	
	/**
	 * This Algorithm construct from array multiple sub arrays in memory
	 * O(n log n) in worst case
	 * @param array
	 */
	public static void mergeSort2(int[] array){
		mergeSortAux(array, new int[array.length], 0, array.length -1);
			
	}
	
	private static void mergeSortAux(int [] array, int [] auxiliarArray, int leftStart, int rightEnd){
		if(leftStart >= rightEnd){
			return;
		}
		int middle = (leftStart + rightEnd)/2;
		mergeSortAux(array, auxiliarArray, leftStart, middle);
		mergeSortAux(array, auxiliarArray, middle + 1, rightEnd);
		mergeHalves(array, auxiliarArray, leftStart, rightEnd);
	}
	
	private static void mergeHalves (int [] array, int [] auxiliarArray, int leftStart, int rightEnd){
		int leftEnd = (leftStart + rightEnd)/2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while(left <= leftEnd && right <= rightEnd){
			
			if (array[left] < array[right]) {
				auxiliarArray[index] = array[left];
				left++;
				
			}else {
				auxiliarArray[index] = array[right];
				right++;
			}
			
			index++;
		}
		
		System.arraycopy(array, left, auxiliarArray, index , leftEnd - left + 1);
		System.arraycopy(array, right, auxiliarArray, index , rightEnd - right + 1);
		System.arraycopy(auxiliarArray, leftStart, array, leftStart , size);
	} 
	
	public static void main(String[] args) {
		int[] array = {2,6,3,5,7,1,4};
		
		insertionSort(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
		
	}

}
