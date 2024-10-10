//package Concurrency;
//
//import java.util.concurrent.Semaphore;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class PrintZeroEvenOdd {
//}
//
//class ZeroEvenOdd {
//    private int n;
//    private Semaphore zeroOrNum = new Semaphore(1);
//    private Semaphore even = new Semaphore(0);
//    private Semaphore odd = new Semaphore(0);
//
//    private boolean flag = false;
//    private AtomicInteger num = new AtomicInteger(1);
//
//    public ZeroEvenOdd(int n) {
//        this.n = n;
//    }
//
//    // printNumber.accept(x) outputs "x", where x is an integer.
//    public void zero(IntConsumer printNumber) throws InterruptedException {
//        for(int i = 1; i < n; i++) {
//            zeroOrNum.acquire();
//            printNumber.accept(0);
//            if(i % 2 == 0) {
//                even.release();
//            } else {
//                odd.release();
//            }
//        }
//    }
//
//    public void even(IntConsumer printNumber) throws InterruptedException {
//        while(even.tryAcquire() && num.get() <= n) {
//            printNumber.accept(num);
//            num.incrementAndGet();
//            zeroOrNum.release();
//        }
//    }
//
//    public void odd(IntConsumer printNumber) throws InterruptedException {
//        while(odd.tryAcquire() && num.get() <= n) {
//            printNumber.accept(num);
//            num.incrementAndGet();
//            zeroOrNum.release();
//        }
//    }
//}