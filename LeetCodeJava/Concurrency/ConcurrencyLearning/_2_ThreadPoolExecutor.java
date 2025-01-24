package Concurrency.ConcurrencyLearning;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class _2_ThreadPoolExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(5);
        ThreadPoolExecutor ex = new ThreadPoolExecutor(4, 6, 1, TimeUnit.SECONDS, queue);
        ExecutorService es = Executors.newCachedThreadPool();
//        class MyCallable implements Callable<String> {
//
//            private String message;
//
//            public MyCallable(String message) {
//                this.message = message;
//            }
//
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(5000);
//                return message;
//            }
//        }
//
//        MyCallable myCallable1 = new MyCallable("Hello");
//        MyCallable myCallable2 = new MyCallable("World");
//        Future<String> future1 =  ex.submit(myCallable1);
//        Future<String> future2 = ex.submit(myCallable2);
//        try {
//            future1.get(1, TimeUnit.SECONDS);
//        } catch (Exception e) {
//            System.out.println("Timed out");
//        }
//        try {
//            future2.get(1, TimeUnit.SECONDS);
//        } catch (Exception e) {
//            System.out.println("Timed out");
//        }
//
//        try {
//            System.out.println(future1.get());
//            System.out.println(future2.get());
//        } catch (Exception e) {
//            System.out.println("Something went wrong!!!");
//        }

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello";
        }).thenApply((String prevOut) -> {
            System.out.println(Thread.currentThread().getName());
            return prevOut + " World!!";
        });

        System.out.println(completableFuture.get());

    }
}
