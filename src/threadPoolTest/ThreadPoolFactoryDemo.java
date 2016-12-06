package threadPoolTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by norman on 16-12-7.
 */
public class ThreadPoolFactoryDemo {
    public static void doTest(int num) {

        //对线程池原理不是很清楚的时候，不知道如何自定义线程池，Executor类中提供常用的线程池

        /**
         * 创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。
         * 如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。
         * 此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
         */
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        /**
         * 创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
         * 线程池的大小一旦达到最大值就会保持不变，
         * 如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
         */
        ExecutorService executorService2 = Executors.newFixedThreadPool(3);

        /**
         * 创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
         */
        ExecutorService executorService3 = Executors.newScheduledThreadPool(3);

        /**
         * 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，
         * 那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，
         * 此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，
         * 线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
         */
        ExecutorService executorService4 = Executors.newCachedThreadPool();

        ExecutorService executorService;
        switch (num) {
            case 1:
                executorService = executorService1;
                break;
            case 2:
                executorService = executorService2;
                break;
            case 3:
                executorService = executorService3;
                break;
            case 4:
                executorService = executorService4;
                break;
            default:
                executorService = executorService1;
                break;
        }

        for (int i = 0; i < 10; i++) {
            doThreadPoolTest(executorService, i + 1);
        }

        executorService1.shutdown();
        executorService2.shutdown();
        executorService3.shutdown();
        executorService4.shutdown();
    }

    private static void doThreadPoolTest(ExecutorService service, final int num) {
//        ScheduledExecutorService es = (ScheduledExecutorService) service;
//        es.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("每2s运行一次");
//            }
//        }, 0, 2000, TimeUnit.MILLISECONDS);

        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": 这是第" + num + "个任务");
            }
        });

    }
}
