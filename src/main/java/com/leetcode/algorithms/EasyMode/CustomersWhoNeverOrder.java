package com.leetcode.algorithms.EasyMode;

/**
 * SQL Schema
 * Create table If Not Exists Customers (id int, name varchar(255))
 * Create table If Not Exists Orders (id int, customerId int)
 * Truncate table Customers
 * insert into Customers (id, name) values ('1', 'Joe')
 * insert into Customers (id, name) values ('2', 'Henry')
 * insert into Customers (id, name) values ('3', 'Sam')
 * insert into Customers (id, name) values ('4', 'Max')
 * Truncate table Orders
 * insert into Orders (id, customerId) values ('1', '3')
 * insert into Orders (id, customerId) values ('2', '1')
 *
 * Table: Customers
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | id          | int     |
 * | name        | varchar |
 * +-------------+---------+
 * id is the primary key column for this table.
 * Each row of this table indicates the ID and name of a customer.
 *
 *
 *
 * Table: Orders
 *
 * +-------------+------+
 * | Column Name | Type |
 * +-------------+------+
 * | id          | int  |
 * | customerId  | int  |
 * +-------------+------+
 * id is the primary key column for this table.
 * customerId is a foreign key of the ID from the Customers table.
 * Each row of this table indicates the ID of an order and the ID of the customer who ordered it.
 *
 *
 *
 * Write an SQL query to report all customers who never order anything.
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
 * Customers table:
 * +----+-------+
 * | id | name  |
 * +----+-------+
 * | 1  | Joe   |
 * | 2  | Henry |
 * | 3  | Sam   |
 * | 4  | Max   |
 * +----+-------+
 * Orders table:
 * +----+------------+
 * | id | customerId |
 * +----+------------+
 * | 1  | 3          |
 * | 2  | 1          |
 * +----+------------+
 * Output:
 * +-----------+
 * | Customers |
 * +-----------+
 * | Henry     |
 * | Max       |
 * +-----------+
 */
public class CustomersWhoNeverOrder {

    // Write your MySQL query statement below

    /**
     * Runtime: 1001 ms, faster than 13.47% of MySQL online submissions for Customers Who Never Order.
     * Memory Usage: 0B, less than 100.00% of MySQL online submissions for Customers Who Never Order.
     */
    /*
    select a.name as Customers from Customers a left join Orders b on a.id = b. customerId where b.id is null
     */

    /**
     * Runtime: 929 ms, faster than 16.87% of MySQL online submissions for Customers Who Never Order.
     * Memory Usage: 0B, less than 100.00% of MySQL online submissions for Customers Who Never Order.
     */
    /*
    select name as Customers from Customers where id not in (select customerId as id from Orders)
     */


}
