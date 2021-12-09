package com.github.shoothzj.springcloud.zk;

import com.github.shoothzj.springcloud.zk.controller.ProbeController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringCloudZooKeeperExampleTest {

    @Autowired
    private ProbeController probeController;

    @Test
    public void testContextLoad() {
        Assertions.assertNotNull(probeController);
    }

}