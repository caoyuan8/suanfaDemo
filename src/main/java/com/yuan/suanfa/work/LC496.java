package com.yuan.suanfa.work;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LC496.下一个更大元素 I
 *
 *
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * 示例 2：
 *
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 *
 *
 * 提示：
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 *
 *
 */
public class LC496 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})));
    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 先计算 nums2 中每个元素右边的第一个更大的值
        // 结果存放到一个哈希集合里面
        // key 是 nums2 中的元素
        // value 是这个元素右边的第一个更大的值
        Map<Integer, Integer> res = new HashMap<>();
        // 设置一个栈
        // 这个栈是一个单调递增栈
        Stack<Integer> stack = new Stack<>();
        // 从后向前访问 nums 中的元素
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            // 在访问过程中
            // 维护单调递增栈的性质
            // 不断的去拿栈顶元素和当前元素 num 比较
            // 1、直到找到一个比 num 更大的元素为止
            // 2、或者栈为空位置
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            // 1、如果栈不为空，那么此时的栈顶元素就是一个比 num 更大的元素
            // 存放栈顶元素值到哈希集合 res 中
            // 2、如果栈为空，说明在 num 的右侧没有任何一个元素比它更大
            // 存放 -1 到哈希集合 res 中
            res.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        // 初始结果数组
        int[] ans = new int[nums1.length];
        // 1、由于两个数组都是没有重复元素的数组
        // 2、nums1 是 nums2 的子集
        for (int i = 0; i < nums1.length; i++) {
            // 那么就去哈希集合 res 中找出对应元素的值来
            ans[i] = res.get(nums1[i]);
        }
        return ans;
    }

}
