public class Driver {

    public static void main(String[] args) throws InterruptedException {

        Booking booking = new Booking();

        Passenger[] passengers = new Passenger[10];

        for (int i = 0; i < 10; i++) {
            passengers[i] = new Passenger("Passenger " + (i + 1), booking);
            passengers[i].start();
        }

        for (int i = 0; i < 10; i++) {
            passengers[i].join();
        }

        System.out.println("Seats Left = " + booking.seatsLeft);
    }
}