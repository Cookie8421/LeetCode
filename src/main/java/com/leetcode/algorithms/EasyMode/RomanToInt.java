package com.leetcode.algorithms.EasyMode;

/**
 * @author YHW
 * @ClassName: RomanToInt
 * @Description:
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * @date 2019/2/22 9:31
 */
public class RomanToInt {

    /**
     * @Status:Accepted
     * @Runtime:35 ms
     * @Memory:39 MB
     */
    public static int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int[] romanNum = new int[20];

        for(int i = 0; i < s.length(); i++){
            char c = charArray[i];
            if(c == 'I'){
                romanNum[i] = 1;
            }else if(c == 'V'){
                romanNum[i] = 5;
            }else if(c == 'X'){
                romanNum[i] = 10;
            }else if(c == 'L'){
                romanNum[i] = 50;
            }else if(c == 'C'){
                romanNum[i] = 100;
            }else if(c == 'D'){
                romanNum[i] = 500;
            }else if(c == 'M'){
                romanNum[i] = 1000;
            }
        }
        int result = 0;
        for(int i = 0; i < romanNum.length - 1; i++){
            if(romanNum[i] < romanNum[i+1]){
                result -= romanNum[i];
            }else{
                result += romanNum[i];
            }
        }
        result += romanNum[romanNum.length - 1];
        return result;
    }

    public static void main(String[] args){
        String roman = "IDCIIIIIIIII";
        System.out.println(romanToInt(roman));

    }
}
