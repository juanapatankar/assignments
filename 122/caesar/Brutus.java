class Brutus {
    /** Sets a double[] constant, containing the frequency of each english letter, in order. E.g. 'a' has a frequency of 0.0855, 'e' is the most common letter (frequency of 0.1210), 'z' has a frequency of 0.0011 */
    public static final double[] english = {
        0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218, 0.0209, 0.0496, 0.0733, 0.0022, 0.0081, 0.0421, 0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633, 0.0673, 0.0894, 0.0268, 0.0106, 0.0183, 0.0019, 0.0172, 0.0011
    };
    
    /*** This method, strip, takes one input, a string. It returns a string that contains only the letter characters in the input, with everything else removed */
    public static String strip(String input) {
        // Converts the input to lowercase, so that it's easier to compare with string lowerletters. 
        input = input.toLowerCase();
        String lowerletters = "abcdefghijklmnopqrstuvwxyz";
        // Initialise strippedinput as an empty string
        String strippedinput = "";
        // Iterates through the supplied input. Adds only characters that are in lowerletters to strippedinput, in the same order that they originally appear
        for (int i = 0; i < input.length(); i++) {
            char stringchar = input.charAt(i);
            if (lowerletters.indexOf(stringchar) != -1) {
                strippedinput += (Character.toString(stringchar));
            } 
        }
        return strippedinput;
    }

    /*** The count method takes one input as a string, and returns an int[] lettercount. Lettercount is an array of 26 elements, one for each letter, consisting of the number of times a letter appears in the string (either upper or lowercase). */
    public static int[] count(String input) {
        // Converts the input to lowercase, as case doesn't need to be preserved for this method's purpose
        // Initialise a blank array with length 26 (for 26 English letters). Create a string containing lowercase letters, in order, to easily add to the array in the correct position for comparing later
        int[] lettercount = new int[26];
        // Removes all non-letter characters from the input string
        input = strip(input);
        String lowerletters = "abcdefghijklmnopqrstuvwxyz";
        // Iterate through each character in the input string. 
        for (int i=0; i < input.length(); i++) {
            char stringchar = input.charAt(i);
            // If the character is a letter, it matches this with the correct position in lowerletters, so that the correct element in lettercount can be incremented. Otherwise, move onto the next character in the string
            int letterindex = lowerletters.indexOf(stringchar);
            lettercount[letterindex] += 1;
        }
        return lettercount; 
    }   

    /*** This method, frequency, takes one string as input, and returns an array double[], containing the frequency of each letter in the input. This is normalised by dividing by the total length of the stripped input */
    public static double[] frequency(String input) {
        double[] frequency = new double[26];
        String lowerletters = "abcdefghijklmnopqrstuvwxyz";
        input = strip(input);
        for (int i=0; i < input.length(); i++) {
            char stringchar = input.charAt(i);
            int letterindex = lowerletters.indexOf(stringchar);
            frequency[letterindex] += 1;
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
