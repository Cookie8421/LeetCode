package com.leetcode.algorithms.MediumMode;

/**
 * SQL Schema
 *
 * Create table If Not Exists Employee (Id int, Salary int)
 * Truncate table Employee
 * insert into Employee (id, salary) values ('1', '100')
 * insert into Employee (id, salary) values ('2', '200')
 * insert into Employee (id, salary) values ('3', '300')
 *
 * Table: Employee
 *
 * +-------------+------+
 * | Column Name | Type |
 * +-------------+------+
 * | id          | int  |
 * | salary      | int  |
 * +-------------+------+
 * id is the primary key column for this table.
 * Each row of this table contains information about the salary of an employee.
 *
 *
 *
 * Write an SQL query to report the nth highest salary from the Employee table. If there is no nth highest salary, the query should report null.
 *
 * The query result format is in the following example.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * Employee table:
 * +----+--------+
 * | id | salary |
 * +----+--------+
 * | 1  | 100    |
 * | 2  | 200    |
 * | 3  | 300    |
 * +----+--------+
 * n = 2
 * Output:
 * +------------------------+
 * | getNthHighestSalary(2) |
 * +------------------------+
 * | 200                    |
 * +------------------------+
 *
 * Example 2:
 *
 * Input:
 * Employee table:
 * +----+--------+
 * | id | salary |
 * +----+--------+
 * | 1  | 100    |
 * +----+--------+
 * n = 2
 * Output:
 * +------------------------+
 * | getNthHighestSalary(2) |
 * +------------------------+
 * | null                   |
 * +------------------------+
 */
public class NthHighestSalary {
    /**
     * Runtime: 657 ms, faster than 27.47% of MySQL online submissions for Nth Highest Salary.
     * Memory Usage: 0B, less than 100.00% of MySQL online submissions for Nth Highest Salary.
     */
    /*
    CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
    BEGIN
    SET N=N-1;
    RETURN (
    # Write your MySQL query statement below.
    select distinct salary
    from employee order by salary desc limit 1 offset N
    );
    END
     */
}
