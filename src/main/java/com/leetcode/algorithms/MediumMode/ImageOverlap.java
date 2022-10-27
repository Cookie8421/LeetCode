package com.leetcode.algorithms.MediumMode;

/**
 * You are given two images, img1 and img2, represented as binary, square matrices of size n x n. A binary matrix has only 0s and 1s as values.
 *
 * We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down any number of units. We then place it on top of the other image. We can then calculate the overlap by counting the number of positions that have a 1 in both images.
 *
 * Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of the matrix borders are erased.
 *
 * Return the largest possible overlap.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
 * Output: 3
 * Explanation: We translate img1 to right by 1 unit and down by 1 unit.
 *
 * The number of positions that have a 1 in both images is 3 (shown in red).
 *
 * Example 2:
 *
 * Input: img1 = [[1]], img2 = [[1]]
 * Output: 1
 * Example 3:
 *
 * Input: img1 = [[0]], img2 = [[0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * n == img1.length == img1[i].length
 * n == img2.length == img2[i].length
 * 1 <= n <= 30
 * img1[i][j] is either 0 or 1.
 * img2[i][j] is either 0 or 1.
 */
public class ImageOverlap {

    public int largestOverlap(int[][] img1, int[][] img2) {
        /**
         * Runtime: 74 ms, faster than 50.91% of Java online submissions for Image Overlap.
         * Memory Usage: 42 MB, less than 88.48% of Java online submissions for Image Overlap.
         */
        int largestOverlap = 0;
        for(int row = -img1.length + 1; row < img1.length; row++)
            for (int col = -img1.length; col < img1.length; col++)
                largestOverlap = Math.max(largestOverlap ,overlapOnes(img1,img2,row,col));
        return largestOverlap;
    }

    private int overlapOnes(int[][] img1, int[][] img2, int rowOff , int colOff) {
        int count = 0;
        for(int row = 0; row <img1.length; row ++) {
            for (int col = 0; col < img1[0].length; col++) {
                if((rowOff + row < 0 || row + rowOff >= img1.length ) || ( col + colOff < 0 ||colOff + col >= img1[0].length ))
                    continue;
                if(img1[row][col] + img2[rowOff+row][colOff+col]  == 2  )
                    count++;
            }
        }
        return count;
    }

}
