import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    static class Buffer {

        private Queue<Integer> queue = new LinkedList<>();
        private final int capacity = 3;

        public synchronized void produce(int value) throws InterruptedException {

            while (queue.size() == capacity) {
                wait();
            }

            queue.add(value);
            System.out.println("Produced: " + value);

            notify();
        }

        public synchronized int consume() throws InterruptedException {

            while (queue.isEmpty()) {
                wait();
            }

            int value = queue.remove();
            System.out.println("Consumed: " + value);

            notify();

            return value;
        }
    }

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.produce(i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.consume();
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Production and consumption completed.");
    }
}