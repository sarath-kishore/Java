package Threads;

public class Test {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("Hi");
            System.out.println(Thread.activeCount());
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("t is Interrupted");
                throw new RuntimeException(e);
            }
            System.out.println("t priority" + Thread.currentThread().getPriority());
            System.out.println("t name" + Thread.currentThread().getName());
            System.out.println("t state" + Thread.currentThread().getState());
        }, "ads thread");
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        try {
            Thread.sleep(300);
            t.interrupt();
            System.out.println("t interrupt sent from Main thread");
            System.out.println("75" + t.getState());

//                    Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(t.getState());

//        t.run();
    }
}
