public class Booking {

    int seatsLeft = 5;

    public synchronized void book(String name) {

        if (seatsLeft > 0) {

            System.out.println(name + " booked a seat.");

            seatsLeft--;

        } else {

            System.out.println(name + " booking failed.");

        }
    }
}