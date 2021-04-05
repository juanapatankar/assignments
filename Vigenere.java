class Vigenere extends Substitution {
    public char[][] translate;
    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public Vigenere() {
        translate = new char[][] {{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}};
    }
    public Vigenere(String mapping) {
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
    public char encrypt(char toChange) {
        return 'a';
    }
    public char decrypt(char toChange) {
        return 'a';
    }
    public static void main(String[] args) {
        Vigenere tr;
        if (args.length == 1) {
            tr = new Vigenere(args[0]);
        } else {
            tr = new Vigenere();
        }
        for (int i = 0; i < args[0].length(); i++) {
            System.out.println(String.valueOf(tr.translate[i])+"\n");
        }
    }
}