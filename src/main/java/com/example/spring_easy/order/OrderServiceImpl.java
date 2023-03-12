package com.example.spring_easy.order;

import com.example.spring_easy.discount.DiscountPolicy;
import com.example.spring_easy.discount.FixDiscountPolicy;
import com.example.spring_easy.member.Member;
import com.example.spring_easy.member.MemberRepository;
import com.example.spring_easy.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice,discountPrice);
    }
}
