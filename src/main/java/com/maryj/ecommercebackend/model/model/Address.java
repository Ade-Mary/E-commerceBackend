package com.maryj.ecommercebackend.model.model;

import jakarta.persistence.*;

@Entity
public class Address {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String country;
    private String addressLine1;
    private String addressLine2;
    private String city;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private LocalUser user;
}
