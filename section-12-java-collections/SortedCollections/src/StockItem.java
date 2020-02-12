import java.text.NumberFormat;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private int price;
    private int quantityInStock;
    private int reserve = 0;

    public StockItem(String name, int price) {
        this(name, price, 0);
    }

    public StockItem(String name, int price, int quantityInStock) {
        this.name = name.toLowerCase();
        this.price = price;
        if (quantityInStock >= 0) {
            this.quantityInStock = quantityInStock;
        } else {
            this.quantityInStock = 0;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int availableQuantity() {
        return quantityInStock - reserve;
    }

    public int getNumberReserved() {
        return reserve;
    }

    public int reserveStock(int quantity) {
        if (quantity <= availableQuantity()) {
            this.reserve += quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(int quantity) {
        if (quantity <= reserve) {
            reserve -= quantity;
            return quantity;
        }
        return 0;
    }

    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        if (quantity == 0) {
            return;
        }
        int newQuantity = this.quantityInStock + quantity;
        if (newQuantity >= 0) {
            if (quantity < 0) {
                unreserveStock(quantity);
            }
            this.quantityInStock = newQuantity;
        }
    }

    public int finalizeStock(int quantity) {
        if (quantity <= reserve) {
            quantityInStock -= quantity;
            reserve -= quantity;
            return quantity;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering stock item.equals()");
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 13;
    }

    public int compareTo(StockItem o) {
        if (this == o) {
            return 0;
        }

        if (o != null) {
            return this.name.compareTo(o.name);
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return toTitleCase(this.name) + " : price " + toCurrency(this.price);
    }

    public static String toTitleCase(String s) {
        if (s.isBlank()) {
            return "";
        }

        if (s.length() == 1) {
            return s.toUpperCase();
        }

        String[] wordList = s.split(" ");
        String r = new String();
        for (String word : wordList) {
            r += word.substring(0, 1).toUpperCase();
            r += word.substring(1);
            r += " ";
        }
        return r.substring(0, r.length() - 1);
    }

    public static String toCurrency(double n) {
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        return defaultFormat.format(n / 100.0);
    }
}
