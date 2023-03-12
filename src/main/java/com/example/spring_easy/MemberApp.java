package com.example.spring_easy;

import com.example.spring_easy.member.Grade;
import com.example.spring_easy.member.Member;
import com.example.spring_easy.member.MemberService;

public class MemberApp {
    public static void main(String[] args){
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new m = "+member.getName());
        System.out.print("find Member = "+ findMember.getName());
    }
}
