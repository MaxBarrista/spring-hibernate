package com.barrista.udemy.spring.controller;

import com.barrista.udemy.spring.model.Car;
import com.barrista.udemy.spring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("car")
public class CarController {

  private CarService carService;

  @Autowired
  public void setCarService(CarService carService) {
    this.carService = carService;
  }

  @GetMapping("get-all")
  public String getCars() {
    Car car = new Car(90, 2000, 5, 580);
    carService.upgradeEngine(car);
    return car.toString();
  }

  @GetMapping("get")
  public String getCar() {
    Car car = new Car(90, 2000, 10, 180);
    carService.upgradeEngine(car);
    return car.toString();
  }


}
