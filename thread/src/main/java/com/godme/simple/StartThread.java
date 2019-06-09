package com.godme.simple;

public class StartThread {
    public static void main(String[] args) {
        ExtendsThread extendsThread = new ExtendsThread();
        // 线程直接启动
        ImplementsRunnable implementsRunnable = new ImplementsRunnable();
        // runnable需要提交到线程环境中才能启动线程
        Thread runnableThread = new Thread(implementsRunnable);
        extendsThread.start();
        runnableThread.start();
    }
}
