package Threads;

public class Deadlock {
    public static void main(String[] args) {
        Resource bread = new Resource();
        Thread t1 = new Thread(()->{
            bread.produce();
        }, "t1");

        Thread t2 = new Thread(()->{
            bread.consume();
        }, "t2");

        t1.start();
        t2.start();
    }

    static class Resource{
        private int sum = 123;
        Object lock1 = new Object();
        Object lock2 = new Object();

        void produce(){
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() + " has obtained lock1 to produce1");
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName() + " has obtained lock2 to produce2");
                    sum += 100;
                    System.out.println("production complete: " + sum);
                }
            }
        }

        void consume(){
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName() + " has obtained lock2 to consume1");
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName() + " has obtained lock1 to consume2");
                    sum = 0;
                    System.out.println("Consumption complete: " + sum);
                }
            }
        }
    }

}
