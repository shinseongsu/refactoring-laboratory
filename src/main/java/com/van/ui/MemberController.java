package com.van.ui;

import com.van.application.MemberService;
import com.van.domain.Member;
import com.van.domain.Request;
import com.van.support.parser.Parser;

import java.util.List;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public void searchMembers() {
        List<Member> members = memberService.searchMember();

        members.forEach(System.out::println);
    }

    public List<Request> fixedLength(byte[] bytes) {
        try {
            Parser parser = new Parser();
            List<Request> requests = parser.parser(bytes, Request.class);

            System.out.println(requests.get(0));

            return requests;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("ㅎㅎ");
        }
    }

}
