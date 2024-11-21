package org.avgrlv;

import org.avgrlv.domain.Car;
import org.avgrlv.domain.Stage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;

public class RaceGame {
    private final String name;
    private final List<Car> cars;
    private final LinkedList<Stage> stages = new LinkedList<>();

    public RaceGame(String name, List<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public void constructRoad(Stage stage) {
        this.stages.add(stage);
    }

    public void startRace() throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(cars.size());
        List<Thread> carsRunners = new ArrayList<>();
        for (var car : cars) {
            car.setRaceStages(this.stages);
            Thread carThread = new Thread(car::run, car.getModel());
            carsRunners.add(carThread);
            carThread.start();
            System.out.println("{" + carThread.getState() + "} " + "Машина " + carThread.getName() + " запущена!");
            Thread.sleep(400);
        }
        cyclicBarrier.await();
        System.out.println("Гонка началась. Путсь победит сельнейший!!!");
    }

    public boolean isReady() {
        return !cars.isEmpty() && !stages.isEmpty();
    }

    @Override
    public String toString() {
        return "Гонка " + name
                + "\n\tучаствующие машины: " + cars.stream().map(Car::toString).collect(Collectors.joining("\n", "{", "}"))
                + "Этапы: "
                + stages.stream().map(Stage::toString).collect(Collectors.joining("\n", "{", "}"));
    }

    public String getName() {
        return name;
    }


//    @Override
//    public Car call() throws Exception {
//        System.out.println("Гонка началась. Путсь победит сельнейший!!!");
//        startCarsThreads();
//
//
//        return null;
//    }

}
