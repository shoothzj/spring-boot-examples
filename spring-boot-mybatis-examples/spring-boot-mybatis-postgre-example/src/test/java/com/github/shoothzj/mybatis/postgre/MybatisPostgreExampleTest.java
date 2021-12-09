package com.github.shoothzj.mybatis.postgre;

import com.github.shoothzj.mybatis.postgre.controller.CountryController;
import com.github.shoothzj.mybatis.postgre.module.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
class MybatisPostgreExampleTest {

    @Autowired
    private CountryController countryController;

    @Test
    public void testContextLoad() {
        Assertions.assertNotNull(countryController);
    }

    @Test
    public void testUserBusiness() {
        countryController.addUser(new Country("China"));
        Assertions.assertEquals(1, countryController.getCountries().getBody().size());
    }

}