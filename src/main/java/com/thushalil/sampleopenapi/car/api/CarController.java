package com.thushalil.sampleopenapi.car.api;

import com.thushalil.sampleopenapi.api.CarApi;
import com.thushalil.sampleopenapi.api.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CarController implements CarApi {

    @Override
    public ResponseEntity<Void> addCar(Car car) {
        return CarApi.super.addCar(car);
    }

    @Override
    public ResponseEntity<Car> getCar(BigDecimal carId) {
        return CarApi.super.getCar(carId);
    }

    @Override
    public ResponseEntity<List<Car>> getCars() {
        return CarApi.super.getCars();
    }
}
