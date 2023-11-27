public class Customer extends Thread {
    private BarberShop shop;

    public Customer(BarberShop shop) {
        this.shop = shop;
    }

    public void run() {
        try {
            shop.customerAction();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
