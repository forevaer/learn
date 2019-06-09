package com.godme.sync;

public class SyncThread implements Runnable {

    private int count = 10;

    /**
     *  可以看到，加了synchronized和不加，是存在区别的
     *  当加了关键字以后，仅有一个线程才能操作方法内容
     *  也就是说，这份代码，是唯一的，即使在多线程环境下，表现的也是如你所见的逻辑
     *  如果没有关键字修饰，展现出来的效果，并非如你所见
     */
    public synchronized void run() {
        try{
            for (;count > 0; count--){
                System.out.println(String.format("%s-count : %d", Thread.currentThread().getName(), count));
                Thread.sleep(1000);
            }
        }catch (Exception e){}
    }

    public static void main(String[] args) {
        Runnable threadCore = new SyncThread();
        Thread t1 = new Thread(threadCore);
        Thread t2 = new Thread(threadCore);
        t1.start();
        t2.start();
    }
}
