package com.jwxtssm.service;

import com.jwxtssm.dao.ITestDao;

public class TestBiz implements ITestBiz {
    ITestDao testDao;

    public ITestDao getTestDao() {
        return testDao;
    }

    public void setTestDao(ITestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public void doSomething() {
        testDao.doSomething();
        System.out.println("test biz!");
    }
}
