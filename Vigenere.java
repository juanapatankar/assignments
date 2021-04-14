public class Vigenere extends Substitution {
    public char[][] translate;
    public int position = 0;
    public int mappos;
    public String mapping;
    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public Vigenere() {
        mapping = "";
        translate = new char[][] {{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}};
    }
    /***
     * 
     * @param map
     */
    public Vigenere(String map) {
        this.mapping = map.toLowerCase();
        translate = new char[mapping.length()][26];
        for (int i = 0; i < mapping.length(); i++) {
            int shift = letterToNumber(mapping.charAt(i));
            for (int j = 0; j < 26; j++) {
                int newletter = j + shift;
                if (newletter >= 26) {
                    newletter -= 26;
                }
                char newchar = alphabet.charAt(newletter);
                translate[i][j] = newchar;
            }
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
    public static Boolean isLetter(char test) {
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == test) {
                return true;
            }
        }
        return false;
    }
    public char encrypt(char toChange) {
        if (mapping == "") {
            return toChange;
        }
        mappos = position % mapping.length();
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Boolean cap = false;
        if (caps.contains(Character.toString(toChange))) {
            cap = true;
            toChange = Character.toLowerCase(toChange);
        }
        position++;
        if (isLetter(toChange) && position <= mapping.length()) {
            int letter = letterToNumber(toChange);
            char changed = translate[mappos][letter];
            // switch between caps/lowercase:
            if (!cap) {
                return changed;
            } else {
                return Character.toUpperCase(changed);
            }
        } else {
            return toChange;
        }
        
    }
    public static int findIndex(char toFind, char[] mapping) {
        for (int i = 0; i < mapping.length; i++) {
            if (mapping[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    public char decrypt(char toChange) {
        if (mapping == "") {
            return toChange;
        }
        mappos = position % mapping.length();
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Boolean cap = false;
        if (caps.contains(Character.toString(toChange))) {
            cap = true;
            toChange = Character.toLowerCase(toChange);
        }
        position++;
        if (isLetter(toChange) && position <= mapping.length()) {
            int letter = findIndex(toChange, translate[mappos]);
            char changed = alphabet.charAt(letter);
            // switch between caps/lowercase:
            if (!cap) {
                return changed;
            } else {
                return Character.toUpperCase(changed);
            }
        } else {
            return toChange;
        }
        
    }
    public static void main(String[] args) {
        Vigenere tr;
        if (args.length < 3) {
            System.out.println("Too few parameters!\nUsage: java Vigenere encrypt key \"cipher text\"");
        } else if (args.length > 3) {
            System.out.println("Too many parameters!\nUsage: java Vigenere encrypt key \"cipher text\"");
        } else if (!(args[0].contains("encrypt") || args[0].contains("decrypt"))) {
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\nUsage: java Vigenere encrypt key \"cipher text\"");
        } else if (args[0].contains("decrypt")) {
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