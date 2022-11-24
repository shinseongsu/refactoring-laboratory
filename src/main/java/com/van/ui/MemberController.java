package com.van.ui;

import com.van.application.MemberService;
import com.van.domain.Member;
import com.van.domain.Request;
import com.van.support.parser.Parser;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
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

    public void fixedLength() {
        try {
            byte[] bytes = "1234567890".getBytes("UTF-8");

            Parser parser = new Parser();
            List<Request> requests = parser.parser(bytes, Request.class);

            System.out.println(requests.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
