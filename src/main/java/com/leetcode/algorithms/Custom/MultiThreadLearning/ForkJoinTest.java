package com.leetcode.algorithms.Custom.MultiThreadLearning;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Author JoeyYoung
 * @ClassName:
 * @Date 2021/12/6 11:19
 * @Description:
 * 首先继承其子类，这个是有返回值的，所以继承RecursiveTask
 * ForkJoinTask在执行任务的时候可能会抛出异常，但主线程无法直接铺获异常，
 * 所以ForkJoinTask提供了isCompletedAbnormally()方法来检查任务是否已将抛出异常或已被取消了，
 * 并可以通过ForkJoinTask的getException方法获取异常.
 */

public class ForkJoinTest extends RecursiveTask<Integer> {
    private static final int THREAD_HOLD = 2;

    private int start;
    private int end;

    public  ForkJoinTest(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute(){
        int sum = 0;
        boolean flag = (end - start)<=THREAD_HOLD;
        if(flag){
            for(int i = start;i <= end;i++){
                sum += i;
            }
        } else {
            int middle = (start + end)/2;
            ForkJoinTest one = new ForkJoinTest(start,middle);
            ForkJoinTest two = new ForkJoinTest(middle+1,end);
            //执行子任务
            one.fork();
            two.fork();
            //获取子任务执行结果
            int oResult = one.join();
            int tResult = two.join();
            sum = oResult + tResult;
        }
        return sum;
    }

    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool ();
        ForkJoinTest task = new ForkJoinTest(1,14);
        Future<Integer> result = pool.submit(task);
        try{
            //合并这些数据
            System.out.println(result.get());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
