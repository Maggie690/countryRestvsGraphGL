package com.example.countryRestvsGraphGL.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private Integer id;
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
