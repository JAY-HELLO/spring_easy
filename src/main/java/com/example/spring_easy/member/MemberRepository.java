package com.example.spring_easy.member;

/***
 * 회원저장소
 * 메모리 회원저장소
 * db회원 저장소
 * 외부 시스템 연동 회원 저장소
 */
public interface MemberRepository {

    void  save(Member member);

    Member findById(Long memberId);

}
