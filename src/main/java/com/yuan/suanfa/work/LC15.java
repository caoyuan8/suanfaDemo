package com.yuan.suanfa.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC15. 三数之和
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 */
public class LC15 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{0,1,1}));
        System.out.println(threeSum(new int[]{0,0,0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //初始化答案集合
        List<List<Integer>> ans = new ArrayList<>();
        //判断边界
        if(nums == null|| nums.length<3){
            return ans;
        }
        //排序 从小到大
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 如果发现 nums[i] > 0 ，由于 nums 是递增序列，left 在 nums[i] 的右侧，right 也在 nums[i] 的右侧
            // 那么 num[i]、nums[left]、nums[right] 都大于 0
            // 说明这三数之和一定大于 0 ，结束循环
            if(nums[i] > 0) break;
            // 答案中不可以包含重复的三元组，所以需要执行一个去重的操作
            // 比如这个输入 [-4,-1,-1,0,1,2]
            // i 指向的为第一个 -1 时，left 指向的元素值为 0 ，right 指向的元素值为 1
            // i 指向的为第二个 -1 时，left 指向的元素值为 0 ，right 指向的元素值为 1
            // 这两组解都是 [ -1 , 0 , 1]，所以需要去重
            if(i > 0 && nums[i] == nums[ i - 1 ]) continue;
            // left 为从 i 到 len - 1 的元素，向右移动
            int left = i + 1;
            // right 为从 len - 1 向左移动到 i 的元素，向左移动
            int right = nums.length - 1;
            // left 和 right 不断的向内移动
            while(left < right){
                // 计算这三者之和
                int sum = nums[i] + nums[left] + nums[right];
                // 发现三者之和为 0
                if(sum == 0){
                    // 把这个结果记录一下
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // 答案中不可以包含重复的三元组，所以需要执行一个去重的操作
                    // 比如这个输入 [-2,0,0,2,2]
                    // i 指向的元素值为 -2 ，left 指向的元素值为第一个 0 ，right 指向的元素值为倒数第一个 2 时
                    // 它们的 sum 为 0 ，如果让 ，left 向右移动一下，，right 向左移动一下，它们的 sum 也为 0
                    // 但是这两组解都是 [ -2 , 0 , 2]，所以需要去重
                    while( left < right && nums[left] == nums[ left + 1 ]) {
                        // left 向右移动
                        left++;
                    }
                    while( left < right && nums[right] == nums[ right - 1]){
                        // right 向左移动
                        right--;
                    }
                    // left 向右移动
                    left++;
                    // right 向左移动
                    right--;
                    // 如果三者之和小于 0 ，那么说明需要找更大的数
                }else if (sum < 0){
                    // left 向右移动
                    left++;
                    // 如果三者之和大于 0 ，那么说明需要找更小的数
                }else if (sum > 0) {
                    // right 向左移动
                    right--;
                }
            }
        }
        return ans;
    }
}
