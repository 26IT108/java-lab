// Custom Checked Exception
class OutOfStockException extends Exception {
    private int shortfall;

    public OutOfStockException(int shortfall) {
        super("Not enough stock.");
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}

// Custom Checked Exception
class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {
    private int stock;

    public Warehouse(int stock) {
        this.stock = stock;
    }

    public void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0)
            throw new InvalidQuantityException("Quantity must be greater than zero.");

        if (qty > stock)
            throw new OutOfStockException(qty - stock);

        stock -= qty;
        System.out.println("Issued " + qty + " " + item + "(s). Remaining stock = " + stock);
    }
}

public class WarehouseTest {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse(20);

        int[] requests = {5, 30, -2, 10};

        for (int qty : requests) {
            try {
                warehouse.issue("Laptop", qty);

            } catch (OutOfStockException e) {
                System.out.println("OutOfStockException: Shortfall = " + e.getShortfall());

            } catch (InvalidQuantityException e) {
                System.out.println("InvalidQuantityException: " + e.getMessage());
            }
        }
    }
}