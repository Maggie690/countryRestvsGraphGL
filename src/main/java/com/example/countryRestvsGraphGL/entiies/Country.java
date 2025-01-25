package com.example.countryRestvsGraphGL.entiies;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private int phone;
    private String currencySymbol;
    private String capital;
    private String currency;
    private String continent;
    private String continentCode;
    private String alpha_3;

}
