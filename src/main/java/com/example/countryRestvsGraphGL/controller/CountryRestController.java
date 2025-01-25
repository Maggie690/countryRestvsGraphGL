package com.example.countryRestvsGraphGL.controller;

import com.example.countryRestvsGraphGL.dto.CountryDto;
import com.example.countryRestvsGraphGL.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/something")
public class CountryRestController {

    private final CountryService countryService;

    @GetMapping
    public List<CountryDto> getAll() {
        return countryService.findAll();
    }
}
