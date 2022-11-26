package com.van.domain;

import com.van.support.parser.FixedLength;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Request {

    @FixedLength(length = 2)
    private String gubun;

    @FixedLength(offset = 2, length = 4)
    private String gubun2;

    public Request() { }

    public Request(String gubun, String gubun2) {
        this.gubun = gubun;
        this.gubun2 = gubun2;
    }

    @Override
    public String toString() {
        return "Request{" +
                "gubun='" + gubun + '\'' +
                ", gubun2='" + gubun2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(gubun, request.gubun) && Objects.equals(gubun2, request.gubun2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gubun, gubun2);
    }
}
