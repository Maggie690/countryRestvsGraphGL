package com.example.countryRestvsGraphGL.services;

import com.example.countryRestvsGraphGL.repositories.CountyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.countryRestvsGraphGL.dto.CountryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountyRepository repository;

    public List<CountryDto> findAll() {
        ObjectMapper mapper = new ObjectMapper();

        return repository.findAll()
                .stream()
                .map(c -> mapper.convertValue(c, CountryDto.class))
                .collect(Collectors.toList());
    }
}
