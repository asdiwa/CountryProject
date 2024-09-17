package com.junitandmockito.testingproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junitandmockito.testingproject.bean.AddResponse;
import com.junitandmockito.testingproject.bean.Country;
import com.junitandmockito.testingproject.service.CountryService;

@RestController

public class CountryController {
	private CountryService countryService;

	@Autowired
	public CountryController(CountryService countryService) {
		super();
		this.countryService = countryService;
	}

	@GetMapping("/getcountries")
	public ResponseEntity<List<Country>> getCountries() {
		return new ResponseEntity<List<Country>>(countryService.getAllCountries(), HttpStatus.OK);

	}

	@GetMapping("/getcountries/{id}")
	public ResponseEntity<Country> getCountriesById(@PathVariable int id) {
		try {
			return new ResponseEntity<Country>(countryService.getCountryById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping("/getcountries/countryname")
	public ResponseEntity<Country> getCountryByName(@RequestParam("name") String name) {
		return new ResponseEntity<Country>(countryService.getCountryByName(name), HttpStatus.OK);
	}

	@PostMapping("/addcountry")
	public ResponseEntity<Country> addCountry(@RequestBody Country country) {
		return new ResponseEntity<Country>(countryService.addCountry(country), HttpStatus.CREATED);
	}

	@PutMapping("/updatecountry/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable Integer id,@RequestBody Country country) {
		try {
		Country countryById = countryService.getCountryById(id);
		countryById.setCountryName(country.getCountryName());
		countryById.setCountryCapital(country.getCountryCapital());
		return new ResponseEntity<Country>(countryService.updateCountry(countryById), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity("Country not found with id "+id,HttpStatus.NOT_FOUND);
		}
			
	}

	@DeleteMapping("/deletecountry/{id}")
	public ResponseEntity<AddResponse> deleteCountryById(@PathVariable Integer id) {
		return new ResponseEntity<AddResponse>(countryService.deleteCountry(id), HttpStatus.OK);
	}

}
