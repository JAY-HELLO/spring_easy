package com.example.spring_easy;

import com.example.spring_easy.discount.FixDiscountPolicy;
import com.example.spring_easy.member.MemberService;
import com.example.spring_easy.member.MemberServiceImpl;
import com.example.spring_easy.member.MemoryMemberRepository;
import com.example.spring_easy.order.OrderService;
import com.example.spring_easy.order.OrderServiceImpl;

/***
 * application 에 대한 환경설정을 이곳에서 다 해준다.
 */
public class AppConfig {

    // 생성자 주입 의존관계 주입 (DI dependency injection)
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new FixDiscountPolicy(), new MemoryMemberRepository());
    }

}
