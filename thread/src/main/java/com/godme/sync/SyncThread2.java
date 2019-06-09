package com.godme.sync;


/**
 *  明明是同一份代码，为什么表现形式差异那么大
 *  因为synchronized修饰方法，默认的锁对象是this
 *  在SyncThread中，使用的的确是同一个对象，这将保持安全
 *  但是如果是多个对象，每个对象其实都是各行其是
 *  也就是说，这只是多个单线程的自我执行，而非同一份代码的多线程执行
 *  一般来说，如果想用默认的synchronized让多个对象之间保持安全
 *  只能使用static关键字，这使得synchronized(this)编程了synchronized(this.getClass())
 *  使用类作为锁，让同一个类的对象之间保持安全，从而让代码在多线程环境之中保持唯一性
 */
public class SyncThread2 {
    public static void main(String[] args) {
        SyncThread threadCore1=  new SyncThread();
        SyncThread threadCore2 = new SyncThread();
        new Thread(threadCore1).start();
        new Thread(threadCore2).start();
    }
}
