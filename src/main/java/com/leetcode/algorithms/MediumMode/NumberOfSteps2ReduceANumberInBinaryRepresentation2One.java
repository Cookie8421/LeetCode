package main.java.com.leetcode.algorithms.MediumMode;
/**
 * Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:

If the current number is even, you have to divide it by 2.

If the current number is odd, you have to add 1 to it.

It is guaranteed that you can always reach one for all test cases.

 

Example 1:

Input: s = "1101"
Output: 6
Explanation: "1101" corressponds to number 13 in their decimal representation.
Step 1) 13 is odd, add 1 and obtain 14. 
Step 2) 14 is even, divide by 2 and obtain 7.
Step 3) 7 is odd, add 1 and obtain 8.
Step 4) 8 is even, divide by 2 and obtain 4.  
Step 5) 4 is even, divide by 2 and obtain 2. 
Step 6) 2 is even, divide by 2 and obtain 1.  
Example 2:

Input: s = "10"
Output: 1
Explanation: "10" corressponds to number 2 in their decimal representation.
Step 1) 2 is even, divide by 2 and obtain 1.  
Example 3:

Input: s = "1"
Output: 0
 

Constraints:

1 <= s.length <= 500
s consists of characters '0' or '1'
s[0] == '1'
 */

 public class NumberOfSteps2ReduceANumberInBinaryRepresentation2One{

    /**
     * Runtime
        0
        ms
        Beats
        100.00%
        of users with Java
        Memory
        41.23
        MB
        Beats
        57.23%
        of users with Java
     */
    public static int numSteps(String s) {
        int count = 0;
        int cache = 0;
        for(int i = s.length()-1; i > 0; i--){
            if(s.charAt(i) == '0'){
                switch (cache) {
                    case 0:
                        count ++;
                        break;
                    case 1:
                        count += 2;
                        break;
                    case 2:
                        count ++;
                        cache = 1;
                        break;
                    default:
                        break;
                }
            } else {
                switch (cache) {
                    case 0:
                        count += 2;
                        cache = 1;
                        break;
                    case 1:
                        count ++;
                        break;
                    case 2:
                        count += 2;
                        cache = 1;
                        break;
                    default:
                        break;
                }
            }
        }
        switch (s.charAt(0) - 48 + cache) {
            case 0:
                count++;
                break;
            case 1:
                break;
            case 2:
                count++;
                break;
            case 3:
                count++;
                break;
            default:
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSteps("1101"));
    }

 }