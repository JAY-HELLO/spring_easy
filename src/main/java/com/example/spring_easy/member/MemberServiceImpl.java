package com.example.spring_easy.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    /**
     * 생성자를 통해서 memberRepository의 구현체를 고르도록 한다.
     * @param memberRepository
     */
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
