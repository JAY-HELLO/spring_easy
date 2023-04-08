package com.example.spring_easy.order;

import com.example.spring_easy.AppConfig;
import com.example.spring_easy.discount.FixDiscountPolicy;
import com.example.spring_easy.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){

        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "member", Grade.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId,"item1", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    /**
     * 필드주입 하지 말자.
     */
    void fieldInjectionTest(){
        /*OrderServiceImpl orderService1 = new OrderServiceImpl();
        orderService1.setMemberRepository(new MemoryMemberRepository());
        orderService1.setDiscountPolicy(new FixDiscountPolicy());
        orderService1.createOrder(1L,"itemA",10000);*/

    }
}
