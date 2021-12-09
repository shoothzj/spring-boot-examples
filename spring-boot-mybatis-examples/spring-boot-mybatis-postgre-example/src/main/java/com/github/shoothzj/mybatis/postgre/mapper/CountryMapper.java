package com.github.shoothzj.mybatis.postgre.mapper;

import com.github.shoothzj.mybatis.postgre.module.Country;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CountryMapper {

    @Update("CREATE TABLE IF NOT EXISTS city (country_name VARCHAR (50) PRIMARY KEY)")
    void createTable();

    @Insert("Insert into city (country_name) values (#{countryName})")
    void saveCountry(Country country);

    @Select("SELECT * FROM city")
    List<Country> findCountries();

}
