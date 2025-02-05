package com.example.countryRestvsGraphGL.services;

import com.example.countryRestvsGraphGL.entiies.Country;
import com.example.countryRestvsGraphGL.repositories.CountyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.countryRestvsGraphGL.dto.CountryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountyRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();

    public List<CountryDto> findAll() {

        return repository.findAll()
                .stream()
                .map(c -> mapper.convertValue(c, CountryDto.class))
                .collect(Collectors.toList());
    }

    public Country findById(Integer id) {
        return this.repository.getReferenceById(id);
    }

    public Country save(CountryDto countryDto) {
        var entity = mapper.convertValue(countryDto, Country.class);
        return repository.save(entity);
    }

    public Country update(CountryDto countryDto) {
        var entity = mapper.convertValue(countryDto, Country.class);
        return repository.save(entity);
    }
}
