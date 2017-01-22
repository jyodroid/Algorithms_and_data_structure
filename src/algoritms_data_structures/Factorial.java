package algoritms_data_structures;

public class Factorial {

	public static int factorial(int num) throws Exception{
		if(num == 0){
			return 1;
		}
		if (num < 0){
			throw new Exception("Undefined Factorial");
		}
		
		int previous = num - 1;
		if (previous > 0){
			if (previous -1 >= 0){
				num *= factorial(previous);
			}
		}
		
		return num;
	}

	public static int memoriedFactorial(int num, int[] memory) throws Exception{
		if(num == 0){
			return 1;
		}
		if (num < 0){
			throw new Exception("Undefined Factorial");
		}

		if (memory[num] == 0){
			memory[num] = num * memoriedFactorial(num-1, memory);
		}

		return memory[num];
	}

	public static int iterativeFactorial(int num, int[] memory) throws Exception{
		memory[0] = 1;

		if (num < 0){
			throw new Exception("Undefined Factorial");
		}

		for (int i = 1; i < memory.length; i++){
			memory[i] = i * memory[i - 1];
		}

		return memory[num];
	}
}
