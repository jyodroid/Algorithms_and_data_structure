package algoritms_data_structures;

public class Sort {
	/**
	 * Simplest sorting algorithm
	 *  O (n^2)
	 * @param array
	 */
	public static void secelctionSort(int[] array){
		
		//move original array to the sorted array. compare each element to the others
		for (int i = 0; i < array.length - 1; i++) {
			int smallestIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[smallestIndex]) {
					smallestIndex = j;
				}
			}
			int vessel = array[i];
			array[i] = array[smallestIndex];
			array[smallestIndex] = vessel;
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
			
			int[] leftArray = new int[middle];
			for (int i = 0; i < middle; i++) {
				leftArray[i] = array[i];
			}
			
			int[] rigthArray = new int[arraySize - middle];
			for (int i = middle; i < arraySize; i++) {
				rigthArray[i - middle] = array[i];
			}
			
			//Sort each subArray
			mergeSort(rigthArray);
			mergeSort(leftArray);
			
			//merge each subArray
			mergeArrays(leftArray, rigthArray, array);
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
	
	public static void main(String[] args) {
		int[] array = {2,6,3,5,7,1,4};
		
		secelctionSort(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
		
	}

}
