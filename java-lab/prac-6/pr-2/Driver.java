public class Driver {

    static class UrgentEmail implements Notifier, Urgent {
        @Override
        public void send(String message) {
            System.out.println("Urgent Email: " + message);
        }
    }

    public static void main(String[] args) {

        Notifier email = (msg) -> System.out.println("Email: " + msg);

        Notifier sms = (msg) -> System.out.println("SMS: " + msg);

        Notifier urgentEmail = new UrgentEmail();

        Notifier[] senders = {
                email,
                sms,
                urgentEmail
        };

        String message = "Meeting at 2 PM";

        for (Notifier sender : senders) {

            sender.send(message);

            if (sender instanceof Urgent) {
                sender.send(message);
            }
        }
    }
}