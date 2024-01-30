//package com.example.demo.service;
//
//import com.example.demo.entity.Restaurant;
//
//import java.util.List;
//
//public interface RestaurantService {
//    Restaurant saveRestaurant(Restaurant restaurant);
//
//    Restaurant getRestaurant(String idRestaurant) throws NoSuchFieldException;
//
//    List<Restaurant> getAllRestaurant();
//
//    Restaurant editRestaurant(String idRestaurant, String name, String noMeja, String pesanan) throws  NoSuchFieldException;
//
//    void deleteRestaurant(String idRestaurant);
//}

package com.example.demo.service;

import com.example.demo.entity.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurant(Long id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        return restaurantOptional.orElse(null);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant editRestaurant(Long id, Restaurant restaurantDetails) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            restaurant.setName(restaurantDetails.getName());
            restaurant.setNoMeja(restaurantDetails.getNoMeja());
            restaurant.setPesanan(restaurantDetails.getPesanan());
            return restaurantRepository.save(restaurant);
        }
        return null;
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
