# 线程学习
## 概念重申

现在开始，把线程当做程序的执行环境。

所谓多线程，就是同一段代码在线程环境下的执行过程。

而线程安全，就是让多个线程下的代码，保证是``同一份``，而不是存在``差异性``

## 简单的开启

- [继承`Thread`](src/main/java/com/godme/simple/ExtendsThread.java)
- [实现`Runnable``](src/main/java/com/godme/simple/ImplementsRunnable.java)
- [`start`](src/main/java/com/godme/simple/StartThread.java)

## 锁的对象

- [单一对象](src/main/java/com/godme/sync/SyncThread.java)
- [多个对象](src/main/java/com/godme/sync/SyncObjectThread.java)
- [多个主体](src/main/java/com/godme/sync/SyncThread2.java)

## 操作的互斥

- [脏读](src/main/java/com/godme/dirtread/DirtReadThread.java)

## 锁的重入

- [重入锁](src/main/java/com/godme/rein/ReinThread.java)
- [继承的同步和重入](src/main/java/com/godme/rein/SupThread.java)