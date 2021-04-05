public class Caesar extends MonoAlphaSubstitution {
    public char[] translate;
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public Caesar() {
        translate = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    }
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

    public static Boolean isLetter(char test) {
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == test) {
                return true;
            }
        }
        return false;
    }

    public char encrypt(char toChange) {
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Boolean cap = false;
        if (caps.contains(Character.toString(toChange))) {
            cap = true;
            toChange = Character.toLowerCase(toChange);
        }
        if (isLetter(toChange)) {
            int letter = alphabet.indexOf(Character.toString(toChange));
            if (!cap) {
                return translate[letter];
            } else {
                return Character.toUpperCase(translate[letter]);
            }
        } else {
            return toChange;
        }
    }

    
    public static void main(String[] args) {
        Boolean valid = false;
        
        if (args.length < 3) {
            System.out.println("Too few parameters!\nUsage: java Caesar encrypt n \"cipher text\"");
        } else if (args.length > 3) {
            System.out.println("Too many parameters!\nUsage: java Caesar encrypt n \"cipher text\"");
        } else {
            valid = true;
        }
        if (!(args[0].contains("encrypt") || args[0].contains("decrypt"))) {
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }

        if (args[0].contains("encrypt") && valid) {
            String done = "";
            Caesar tr = new Caesar(Integer.parseInt(args[1]));
            for (int i = 0; i < args[2].length(); i++) {
                done += tr.encrypt(args[2].charAt(i));
            }
            System.out.println(done);
        }
        if (args[0].contains("decrypt") && valid) {
            String done = "";
            Caesar tr = new Caesar(-(Integer.parseInt(args[1])));
            for (int i = 0; i < args[2].length(); i++) {
                done += tr.encrypt(args[2].charAt(i));
            }
            System.out.println(done);
        }

    }
}