package com.example.spring_easy.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int userA = statefulService1.order("userA",10000);
        int userB = statefulService2.order("userB",20000);

        //thread a : 사용자 a 주문 금액 조회
    //    int price = statefulService1.getPrice();
//        System.out.println("price = "+price);
        System.out.println("price = "+userA);

        //같은 객체를 사용하기 때문에, userA 가 10000원물건을 구매했음에도 20000원의 결제가 나오게 된다
        // 따라서 스프링 빈은 항상 무상태로 설계해야한다

   //     Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);


    }
    static  class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}