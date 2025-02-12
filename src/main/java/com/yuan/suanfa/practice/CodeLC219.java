package com.yuan.suanfa.practice;

import java.util.HashMap;

/**
 * LC219. 存在重复元素II
 *
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * 提示：
 * - 1 <= nums.length <= 10^5
 * - -109 <= nums[i] <= 10^9
 * - 0 <= k <= 10^5
 *
 */
public class CodeLC219 {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(num)&&i-map.get(num)<=k){
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

}
