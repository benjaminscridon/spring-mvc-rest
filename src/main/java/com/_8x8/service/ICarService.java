package com._8x8.service;

import com._8x8.model.Car;

import java.util.List;

/**
 * Created by bscridon on 29.08.2016.
 */
public interface ICarService {
    Car addCar(Car car);

    Car findCarById(Long id);

    List<Car> getAllCars();

    Car updateCar(Car oldCar) throws Exception;

    void deleteCar(Long id);
}
