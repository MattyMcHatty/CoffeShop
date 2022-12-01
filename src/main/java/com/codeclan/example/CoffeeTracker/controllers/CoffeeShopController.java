package com.codeclan.example.CoffeeTracker.controllers;

import com.codeclan.example.CoffeeTracker.models.CoffeeShop;
import com.codeclan.example.CoffeeTracker.repositories.CoffeeShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoffeeShopController {

    @Autowired
    CoffeeShopRepository coffeeShopRepository;

    @GetMapping(value = "/coffeeshops")
    public ResponseEntity<List<CoffeeShop>> findCoffeeShopByRegion(@RequestParam(name="region", required = false) String region){
        if(region != null){
            return new ResponseEntity<>(coffeeShopRepository.findCoffeeShopByRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity<>(coffeeShopRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/coffeeshops/{id}")
    public ResponseEntity getCoffeeShops(@PathVariable Long id){
        return new ResponseEntity<>(coffeeShopRepository.findById(id), HttpStatus.OK);
    }

}
