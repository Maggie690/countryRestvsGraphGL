package com.example.countryRestvsGraphGL.services;

import com.example.countryRestvsGraphGL.exceprions.ResourceNotFoundException;
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

    public CountryDto findById(Integer id) throws ResourceNotFoundException {

        return this.repository.findById(id)
                .map(c -> mapper.convertValue(c, CountryDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Country with id:" + id + " is not found"));
    }

    public CountryDto save(CountryDto countryDto) {
        var entity = mapper.convertValue(countryDto, Country.class);
        var response = repository.save(entity);

        return mapper.convertValue(response, CountryDto.class);
    }

    public CountryDto update(CountryDto countryDto) throws ResourceNotFoundException {
        var entity = mapper.convertValue(countryDto, Country.class);

        findById(countryDto.getCountryId());

        var response = repository.save(entity);
        return mapper.convertValue(response, CountryDto.class);
    }

    public void deleteById(Integer id) throws ResourceNotFoundException {
        findById(id);
        repository.deleteById(id);
    }
}
