package com.example.spring_easy;

import com.example.spring_easy.discount.DiscountPolicy;
import com.example.spring_easy.discount.FixDiscountPolicy;
import com.example.spring_easy.discount.RateDiscountPolicy;
import com.example.spring_easy.member.MemberRepository;
import com.example.spring_easy.member.MemberService;
import com.example.spring_easy.member.MemberServiceImpl;
import com.example.spring_easy.member.MemoryMemberRepository;
import com.example.spring_easy.order.OrderService;
import com.example.spring_easy.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * application 에 대한 환경설정을 이곳에서 다 해준다.
 */

@Configuration
public class AppConfig {

    // 생성자 주입 의존관계 주입 (DI dependency injection)
    @Bean
    public MemberService memberService(){
       // System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
       // System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
       // System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
