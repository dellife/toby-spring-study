package com.dellife.springbook.user.dao;

public class DaoFactory {

    public UserDao userDao() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        return new UserDao(connectionMaker);
    }

    public AccountDao accountDao() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        return new AccountDao(connectionMaker);
    }

    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
