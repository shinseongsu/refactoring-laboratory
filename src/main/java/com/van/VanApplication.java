package com.van;

import com.van.application.MemberService;
import com.van.domain.MemberRepositoryImpl;
import com.van.ui.MemberController;

import java.nio.charset.StandardCharsets;

public class VanApplication {

    public static void main(String[] args) {
        MemberController controller = new MemberController(new MemberService(new MemberRepositoryImpl()));

        controller.searchMembers();
        controller.fixedLength("123456789".getBytes(StandardCharsets.UTF_8));
    }

}
