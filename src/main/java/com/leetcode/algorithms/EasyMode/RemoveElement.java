package com.leetcode.algorithms.EasyMode;

/**
 * @author YHW
 * @ClassName: RemoveElement
 * @Description:
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @date 2019/2/25 8:56
 */
public class RemoveElement {

    /**
     * @Status:Accepted
     * @Runtime:3 ms
     * @Memory:37.8 MB
     */
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int i = 0;
        int j = length  - 1;
        int count = length;

        if(length == 0){
            return 0;
        }else if(length == 1){
            if(nums[0] == val){
                return 0;
            }else{
                return 1;
            }
        }

        for(; i < length - 1; i++){
            if(nums[i] == val){
                count --;
                for(; j > i; j--){
                    if(nums[j] != val) {
                        nums[i] = nums[j--];
                        break;
                    }else{
                        count --;
                    }
                }
            }
            if(i == j){
                return count;
            }
        }
        if(j == length - 1 && nums[j] == val){
            count --;
        }
        return count;
    }

    public static void main(String[] args){
        int nums[] = {0, 3, 1, 1, 0, 1, 3, 0, 3, 3, 1, 1};
        int count = new RemoveElement().removeElement(nums, 1);
        System.out.println(count);
        for(int i = 0; i < count; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
