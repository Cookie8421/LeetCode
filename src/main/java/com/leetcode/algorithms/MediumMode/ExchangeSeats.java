package com.leetcode.algorithms.MediumMode;


/**
 * SQL Schema
 *
 * Create table If Not Exists Seat (id int, student varchar(255))
 * Truncate table Seat
 * insert into Seat (id, student) values ('1', 'Abbot')
 * insert into Seat (id, student) values ('2', 'Doris')
 * insert into Seat (id, student) values ('3', 'Emerson')
 * insert into Seat (id, student) values ('4', 'Green')
 * insert into Seat (id, student) values ('5', 'Jeames')
 *
 * Table: Seat
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | id          | int     |
 * | name        | varchar |
 * +-------------+---------+
 * id is the primary key column for this table.
 * Each row of this table indicates the name and the ID of a student.
 * id is a continuous increment.
 *
 *
 *
 * Write an SQL query to swap the seat id of every two consecutive students. If the number of students is odd, the id of the last student is not swapped.
 *
 * Return the result table ordered by id in ascending order.
 *
 * The query result format is in the following example.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * Seat table:
 * +----+---------+
 * | id | student |
 * +----+---------+
 * | 1  | Abbot   |
 * | 2  | Doris   |
 * | 3  | Emerson |
 * | 4  | Green   |
 * | 5  | Jeames  |
 * +----+---------+
 * Output:
 * +----+---------+
 * | id | student |
 * +----+---------+
 * | 1  | Doris   |
 * | 2  | Abbot   |
 * | 3  | Green   |
 * | 4  | Emerson |
 * | 5  | Jeames  |
 * +----+---------+
 * Explanation:
 * Note that if the number of students is odd, there is no need to change the last one's seat.
 */
public class ExchangeSeats {

    /**
     * Runtime: 460 ms, faster than 36.78% of MySQL online submissions for Exchange Seats.
     * Memory Usage: 0B, less than 100.00% of MySQL online submissions for Exchange Seats.
     */
    /*
    select e1.id,ifnull(e2.student,e1.student) as student from seat e1 left join (
    select id,student,
    CASE
    WHEN id%2!=0 THEN id+1
    ELSE id-1
    END AS new_id
    FROM Seat
    ) e2 on e1.id=e2.new_id
     */
}
