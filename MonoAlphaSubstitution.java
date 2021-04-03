public class MonoAlphaSubstitution {
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

    public static char encrypt (char toChange, MonoAlphaSubstitution tr, char[] maptable) {
        int letter = letterToNumber(toChange);
        return maptable[letter];
    }
    public static void main(String[] args) {
        MonoAlphaSubstitution tr;
        char done;
        char[] maptable;
        if (args[0].contains("encrypt")) {
            if (args.length == 2) {
                tr = new MonoAlphaSubstitution();
                maptable = tr.translate;
                done = encrypt(args[1].charAt(0), tr, maptable);
            } else {
                tr = new MonoAlphaSubstitution(args[1]);
                maptable = tr.translate;
                done = encrypt(args[2].charAt(0), tr, maptable);
            }
            System.out.println(done);
        }
        
        
        
      //  System.out.println(encrypt('a'));
    }
}