package com.example.countryRestvsGraphGL.repositories;

import com.example.countryRestvsGraphGL.entiies.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountyRepository extends JpaRepository<Country, Integer> {
}
