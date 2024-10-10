package Concurrency;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class H2OBarrier {
    public static void main(String[] args) throws InterruptedException {
        H2O h2o = new H2O();
        ReleaseAtom rh = new ReleaseAtom("H");
        ReleaseAtom ro = new ReleaseAtom("O");
        TriggerAtom th = new TriggerAtom(h2o, rh);
        TriggerAtom to = new TriggerAtom(h2o, ro);
        ExecutorService es = Executors.newCachedThreadPool();
        try {
            System.out.println("OOHHHH : ");
            es.execute(to);
            es.execute(to);
            es.execute(th);
            es.execute(th);
            es.execute(th);
            es.execute(th);
        } finally{
            es.shutdown();
        }
    }
}

class H2O {
    private final Semaphore so;
    private final Semaphore sh;

    public H2O() {
        this.so = new Semaphore(0);
        this.sh = new Semaphore(2);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        this.sh.acquire(1);
        releaseHydrogen.run();
        this.so.release(1);

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        this.so.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        this.sh.release(2);
    }
}

class ReleaseAtom implements Runnable {
    String atom;

    public ReleaseAtom(String atom) {
        this.atom = atom;
    }

    @Override
    public void run() {
        System.out.print(atom);
    }
}

class TriggerAtom implements Runnable {

    H2O h2o;
    ReleaseAtom rAtom;
    public TriggerAtom(H2O h2o, ReleaseAtom rAtom) {
        this.h2o = h2o;
        this.rAtom = rAtom;
    }

    @Override
    public void run() {
        try {
            if(this.rAtom.atom.equals("O")) {
                this.h2o.oxygen(this.rAtom);
            }
            else if(this.rAtom.atom.equals("H")) {
                this.h2o.hydrogen(this.rAtom);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
