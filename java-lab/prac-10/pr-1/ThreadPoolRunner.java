import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolRunner {

    static class Task implements Runnable {
        private int id;

        Task(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(
                "Task " + id + " running on " +
                Thread.currentThread().getName()
            );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("Task " + id + " completed");
        }
    }

    public static void main(String[] args) {

        // Fixed thread pool containing only 3 threads
        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        // Submit 10 tasks
        for (int i = 1; i <= 10; i++) {
            executor.submit(new Task(i));
        }

        // No more tasks will be accepted
        executor.shutdown();

        try {
            // Wait for all tasks to complete
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All tasks completed.");
    }
}