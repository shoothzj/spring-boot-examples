package com.github.shoothzj.mysql.test.init.sql.repository;

import com.github.shoothzj.mysql.test.init.sql.TestInitSqlTestConfig;
import com.github.shoothzj.mysql.test.init.sql.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestInitSqlTestConfig.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testInsertDuplicateUserName() {
        userRepository.save(new User(0L, "sh", "sh"));
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            userRepository.save(new User(1L, "sh", "hs"));
            System.out.println("size is " + userRepository.findAll().size());
        });
    }

}