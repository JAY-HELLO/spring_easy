package com.example.spring_easy.order;

import com.example.spring_easy.discount.DiscountPolicy;
import com.example.spring_easy.member.Member;
import com.example.spring_easy.member.MemberRepository;


public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 이 코드를 바꾸는 순간 fixDiscountPolicy 에서 다른 구체 클래스를 의존하게 되는 것임으로
    //DIP => 인터페이스에만 의존하도록 해야함 와 OCP => 코드 변경 없이 확장 가능해야함. 모두 위반.
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // DIP 를 지키기 위해 discountPolicy를 변경
    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice,discountPrice);
    }
}
