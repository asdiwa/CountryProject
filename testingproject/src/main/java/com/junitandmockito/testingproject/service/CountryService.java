package com.junitandmockito.testingproject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junitandmockito.testingproject.bean.AddResponse;
import com.junitandmockito.testingproject.bean.Country;
import com.junitandmockito.testingproject.repositories.CountryRepository;

@Service
public class CountryService {
	// static HashMap<Integer, Country> countryIdMap;
	private CountryRepository countryRepository;

	@Autowired
	public CountryService(CountryRepository countryRepository) {
//		countryIdMap=new HashMap<Integer, Country>();
//		Country indiaCountry=new Country(1,"India","Delhi");
//		Country usaCountry=new Country(2,"USA","Washington");
//		Country ukCountry=new Country(3,"UK","London");
//		countryIdMap.put(1,indiaCountry);
//		countryIdMap.put(2,usaCountry);
//		countryIdMap.put(3,ukCountry);
		this.countryRepository = countryRepository;

	}

	public List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<Country>(countryRepository.findAll());
		return countries;
	}

	public Country getCountryById(Integer id) {
		Country country = countryRepository.findById(id).get();
		return country;

	}

	public Country getCountryByName(String countryName) {
		//Country country1=null;
		Country country = countryRepository.findByCountryName(countryName);
//		List<Country> all = countryRepository.findAll();
//		for(Country c:all) {
//			if(c.getCountryName().equals(countryName)) {
//				return c;
//				
//			}
//		}
//		return null;
//		Country country =null;
//		Set<Integer> keySet = countryIdMap.keySet();
//		for(Integer i:keySet) {
//			if(countryIdMap.get(i).getCountryName().equals(countryName)) {
//				country=countryIdMap.get(i);
//			}
//		}
//		return country;

//		for(Map.Entry<Integer, Country> c:countryIdMap.entrySet()) {
//			if(c.getValue().getCountryName().equals(countryName)) {
//				country =c.getValue();
//			}
//		}
		return country;
	}

	public Country addCountry(Country country) {
		//country.setCountryId(getMaxId());
		//countryIdMap.put(country.getCountryId(), country);
		Country country1 = countryRepository.save(country);
		return country1;
	}

	public Country updateCountry(Country country) {
//		if (country.getCountryId() > 0) {
//			countryIdMap.put(country.getCountryId(), country);
//		}
//		Country country2 = countryRepository.findById(id).get();
//		country2.setCountryName(country.getCountryName());
//		
		return countryRepository.save(country);
	}

	public AddResponse deleteCountry(Integer id) {
		//countryIdMap.remove(id);
		countryRepository.deleteById(id);
		return new AddResponse("Country deleted", id);
	}

//	public static int getMaxId() {
//		int max = 0;
//		for (Integer i : countryIdMap.keySet()) {
//			if (i >= max) {
//				max = i;
//			}
//		}
//		return max + 1;
//	}

}
