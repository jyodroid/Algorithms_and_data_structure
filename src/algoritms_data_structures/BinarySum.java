package algoritms_data_structures;

/**
 * Created by jyodroid on 1/30/17.
 */
public class BinarySum {

    public String sumBinaries(String a, String b) {

        StringBuilder result = new StringBuilder();

        int biggerLength = b.length();
        if (a.length() > b.length()) {
            biggerLength = a.length();
        }

        boolean hasCarrier = false;
        for (int i = 0; i < biggerLength; i++) {
            char augend = '0';
            if (a.length() - 1 - i >= 0) {
                augend = a.charAt(a.length() - 1 - i);
            }
            char addded = '0';
            if (b.length() - 1 - i >= 0) {
                addded = b.charAt(b.length() - 1 - i);
            }

            if (augend == '1' && addded == '1') {
                if (!hasCarrier) {
                    result.append('0');
                    hasCarrier = true;
                } else {
                    result.append('1');
                }
            } else if (augend == '1' ^ addded == '1') {
                if (!hasCarrier) {
                    result.append('1');
                } else {
                    result.append('0');
                }
            } else {
                if (hasCarrier) {
                    result.append(1);
                    hasCarrier = false;
                }
            }
        }

        if (hasCarrier) {
            result.append('1');
        }

        return result.reverse().toString();
    }

    public static void main(String... arg) {
        BinarySum bs = new BinarySum();
        System.out.println(bs.sumBinaries("1011", "111"));
        System.out.println(bs.sumBinaries("1101101", "1011"));
    }

}
