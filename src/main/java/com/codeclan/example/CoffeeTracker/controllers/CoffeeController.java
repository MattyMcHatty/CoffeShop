package com.codeclan.example.CoffeeTracker.controllers;

import com.codeclan.example.CoffeeTracker.models.Coffee;
import com.codeclan.example.CoffeeTracker.repositories.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CoffeeController {

    @Autowired
    CoffeeRepository coffeeRepository;

//    @GetMapping(value = "/coffees")
//    public ResponseEntity<List<Coffee>> getAllCoffees(){
//        return new ResponseEntity<>(coffeeRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value = "/coffees/{id}")
    public ResponseEntity getCoffee(@PathVariable Long id){
        return new ResponseEntity<>(coffeeRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/coffees")
    public ResponseEntity<List<Coffee>> findCoffeesFilterByStrength(
            @RequestParam(name="strength", required = false) Integer strength) {
        if (strength != null) {
            return new ResponseEntity<>(coffeeRepository.findCoffeesByStrength(strength), HttpStatus.OK);
        }
        return new ResponseEntity<>(coffeeRepository.findAll(), HttpStatus.OK);
    }

}
