class testme {
    public static void hello(String name) {
        System.out.println("Hello, " + name);
    }
    
    public static void countTo(int target) {
        for (int i = 1; i <= target; i++) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        hello("Juana");
        countTo(20);
    }
}