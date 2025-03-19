package com.yuan.suanfa.mockTest.stack;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 分奖金
 */
public class C2024EFenJiangJin {

    /**
     * 输入
     * 3
     * 2 10 3
     * 输出
     * 8 10 3
     * 8=(1-0)*(10-2)
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 输入员工个数n
        int n = sc.nextInt();
        // 输入N个员工的随机数数组
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // 构建一个单调栈，用来存放不同随机数的索引
        // 栈中储存的索引所对应的元素大小，从栈底至栈顶单调递减
        // 即更大的数（的下标）位于栈底
        Stack<Integer> stack = new Stack<>();
        // 构建列表ans，用来保存输出结果
        // 初始化其中所有的元素和原数组一样，注意此处要使用拷贝
        int[] ans = Arrays.copyOf(nums, n);
        // 从头开始正序遍历nums中的每一个随机数
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // 第i个员工拿到的的随机数num，需要不断地与栈顶元素比较
            // 如果栈顶元素存在并且num【大于】栈顶元素stack[-1]这个下标对应的数字
            // 意味着nums中下标为stack[-1]的数字，找到了右边最近的比它更大的数字num
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                // 首先获取栈顶元素的值，也就是要修改的位置
                int preIndex = stack.pop();
                // i即为preIndex这个索引所对应的，下一个最近的更大的随机数的下标
                // 它们之间的下标距离为i-preIndex，数字大小差值为num-nums[preIndex]
                // 相乘后在ans中修改，作为答案
                ans[preIndex] = (i - preIndex) * (num - nums[preIndex]);
            }
            // 再把当前下标i储存入栈中
            // 注意：所储存的是下标i，而不是随机数num
            stack.push(i);
        }
        // 输出结果，避免最后的空格
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");  // 在输出之前先输出一个空格
            }
            System.out.print(ans[i]);
        }
        System.out.println();
        sc.close();
    }


    public static void main1(String[] args) {
        // 创建Scanner对象用于输入
        Scanner sc = new Scanner(System.in);
        // 输入员工个数n
        int n = sc.nextInt();
        // 输入N个员工的随机数数组
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // 构建一个单调栈，用来存放不同随机数的索引
        // 栈中储存的索引所对应在nums中的元素大小，从栈底至栈顶单调递减
        // 即更大的数（的下标）位于栈底
        Stack<Integer> stack = new Stack<>();
        // 构建列表ans，用来保存输出结果
        // 初始化其中所有的元素和原数组一样，注意此处要使用拷贝
        int[] ans = Arrays.copyOf(nums, n);
        // 逆序遍历nums中的每一个随机数
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            // 第i个员工拿到的的随机数num，需要不断地与栈顶元素比较
            // 如果栈顶元素存在并且num【大于等于】栈顶元素stack[-1]这个下标对应的数字
            // 说明栈顶元素stack[-1]这个下标对的数字，并不是随机数num右边最近的比num更大的元素
            // 需要将栈顶元素弹出，继续寻找比num大的栈顶元素
            while (!stack.isEmpty() && num >= nums[stack.peek()]) {
                // 栈顶元素下标对应的数字不大于当前数字num，不是符合要求的更大数字，弹出
                stack.pop();
            }

            // 完成弹出后，如果栈顶仍存在元素，说明stack[-1]所对应的数字，是严格比当前数字num大的下一个数字
            if (!stack.isEmpty()) {
                // stack.peek()即为i这个索引所对应的，下一个最近的更大的随机数的下标
                // 它们之间的下标距离为stack.peek()-i，数字大小差值为nums[stack.peek()]-num
                // 相乘后在ans中修改，作为答案
                ans[i] = (stack.peek() - i) * (nums[stack.peek()] - num);
            }

            // 再把当前下标i储存入栈中
            // 注意：所储存的是下标i，而不是随机数num
            stack.push(i);
        }

        // 输出结果，确保数字之间用空格分隔，没有尾部空格
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(ans[i]);
        }
        System.out.println();
    }

}
