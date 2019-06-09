package com.godme.sync;

public class SyncObjThread extends Thread {

    private int count = 10;

    /**
     *  主体逻辑仍然是同一份，但是效果截然不同
     *  仿佛关键字失去了效用
     */
    @Override
    public synchronized void run() {
        try{
            for (;count > 0; count--){
                System.out.println(String.format("%s-count:%d", Thread.currentThread().getName(), count));
            }
        }   catch (Exception e){}
    }

    public static void main(String[] args) {
        new SyncObjThread().start();
        new SyncObjThread().start();
    }
}
