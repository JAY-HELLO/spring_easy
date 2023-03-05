package com.example.spring_easy;

import com.example.spring_easy.member.Grade;
import com.example.spring_easy.member.Member;
import com.example.spring_easy.member.MemberService;
import com.example.spring_easy.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService =new MemberServiceImpl();
    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then

        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
