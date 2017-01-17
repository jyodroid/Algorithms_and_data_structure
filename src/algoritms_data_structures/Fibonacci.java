package algoritms_data_structures;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	//O(2^n) complexity 
	public long fibonacci(int n){
		if(n == 0 || n == 1){
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	//O(n) complexity
	public long memoriedFibonacci(int n, long[] memory){
		
		if(n == 0 || n == 1){
			return 1;
		}else if (memory[n-1] == 0){
			memory[n-1] = memoriedFibonacci(n-1, memory) + memoriedFibonacci(n-2, memory);
		}
		return memory[n-1];
	}
	/**
	 * DP
	 * 1. Memory
	 * 2. What are the subproblems that helps solve the problem
	 * 3. re - use the answer of subproblems. 
	 * 4. time = # subproblem * time/subproblem 
	 * @param n
	 * @return
	 */
	//O(n) complexity, essentially recursive + memorization
	public long fibonacciDP(int n){
		Map<Integer, Long> fiboValues = new HashMap<>();
		for (int k = 0; k <= n; k++) {
			long fiboValue;
			if(k < 2) {
				fiboValue = 1;
			} else {
				fiboValue = fiboValues.get(k-1) + fiboValues.get(k-2);
			}
			fiboValues.put(k, fiboValue);
		}
		return fiboValues.get(n);
	}
}