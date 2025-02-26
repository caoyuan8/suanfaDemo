package com.yuan.suanfa.work;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 *2024E-回转寿司
 *
 * 题目描述
 * 寿司店周年庆，正在举办优惠活动回馈新老客户寿司转盘上总共有n盘寿司，prices[i]是第 i 盘寿司的价格，如果客户选择了第 i盘寿司，寿司店免费赠送客户距离第 i 盘寿司最近的下一盘寿司 j，前提是prices[j] < prices[i]，如果没有满足条件的 j，则不赠送寿司。
 * 每个价格的寿司都可无限供应。
 * 输入描述
 * 输入的每一个数字代表每盘寿司的价格，每盘寿司的价格之间使用空格分隔
 * 寿司的盘数 n范围为: 1 <= n <= 500
 * 输出描述
 * 输出享受优惠后的一组数据，每个值表示客户选择第i 盘寿司时实际得到的寿司的总价格。使用空格进行分隔。
 * 示例一
 * 输入
 * 3 15 6 14
 * 输出
 * 3 21 9 17
 * 示例二
 * 输入
 * 5 12 7 13
 * 输出
 * 5 19 12 18
 *
 */
public class Work2024EHuiZhuanShouSi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = input.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        Stack<Integer> stack = new Stack<>();
        int[] ans = Arrays.copyOf(nums, n);
        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            int num = nums[idx];
            while (!stack.isEmpty() && nums[stack.peek()] > num) {
                int topIdx = stack.pop();
                ans[topIdx] = num + nums[topIdx];
            }
            stack.push(idx);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

}
