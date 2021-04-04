public class MonoAlphaSubstitution extends Substitution {
    public char[] translate;
    public MonoAlphaSubstitution() {
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
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int pos = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == toFind) {
                pos = i;
            }
        }
        return pos;
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
        if (toChange == ' ') {
            return ' ';
        } else {
            if (!cap) {
                return translate[letter];
            } else {
                return Character.toUpperCase(translate[letter]);
            }
            
        }
    }

    public char decrypt(char toChange) {
        return 'a';
    }
    public static void main(String[] args) {
        MonoAlphaSubstitution tr;
        String done;
        char[] maptable;
        if (args[0].contains("encrypt")) {
            if (args.length == 2) {
                System.out.println(args[1]);
               
            } else {
                tr = new MonoAlphaSubstitution(args[1]);
                maptable = tr.translate;
                for (int i = 0; i < args[2].length(); i++) {
                    System.out.print(tr.encrypt(args[2].charAt(i)));
                }
            } 
        }
    }
}
