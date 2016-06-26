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
				num = num * factorial(previous);
			}
		}
		
		return num;
	}
}
