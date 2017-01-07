package algoritms_data_structures;

public class Fibonacci {
	
	//O(2^n) complexity 
	public static int fibonacci(int n){
		if(n == 0 || n == 1){
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	//O(n) complexity
	public static int memoriedFibonacci(int n, int[] memory){
		
		if(n == 0 || n == 1){
			return 1;
		}else if (memory[n-1] == 0){
			memory[n-1] = memoriedFibonacci(n-1, memory) + memoriedFibonacci(n-2, memory);
		}
		return memory[n-1];
	}
	
	public static void main(String...strings){
		int n = 30;
		long startTime = System.currentTimeMillis();
		System.out.println(memoriedFibonacci(n, new int[n]));
		System.out.println(System.currentTimeMillis() - startTime);
		startTime = System.currentTimeMillis();
		System.out.println(fibonacci(n));
		System.out.println(System.currentTimeMillis() - startTime);
	}

}
