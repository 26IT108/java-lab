interface Permission {
    boolean allow(Switchable device, int hour);
}

public class Driver {

    public static void main(String[] args) {

        Switchable[] devices = {
                new Fan(),
                new Light()
        };

        System.out.println("Using toggle():");
        for (Switchable d : devices) {
            d.toggle();
        }

        // Anonymous Class
        Permission p1 = new Permission() {
            @Override
            public boolean allow(Switchable device, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        // Lambda Expression
        Permission p2 = (device, hour) -> hour >= 8 && hour <= 20;

        int hour = 10;

        System.out.println("\nAnonymous Class:");
        for (Switchable d : devices) {
            if (p1.allow(d, hour))
                d.on();
            else
                System.out.println("Not Allowed");
        }

        System.out.println("\nLambda:");
        for (Switchable d : devices) {
            if (p2.allow(d, hour))
                d.on();
            else
                System.out.println("Not Allowed");
        }
    }
}