package com.junitandmockito.testingproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junitandmockito.testingproject.bean.Country;
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{
	
	Country findByCountryName(String countryName);

}
