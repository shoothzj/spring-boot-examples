package com.github.shoothzj.mysql.common.repository;

import com.github.shoothzj.mysql.common.domain.User;
import com.github.shoothzj.mysql.common.test.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestConfig.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFilterGroup() {
        userRepository.save(new User(0L, "sh", "sh"));
        userRepository.save(new User(0L, "sh", "sh2"));
        userRepository.save(new User(0L, "zh", "sh"));
        List<String> nameList = userRepository.findUserNameListByPasswordGroupByUsername("sh");
        List<User> userList = userRepository.findUserListByPasswordGroupByUsername("sh");
        Assertions.assertEquals(2, nameList.size());
        Assertions.assertEquals(2, userList.size());
    }

}