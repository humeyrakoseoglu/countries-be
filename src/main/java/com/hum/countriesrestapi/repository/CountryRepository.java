package com.hum.countriesrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hum.countriesrestapi.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> { //Spring Data JPA'nın sorgu oluşturma mekanizmasını kullanabilirsin
    List<Country> getByPhone(int phonecode);
    Country getCountryByName(String name);
    void deleteById(String id);
} 