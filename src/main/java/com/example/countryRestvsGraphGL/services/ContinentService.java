package com.example.countryRestvsGraphGL.services;

import com.example.countryRestvsGraphGL.dto.ContinentDto;
import com.example.countryRestvsGraphGL.exceprions.ResourceNotFoundException;
import com.example.countryRestvsGraphGL.repositories.ContinentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContinentService {

    private final ContinentRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();

    public List<ContinentDto> findAll(){
        return repository.findAll().stream()
                .map(c -> mapper.convertValue(c, ContinentDto.class))
                .collect(Collectors.toList());
    }
    public ContinentDto findById(Integer id) throws ResourceNotFoundException {
        return repository.findById(id)
                .map(c -> mapper.convertValue(c, ContinentDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Continent with id:" + id + " is not found"));
    }
}
