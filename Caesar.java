public class Caesar extends MonoAlphaSubstitution {
    /***
    * Declare a blank translation table
    */
    public char[] translate;
    /***
    * Delare a string containing the actual alphabet
    */
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    /***
    * Default constructor, intialises translate as a translation table containing the unchanged alphabet
    */
    public Caesar() {
        translate = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    }

    /***
     * Initialises the translation table as the alphabet, then calculates the number of letters to shift forwards/backwards by depending on the given number. Uses the string encoder to select the target letter for each element in the translation table, which is then updated.
     * @param shift the number of letters to shift by 
     */
    public Caesar(int shift) {
        translate = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String encoder = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < translate.length; i++) {
            if (shift < 0) {
                shift = 26 + (shift % 26);
            }
            translate[i] = encoder.charAt((i + shift) % 26);
        }
    }

    /***
    * Uses the alphabet string to test if the passed character is or is not a letter. Returns true or false depending on the result.
    * @param test the character to test
    * @return true if test is a letter. Otherwise, false
    */
    public static Boolean isLetter(char test) {
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == test) {
                return true;
            }
        }
        return false;
    }

    /*** 
    * If toChange is a capital, set the caps flag to true then make toChange lowercase. If toChange is not a letter, then return the unchanged character. If toChange is a letter, find its index position in the alphabet, then return the letter that is in the translation table at the same position. E.g. 'r' is the 18th letter, so encrypt('r') will return the 17th letter in the translation table. 
    * @param the character to encrypt
    * @return the encrypted character
    */
    public char encrypt(char toChange) {
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Boolean cap = false;
        // Test if toChange is a capital letter
        if (caps.contains(Character.toString(toChange))) {
            cap = true;
            toChange = Character.toLowerCase(toChange);
        }
        // Test if toChange is a letter
        if (isLetter(toChange)) {
            int letter = alphabet.indexOf(Character.toString(toChange));
            if (!cap) {
                return translate[letter];
            } else {
                // Return the uppercase of the encrypted letter
                return Character.toUpperCase(translate[letter]);
            }
        } else {
            // Return the unchanged character, since not a letter
            return toChange;
        }
    }

    /***
    * Returns the index position of a value (in this case a letter) in the translation table. If it isn't in the table, then return -1 (as int expected).
    * @param toFind
    * @param mapping
    * @return the index position of the character in the translation table. If it is not present, return -1. 
    */
    public static int findIndex(char toFind, char[] mapping) {
        for (int i = 0; i < mapping.length; i++) {
            if (mapping[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    /***
    * Decrypts the given character, by finding it in the translation table then returning the character that is at that same position in the real alphabet. If toChange is a capital letter, then sets the caps flag to true and makes toChange lowercase for comparison. The decrypted character will be converted back to uppercase, since caps is true. If toChange is not a letter, then returns the unchanged character. 
    * @param toChange the given character to decrypt
    * @return the decrypted character
    */
    public char decrypt(char toChange) {
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Boolean cap = false;
        // Tests if toChange is a capital letter
        if (caps.contains(Character.toString(toChange))) {
            cap = true;
            toChange = Character.toLowerCase(toChange);
        }
        // Tests if toChange is a letter. 
        if (isLetter(toChange)) {
            // Finds the index position of toChange in the mapped translation table
            int letter = findIndex(toChange, translate);
            if (!cap) {
                return alphabet.charAt(letter);
            } else {
                // Returns the uppercase of the decrypted character
                return Character.toUpperCase(alphabet.charAt(letter));
            }
        } else {
            // Returns the unchanged character
            return toChange;
        }
    }

    /***
    * First test if the correct number of arguments was passed, and output the correct error message if less or more than 3 arguments were passed. If test 1 is succesful, then check if the first argument is 'encrypt'/'decrypt' and output an error message if test fails. Assuming both tests are passed, initialise the translation table by passing the second argument as the number of positions to shift each letter by. Finally, encrypts/decrypts the third argument as requested. 
    * @param args an array containing the strings passed at the command line
    */
    public static void main(String[] args) {
        Boolean valid = false;
        // Test if 3 arguments passed
        if (args.length < 3) {
            System.out.println("Too few parameters!\nUsage: java Caesar encrypt n \"cipher text\"");
        } else if (args.length > 3) {
            System.out.println("Too many parameters!\nUsage: java Caesar encrypt n \"cipher text\"");
        } else {
            valid = true;
        }
        
        if (valid) {
            // Test if valid first argument
            if (!(args[0].contains("encrypt") || args[0].contains("decrypt"))) {
                System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\nUsage: java Caesar encrypt n \"cipher text\"");
            }
            // Encrypts/decrypts as necessary
            if (args[0].contains("encrypt") && valid) {
                Caesar tr = new Caesar(Integer.parseInt(args[1]));
                System.out.println(tr.encrypt(args[2]));
            }
            if (args[0].contains("decrypt") && valid) {
                Caesar tr = new Caesar(Integer.parseInt(args[1]));
                System.out.println(tr.decrypt(args[2]));
            }
        }
    }
}