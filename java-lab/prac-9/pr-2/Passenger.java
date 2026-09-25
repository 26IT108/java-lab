public class Passenger extends Thread {

    Booking booking;

    String name;

    public Passenger(String name, Booking booking) {
        this.name = name;
        this.booking = booking;
    }

    @Override
    public void run() {
        booking.book(name);
    }
}