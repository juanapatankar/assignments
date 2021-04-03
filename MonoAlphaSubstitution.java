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
    public static void main(String[] args) {
        MonoAlphaSubstitution f = new MonoAlphaSubstitution();
        String fdone = String.valueOf(f.translate);
        System.out.println(fdone);
        MonoAlphaSubstitution g = new MonoAlphaSubstitution("abbccd");
        String gdone = String.valueOf(g.translate);
        System.out.println(gdone);
    }
}