package com._8x8.service;

import com._8x8.model.Car;
import com._8x8.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bscridon on 29.08.2016.
 */
@Service
public class CarService implements ICarService {

    private CarRepository carRepository;

    public CarRepository getCarRepository() {
        return carRepository;
    }

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);

    }

    @Override
    public Car findCarById(Long id) {
         return carRepository.findOne(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car updateCar(Car oldCar) throws Exception {
        Car searchedCar = carRepository.findOne(oldCar.getId());
        if (searchedCar != null) {
            return carRepository.save(oldCar);
        } else {
            throw new Exception("To Do -updateCar");
        }
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.delete(id);
    }


    /*
    @Override
    public List<Car> findCarByOwnerId(Long id){
        return carRepository.findCarByOwnerId(id);
    }
    */
}
