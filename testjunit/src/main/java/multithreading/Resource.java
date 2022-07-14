package multithreading;

public class Resource {
    private int number = 0;

    public static Runnable convertToRunnable(Runnable runnable) {
        return runnable;
    }

    public synchronized void addResource() {
        for (int i = 0; i < 10; i++) {
            while (number > 5) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number++;
            System.out.println(number);
            notify();
        }

    }

    public synchronized void removeResource() {
        for (int i = 0; i < 10; i++) {
            while (number < 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number--;
            System.out.println(number);
            notify();
        }

    }
}
