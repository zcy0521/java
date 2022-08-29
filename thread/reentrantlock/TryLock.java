package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {

    public static void main(String[] args) {
        BusinessObj obj1 = new BusinessObj();
        obj1.setLock(new ReentrantLock());
        obj1.setName("业务实体1");

        BusinessObj obj2 = new BusinessObj();
        obj2.setLock(new ReentrantLock());
        obj2.setName("业务实体2");

        Thread thread1 = new Thread(() -> {
            doService(obj1, obj2, 10, TimeUnit.SECONDS);
        });
        thread1.setName("线程1");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            doService(obj2, obj1, 10, TimeUnit.SECONDS);
        });
        thread2.setName("线程2");
        thread2.start();
    }

    public static boolean doService(BusinessObj obj1, BusinessObj obj2, long timeout, TimeUnit unit) {
        // 业务是否成功
        boolean isSuccess = false;

        // 当前线程名
        String threadName = Thread.currentThread().getName();

        // 尝试锁的时间
        long stopTime = System.nanoTime() + unit.toNanos(timeout);

        while (true) {
            System.out.println(threadName + "请求获取" + obj1.getName());

            // while循环获取obj1的锁
            if (!obj1.getLock().tryLock()) {
                System.out.println(threadName + "锁定失败" + obj1.getName());

                // 重试超时
                if (isTimeout(threadName, stopTime)) {
                    return false;
                }
                continue;
            }

            System.out.println(threadName + "请求获取" + obj2.getName());

            // while循环获取obj2的锁
            if (!obj2.getLock().tryLock()) {
                System.out.println(threadName + "锁定失败" + obj2.getName());

                // 重试超时
                if (isTimeout(threadName, stopTime)) {
                    return false;
                }
                continue;
            }
        }

//        return false;
    }

    private static boolean isTimeout(String threadName, long stopTime) {
        if (stopTime < System.nanoTime()) {
            System.out.println(threadName + "重试超时...");
            return true;
        }
        return false;
    }

}

class BusinessObj {

    private ReentrantLock lock;

    private String name;

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
