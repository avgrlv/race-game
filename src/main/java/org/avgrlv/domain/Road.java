package org.avgrlv.domain;

public class Road extends Stage {
    @Override
    public String toString() {
        return "Дорога " + super.getName() + "  кол-во полос: " + super.getMaxCapacity();
    }

    @Override
    public void go(Car car) throws InterruptedException {
        try {
            int speed = (int) (Math.random() * 80 + 20);
            System.out.println(car.getModel() + " начинает этап: " + getName() + " скорость " + speed);
            Thread.sleep(getDistance() / speed * 100);
            System.out.println(car.getModel() + " закончил этап: " + getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Road(String name, int distance, int maxCapacity) {
        super(name, distance, maxCapacity);
    }
}
