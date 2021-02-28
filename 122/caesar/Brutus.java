import java.util.Arrays;;
class Brutus {
    public static final double[] english = {
        0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218, 0.0209, 0.0496, 0.0733, 0.0022, 0.0081, 0.0421, 0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633, 0.0673, 0.0894, 0.0268, 0.0106, 0.0183, 0.0019, 0.0172, 0.0011
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

    public static String strip(String input) {
        input = input.toLowerCase();
        String lowerletters = "abcdefghijklmnopqrstuvwxyz";
        String strippedinput = "";
        for (int i = 0; i < input.length(); i++) {
            char stringchar = input.charAt(i);
            if (lowerletters.indexOf(stringchar) != -1) {
                strippedinput += (Character.toString(stringchar));
            } 
        }
        return strippedinput;
    }

    public static double[] frequency(String input) {
        double[] frequency = new double[26];
        String lowerletters = "abcdefghijklmnopqrstuvwxyz";
        input = strip(input);
        

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

    public static double chiSquared(double[] english, double[] cipher) {
        double[] chiSet = new double[26];
        for (int i = 0; i < 26; i++) {
            chiSet[i] = (Math.pow((cipher[i] - english[i]), 2)/english[i]);
        }
        double sum = 0.0;
        for (int i = 0; i < 26; i++) {
            sum += chiSet[i];
        }
        return sum;
    }

    public static int positionofmin(double[] differences) {
        double minvalue = differences[0];
        int position = 0;
        for (int i=0; i < differences.length; i++) {
            if (differences[i] < minvalue) {
                minvalue = differences[i];
                position = i;
            }
        }
        return position;
    }

    public static String decoded(String input) {
        String encodedletters = strip(input);
        int finalshift = 0;
        String rotated;
        double diff;
        double[] chidiffs = new double[26];

        for (int shift = 0; shift <= 25; shift++) {
            rotated = Caesar.rotate(shift, encodedletters);
            diff = chiSquared(english, frequency(rotated));
            chidiffs[shift] = diff;
        }

        finalshift = positionofmin(chidiffs);
        return(Caesar.rotate(finalshift, input));
     }
    public static void main(String[] args) {
        String encodedletters = strip(args[0]);
        int finalshift = 0;
        String rotated;
        double diff;
        double[] chidiffs = new double[26];

        for (int shift = 0; shift <= 25; shift++) {
            rotated = Caesar.rotate(shift, encodedletters);
            diff = chiSquared(english, frequency(rotated));
            chidiffs[shift] = diff;
        }
        
        finalshift = positionofmin(chidiffs);
        System.out.println(Caesar.rotate(finalshift, args[0]));
    }
}
