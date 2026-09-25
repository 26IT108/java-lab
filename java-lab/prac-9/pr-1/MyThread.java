public class MyThread extends Thread {

    Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100000; i++) {
            counter.increment();
        }
    }
}