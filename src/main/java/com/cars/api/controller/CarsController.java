package com.cars.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.api.dto.CarsDTO;
import com.cars.api.model.Cars;
import com.cars.api.repository.CarsRepository;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

  @Autowired
  private CarsRepository repository;

  @GetMapping
  public List<Cars> listAll() {
    return repository.findAll();
  }

  @PostMapping
  public void createCars(@RequestBody CarsDTO req) {
    repository.save(new Cars(req));
  }
}
