package com.leetcode.algorithms.EasyMode;

/**
 * SQL Schema
 * Create table If Not Exists Employee (id int, name varchar(255), salary int, managerId int)
 * Truncate table Employee
 * insert into Employee (id, name, salary, managerId) values ('1', 'Joe', '70000', '3')
 * insert into Employee (id, name, salary, managerId) values ('2', 'Henry', '80000', '4')
 * insert into Employee (id, name, salary, managerId) values ('3', 'Sam', '60000', 'None')
 * insert into Employee (id, name, salary, managerId) values ('4', 'Max', '90000', 'None')
 * Table: Employee
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | id          | int     |
 * | name        | varchar |
 * | salary      | int     |
 * | managerId   | int     |
 * +-------------+---------+
 * id is the primary key column for this table.
 * Each row of this table indicates the ID of an employee, their name, salary, and the ID of their manager.
 *
 *
 *
 * Write an SQL query to find the employees who earn more than their managers.
 *
 * Return the result table in any order.
 *
 * The query result format is in the following example.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * Employee table:
 * +----+-------+--------+-----------+
 * | id | name  | salary | managerId |
 * +----+-------+--------+-----------+
 * | 1  | Joe   | 70000  | 3         |
 * | 2  | Henry | 80000  | 4         |
 * | 3  | Sam   | 60000  | Null      |
 * | 4  | Max   | 90000  | Null      |
 * +----+-------+--------+-----------+
 * Output:
 * +----------+
 * | Employee |
 * +----------+
 * | Joe      |
 * +----------+
 * Explanation: Joe is the only employee who earns more than his manager.
 */
public class EmployeesEarningMoreThanTheirManagers {

    /**
     * Runtime: 391 ms, faster than 66.93% of MySQL online submissions for Employees Earning More Than Their Managers.
     * Memory Usage: 0B, less than 100.00% of MySQL online submissions for Employees Earning More Than Their Managers.
     */
    //Write your MySQL query statement below
    /*
    select a.name as Employee from Employee a join Employee b on a.managerId = b.id where a.managerId is not null and a.salary > b.salary
     */
}
