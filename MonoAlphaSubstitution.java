public class MonoAlphaSubstitution extends Substitution {
    // Declares translate, an array containing characters
    public char[] translate;
    // Declares an alphabet string, to test character
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    // Default constructor, assigns an unchanged translation table
    public MonoAlphaSubstitution() {
        // Initialise translate
        translate = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    }
    /*** 
     * Changes the translation table so that each letter that appears in the mapping is changed to the appropriate new character. Letters that aren't in mapping as those to be changed remain unaffected.
     * @param mapping the string depicting what each alternate character should be changed to (the character after)
     */
    public MonoAlphaSubstitution(String mapping) {
        // Find alternate characters
        translate = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i = 1; i < mapping.length(); i+=2) {
            char encoded = mapping.charAt(i);
            char decoded = mapping.charAt(i-1);
           translate[letterToNumber(decoded)] = encoded; 
        }
        
    }

    /***
     * Helper method converts a letter in the alphabet to its index. E.g. 'c' is the third letter of the alphabet, so its index is 2.
     * @param toFind the character whose index position in the alphabet needs to be identified
     * @return pos, the index position of the character (assuming it is a letter)
     */
    public static int letterToNumber(char toFind) {
        int pos = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == toFind) {
                pos = i;
            }
        }
        return pos;
    }

    /***
     * If the character in the string to be encoded/decoded is in the key (mapping), then return the index position of it in mapping. Otherwise, return -1 to indicate that the plaintext character should not be changed
     * @param toFind the character that is to be encoded/decoded from the command-line text 
     * @param mapping the string stating what each included character should be changed to. Passed from the command line
     * @return the position of the target character in mapping
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
     * Test if the current character in the input string is a letter (which may be encrypted/decrypted) or is a number/punctuation/' '.
     * @param test the character to be tested
     * @return true if and only if the character is a letter
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
     * Takes a passed character. If it is a capital, set the cap flag to true and convert the character to lowercase. The returned character will be a capital, even though toChange will be manipulated as a lowercase letter. If it isn't a capital, test if the character is a letter by calling the static method isLetter. If it isn't a letter, return the unchanged character. If it is a letter, return the corresponding letter in the translation table. E.g. if the letter is 'f', the 6th letter in the table will be returned. 
     * @param toChange a character to be encrypted
     * @return the encrypted character
     */
    public char encrypt (char toChange) {
        int letter;
        Boolean cap = false;
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (caps.contains(Character.toString(toChange))) {
            cap = true;
            toChange = Character.toLowerCase(toChange);
        }
        letter = letterToNumber(toChange);
        if (!isLetter(toChange)) {
            return toChange;
        } else {
            if (!cap) {
                return translate[letter];
            } else {
                return Character.toUpperCase(translate[letter]);
            }
            
        }
    }

    /*** 
     * As with encrypt, first check if the character is a capital letter. If it is, convert it to lowercase (for comparing) and set the cap flag to true. If it isn't, test if it is a letter using isLetter. If it isn't, return the unchanged character. Otherwise, find the index position of the letter in the translation table and return the corresponding letter in the alphabet. E.g. if the mapping dictates that 'g's should be changed to 'z's (encrypted), find 'z' in the translation table, which will be the 6th element, and therefore return the alphabet.charAt(6), the 7th letter in the alphabet ('g'). 
     * @param toChange the character to be decrypted if appropriate
     * @return the decrypted character
     */
    public char decrypt(char toChange) {
        Boolean cap = false;
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char letter = 'a';
        if (caps.contains(Character.toString(toChange))) {
            cap = true;
            toChange = Character.toLowerCase(toChange);
        }
        if (!isLetter(toChange)) {
            return toChange;
        } else {
            letter = caps.charAt(findIndex(Character.toLowerCase(toChange), translate));
        }
        if (!cap) {
            return Character.toLowerCase(letter);
        } else {
            return letter;
        }
    }

    /***
     * Sets the validNum flag to false initially. Check how many arguments have been passed. If there aren't enough, print that there are insufficient arguments and prompt the user for correct usage. Similarly, if there are too many, print there are too many arguments to the console. If there are 3 arguments, set validNum to true. Then, see if the first argument is 'encrypt' or 'decrypt'. If it is neither, then output an error message and again prompt for the correct usage. If it is, then encrypt/decrypt the third argument string by using the second argument as a mapping string.
     * @param args the list of command line arguments that have been passed
     */
    public static void main(String[] args) {
        Boolean validNum = false;
        if (args.length < 3) {
            System.out.println("Too few parameters!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        } else if (args.length > 3) {
            System.out.println("Too many parameters!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        } else {
            validNum = true;
        }

        if (!(args[0].contains("encrypt") || args[0].contains("decrypt"))) {
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }

        MonoAlphaSubstitution tr;
        if (args[0].contains("encrypt") && validNum) {
            tr = new MonoAlphaSubstitution(args[1]);
            System.out.println(tr.encrypt(args[2]));
        }
        if (args[0].contains("decrypt") && validNum) {
            if (args.length == 2) {
                System.out.println(args[1]);
            } else {
                tr = new MonoAlphaSubstitution(args[1]);
                System.out.println(tr.decrypt(args[2]));
            }
        }

        
    }
}
