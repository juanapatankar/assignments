class Caesar {

    public static char rotate(int shift, char input) {
        String lowerletters = "abcdefghijklmnopqrstuvwxyz";
        String upperletters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (lowerletters.indexOf(input) != -1) {
            if (shift >= 0) {
                return lowerletters.charAt((lowerletters.indexOf(input) + shift) % 26);
            } else {
                shift = 26 + (shift % 26);
                return lowerletters.charAt((lowerletters.indexOf(input) + shift) % 26);
            }
        } else if (upperletters.indexOf(input) != -1) {
            if (shift >= 0) {
                return upperletters.charAt((upperletters.indexOf(input) + shift) % 26);
            } else {
                shift = 26 + (shift % 26);
                return upperletters.charAt((upperletters.indexOf(input) + shift) % 26);
            }
        } else {
            return input;
        }
    }

    public static String rotate(int shift, String input) {
        String result = "";
        for (int i=0; i < input.length(); i++ ) {
            result += rotate(shift, input.charAt(i));

        }
        return result;
    }

    public static void correctusage() {
        System.out.println("Usage: java Caesar n [original text]");
    }
    public static void main(String[] args) {
        if (args.length == 2) {
            System.out.println(rotate(Integer.parseInt(args[0]), args[1]));
        } else if (args.length == 0) {
            System.out.println("No arguments given!");
            correctusage();
        } else if (args.length == 1) {
            System.out.println("You've missed an argument!");
            correctusage();
        } else {
            System.out.println("Too many arguments");
            correctusage();
        }
    }
}
