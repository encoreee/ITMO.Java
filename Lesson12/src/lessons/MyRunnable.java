package lessons;

public class MyRunnable extends Thread{
    private Object lock;

    public MyRunnable(Object lock) {
        this.lock = lock;
    }

    @Override
    public  void run() {
        while (true) {
            synchronized (lock) {
                lock.notify();
                System.out.println(Thread.currentThread().getName());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
