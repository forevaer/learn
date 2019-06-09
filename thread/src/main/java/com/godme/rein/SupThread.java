package com.godme.rein;

/**
 * 继承关系中，锁之间也存在互斥的传递性
 * 保证了在子类操作和父类操作之间方法的同步单一顺序性
 * 切记，两者必须保证都被synchronized关键词修饰
 * 否则，方法之间并不会同步的单一执行
 */
public class SupThread {
    protected int count = 10;
    public synchronized void operationSup(){
        try{
            if(count > 0){
                System.out.println(String.format("%s-count : %d",SupThread.class.getSimpleName(), --count));
                Thread.sleep(100);
            }
        }catch (Exception e){}
    }

    static class SubThread extends SupThread{
        @Override
        public synchronized void operationSup() {
            try{
                while(count > 0){
                    System.out.println(String.format("%s-count : %d",SubThread.class.getSimpleName(), --count));
                    super.operationSup();
                    Thread.sleep(100);
                }
            }catch (Exception e){}
        }
    }

    public static void main(String[] args) {
        final SubThread subThread = new SubThread();
        new Thread(){
            @Override
            public void run() {
                subThread.operationSup();
            }
        }.start();
    }
}
