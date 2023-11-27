public class BarberShop {
    private int chairsAvailable;
    private boolean barberSleeping;

    public BarberShop(int chairs) {
        this.chairsAvailable = chairs;
        this.barberSleeping = true;
    }

    public synchronized void barberAction() throws InterruptedException {
        while (true) {
            while (chairsAvailable == 0) {
                barberSleeping = true;
                System.out.println("Barber is sleeping.");
                wait();
            }

            barberSleeping = false;
            System.out.println("Barber woke up.");
            Thread.sleep(500);

            chairsAvailable++;
            System.out.println("Barber is cutting hair.");
            Thread.sleep((long) (Math.random() * 2000) + 1000);

            notify();
            wait();
        }
    }

    public synchronized void customerAction() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 1000) + 1000);

        if (chairsAvailable > 0) {
            chairsAvailable--;
            System.out.println("Customer sat down.");
            if (barberSleeping) {
                notify();
            }
        } else {
            System.out.println("No seats available, customer left.");
            chairsAvailable++;
        }
        notify();
        wait();
        System.out.println("Customer got a haircut and left.");
    }
}
