package com.example.countryRestvsGraphGL.controller;

import com.example.countryRestvsGraphGL.entiies.Country;
import com.example.countryRestvsGraphGL.repositories.CountyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CountryGraphQLController {

    private final CountyRepository repository;

    @QueryMapping
    public Iterable<Country> countries() {
        return this.repository.findAll();
    }
}
