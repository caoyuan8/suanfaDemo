package com.yuan.suanfa.work;


import java.util.Arrays;

/**
 * LC283. 移动零
 *
 *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 * 提示:
 * - 1 <= nums.length <= 10^4
 * - -2^31 <= nums[i] <= 2^31 - 1
 *
 */
public class LC283 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{0,1,0,3,12})));
        System.out.println(Arrays.toString(moveZeroes(new int[]{0})));
    }

    public static int[] moveZeroes(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[slow] = nums[i];
                slow++;
            }
        }
        for (int i = slow; i <nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }


}
