package com.example.spring_easy.member;

/***
 * 회원 서비스
 * 회원가입
 * 회원조회
 */
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
