package com.example.countryRestvsGraphGL.controller;

import com.example.countryRestvsGraphGL.dto.CountryDto;
import com.example.countryRestvsGraphGL.exceprions.ResourceNotFoundException;
import com.example.countryRestvsGraphGL.services.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CountryGraphQLController {

    private final CountryService service;

    @QueryMapping
    public Iterable<CountryDto> countries() {
        return this.service.findAll();
    }

    @QueryMapping
    public CountryDto countryById(@Argument(name = "id") Integer id) throws ResourceNotFoundException {
        return service.findById(id);
    }

    @MutationMapping
    public CountryDto addCountry(@Argument(name = "input") CountryDto countryDto) {
        return this.service.save(countryDto);
    }

    @MutationMapping
    public CountryDto updateCountry(@Argument(name = "input") CountryDto countryDto) throws ResourceNotFoundException {
        return this.service.update(countryDto);
    }
}
