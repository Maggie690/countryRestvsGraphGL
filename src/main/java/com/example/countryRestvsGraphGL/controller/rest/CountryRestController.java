package com.example.countryRestvsGraphGL.controller.rest;

import com.example.countryRestvsGraphGL.dto.CountryDto;
import com.example.countryRestvsGraphGL.exceprions.ResourceNotFoundException;
import com.example.countryRestvsGraphGL.services.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryRestController {

    private final CountryService countryService;

    @GetMapping
    public List<CountryDto> getAll() {
        return this.countryService.findAll();
    }

    @GetMapping("/{id}")
    public CountryDto findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return this.countryService.findById(id);
    }

    @PostMapping
    public CountryDto createCountry(@RequestBody CountryDto countryDto) {
        return this.countryService.save(countryDto);
    }

    @PutMapping
    public CountryDto updateCountry(@RequestBody CountryDto countryDto) throws ResourceNotFoundException {
        return this.countryService.update(countryDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Integer id) throws ResourceNotFoundException {
        this.countryService.deleteById(id);
    }
}
