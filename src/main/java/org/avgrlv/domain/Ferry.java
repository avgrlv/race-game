package org.avgrlv.domain;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ferry extends Stage {
    @Override
    public String toString() {
        return "Паром " + super.getName() + "  максимальное кол-во машин: " + super.getMaxCapacity();
    }

    @Override
    public void go(Car car) throws InterruptedException {
        System.out.println(car.getModel() + " подошёл к парому");
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println("Машина " + car.getModel() + " переправляется по парому");
            Thread.sleep(2000);
            System.out.println("Машина " + car.getModel() + " перепарвлена");

        } finally {
            lock.unlock();
        }
    }

    private int ferrySpeed;

    public Ferry(String name, int distance) {
        super(name, distance);
        this.ferrySpeed = 220;
    }
}
