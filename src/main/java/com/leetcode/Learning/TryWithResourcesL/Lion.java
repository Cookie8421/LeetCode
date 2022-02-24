package com.leetcode.Learning.TryWithResourcesL;

public class Lion implements AutoCloseable{
    public Lion(){
        System.out.println("Lion is open in the world");
    }
    public void hunt() throws Exception{
        throw new Exception("DeerNotFound says Lion");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Lion is closed in the cage");
        throw new Exception("Unable to close the cage");
    }

}
