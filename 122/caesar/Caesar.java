class Caesar {
    /*** This method, rotate, takes 2 inputs: an integer (shift) to shift the input by, and a single character (input) to shift. It then returns the encoded character */
    public static char rotate(int shift, char input) {
        // 2 strings are assigned, to shift any chars that are letters. This is done separately to preserve input case when the final string is returned through main
        String lowerletters = "abcdefghijklmnopqrstuvwxyz";
        String upperletters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // The below if/else if/else has 3 branches - one for shifting lowercase letters, one for upper case letters, and the else for other characters (spaces, punctuation) 
        if (lowerletters.indexOf(input) != -1) {
            // This inner if/else determines if the shift is positive, or negative. If it's positive, it shifts normally, using modulo to wrap around
            // The else if for negative shifts. It uses adding and modulo to convert to a positive shift, then applies this
            if (shift >= 0) {
                return lowerletters.charAt((lowerletters.indexOf(input) + shift) % 26);
            } else {
                shift = 26 + (shift % 26);
                return lowerletters.charAt((lowerletters.indexOf(input) + shift) % 26);
            }
        } else if (upperletters.indexOf(input) != -1) {
            // This if/else is the same as above
            if (shift >= 0) {
                return upperletters.charAt((upperletters.indexOf(input) + shift) % 26);
            } else {
                shift = 26 + (shift % 26);
                return upperletters.charAt((upperletters.indexOf(input) + shift) % 26);
            }
        } else {
            // This just returns the original character (for ones that aren't letters)
            return input;
        }
    }

    /** This rotate method takes an integer (shift), and a string input, and returns the encoded string. It is called in main with both command-line arguments */
    public static String rotate(int shift, String input) {
        // initialise result to an empty string, to add the next character to. This character will be encoded if appropriate, after being tested when the rotate(int, char) method above is called
        String result = "";
        // This for loop is used to iterate through the input string
        for (int i=0; i < input.length(); i++ ) {
            result += rotate(shift, input.charAt(i));
        }
        // Returns the encoded input, as a string. Preserves anything that isn't letters
        return result;
    }

    /** This method prints an error message if the user inputs anything other than 2 inputs to encode. If the user only inputs one argument, the program returns an attempt at a decoded version, as well as outputting the below message */
    public static void correctusage() {
        System.out.println("Usage: java Caesar n [original text]");
    }

    /** The main method take the command-line arguments, as String[]. It first checks the number of arguments given, and prints a custom message if there are anything other than 2 supplied arguments. If 2 arguments are supplied, it encodes this by the shifting by the inputted integer (args[0]). If there is only 1, it will first try to decode */
    public static void main(String[] args) {
        // This if/else if/else if/else calls rotate(int, string) for either 2 or 1 arguments. It prints an error message, and a usage prompt (using the correctusage() method) for anything other than 2 arguments. The final else is an umbrella for anthing more than 2 arguments, while the last else if is for when no arguments are supplied
        if (args.length == 2) {
            System.out.println(rotate(Integer.parseInt(args[0]), args[1]));
        } // Check if there are no given command-line arguments
        else if (args.length == 0) {
            System.out.println("No arguments given!");
            correctusage();
        } // Check if there is only one argument, and tries to decode it
        else if (args.length == 1) {
            System.out.println(Brutus.decoded(args[0]));
            System.out.println("\nYou've missed an argument if you wanted to encode!");
            correctusage();
        } // Outputs an error if there are too many arguments
        else {
            System.out.println("Too many arguments");
            correctusage();
        }
    }
}
