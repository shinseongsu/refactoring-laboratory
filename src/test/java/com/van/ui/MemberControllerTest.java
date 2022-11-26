package com.van.ui;

import com.van.domain.Request;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberControllerTest {

    @InjectMocks
    private MemberController controller;

    @BeforeEach
    void setUp() {
        // MockitoAnnotations.initMocks(this); // deprecated
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("받은 전문을 테스트 합니다.")
    @Test
    void fixedLength() {
        byte[] bytes = "1234567890".getBytes(StandardCharsets.UTF_8);

        List<Request> requests = controller.fixedLength(bytes);

        assertThat(requests.get(0)).isEqualTo(new Request("12", "3456"));
    }

}