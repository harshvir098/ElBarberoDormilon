public class Barber extends Thread {
    private BarberShop shop;

    public Barber(BarberShop shop) {
        this.shop = shop;
    }

    public void run() {
        try {
            shop.barberAction();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
