package com.leetcode.algorithms.EasyMode;

/**
 * SQL Schema
 * Create table If Not Exists Weather (id int, recordDate date, temperature int)
 * Truncate table Weather
 * insert into Weather (id, recordDate, temperature) values ('1', '2015-01-01', '10')
 * insert into Weather (id, recordDate, temperature) values ('2', '2015-01-02', '25')
 * insert into Weather (id, recordDate, temperature) values ('3', '2015-01-03', '20')
 * insert into Weather (id, recordDate, temperature) values ('4', '2015-01-04', '30')
 *
 * Table: Weather
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | id            | int     |
 * | recordDate    | date    |
 * | temperature   | int     |
 * +---------------+---------+
 * id is the primary key for this table.
 * This table contains information about the temperature on a certain day.
 *
 *
 *
 * Write an SQL query to find all dates' Id with higher temperatures compared to its previous dates (yesterday).
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
 * Weather table:
 * +----+------------+-------------+
 * | id | recordDate | temperature |
 * +----+------------+-------------+
 * | 1  | 2015-01-01 | 10          |
 * | 2  | 2015-01-02 | 25          |
 * | 3  | 2015-01-03 | 20          |
 * | 4  | 2015-01-04 | 30          |
 * +----+------------+-------------+
 * Output:
 * +----+
 * | id |
 * +----+
 * | 2  |
 * | 4  |
 * +----+
 * Explanation:
 * In 2015-01-02, the temperature was higher than the previous day (10 -> 25).
 * In 2015-01-04, the temperature was higher than the previous day (20 -> 30).
 */
public class RisingTemperature {

    // Write your MySQL query statement below
    /**
     * Runtime: 316 ms, faster than 96.90% of MySQL online submissions for Rising Temperature.
     * Memory Usage: 0B, less than 100.00% of MySQL online submissions for Rising Temperature.
     */
    /*
    select a.id from Weather a join Weather b where a.recordDate = DATE_ADD(b.recordDate,INTERVAL 1 DAY) and a.temperature > b.temperature
     */
}
