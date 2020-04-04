package com.dellife.springbook.user.dao;


import com.dellife.springbook.user.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

class UserDaoTest {

    @DisplayName("유저를 등록한다")
    @Test
    public void addUser() throws SQLException, ClassNotFoundException {
        //given
        UserDao dao = new UserDao();

        User user = new User();
        user.setId("dellife");
        user.setName("sehee");
        user.setPassword("sehee123");

        //when
        dao.add(user);

        //then
        System.out.println(user.getId() + " 등록 성공");
    }

    @DisplayName("유저를 조회한다.")
    @Test
    void getUser() throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();

        User user = dao.get("dellife");

        assertThat(user.getName()).isEqualTo("sehee");
        assertThat(user.getPassword()).isEqualTo("sehee123");
    }
}
