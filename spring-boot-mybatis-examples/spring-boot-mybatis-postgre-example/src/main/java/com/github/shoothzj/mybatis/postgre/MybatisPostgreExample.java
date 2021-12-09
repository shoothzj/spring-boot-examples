package com.github.shoothzj.mybatis.postgre;

import com.github.shoothzj.mybatis.postgre.mapper.CountryMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class MybatisPostgreExample {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPostgreExample.class);
    }

//    @Profile("!test")
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgre://localhost:5432/ttbb");
//        dataSource.setUsername("sh");
//        dataSource.setPassword("ttlovezj");
//        return dataSource;
//    }

    @Bean
    CommandLineRunner createTable(@Autowired CountryMapper countryMapper) {
        return args -> countryMapper.createTable();
    }

}
