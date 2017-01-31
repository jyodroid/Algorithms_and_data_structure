package algoritms_data_structures;

/**
 * Created by jyodroid on 1/30/17.
 */
public class BinarySum {

    public String sumBinaries(String a, String b) {

        StringBuilder result = new StringBuilder();

        int big;
        if (a.length() > b.length()) {
            big = a.length();
        } else {
            big = b.length();
        }

        char carrier = '0';
        for (int i = 0; i < big; i++) {
            char up = '0';
            if (a.length() - 1 - i >= 0) {
                up = a.charAt(a.length() - 1 - i);
            }
            char down = '0';
            if (b.length() - 1 - i >= 0) {
                down = b.charAt(b.length() - 1 - i);
            }

            if (up == '1' && down == '1') {
                if (carrier == '0') {
                    result.append('0');
                    carrier = '1';
                } else {
                    result.append('1');
                }
            } else if ((up == '1' ^ down == '1')) {
                if (carrier == '0') {
                    result.append('1');
                } else {
                    result.append('0');
                }
            } else {
                result.append(carrier);
                carrier = '0';
            }
        }

        if (carrier == '1') {
            result.append(carrier);
        }

        return result.reverse().toString();
    }

    public static void main(String... arg) {
        BinarySum bs = new BinarySum();
        System.out.println(bs.sumBinaries("1011", "111"));
        System.out.println(bs.sumBinaries("1101101", "1011"));
    }

}
