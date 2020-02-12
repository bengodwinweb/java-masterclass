import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 110, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 1250, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 6200, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 50, 200);
        stockList.addStock(temp);

        temp = new StockItem("door", 7295, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 259, 36);
        stockList.addStock(temp);
        temp = new StockItem("juice", 314, 11);
        stockList.addStock(temp);

        temp = new StockItem("phone", 9599, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 240, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 876, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket timsBasket = new Basket("Tim");
        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "spanner", 5);

        sellItem(timsBasket, "juice", 4);
        sellItem(timsBasket, "cup", 12);
        sellItem(timsBasket, "bread", 1);

        Basket basket = new Basket("Customer");
        sellItem(basket, "cup", 100);
        sellItem(basket, "juice", 5);
        removeItem(basket, "cup", 1);
        System.out.println(basket);

        removeItem(timsBasket, "car", 2);
        removeItem(timsBasket, "cup", 9);
        System.out.println("Cars removed " + removeItem(timsBasket, "car", 2));
        System.out.println(timsBasket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(stockList);
        System.out.println(basket);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);

        stockList.Items().get("car").adjustStock(2000);
        stockList.get("car").adjustStock(-1000);

        System.out.println(stockList);

        checkOut(timsBasket);
        System.out.println(timsBasket);

    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from the stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.reserveStock(item, quantity) != 0) {
            System.out.println("Adding " + quantity + " " + item + "s to basket");
            return basket.addToBasket(stockItem, quantity);
        }
        System.out.println("Error");
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        // retrieve the item from the stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
