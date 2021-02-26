import java.util.ArrayList;
class Caesar {

    public static char rotate(int shift, char input) {
        ArrayList<Char> lowerletters = "abcdefghijklmnopqrstuvwxyz";
        if (lowerletters.indexOf(shift) >= 0) {
            return 'y';
        } else {
            return ' ';
        }
    }

    public static String rotate(int shift, String input) {
        return "hello";
    }

    public static void main(String[] args) {
        rotate(3, args[0]);
    }
}
