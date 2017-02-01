package algoritms_data_structures;

public class BitManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,-1,1,2,2};

		int accumXOR = array[0];
		for (int i = 1; i < array.length; i++) {
			accumXOR ^= array[i];
		}

		int accumAND = array[0];
		for (int i = 1; i < array.length; i++) {
			accumAND &= array[i];
		}

		int accumOR = array[0];
		for (int i = 1; i < array.length; i++) {
			accumOR |= array[i];
		}

		System.out.println(accumXOR);
		System.out.println(accumAND);
		System.out.println(accumOR);
		System.out.println(13 << 1); // one left shift
		System.out.println(13 >> 1); // one right shift
		System.out.println(1 << 1); // one left shift multiplies by 2
		System.out.println(1 >> 1); // one right shift
		System.out.println(-13 >> 1); // one right shift (is arithmetic)
		System.out.println(-13 << 1);
		System.out.println(-13 & 1);
		System.out.println(-13 & -14); //Bring minor value
		System.out.println(-13 | 1);
		System.out.println(-13 | -14);
		System.out.println(-13 ^ 1);
		System.out.println(-13 ^ -14);
		System.out.println(0 >> 1);
		System.out.println(~1001);
		int a = 11;
		a >>= 1;
		a >>= 1;
		a >>= 1;
		a >>= 1;
		System.out.println(a);

	}

}
