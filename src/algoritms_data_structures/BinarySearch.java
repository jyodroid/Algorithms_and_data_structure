package algoritms_data_structures;

public class BinarySearch {
	
	public int binarySearch(int [] array, int init, int end, int searchedValue){
		
		if(init > end){
			return -1;
		}
		
		int index = (end + init)/ 2;
		if(array[index] == searchedValue){
			return index;
		}else{
			if(searchedValue > array[index]){
				index = binarySearch(array, index + 1, end, searchedValue);
			}else{
				index = binarySearch(array, init, index - 1, searchedValue);
			}
		}
		
		return index;
	}
	
	public int binarySearchIterative(int [] array, int searchedValue){
		
		int left = 0;
		int right = array.length;
		
		while(left <= right){
			int index = (left + right)/ 2;
			if(array[index] == searchedValue){
				return index;
			}else{
				if(searchedValue > array[index]){
					left = index + 1; 
				}else{
					right = index - 1;					
				}
			}
		}
		
		return -1;
	}
}
