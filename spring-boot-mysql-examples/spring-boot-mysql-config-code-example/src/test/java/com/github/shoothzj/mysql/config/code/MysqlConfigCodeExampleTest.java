package com.github.shoothzj.mysql.config.code;

import com.github.shoothzj.mysql.common.controller.UserController;
import com.github.shoothzj.mysql.common.module.UserAddReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
class MysqlConfigCodeExampleTest {

    /**
     * put the datasource in this, in case the wrong load order
     * @return
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
        return dataSource;
    }

    @Autowired
    private UserController userController;

    @Test
    public void testContextLoad() {
        Assertions.assertNotNull(userController);
    }

    @Test
    public void testUserBusiness() {
        userController.addUser(new UserAddReq("ZhangSan", "pwd"));
        userController.addUser(new UserAddReq("LiSi", "pwd"));
        Assertions.assertEquals(2, userController.getUsers().getBody().size());
    }

}