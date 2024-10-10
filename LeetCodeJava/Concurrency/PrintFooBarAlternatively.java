package Concurrency;

import java.util.concurrent.Semaphore;

public class PrintFooBarAlternatively {
}

class FooBar {
    private int n;
    private Semaphore foo;
    private Semaphore bar;

    public FooBar(int n) {
        this.n = n;
        this.foo = new Semaphore(1);
        this.bar = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }
}
