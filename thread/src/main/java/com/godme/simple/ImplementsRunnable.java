package com.godme.simple;

/**
 *  实现Runnable接口，实现线程的主体逻辑，但是需要提交到线程环境中
 */
public class ImplementsRunnable implements Runnable {
    public void run() {
        try{
         for (int index = 10; index > 0; index--){
             System.out.println(this.getClass().getName() + "\t:\t" + index);
             Thread.sleep(1000);
         }
        }catch (Exception e){
        }
    }
}
