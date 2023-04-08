package com.example.spring_easy.order;

import com.example.spring_easy.discount.FixDiscountPolicy;
import com.example.spring_easy.member.Grade;
import com.example.spring_easy.member.Member;
import com.example.spring_easy.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"NAME", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl( new FixDiscountPolicy(),memberRepository);
        Order order = orderService.createOrder(1L, "ItemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}