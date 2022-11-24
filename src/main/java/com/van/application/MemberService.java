package com.van.application;

import com.van.domain.Member;
import com.van.domain.MemberRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> searchMember() {
        return memberRepository.findByAll();
    }

}
