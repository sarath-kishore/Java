package Threads;

import java.util.Random;
import java.util.Stack;

public class ProducerConsumer {
    public static void main(String[] args) {
        Resource bread =  new ProducerConsumer().new Resource();
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " is executing.");
            for(int i=0; i<5; i++){
                bread.produce();
                try {
                    System.out.println(Thread.currentThread().getName() + " is going to sleep.");
//                    Thread.sleep(1500);
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " is awake.");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " is exiting.");
        }, "t1");
        Thread t2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " is executing.");
            for(int i=0; i<5; i++){
                bread.consume();
                try {
                    System.out.println(Thread.currentThread().getName() + " is going to sleep.");
                    Thread.sleep(1000);
//                    Thread.sleep(1500);
                    System.out.println(Thread.currentThread().getName() + " is awake.");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " is exiting.");
        }, "t2");

        System.out.println("t1 state " + t1.getState());
        System.out.println("t2 state " + t2.getState());

        t1.start();
        t2.start();

        System.out.println("Main thread is executing");
        System.out.println("t1 state " + t1.getState());
        System.out.println("t2 state " + t2.getState());

        try {
            System.out.println("Main thread sleeping");
            Thread.sleep(2000);
            System.out.println("Main thread awake");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("t1 state " + t1.getState());
        System.out.println("t2 state " + t2.getState());
        System.out.println("Main thread exiting");
    }

    class Resource{
        private Stack<Integer> st;
        private int capacity;
        Resource(){
            st = new Stack<>();
            capacity = 2;
        }
        protected boolean produce(){
            synchronized (this){
                while(st.size()==capacity) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " capacity full. waiting for consumption.");
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("producing..");
                st.push(new Random(10).nextInt(10, 100));
                notify();
                return true;
            }
        }

        protected boolean consume(){
            synchronized (this){
                while(st.isEmpty()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " stack empty. waiting for production.");
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("consuming..");
                st.pop();
                notify();
                return true;
            }
        }
    }

}
