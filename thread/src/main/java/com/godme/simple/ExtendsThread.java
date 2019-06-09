package com.godme.simple;

/**
 *  直接继承Thread，复写run方法即可实现一个线程
 */
public class ExtendsThread  extends Thread{
    @Override
    public void run() {
        try{
            for(int index = 0; index < 10; index++){
                System.out.println(this.getClass().getName() + "\t:\t"+ index);
                Thread.sleep(1000);
            }
        }catch (Exception e){
        }
    }
}
