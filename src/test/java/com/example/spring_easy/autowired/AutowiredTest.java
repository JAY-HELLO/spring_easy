package com.example.spring_easy.autowired;

import com.example.spring_easy.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{

        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            //scoutv로 자동 생성
            System.out.println("noBean1 = " + noBean1);

        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            //scoutv로 자동 생성
            System.out.println("noBean2 = " + noBean2);

        }

        @Autowired
        public void setNoBean2(Optional<Member> noBean3){
            //scoutv로 자동 생성
            System.out.println("noBean3 = " + noBean3);

        }
    }
}
