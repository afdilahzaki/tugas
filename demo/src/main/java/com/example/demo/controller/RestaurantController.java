//package com.example.demo.controller;
//
//import com.example.demo.entity.Restaurant;
//import com.example.demo.service.RestaurantService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/restaurant")
//public class RestaurantController {
//    private final RestaurantService restaurantService;
//    @Autowired
//    public RestaurantController (RestaurantService restaurantService) { this.restaurantService = restaurantService; }
//
//    @PostMapping("/save")
//    public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant) {
//        Restaurant response = restaurantService.saveRestaurant(restaurant);
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/{id-restaurant}")
//    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id-restaurant") String idrestaurant) throws NoSuchFieldException {
//        Restaurant reponse =restaurantService.getRestaurant(idrestaurant);
//        return ResponseEntity.ok(reponse);
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Restaurant>> getAllRestaurant(){
//        List<Restaurant> response = restaurantService.getAllRestaurant();
//        return ResponseEntity.ok(response);
//    }
//
//    @PutMapping("/edit")
//    public ResponseEntity<Restaurant> editRestaurant(@RequestParam("id-restaurant") String idRestaurant,
//                                                     @RequestParam("name") String name,
//                                                     @RequestParam("no meja") String noMeja,
//                                                     @RequestParam("Pesanan") String pesanan ) throws NoSuchFieldException {
//        Restaurant restaurant = restaurantService.editRestaurant(idRestaurant, name, noMeja, pesanan);
//        return ResponseEntity.ok(restaurant);
//    }
//
//    @DeleteMapping("/{id-restaurant}")
//    public ResponseEntity<String> deleteRestaurant(@PathVariable("id-restaurant") String idRestaurant){
//        restaurantService.deleteRestaurant(idRestaurant);
//        return ResponseEntity.ok("OK");
//    }
//}

package com.example.demo.controller;

import com.example.demo.entity.Restaurant;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/save")
    public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantService.saveRestaurant(restaurant);
        return ResponseEntity.ok(savedRestaurant);
    }

    @GetMapping("/{idRestaurant}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable String idRestaurant) {
        Restaurant restaurant = restaurantService.getRestaurant(idRestaurant);
        if (restaurant != null) {
            return ResponseEntity.ok(restaurant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Restaurant>> getAllRestaurant() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurant();
        return ResponseEntity.ok(restaurants);
    }

    @PutMapping("/edit/{idRestaurant}")
    public ResponseEntity<Restaurant> editRestaurant(@PathVariable String idRestaurant,
                                                     @RequestBody Restaurant restaurantDetails) {
        Restaurant updatedRestaurant = restaurantService.editRestaurant(idRestaurant, restaurantDetails);
        if (updatedRestaurant != null) {
            return ResponseEntity.ok(updatedRestaurant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idRestaurant}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable String idRestaurant){
        restaurantService.deleteRestaurant(idRestaurant);
        return ResponseEntity.ok("OK");
    }
}




