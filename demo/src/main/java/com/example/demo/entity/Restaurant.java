package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Restaurant {

    @Id
    private String idRestaurant;

    @Column (name = "nama")
    private String name;

    @Column (name = "no meja")
    private String noMeja;

    @Column (name = "pesanan")
    private String pesanan;

}



