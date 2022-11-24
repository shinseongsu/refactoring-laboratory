package com.van.domain;

import com.van.support.parser.FixedLength;
import lombok.Getter;

@Getter
public class Request {

    @FixedLength(length = 2)
    private String gubun;

    @FixedLength(offset = 2, length = 4)
    private String gubun2;

    @Override
    public String toString() {
        return "Request{" +
                "gubun='" + gubun + '\'' +
                ", gubun2='" + gubun2 + '\'' +
                '}';
    }
}
