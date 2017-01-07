package algoritms_data_structures;

public class GeneralTests {
	
	public static void main(String... arguments ){
		char[] a = {'a','b','c','d'};
		char[] b = a.clone();
		a[0] = 'z';
		for(int i = 0; i < b.length; i++){
			System.out.println(b[i]);
		}
	}
	
}
