package multithreading;

public class Resource {
    private volatile int number = 0;

    public synchronized void addResource() throws InterruptedException {
        if (number > 5)
            wait();
        number++;
        notify();
    }

    public synchronized void removeResource() throws InterruptedException {
        if (number < 1)
            wait();
        number--;
        notify();
    }
}
