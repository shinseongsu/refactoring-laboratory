package com.van;

import com.van.application.MemberService;
import com.van.domain.MemberRepositoryImpl;
import com.van.ui.MemberController;

public class VanApplication {

    public static void main(String[] args) {
        MemberController controller = new MemberController(new MemberService(new MemberRepositoryImpl()));

        controller.searchMembers();
        controller.fixedLength();
    }

}
