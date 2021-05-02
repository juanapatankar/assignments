import java.util.*;
class Press {
    private int booksPerEdition;
    private String content;
    private Map<String, Integer> edition = new HashMap<String, Integer>();
    private Map<String, Queue<Book>> shelf = new HashMap<>();

    public Press(String pathToBookDir, int booksPerEd) {
        booksPerEdition = booksPerEd;
        
    }
}