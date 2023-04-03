package com.example.spring_easy.singleton;

import com.example.spring_easy.AppConfig;
import com.example.spring_easy.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 di 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        MemberService ms1 = appConfig.memberService();
        MemberService ms2 = appConfig.memberService();
        //스프링 없는 순수학 di 컨테이너 appConfig는 요청을 할때 마다 객체를 새로 생성한다. -> 메모리 낭비가 심하다
        assertThat(ms1).isNotSameAs(ms2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체사용")
    //같은객체 인스턴스가 반환되었음을 확인.
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("s s 1 = " + singletonService1);
        System.out.println("s s 1 = " + singletonService2);
        
        assertThat(singletonService1).isSameAs(singletonService2);
        
        //same == 객체 인스턴스 비교
        //equal == 값 비교
    }
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService ms1 = ac.getBean("memberService",MemberService.class);
        MemberService ms2 = ac.getBean("memberService",MemberService.class);
        //스프링 없는 순수학 di 컨테이너 appConfig는 요청을 할때 마다 객체를 새로 생성한다. -> 메모리 낭비가 심하다
        // 그러나 스프링 컨테니너는 싱글톤 의 장점과 단접을 잘 처리한 컨테이너를 제공함. 객체를 따로 생성하지 않음.
        assertThat(ms1).isSameAs(ms2);
    }
}
