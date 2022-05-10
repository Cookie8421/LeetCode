package com.leetcode.algorithms.Custom;

/**
 * @author JoeyYoung
 * @version 1.0.0
 * @ClassName MathUtils
 * @Description TODO
 * @createTime 2022/5/10 12:00
 */
public class MathUtils {

    /*Euclid's Algorithm
    欧几里得算法又称辗转相除法，是指用于计算两个非负整数a，b的最大公约数。应用领域有数学和计算机两个方面。
    计算公式gcd(a,b) = gcd(b,a mod b)。
    欧几里得算法和扩展欧几里得算法可使用多种编程语言实现。
     */
    /*Lamé's Theorem
    拉梅定理，是对辗转相除法（即欧几里得算法）的步数估计，
    设b≥a都是正整数，d(a)是a的十进制表示式中数字的个数，
    若n为辗转相除法计算最大公因数(a,b)的步数，则：n≤5d(a)
     */
    public static Integer gcd(int a, int b){
        int l,s;
        if(a < b){
            l = b;
            s = a;
        } else {
            l = a;
            s = b;
        }

        if(s == 0){
            if(l != 0){
                return l;
            } else {
                return 0;
            }
        }
        if(l == s){
            return l;
        }
        gcd(s, l%s);
        return 0;
    }
}
