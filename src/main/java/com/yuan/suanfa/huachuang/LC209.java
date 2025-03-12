package com.yuan.suanfa.huachuang;


/**
 * LC209. 长度最小的子数组
 *
 *给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class LC209 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口的左端
        int left = 0;
        // 滑动窗口中所有元素的和
        int sum = 0;
        // 记录滑动窗口的长度，并且不断更新获取最小的那个
        // 一开始，result 可以初始化为一个超过数组长度的值
        // 这样的目的是为了最后返回结果的时候判断 result 有没有被更新
        // 如果没有被更新，并且滑动窗口的长度不可能为 result，因为超过了数组的长度
        // 那就代表不存在符合条件的子数组，需要返回 0
        // 比如 target = 11, nums = [1,1,1,1,1,1,1,1]
        // 先设置 result = 9，执行完后续代码，result 依旧为 9
        // 代表 nums 里面找不到一个子数组和大于等于 11 ，需要返回 0
        int result = nums.length + 1;
        // 滑动窗口的右端从 0 开始，这样，当 nums 为空时，可以直接跳出 for 循环
        for (int right = 0; right < nums.length; right++) {
            // 滑动窗口中加入了 nums[right] 这个元素
            // 滑动窗口元素和需要发生变化
            sum += nums[right];
            // 变化之后需要判断一下，如果滑动窗口的元素和大于等于了 target
            // 那么这个时候就需要不断的向右移动 left，缩小滑动窗口的长度
            while (sum >= target) {
                // 在获取到一个满足要求的子数组时，更新 result 的值
                result = Math.min(result, right - left + 1);
                // 把 nums[left] 移除滑动窗口
                sum -= nums[left];
                // 即 left 向右移动
                left++;
            }
        }
        // 返回结果
        return result == nums.length + 1 ? 0 : result;
    }

}
