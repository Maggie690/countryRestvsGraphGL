package com.example.countryRestvsGraphGL.controller.graphql;

import com.example.countryRestvsGraphGL.dto.ContinentDto;
import com.example.countryRestvsGraphGL.exceprions.ResourceNotFoundException;
import com.example.countryRestvsGraphGL.services.ContinentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ContinentController {

    private final ContinentService continentService;

    @QueryMapping
    public Iterable<ContinentDto> continents() {
        return this.continentService.findAll();
    }

    @SchemaMapping(typeName = "Query", field = "continent")
    public ContinentDto countriesByContinent(@Argument(name = "id") Integer id) throws ResourceNotFoundException {
        return continentService.findById(id);
    }
}
