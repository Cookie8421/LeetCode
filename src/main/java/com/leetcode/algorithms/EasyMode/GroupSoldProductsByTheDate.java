package com.leetcode.algorithms.EasyMode;

/**
 * SQL Schema
 *
 * Create table If Not Exists Activities (sell_date date, product varchar(20))
 * Truncate table Activities
 * insert into Activities (sell_date, product) values ('2020-05-30', 'Headphone')
 * insert into Activities (sell_date, product) values ('2020-06-01', 'Pencil')
 * insert into Activities (sell_date, product) values ('2020-06-02', 'Mask')
 * insert into Activities (sell_date, product) values ('2020-05-30', 'Basketball')
 * insert into Activities (sell_date, product) values ('2020-06-01', 'Bible')
 * insert into Activities (sell_date, product) values ('2020-06-02', 'Mask')
 * insert into Activities (sell_date, product) values ('2020-05-30', 'T-Shirt')]
 *
 * Table Activities:
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | sell_date   | date    |
 * | product     | varchar |
 * +-------------+---------+
 * There is no primary key for this table, it may contain duplicates.
 * Each row of this table contains the product name and the date it was sold in a market.
 *
 *
 *
 * Write an SQL query to find for each date the number of different products sold and their names.
 *
 * The sold products names for each date should be sorted lexicographically.
 *
 * Return the result table ordered by sell_date.
 *
 * The query result format is in the following example.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * Activities table:
 * +------------+------------+
 * | sell_date  | product     |
 * +------------+------------+
 * | 2020-05-30 | Headphone  |
 * | 2020-06-01 | Pencil     |
 * | 2020-06-02 | Mask       |
 * | 2020-05-30 | Basketball |
 * | 2020-06-01 | Bible      |
 * | 2020-06-02 | Mask       |
 * | 2020-05-30 | T-Shirt    |
 * +------------+------------+
 * Output:
 * +------------+----------+------------------------------+
 * | sell_date  | num_sold | products                     |
 * +------------+----------+------------------------------+
 * | 2020-05-30 | 3        | Basketball,Headphone,T-shirt |
 * | 2020-06-01 | 2        | Bible,Pencil                 |
 * | 2020-06-02 | 1        | Mask                         |
 * +------------+----------+------------------------------+
 * Explanation:
 * For 2020-05-30, Sold items were (Headphone, Basketball, T-shirt),
 * we sort them lexicographically and separate them by a comma.
 * For 2020-06-01, Sold items were (Pencil, Bible),
 * we sort them lexicographically and separate them by a comma.
 * For 2020-06-02, the Sold item is (Mask), we just return it.
 */
public class GroupSoldProductsByTheDate {

    // Write your MySQL query statement below

    /**
     * Runtime: 518 ms, faster than 45.86% of MySQL online submissions for Group Sold Products By The Date.
     * Memory Usage: 0B, less than 100.00% of MySQL online submissions for Group Sold Products By The Date.
     */
    /*
    SELECT
        sell_date,
        COUNT(DISTINCT product) AS num_sold,
        GROUP_CONCAT(DISTINCT product ORDER BY product SEPARATOR ',') AS products
    FROM
        Activities
    GROUP BY
        sell_date
    ORDER BY
        sell_date;
     */
}
