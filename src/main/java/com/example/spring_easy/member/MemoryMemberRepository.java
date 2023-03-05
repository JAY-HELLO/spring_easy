package com.example.spring_easy.member;

import java.util.HashMap;
import java.util.Map;

/***
 * db 가 확정이 되지 않아 memory member reposiroty 생성
 */
public class MemoryMemberRepository implements MemberRepository{
    
    private static Map<Long, Member> store = new HashMap<>();
    
    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
