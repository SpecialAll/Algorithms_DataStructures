package com.zxh.algorithms.interview;


/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/17
 */
public class ProduceSumer {
    private static volatile int number;
    static class Producer implements Runnable{

        @Override
        public void run() {
            if(number != 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Producer");
            number = (int) (Math.random()*99);
            notify();
        }
    }
    static class Consumer implements Runnable{

        @Override
        public void run() {
            if(number == 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Consumer");
            System.out.println(number);
            number = 0;
            notify();
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Producer());
        Thread thread2 = new Thread(new Consumer());

        thread1.start();
        thread2.start();
    }
}
