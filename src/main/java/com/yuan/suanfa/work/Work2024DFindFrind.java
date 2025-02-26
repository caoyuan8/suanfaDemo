package com.yuan.suanfa.work;


import java.util.Scanner;
import java.util.Stack;

/**
 *
 * 题目描述
 * 在学校中，N个小朋友站成一队， 第i个小朋友的身高为height[i]，第i个小朋友可以看到的右边的第一个比自己身高更高的小朋友j，那么j是i的好朋友（j > i）。请重新生成一个列表，对应位置的输出是每个小朋友的好朋友位置，如果没有看到好朋友，请在该位置用0代替。小朋友人数范围是 [0, 40000]。
 * 输入描述
 * 第一行输入N，表示有N个小朋友
 * 第二行输入N个小朋友的身高height[i]，都是整数
 * 输出描述
 * 输出N个小朋友的好朋友的位置
 * 示例一
 * 输入
 * 2
 * 100 95
 * 输出
 * 0 0
 * 示例二
 * 输入
 * 8
 * 123 124 125 121 119 122 126 123
 * 输出
 * 1 2 6 5 5 6 0 0
 *
 *
 *
 */
public class Work2024DFindFrind {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        //遍历小朋友身高数组 从前往后遍历
        /*for (int i = 0; i < n; i++) {
            //获取当前小朋友的高度
            int h = height[i];
            // 第i个小朋友的身高h，需要不断地与栈顶元素比较
            // 如果栈顶元素存在并且h > 栈顶元素 stack.peek()
            // 意味着栈顶元素找到了右边最近的比他更高的身高h
            while (!stack.isEmpty() && h>height[stack.peek()]){
                // 首先获取栈顶元素的值，也就是上一个比h小的身高的索引值
                Integer pop = stack.pop();
                // i即为pop这个索引所对应的，下一个最近身高
                ans[pop] = i;
            }
            // 再把当前小朋友身高的下标i存放到栈中
            stack.push(i);
        }*/
        for (int i = n-1; i >= 0; i--){
            int h = height[i];
            // 第i个小朋友的身高h，需要不断地与栈顶元素比较
            // 如果栈顶元素存在并且h >= 栈顶元素 stack.peek()
            // 说明栈顶元素 stack.peek() 并不是身高h右边最近的比h更大的元素
            // 需要将栈顶元素弹出，继续寻找比h大的栈顶元素
            while (!stack.isEmpty() && h>=height[stack.peek()]){
            // 栈顶元素下标对应的身高不大于当前身高h，不是符合要求的更大身高，弹出
                stack.pop();
            }
            // 完成弹出后，如果栈顶仍存在元素，说明 stack.peek() 所对应的身高，是严格比h大的下一个身高
            if (!stack.isEmpty()) {
                // ans[i] 修改为 stack.peek()
                ans[i] = stack.peek();
            }
            // 再把当前小朋友身高的下标i存放到栈中
            stack.push(i);
        }
        // ans中的int元素转成str后才能合并成字符串
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]+" ");
        }
    }


}
