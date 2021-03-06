public class Vigenere extends Substitution {
    /***
    * Declare an empty list of translation tables, with undefined lengths (as length of mapping is not known)
    */
    public char[][] translate;

    /***
    * Intialise the position of the character (through the string to tnecrypt/decrypt) as 0
    */
    public int position = 0;

    /***
    * Declare a mapping variable: will remain blank if none is given, to avoid errors
    */
    public String mapping;

    /***
    * Create a string containing the unchanged alphabet
    */
    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    // Declare a counter variable for the position of the next mapping character
    private int mappos;

    /***
    * Default constructor, sets the translation table to contain the unchanged alphabet
    */
    public Vigenere() {
        mapping = "";
        translate = new char[][] {{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}};
    }

    /***
    * Iterates through mapping to change letters in the unchanged translation table to their encrypted counterparts. First changes mapping to a lowercase string, so that each character can be compared with 'a'. E.g. 'g' is the 7th letter, 'a' is the 1st, so the shift for that character in the string to be changed will be 6. If the current mapping character is 'a', the letter will not be changed during the en/decryption. Next, the list of translation tables is initialised to specific size: it will contain one array for each letter in mapping, and each of the inner arrays will contain one element for each of the 26 letters in the alphabet. Then calculate the shift, using modulus for shifts larger than 26. Finally, set each element in each translation table to be the changed letter. E.g if the the first letter in the mapping was 'd', this implies a shift of 3. The first translation table will contain the new alphabet, 'a' is now 'd', 'b' is 'e', 'c' is 'f', etc. 
    * @param map the mapping to modify the translation table
    */
    public Vigenere(String map) {
        // Converts mapping to lowercase
        this.mapping = map.toLowerCase();
        // Initialises list of translation tables
        translate = new char[mapping.length()][26];
        for (int i = 0; i < mapping.length(); i++) {
            // Calculate the shift
            int shift = letterToNumber(mapping.charAt(i));
            for (int j = 0; j < 26; j++) {
                int newletter = j + shift;
                if (newletter >= 26) {
                    newletter -= 26;
                }
                // Set newchar to be the shifted letter
                char newchar = alphabet.charAt(newletter);
                translate[i][j] = newchar;
            }
        }

    }

    /***
    * Returns the index position of toFind in the alphabet
    * @param toFind the letter to find the position of
    * @return the position of toFind in the alphabet
    */
    public static int letterToNumber(char toFind) {
        int pos = 0;
        // Search through the alphabet
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == toFind) {
                pos = i;
            }
        }
        // Return the index position of toFind in the alphabet
        return pos;
    }

    /***
    * Tests if a character is or is not a letter
    * @param test the character to test
    * @return true if test is a letter. Otherwise, returns false
    */
    public static Boolean isLetter(char test) {
        // Search through the alphabet for target
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == test) {
                return true;
            }
        }
        return false;
    }

    /***
    * Uses the list of translation tables to change toChange to its encrypted counterpart by utilising the appropriate mapping. First finds the appropriate mapping for toChange by dividing toChange's position in the string to encrypt by the length of the string. Sets the encrypted letter by selecting the element corresponding to that letter in the appropriate translation table from the list.
    * @param toChange the decrypted character
    * @return the encrypted character (unchanged if toChange isn't a letter)
    */
    public char encrypt(char toChange) {
        // If there is no mapping, return the unchanged character
        if (mapping == "") {
            return toChange;
        }
        // Calculate the mapping number  
        mappos = position % mapping.length();
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Boolean cap = false;
        // If toChange is a capital letter, set cap flag to true and convert toChange to lowercase
        if (caps.contains(Character.toString(toChange))) {
            cap = true;
            toChange = Character.toLowerCase(toChange);
        }
        // Increment position, so that the enxt translation table will be used
        position++;
        if (isLetter(toChange) && position <= mapping.length()) {
            int letter = letterToNumber(toChange);
            // Set changed to the encrypted character 
            char changed = translate[mappos][letter];
            // Convert to uppercase if needed, then return the encrypted letter
            if (!cap) {
                return changed;
            } else {
                return Character.toUpperCase(changed);
            }
        } else {
            // Return the unchanged character if toChange is not a letter
            return toChange;
        }
        
    }

    /***
    * Finds toFind in the mapping, to change the translation table as appropriate at the letter's position in the alphabet.
    * @param toFind the letter to find in the mapping 
    * @param mapping the mapping passed by command line
    * @return the index position of the letter in mapping, or -1 if it wasn't included
    */
    public static int findIndex(char toFind, char[] mapping) {
        for (int i = 0; i < mapping.length; i++) {
            if (mapping[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    /*** Uses the list of translation tables to find toChange in the correct encrypted alphabet, then return the correct letter (same position in the actual alphabet). Choose which table to use by manipulating toChange's position in the encrypted string, and the total length of the encrypted string (passed by the command line). 
    * @param toChange the character to decrypt
    * @return the decrypted character
    */
    public char decrypt(char toChange) {
        // If no mapping, return the unchanged character
        if (mapping == "") {
            return toChange;
        }
        // Set mappos to point to the correct translation table. 
        mappos = position % mapping.length();
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Boolean cap = false;
        // If toChange is a capital letter, set cap flag to true and convert toChange to lowercase
        if (caps.contains(Character.toString(toChange))) {
            cap = true;
            toChange = Character.toLowerCase(toChange);
        }
        // Increment position, ready for when the next character is to be decrypted
        position++;
        if (isLetter(toChange) && position <= mapping.length()) {
            // Find the index position of toChange in the appropriate translation table. 
            int letter = findIndex(toChange, translate[mappos]);
            // Set changed to be the corresponding letter in the actual alphabet (decrypted)
            char changed = alphabet.charAt(letter);
            // switch between caps/lowercase:
            if (!cap) {
                return changed;
            } else {
                // Return changed as uppercase if toChange was a capital
                return Character.toUpperCase(changed);
            }
        } else {
            // Return the unchanged character if it was not a letter
            return toChange;
        }
        
    }

    /***
    * Prints error message if invalid number of arguments was passed (not 3). Prints error message if the first argument isn't 'encrypt'/'decrypt'. If all tests were passed, create the list of translation tables (containing the same number of elements as the mapping argument) and use this to encrypt or decrypt the third argument as requested. 
    * @param args the list of arguments passed at command line
    */
    public static void main(String[] args) {
        Vigenere tr;
        // Test if enough/too many arguments were passed, print corresponding error 
        if (args.length < 3) {
            System.out.println("Too few parameters!\nUsage: java Vigenere encrypt key \"cipher text\"");
        } else if (args.length > 3) {
            System.out.println("Too many parameters!\nUsage: java Vigenere encrypt key \"cipher text\"");
        } // test if the first argument is 'encrypt'/'decrypt'
        else if (!(args[0].contains("encrypt") || args[0].contains("decrypt"))) {
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\nUsage: java Vigenere encrypt key \"cipher text\"");
        } // Create the appropriate list of translation tables depending on first argument
        // Print the encrypted/decrypted string
        else if (args[0].contains("decrypt")) {
            tr = new Vigenere(args[1]);
            System.out.println(tr.decrypt(args[2]));
        } else {
            if (args[0].contains("encrypt")) {
                tr = new Vigenere(args[1]);
                System.out.println(tr.encrypt(args[2]));
            }
        }        
    }
}