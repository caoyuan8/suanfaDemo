package com.yuan.suanfa.mockTest.stack;

import java.util.*;

/**
 * 回转寿司
 */
public class C2024EHuiZhuanShouSi {

    /**
     * 输入
     * 3 15 6 14
     * 输出
     * 3 21 9 17
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = split.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        Stack<Integer> stack = new Stack<>();
        int[] ans = Arrays.copyOf(nums, n);

        for (int i = 0; i < 2 * n; i++) {
            //得到原数组中的索引
            int idx = i % n;
            int num = nums[idx];
            // 栈顶元素比当前元素大，则弹出栈顶元素，并更新当前元素对应的答案
            while (!stack.isEmpty() && nums[stack.peek()] > num) {
                int topIdx = stack.pop();
                ans[topIdx] = num + nums[topIdx];
            }
            stack.push(idx);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = split.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = Arrays.copyOf(nums, n);

        for (int i = 2*n-1; i >= 0; i--) {
            //得到原数组中的索引
            int idx = i % n;
            int num = nums[idx];
            // 栈顶元素比当前元素大，则弹出栈顶元素，并更新当前元素对应的答案
            while (!stack.isEmpty() && nums[stack.peekLast()] >= num) {
                stack.pollLast();
            }
            if (!stack.isEmpty()) {
                ans[idx] = nums[stack.peekLast()] + nums[idx];
            }
            stack.offerLast(idx);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }

}
