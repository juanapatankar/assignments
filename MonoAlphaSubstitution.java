public class MonoAlphaSubstitution {
    public char[] translate;
    public static char[] maptable;
    public MonoAlphaSubstitution() {
        translate = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    }
    public MonoAlphaSubstitution(String mapping) {
        // Find alternate characters
        translate = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i = 1; i < mapping.length(); i+=2) {
            char encoded = mapping.charAt(i);
            char decoded = mapping.charAt(i-1);
            int decodepos = letterToNumber(decoded);
            translate[decodepos] = encoded;
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

    public static char encrypt (char toChange) {
        int letter = letterToNumber(toChange);
        return maptable[letter];
    }
    public static void main(String[] args) {
        MonoAlphaSubstitution tr;
        if (args.length == 1) {
            tr = new MonoAlphaSubstitution();
            System.out.println(tr.translate[letterToNumber((args[0]).charAt(0))]);
        } else {
            tr = new MonoAlphaSubstitution(args[0]);
            System.out.println(tr.translate[letterToNumber((args[1]).charAt(0))]);
        }
        char[] maptable = tr.translate;
        
      //  System.out.println(encrypt('a'));
    }
}