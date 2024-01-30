package com.example.demo.service;


import com.example.demo.entity.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {this.restaurantRepository = restaurantRepository; }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurant(String idRestaurant) throws NoSuchFieldException {
        return restaurantRepository.findById(idRestaurant).orElseThrow(()->{
            return new NoSuchFieldException("Restaurant Not Found");
        });
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant editRestaurant(String idRestaurant, String name, String noMeja, String pesanan) throws NoSuchFieldException {
        Restaurant restaurant = restaurantRepository.findById(idRestaurant).orElseThrow(()->{
            return new NoSuchFieldException("Restaurant no found");
        });
        restaurant.setName(name);
        restaurant.setNoMeja(noMeja);
        restaurant.setPesanan(pesanan);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(String idRestaurant) {
        restaurantRepository.deleteById(idRestaurant);
    }
}


