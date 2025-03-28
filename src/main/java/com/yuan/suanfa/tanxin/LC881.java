package com.yuan.suanfa.tanxin;

import java.util.Arrays;

/**
 * LC881. 救生艇
 *
 *给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
 *
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 *
 * 返回 承载所有人所需的最小船数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 *
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 *
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 *
 *
 * 提示：
 *
 * 1 <= people.length <= 5 * 104
 * 1 <= people[i] <= limit <= 3 * 104
 */
public class LC881 {

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{1,2}, 3));
        System.out.println(numRescueBoats(new int[]{3,2,2,1}, 3));
        System.out.println(numRescueBoats(new int[]{3,5,3,4}, 5));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int left = 0;
        int right = n - 1;
        int ans = 0;

        while (left <= right) {
            // 如果最轻的 + 最重的 <= limit，那么最轻的 + 最重的这个组合可以坐满一艘船 左右边界向中间靠拢
            if (people[left] + people[right] <= limit) {
                ans++;
                left++;
                right--;
                // 如果最轻的 + 最重的 > limit，那么就只能放最重的这个组合，右边界向左靠拢
            } else {
                ans++;
                right--;
            }
        }
        return ans;
    }

}
