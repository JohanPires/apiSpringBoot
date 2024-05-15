package io.tutorial.spring.garageApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.tutorial.spring.garageApp.model.Car;

@Service
public class GarageService {
    static private ArrayList<Car> cars = new ArrayList<>();
    static {

        cars.add(new Car(1, "Laguna", "Renault", 2004, Car.Color.BLUE));
        cars.add(new Car(2, "5008", "Peugeot", 2002, Car.Color.RED));
        cars.add(new Car(3, "C4", "Citroën", 2006, Car.Color.GREEN));
        cars.add(new Car(4, "206", "Peugeot", 2008, Car.Color.YELLOW));
        cars.add(new Car(5, "Laguna", "Renault", 2010, Car.Color.RED));
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(long id) {
        return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
    }

    public void deleteCar(long id) {
        cars.removeIf(car -> car.getId() == id);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void updateCar(Car car, long id) {
        cars.forEach(car1 -> {
            if (car1.getId() == id) {
                cars.set(cars.indexOf(car1), car);
            }
        });
    }
}
