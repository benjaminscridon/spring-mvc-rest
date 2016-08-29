package com._8x8.controller;

import com._8x8.model.Car;
import com._8x8.service.ICarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by bscridon on 29.08.2016.
 */

@RestController
@RequestMapping(value = "/car")
@Api(value = "car", description = "Car API")
public class CarController {

    private ICarService carService;

    @Autowired
    public void setCarService(ICarService carService) {
        this.carService = carService;
    }

    public ICarService getCarService() {
        return carService;
    }

    @ApiOperation(value = "addCar", notes = "Add Car")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car addCar(@RequestBody Car car) throws Exception {
        if (car.getOwner() == null) {
            throw new Exception("To do....");
        }
        return carService.addCar(car);
    }


    @ApiOperation(value = "findCarById", notes = "Find car by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car findCarById(@PathVariable("id") Long id) throws Exception {
        if (id == null) {
            throw new Exception("To Do");
        }
        return carService.findCarById(id);
    }

    @ApiOperation(value = " getAllCars", notes = "Get all cars")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @ApiOperation(value = "updateCar", notes = "Update a car")
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car updateCar(@RequestBody Car oldCar) throws Exception {
        if (oldCar != null) {
            return carService.updateCar(oldCar);
        } else {
            throw new Exception("To do-updateCar");
        }
    }

    @ApiOperation(value = "deleteCar", notes = "Delete a car")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable("id") Long id) throws Exception {
        carService.deleteCar(id);
    }

    /*
    @ApiOperation(value = "findCarByOwnerId", notes = "Find car by owner id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> find(@PathVariable("id") Long id) {
       return carService.findCarByOwnerId(id);
    }*/
}
