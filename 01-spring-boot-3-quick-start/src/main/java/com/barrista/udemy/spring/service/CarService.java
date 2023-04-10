package com.barrista.udemy.spring.service;

import com.barrista.udemy.spring.model.Car;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    public void upgradeEngine(Car car) {
        car.setAcceleration(car.getAcceleration() * 0.9);
        car.setMaxSpeed(car.getMaxSpeed() * 1.1);
    }
}
