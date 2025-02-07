package com.example.countryRestvsGraphGL.repositories;

import com.example.countryRestvsGraphGL.entiies.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Integer> {
}