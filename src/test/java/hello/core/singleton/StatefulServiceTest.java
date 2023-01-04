package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A 사용자가 10000원 주문
        int userA = statefulService1.order("userA", 10000);
        //ThreadB : B 사용자가 20000원 주문
        int userB = statefulService2.order("userB", 20000);

        //ThreadA : 사용자 A 주문금액 조회
        //int priceA = statefulService1.getPrice();
        //ThreadB : 사용자 B 주문금액 조회
        //int priceB = statefulService2.getPrice();

        assertThat(userA).isEqualTo(10000);
        assertThat(userB).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}