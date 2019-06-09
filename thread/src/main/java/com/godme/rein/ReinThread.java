package com.godme.rein;

/**
 *  synchronized的对象锁，在外部进行调用的时候，保证了同步，同一时间只能够进行单一的方法操作
 *  也就是说操作之间属于互斥的关系
 *  但是，这是属于同一个级别的操作调用，也就是正在做某件事情的时候中途插入其他操作
 *  如果是存在依赖的条件下，也即是某个操作中需要依赖的进行其他操作，此时就不存在互斥问题
 *  也就是重入的概念，此时的操作不存在互斥，虽然调用的其他方法，但还是这件事
 *  或者说，非外部调用的时候，不存在互斥的概念
 *  只有在对象外层进行互斥动作执行的时候，才会存在锁之间的互斥----为了保证同步性
 *
 *  不过
 */
public class ReinThread {

    public synchronized void method1(){
        System.out.println("method1");
        method2();
    }

    public synchronized void method2(){
        System.out.println("method2");
        method3();
    }
    public synchronized void method3(){
        System.out.println("method3");
        method4();
    }
    public synchronized void method4(){
        System.out.println("method4");
    }
    public static void main(String[] args) {
        final ReinThread reinThread = new ReinThread();
        new Thread(){
            @Override
            public void run() {
                reinThread.method1();
            }
        }.start();
    }
}
