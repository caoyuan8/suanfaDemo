package com.yuan.suanfa.huachuang;


import java.util.HashSet;

/**
 * LC1695. 删除子数组的最大分数
 *
 *给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 * 示例 1：
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * 示例 2：
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 * 提示：
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^4
 *
 */
public class LC1695 {

    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4,2,4,5,6}));
        System.out.println(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }
    public static int maximumUniqueSubarray(int[] nums) {
        // 滑动窗口模板化解题，五步走策略
        // 【1、定义需要维护的变量】
        // 对于此题来说，需要维护当前滑动窗口的元素和、滑动过程中得出的最大得分
        // 一开始，滑动窗口没有元素，元素和为 0
        int sums = 0;
        // 由于数组都是正数，所以可以初始化为 0
        int largest = 0;
        // 同时又涉及去重，因此需要一个哈希表
        HashSet<Integer> hash = new HashSet<Integer>();
        // 【2、定义窗口的首尾端 (start, end)， 然后滑动窗口】
        // 窗口的左端位置从 0 开始
        int start = 0;
        // 窗口的右端位置从 0 开始，可以一直移动到尾部
        for( int end = 0 ; end < nums.length ; end++ ){
            // 【3、更新需要维护的变量, 有的变量需要一个 if 语句来维护 (比如最大最小长度)】
            // 【4、如果题目的窗口长度可变: 这个时候一般涉及到窗口是否合法的问题】
            //  如果当前窗口不合法时, 用一个 while 去不断移动窗口左指针, 从而剔除非法元素直到窗口再次合法
            // 如果哈希表中存储了即将加入滑动窗口的元素
            while(hash.contains(nums[end])){
                // 那么需要不断的把窗口左边的元素移除窗口
                // 元素和需要减去移除的值
                sums -= nums[start];
                // 把 nums[start] 移除记录
                hash.remove(nums[start]);
                // 窗口左端向右移动
                start++;
            }
            // 此时，滑动窗口可以接纳 nums[end]
            hash.add(nums[end]);
            // 维护变量 sum
            sums += nums[end];
            // 维护变量 largest
            largest = Math.max(largest,sums);
        }
        // 【5、返回所需要的答案】
        return largest;
    }
}
