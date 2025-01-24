package Concurrency.ConcurrencyLearning;

public class _1_LearningRunnableAndMonitorLocking {

    public static void main(String[] args) {
        TestRunnable testRunnable = new TestRunnable();
        Thread testThread = new Thread(testRunnable);
        testThread.start();
        System.out.println("I am done running thread");

        MonitorLocking obj = new MonitorLocking();
        Thread t1 = new Thread(() -> {obj.task1();});
        Thread t2 = new Thread(() -> {obj.task2();});
        Thread t3 = new Thread(() -> {obj.task3();});
        t1.start();
        t2.start();
        t3.start();
    }
}

class TestRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("I am running this method");
    }
}

class MonitorLocking {
    public synchronized void task1() {
        System.out.println("I am starting task 1");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("I am done with task1");
    }

    public  void task2() {
        System.out.println("I am starting task 2");
        synchronized (this) {
            System.out.println("I am done with task 2");
        }
    }

    public void task3() {
        System.out.println("I am starting task 3");
        System.out.println("I am done with task 3");
    }
}