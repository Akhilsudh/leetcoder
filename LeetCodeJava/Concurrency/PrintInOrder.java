package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PrintInOrder {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Foo foo = new Foo();
        PrintSeq printFirst = new PrintSeq("first");
        PrintSeq printSecond = new PrintSeq("second");
        PrintSeq printThird = new PrintSeq("third");
        ThreadRunner tr1 = new ThreadRunner(foo, printFirst);
        ThreadRunner tr2 = new ThreadRunner(foo, printSecond);
        ThreadRunner tr3 = new ThreadRunner(foo, printThird);
        try {
            System.out.println("Executing second, third and first: ");
            es.execute(tr2);
            es.execute(tr3);
            es.execute(tr1);
        } finally {
            es.shutdown();
            es.awaitTermination(1, TimeUnit.MINUTES);
        }
        es = Executors.newCachedThreadPool();
        try {
            System.out.println("Executing third, second and first: ");
            es.execute(tr3);
            es.execute(tr2);
            es.execute(tr1);
        } finally {
            es.shutdown();
            es.awaitTermination(1, TimeUnit.MINUTES);
        }
    }
}

class Foo {
    private final Semaphore s1;
    private final Semaphore s2;

    public Foo() {
        this.s1 = new Semaphore(0);
        this.s2 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        s1.acquire();
        printSecond.run();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        s2.acquire();
        printThird.run();
    }
}

class PrintSeq implements Runnable {
    String seq;

    public PrintSeq(String seq) {
        this.seq = seq;
    }

    @Override
    public void run() {
        System.out.println(this.seq);
    }
}

class ThreadRunner implements Runnable {
    Foo foo;
    PrintSeq printSeq;
    public ThreadRunner(Foo foo, PrintSeq printSeq) {
        this.foo = foo;
        this.printSeq = printSeq;
    }

    @Override
    public void run() {
        try {
            if(this.printSeq.seq.equals("first")) {
                this.foo.first(printSeq);
            } else if(this.printSeq.seq.equals("second")) {
                this.foo.second(printSeq);
            } else if(this.printSeq.seq.equals("third")) {
                this.foo.third(printSeq);
            }
        } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }
    }
}
