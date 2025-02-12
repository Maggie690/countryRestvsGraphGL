package com.example.countryRestvsGraphGL.controller.graphql;

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
public class CountryController {

    private final CountryService countryService;

    @QueryMapping
    public Iterable<CountryDto> countries() {
        return this.countryService.findAll();
    }

    @QueryMapping
    public CountryDto countryById(@Argument(name = "countryId") Integer countryId) throws ResourceNotFoundException {
        return countryService.findById(countryId);
    }

    @MutationMapping
    public CountryDto addCountry(@Argument(name = "input") CountryDto countryDto) {
        return this.countryService.save(countryDto);
    }

    @MutationMapping
    public CountryDto updateCountry(@Argument(name = "input") CountryDto countryDto) throws ResourceNotFoundException {
        return this.countryService.update(countryDto);
    }
}
