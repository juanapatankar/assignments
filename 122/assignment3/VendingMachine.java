import java.util.*;
class VendingMachine {
    private Map<String, Queue<Book>> shelf;
    private Press supplier;
    private double locationFactor;
    private int size;
    private double cassette;

    public VendingMachine(Press supplier, double locationFactor, int size) {
        this.supplier = supplier;
        this.locationFactor = locationFactor;
        this.size = size;
    }

    public double getCassette() {
        return cassette;
    }

    public void insertCoin(double coin) throws IllegalArgumentException {
        cassette += coin;
    }
}