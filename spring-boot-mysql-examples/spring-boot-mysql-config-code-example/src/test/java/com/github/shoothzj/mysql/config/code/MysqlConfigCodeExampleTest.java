package com.github.shoothzj.mysql.config.code;

import com.github.shoothzj.mysql.common.controller.UserController;
import com.github.shoothzj.mysql.common.module.UserAddReq;
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
class MysqlConfigCodeExampleTest {

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