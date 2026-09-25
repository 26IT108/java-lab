public class Counter {

    int count = 0;

    // Uncomment synchronized to fix race condition
    public synchronized void increment() {
        count++;
    }
}