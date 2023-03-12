package com.example.spring_easy.discount;

import com.example.spring_easy.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @param member
     * @param price
     * @return 할인대상금액
     */
    int discount(Member member, int price);
}
