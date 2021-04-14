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
    
    public MonoAlphaSubstitution(String mapping) {
        // Find alternate characters
        translate = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i = 1; i < mapping.length(); i+=2) {
            char encoded = mapping.charAt(i);
            char decoded = mapping.charAt(i-1);
           translate[letterToNumber(decoded)] = encoded; 
        }
        
    }
    public static int letterToNumber(char toFind) {
        int pos = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == toFind) {
                pos = i;
            }
        }
        return pos;
    }

    public static int findIndex(char toFind, char[] mapping) {
        for (int i = 0; i < mapping.length; i++) {
            if (mapping[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    public static Boolean isLetter(char test) {
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == test) {
                return true;
            }
        }
        return false;
    }
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
    public static void main(String[] args) {
        Boolean valid = false;
        
        if (args.length < 3) {
            System.out.println("Too few parameters!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        } else if (args.length > 3) {
            System.out.println("Too many parameters!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        } else {
            valid = true;
        }

        if (!(args[0].contains("encrypt") || args[0].contains("decrypt"))) {
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }

        MonoAlphaSubstitution tr;
        if (args[0].contains("encrypt") && valid) {
            tr = new MonoAlphaSubstitution(args[1]);
            System.out.println(tr.encrypt(args[2]));
        }
        if (args[0].contains("decrypt") && valid) {
            if (args.length == 2) {
                System.out.println(args[1]);
            } else {
                tr = new MonoAlphaSubstitution(args[1]);
                System.out.println(tr.decrypt(args[2]));
            }
        }

        
    }
}
