package com.leetcode.Learning.TryWithResourcesL;

public class Sample {
    public static void main(String[] args) {
        try(Lion lion = new Lion(); Tiger tiger = new Tiger()){
            lion.hunt();
            tiger.hunt();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("finally");
        }
    }
    /**
     * 狮子的close方法中的异常被抑制输出了，这是try-with-resources的特性，用于不关注close抛出异常的场景
     * 用Throwable.getSuppressed()方法来获取被抑制的异常
     * 同时，close抛出异常时，不会影响其他资源close方法的调用
     * 字节码层面的实现逻辑与try-finally一致
     */
}
