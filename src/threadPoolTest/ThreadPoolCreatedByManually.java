package threadPoolTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by norman on 16-12-7.
 */
public class ThreadPoolCreatedByManually {

//    private static BlockingQueue queue = new LinkedBlockingQueue();
    private static BlockingQueue queue = new ArrayBlockingQueue(2);

    public static void doTest() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,//corePoolSize
                6,//maxPoolSize
                2L,//keepAliveTime
                TimeUnit.SECONDS,//TimeUnit
                queue//BlockingQueue
        );

        for (int i = 0; i < 20; i++) {
            doing(threadPoolExecutor,i+1);
        }
    }

    private static void doing(ExecutorService threadPoolExecutor, final int num) {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行中... 对应第" + num + "个任务");
            }
        });


    }
}
