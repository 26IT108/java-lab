public class CinemaShow {
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    
    public CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

   
    public CinemaShow(String title) {
        this(title, 100);
    }

    
    public boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        return false;
    }

 
    public void cancel(int n) {
        seatsAvailable = Math.min(seatsAvailable + n, capacity);
    }

   
    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    
    public static int getTotalBooked() {
        return totalBooked;
    }

    
    public static void main(String[] args) {
        CinemaShow show = new CinemaShow("Avengers", 50);

        System.out.println("Book 20: " + show.book(20)
                + ", Seats: " + show.getSeatsAvailable());

        System.out.println("Book 25: " + show.book(25)
                + ", Seats: " + show.getSeatsAvailable());

        System.out.println("Book 10: " + show.book(10)
                + ", Seats: " + show.getSeatsAvailable());

        show.cancel(15);
        System.out.println("Cancel 15, Seats: " + show.getSeatsAvailable());

        System.out.println("Book 10: " + show.book(10)
                + ", Seats: " + show.getSeatsAvailable());

        show.cancel(100);
        System.out.println("Cancel 100, Seats: " + show.getSeatsAvailable());

        System.out.println("Total Booked: " + CinemaShow.getTotalBooked());
    }
}