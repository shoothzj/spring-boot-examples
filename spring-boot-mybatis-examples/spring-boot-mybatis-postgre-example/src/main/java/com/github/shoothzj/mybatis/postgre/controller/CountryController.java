package com.github.shoothzj.mybatis.postgre.controller;

import com.github.shoothzj.mybatis.postgre.mapper.CountryMapper;
import com.github.shoothzj.mybatis.postgre.module.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CountryController {

    @Autowired
    private CountryMapper countryMapper;

    @GetMapping(path = "/countries")
    public ResponseEntity<List<Country>> getCountries() {
        List<Country> countries = countryMapper.findCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @PostMapping(path = "/countries")
    public ResponseEntity<Void> addUser(@RequestBody Country country) {
        countryMapper.saveCountry(country);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
