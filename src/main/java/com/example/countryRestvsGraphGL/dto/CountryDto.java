package com.example.countryRestvsGraphGL.dto;

import com.example.countryRestvsGraphGL.entiies.Continent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private Integer countryId;
    private String code;
    private String name;
    private int phone;
    private String currencySymbol;
    private String capital;
    private String currency;
    private String alpha_3;
    private Continent continent;
}
