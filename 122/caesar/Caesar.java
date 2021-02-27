import java.util.Arrays;
class Caesar {

    public static char rotate(int shift, char input) {
        String lowerletters = "abcdefghijklmnopqrstuvwxyz";
        if (lowerletters.indexOf(input) != -1) {
            return lowerletters.charAt(lowerletters.indexOf(input) + shift);
        } else {
            return 'n';
        }
    }

    public static String rotate(int shift, String input) {
        return "hello";
    }

    public static void main(String[] args) {
        System.out.println(rotate(3, args[0].charAt(0)));
    }
}
