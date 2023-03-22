package com.example.spring_easy;

import com.example.spring_easy.member.Grade;
import com.example.spring_easy.member.Member;
import com.example.spring_easy.member.MemberService;
import com.example.spring_easy.order.Order;
import com.example.spring_easy.order.OrderService;
import com.example.spring_easy.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
 //       MemberService memberService = new MemberServiceImpl(null);
 //       OrderService orderService = new OrderServiceImpl(null,null);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);
    }
}
