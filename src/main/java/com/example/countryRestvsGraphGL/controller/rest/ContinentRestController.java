package com.example.countryRestvsGraphGL.controller.rest;

import com.example.countryRestvsGraphGL.dto.ContinentDto;
import com.example.countryRestvsGraphGL.exceprions.ResourceNotFoundException;
import com.example.countryRestvsGraphGL.services.ContinentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/continent")
public class ContinentRestController {

    private final ContinentService service;

    @GetMapping
    public List<ContinentDto> getAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public ContinentDto findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return this.service.findById(id);
    }
}
