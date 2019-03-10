package com.jwxtssm.common;

import com.jwxtssm.controller.TestAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestAction testAction = (TestAction) ctx.getBean("testAction");
		testAction.doSomething();
	}
}
