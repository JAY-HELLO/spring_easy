package com.example.spring_easy.discount;

import com.example.spring_easy.annotation.MainDiscountPolicy;
import com.example.spring_easy.member.Grade;
import com.example.spring_easy.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    /***
     *
     * @param member
     * @param price
     * @return
     */
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100; // 이러한 계산 로직은 항상 의심해 보아야 한다. 즉 test 해보아야 한다는 의미.
        }else{
            return 0;
        }
    }

    // 윈도우에서 ctrl shift t 를 통해서 바로 test 파일 생성 가능

}
