package com.example.countryRestvsGraphGL.entiies;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private char code;
    private String name;
    private int phone;
    private String currencySymbol;
    private String capital;
    private String currency;
    private String continent;
    private String continentCode;
    private String alpha3;

}
