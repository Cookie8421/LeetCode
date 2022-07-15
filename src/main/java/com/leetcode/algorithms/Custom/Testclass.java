package com.leetcode.algorithms.Custom;

import com.google.common.collect.Lists;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Testclass {

    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("");
        Statement statement = connection.createStatement();

    }
}
