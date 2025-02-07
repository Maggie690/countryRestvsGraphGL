package com.example.countryRestvsGraphGL.dto;

import com.example.countryRestvsGraphGL.entiies.Country;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContinentDto {
    private Integer id;
    private String name;
    private String code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Country> countries;
}
