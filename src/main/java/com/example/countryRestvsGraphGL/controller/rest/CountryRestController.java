package com.example.countryRestvsGraphGL.controller.rest;

import com.example.countryRestvsGraphGL.dto.CountryDto;
import com.example.countryRestvsGraphGL.exceprions.ResourceNotFoundException;
import com.example.countryRestvsGraphGL.services.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CountryDto> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(this.countryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CountryDto> createCountry(@RequestBody CountryDto countryDto) {
        return ResponseEntity.ok(this.countryService.save(countryDto));
    }

    @PutMapping
    public ResponseEntity<CountryDto> updateCountry(@RequestBody CountryDto countryDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(this.countryService.update(countryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Integer id) {
        try {
            this.countryService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
