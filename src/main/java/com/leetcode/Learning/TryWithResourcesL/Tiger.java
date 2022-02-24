package com.leetcode.Learning.TryWithResourcesL;

import java.io.Closeable;

public class Tiger implements AutoCloseable {

    public Tiger(){
        System.out.println("Tiger is open in the world");
    }

    public void hunt() throws Exception{
        throw new Exception("DeerNotFound says Tiger");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Tiger is closed in the cage");
        throw new Exception("Unable to close the cage");
    }
}
