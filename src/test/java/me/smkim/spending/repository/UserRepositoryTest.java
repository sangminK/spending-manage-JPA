package me.smkim.spending.repository;

import me.smkim.spending.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // junit에게 spring과 관련된 테스트임을 알려줌
@SpringBootTest
public class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @Test
    @Transactional
    public void testUser() throws Exception {
        // given
        User user = new User();
        user.setName("smkim");

        // when
        Long savedId = userRepository.save(user);
        User findUser = userRepository.find(savedId);

        // then
        Assertions.assertThat(findUser.getId()).isEqualTo(user.getId());

    }

}