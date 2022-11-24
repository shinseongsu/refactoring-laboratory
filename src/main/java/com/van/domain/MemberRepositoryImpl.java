package com.van.domain;

import com.van.support.ResultSetMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryImpl implements MemberRepository {

    @Override
    public List<Member> findByAll() {
        List<Member> members = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "SELECT id, name, age FROM member";

            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/van", "root", "0000");
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            ResultSetMapper<Member> mapper = new ResultSetMapper<>();

            members = mapper.mapRersultSetToObject(resultSet, Member.class);
        } catch (ClassNotFoundException error) {
            System.out.println("Mysql driver 미설치 또는 드라이버 이름 오류");
        } catch (SQLException e) {
            System.out.println("DB 접속 오류");
        }

        return members;
    }
}
