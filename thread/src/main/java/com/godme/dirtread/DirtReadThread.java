package com.godme.dirtread;

public class DirtReadThread {
    private String name = "godme";
    private int age = 18;

    public synchronized void setAttr(String name, int age){
        try{
            this.name = name;
            Thread.sleep(2000);
            this.age = age;
            System.out.println(String.format("setAttr : name=%s\tage=%s", this.name, this.age));
        }catch (Exception e){

        }
    }
    public  void getAttr(){
        System.out.println(String.format("getAttr : name=%s\tage=%s", this.name, this.age));
    }

    /**
     * 这里可以看到一个差异点，它设置成功了么
     * 名字的确设置进去了，但是age却是不对的
     * 我们的synchronized失效了么？
     * 在这里，我们得澄清synchronized的锁的概念：以什么作为锁
     * 这里的锁，默认的是this，也就是说，同一时刻，只能由单一对象进入
     * 我们已经避免了多个对象的情况，使用了单一对象进行操作，但是还是出了问题
     * 我们称呼方法上的锁叫做行为锁，由单一对象进行操作
     * 但是我们想的是让资源保持一致，上的锁或者应该成为资源锁
     * 资源锁的情况，可以避免多个行为之间的不安全行为
     * 但是行为锁之间的动作，却还需要自己进行安全策略的调节
     * 也就是还需要在getAttr上面进行加锁
     */
    public static void main(String[] args) throws InterruptedException {
        final DirtReadThread dirt = new DirtReadThread();
        new Thread(){
            @Override
            public void run() {
                dirt.setAttr("judas", 99);
            }
        }.start();
        Thread.sleep(1000);
        new Thread(){
            @Override
            public void run() {
                dirt.getAttr();
            }
        }.start();

    }
    /**
     * 值得补充的是，这里存在一个异步和同步的概念
     * 同步的haul，可以看做是一个人一次只能做一件事情
     * 异步的话，就是一个人可以插入的做其他事情
     * 上面的例子，已经加了安全的操作，仅存在一个对象
     * 但是在设值的时候，我们让它进行了读取的操作，也就是存在异步行为
     * 之前的情景，是多个对象的单一操作，我们让资源被锁住，仅仅能有一个对象进行操作
     * 而现在，哪怕一个对象，行为上面不能够保持同步的话，也会产生不安全的问题
     * 概念上进行区分，也就是原来的对象锁足以作为资源锁
     * 而在多操作之间，对象锁不足以让资源保证安全
     * 必须让对象同一时间内保证操作的同步，也就是但一时间内只能进行单一操作，才能够保证资源的统一
     *
     *  想要保证资源的统一，所加的，必然是资源锁
     *  如果采用其他的方式来进行同样的效果，就得明白然后避免特定方法发所产生的差异
     *
     *  直白的说，在这种操作中，丧失了原子性
     */
}
