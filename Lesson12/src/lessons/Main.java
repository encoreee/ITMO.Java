package lessons;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //    for (int i = 0; i < 10; i++) {
        //        new CountThread().start(); }

      //  Thread thread = new StateThread();
      //  System.out.println(thread.getState());
      //  thread.start();
      //  System.out.println(thread.getState());

     //   Counter counter = new Counter();
     //   for (int i = 0; i < 100; i++) {
      //      new CounterThread(counter).start();
     //  }
      //  Thread.sleep(1000);
       // System.out.println(counter.count);

        Object lock = new Object();
        Thread thread1 = new MyRunnable(lock);
        Thread thread2 = new MyRunnable(lock);
        thread1.start();
        thread2.start();

    }
}
