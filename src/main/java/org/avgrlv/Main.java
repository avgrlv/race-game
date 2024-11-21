package org.avgrlv;

import org.avgrlv.domain.*;

import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        createRace();
    }

    private static void createRace() throws BrokenBarrierException, InterruptedException {
        List<Car> cars = List.of(
                new Car("Nissan GTR", 280),
                new Car("Ferrari", 350),
                new Car("Subaru Impreza", 290),
                new Car("BMW", 330)
        );

        RaceGame raceGame = new RaceGame("Гиблая река", cars);
        raceGame.constructRoad(new Road("Трасса", 5000, cars.size()));
        raceGame.constructRoad(new Road("Дорога [трёхполосная]", 2500, 3));
        raceGame.constructRoad(new Ferry("Паромная переправа", 1500));
        raceGame.constructRoad(new Road("Дорога [двухполосная]", 1000, 2));
        raceGame.constructRoad(new Road("Финишная прямая", 1000, cars.size()));

        raceGame.startRace();
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        Future<Car> raceWinner = executorService.submit(raceGame);
//
//        if (raceWinner.isDone()) {
//            try {
//                System.out.println("Победитель определён: " + raceWinner.get());
//            } catch (InterruptedException | ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        executorService.shutdown();

    }
}