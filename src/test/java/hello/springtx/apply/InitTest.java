package hello.springtx.apply;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@SpringBootTest
public class InitTest {

    @Autowired Hello hello;

    @Test
    void go () {
        // 초기화 코드는 스프링이 초기화 시점에 호출
    }

    @TestConfiguration
    static class InitTestConfig {

        @Bean
        Hello hello() {
            return new Hello();
        }
    }

    static class Hello {

        @PostConstruct
        @Transactional  // 트랜잭션 미적용
        public void initV1() {
            boolean active = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("Hello initV1 @PostConstruct tx active={}", active);
        }

        @EventListener(ApplicationReadyEvent.class)
        @Transactional  // 트랜잭션 적용
        public void initV2() {
            boolean active = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("Hello initV2 ApplicationReady tx active={}", active);
        }
    }
}
