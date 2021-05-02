class Book {
    private String title;
    private String author;
    private String content;
    private int edition;
    private int pages;

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getContent() {
        return content;
    }
    public int getEdition() {
        return edition;
    }

    public Book(String t, String a, String c, int e) {
        title = t;
        author = a;
        content = c;
        edition = e;
    }

    public int getPages() {
        int characters = content.length();
        return (int) Math.ceil(characters/800.0);
    }

    public String toString() {
        String output = String.format("Title: %s \nAuthor: %s \nEdition: %s \nPages: %s", title, author, edition, pages);
        return output;
    }

    /* public static void main(String[] args) {
        Book f = new Book("test", "haha", "uhsjd", 4);
        System.out.println(f.toString());
    } */
}