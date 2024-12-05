package com.conpany.project;

import com.company.project.Application;
import com.company.project.core.Result;
import com.company.project.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 单元测试继承该类即可
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
@Rollback
public abstract class Tester {

    @Autowired
    private UserController userController;

    @Test
    public void testGetUserList() {
        int page = 0;
        int size = 10; // assuming a default page size
        Result result = userController.list(page, size);
        assertThat(result).isNotNull();
        // Additional assertions can be made here to verify the contents of the result, e.g.,
        // assertThat(result.getData()).isNotEmpty();
    }
}