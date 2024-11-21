package org.avgrlv.domain;

public class Road extends Stage {
    @Override
    public String toString() {
        return "Дорога " + super.getName() + "  кол-во полос: " + super.getMaxCapacity();
    }

    @Override
    public void go(Car car) throws InterruptedException {
        try {
            System.out.println(car.getModel() + " начинает этап: " + getName());
            int speed = (int) (Math.random() * 80 + 20); // Случайная скорость
            Thread.sleep(getDistance() / speed * 100); // Время прохождения этапа
            System.out.println(car.getModel() + " закончил этап: " + getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Road(String name, int distance, int maxCapacity) {
        super(name, distance, maxCapacity);
    }
}
