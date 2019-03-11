package com.jwxtssm.web;

import com.jwxtssm.service.ITestBiz;

public class TestAction {
    ITestBiz testBiz;

    public ITestBiz getTestBiz() {
        return testBiz;
    }

    public void setTestBiz(ITestBiz testBiz) {
        this.testBiz = testBiz;
    }

    public void doSomething() {
        testBiz.doSomething();
        System.out.println("test action!");
    }
}
