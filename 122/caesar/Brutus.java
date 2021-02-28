import java.util.Arrays;
class Brutus {
    public static final double[] english = {
        0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218, 0.0209, 0.0496, 0.0733, 0.0022, 0.0081, 0.0421, 0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633, 0.0673, 0.0894, 0.0268, 0.0106, 0.0019, 0.0172, 0.0011
    };

    public static int[] count(String input) {
        input = input.toLowerCase();
        int[] lettercount = new int[26];
        String lowerletters = "abcdefghijklmnopqrstuvwxyz";
        for (int i=0; i < input.length(); i++) {
            char stringchar = input.charAt(i);
            if (lowerletters.indexOf(stringchar) != -1) {
                int letterindex = lowerletters.indexOf(stringchar);
                lettercount[letterindex] += 1;
            }
        }
        return lettercount;    
    }

    public static double[] frequency(String input) {
        double[] frequency = new double[26];
        input = input.toLowerCase();
        String lowerletters = "abcdefghijklmnopqrstuvwxyz";
        for (int i=0; i < input.length(); i++) {
            char stringchar = input.charAt(i);
            if (lowerletters.indexOf(stringchar) != -1) {
                int letterindex = lowerletters.indexOf(stringchar);
                frequency[letterindex] += 1;
            }
        }
        for (int i=0; i < 26; i++) {
            frequency[i] /= input.length();
        }
        return frequency;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString((frequency(args[0]))));
    }
}