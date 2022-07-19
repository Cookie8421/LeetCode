package com.leetcode.algorithms.MediumMode;

/**
 * You are playing the Bulls and Cows game with your friend.
 *
 * You write down a secret number and ask your friend to guess what the number is.
 * When your friend makes a guess, you provide a hint with the following info:
 *
 *     The number of "bulls", which are digits in the guess that are in the correct position.
 *     The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position.
 *     Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
 *
 * Given the secret number secret and your friend's guess guess,
 * return the hint for your friend's guess.
 *
 * The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows.
 * Note that both secret and guess may contain duplicate digits.
 *
 *
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 * Output: "1A3B"
 * Explanation: Bulls are connected with a '|' and cows are underlined:
 * "1807"
 *   |
 * "7810"
 *
 * Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 * Output: "1A1B"
 * Explanation: Bulls are connected with a '|' and cows are underlined:
 * "1123"        "1123"
 *   |      or     |
 * "0111"        "0111"
 * Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
 *
 *
 *
 * Constraints:
 *
 *     1 <= secret.length, guess.length <= 1000
 *     secret.length == guess.length
 *     secret and guess consist of digits only.
 */
public class BullsAndCows {

    /**
     * linear time complex
     */
    /**
     * public String getHint(String secret, String guess) {
     *         Map<Character,Integer> mp=new HashMap<>();
     *         for(int i=0;i<secret.length();i++)
     *             mp.put(secret.charAt(i),mp.getOrDefault(secret.charAt(i),0)+1);
     *         int bull=0;
     *         int cow=0;
     *         for(int i=0;i<guess.length();i++){
     *
     *             if(guess.charAt(i)==secret.charAt(i) ){
     *                 bull++;
     *                 if( mp.containsKey(guess.charAt(i))==false){cow--;}
     *                 else if(mp.get(secret.charAt(i))==1)mp.remove(secret.charAt(i));
     *                 else mp.put(secret.charAt(i),mp.get(secret.charAt(i))-1);
     *             }else{
     *                 if( mp.containsKey(guess.charAt(i))==false){continue;}
     *                 else if(mp.get(guess.charAt(i))==1)mp.remove(guess.charAt(i));
     *                 else mp.put(guess.charAt(i),mp.get(guess.charAt(i))-1);
     *                 cow++;
     *             }
     *         }
     *         return bull+"A"+cow+"B";
     *     }
     */


    /**
     * Runtime: 41 ms, faster than 5.09% of Java online submissions for Bulls and Cows.
     * Memory Usage: 42.1 MB, less than 95.85% of Java online submissions for Bulls and Cows.
     */
    public String getHint(String secret, String guess) {
        int length = secret.length();
        char[] secretArr = secret.toCharArray();
        char[] guessArr = guess.toCharArray();
        int bulls = 0;
        int cows = 0;
        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            if(secretArr[i] == guessArr[i]){
                bulls++;
                arr[i] = 1;
            }
        }
        for(int j = 0; j < length; j++){
            if(arr[j] == 0){
                //switch
                for(int k = 0; k < length; k++){
                    if(guessArr[k] == secretArr[j] && arr[k] == 0 && arr[j] == 0 && j != k){
                        char t = guessArr[k];
                        guessArr[k] = guessArr[j];
                        guessArr[j] = t;
                        arr[j] = 1;
                        cows++;
                        if(secretArr[k] == guessArr[k]){
                            arr[k] = 1;
                            cows++;
                        }
                    }
                }
            }
        }

        return bulls + "A" + cows + "B";
    }

}
