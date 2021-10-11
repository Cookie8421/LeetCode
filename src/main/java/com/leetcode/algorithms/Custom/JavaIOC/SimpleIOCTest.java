package com.leetcode.algorithms.Custom.JavaIOC;

public class SimpleIOCTest {

    public void getBean() throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("spring-test.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        TestBean bean = (TestBean) bf.getBean("bean");
        System.out.println(bean);
    }
}
