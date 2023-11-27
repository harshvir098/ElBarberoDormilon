public class Main {
    public static void main(String[] args) {
        int totalChairs = 5;
        BarberShop shop = new BarberShop(totalChairs);

        Barber barber = new Barber(shop);
        Customer[] customers = new Customer[15];

        barber.start();

        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(shop);
            customers[i].start();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
