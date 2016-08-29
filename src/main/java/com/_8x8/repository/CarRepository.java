package com._8x8.repository;

import com._8x8.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bscridon on 29.08.2016.
 */
@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
}
