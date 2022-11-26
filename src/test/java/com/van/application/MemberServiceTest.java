package com.van.application;

import com.van.domain.Member;
import com.van.domain.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @BeforeEach
    void setUp() {
        // MockitoAnnotations.initMocks(this); // deprecated
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("회원 전체를 조회한다.")
    @Test
    void searchMembers() {
        when(memberService.searchMember()).thenReturn(List.of(
                new Member(1L, "네이버", 10)
        ));
        List<Member> members = memberService.searchMember();

        assertThat(members).hasSize(1);
    }

}