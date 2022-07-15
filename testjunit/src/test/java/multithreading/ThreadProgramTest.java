package multithreading;

import org.junit.Test;

public class ThreadProgramTest {

    @Test
    public void taskThread1() {
        MyThread firstThread = new MyThread("First");
        Thread firstRunnable = new Thread(new MyRunnable("Second"));
        firstThread.start();
        firstRunnable.start();
    }

    @Test
    public void taskTest2() throws InterruptedException {
        Thread sideThread = new Thread(() -> System.out.println("side thread"));
        Thread mainThread = new Thread(() -> System.out.println("main thread"));
        sideThread.start();
        sideThread.join();
        mainThread.start();
    }

    @Test
    public void taskTest3() {
        Thread sideThread = new Thread(() -> {
            try {
                System.out.println("side thread");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        sideThread.setDaemon(true);
        sideThread.start();
    }

    @Test
    public void taskTest4() {
        Resource resource = new Resource();
        Thread manufacturerThread = new Thread(Resource.convertToRunnable(resource::addResource));
        Thread consumerThread = new Thread(Resource.convertToRunnable(resource::removeResource));

        manufacturerThread.start();
        consumerThread.start();
    }

    @Test
    public void taskTest5() throws InterruptedException {
        Object lock = new Object();
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(5000);
                    synchronized (lock) {
                        System.out.println("print");
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        synchronized (lock) {
            lock.wait();
        }
    }

    @Test
    public void taskTest6() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
                System.out.println("print");
            }
        });
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
