package com.bytespaces.RLockDemo;

import org.redisson.Redisson;
import org.redisson.api.RLock;

public class SellTicket_redisson implements Runnable {

    private int tickets = 100;
    RLock lock = getRedissonLock();
    private RLock getRedissonLock(){
        Redisson redisson = (Redisson) Redisson.create();
        RLock lock = redisson.getLock("keyLock");
        return lock;
    }
    @Override
    public void run() {
        while (tickets>0){
            lock.lock();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets-- +"张票");
        }
    }
}
