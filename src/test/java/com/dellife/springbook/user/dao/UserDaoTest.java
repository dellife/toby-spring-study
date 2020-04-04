package com.dellife.springbook.user.dao;


import com.dellife.springbook.user.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

class UserDaoTest {

    @DisplayName("유저를 등록한다")
    @Test
    public void addUser() throws SQLException, ClassNotFoundException {
        //given
        UserDao dao = new DaoFactory().userDao();

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
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = dao.get("dellife");

        assertThat(user.getName()).isEqualTo("sehee");
        assertThat(user.getPassword()).isEqualTo("sehee123");
    }

    @DisplayName("직접 생성한 dao는 매번 새로운 오브젝트가 만들어진다.")
    @Test
    void getDaoFactory() {
        DaoFactory factory = new DaoFactory();
        UserDao dao1 = factory.userDao();
        UserDao dao2 = factory.userDao();

        System.out.println(dao1);
        System.out.println(dao2);
        assertThat(dao1.equals(dao2)).isFalse();
    }

    @DisplayName("스프링컨텍스트로부터 가져온 오브젝트는 동일하다")
    @Test
    void getDaoFactory2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao1 = context.getBean("userDao", UserDao.class);
        UserDao dao2 = context.getBean("userDao", UserDao.class);

        System.out.println(dao1);
        System.out.println(dao2);
        assertThat(dao1.equals(dao2)).isTrue();
    }

    @DisplayName("getConnection을 count한다")
    @Test
    void countingConnectionMaker() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        CountingConnectionMaker countingConnectionMaker = context.getBean("connectionMaker", CountingConnectionMaker.class);
        UserDao userDao = new UserDao(countingConnectionMaker);
        userDao.get("dellife");
        userDao.get("dellife");
        userDao.get("dellife");
        System.out.println(countingConnectionMaker.getCounter());

        assertThat(countingConnectionMaker.getCounter()).isEqualTo(3);
    }
}
