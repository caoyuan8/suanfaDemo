package com.yuan.suanfa.practice;


/**
 * LC485. 最大连续 1 的个数
 *
 *给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * 示例 1：
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * 示例 2:
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 * 提示：
 * - 1 <= nums.length <= 10^5
 * - nums[i] 不是 0 就是 1.
 *
 */
public class CodeLC485 {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        //记录最后一个0位置
        int lastZero=-1;
        //记录最大连续1的个数
        int maxOne=0;
        for (int i = 0; i < nums.length; i++) {
            //如果遇到1并且当前位置-0的位置即为最大个数
            if(nums[i]==1&&i-lastZero>maxOne){
                maxOne=i-lastZero;
            //遇到0则更新lastZero的值
            }else if (nums[i]==0){
                lastZero=i;
            }
        }
        return maxOne;
    }

}
