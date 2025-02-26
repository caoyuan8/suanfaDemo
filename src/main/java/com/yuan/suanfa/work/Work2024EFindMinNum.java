package com.yuan.suanfa.work;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * 【单调栈】2024E-找最小数
 *
 *
 * 题目描述
 * 给一个正整数 NUM1，计算出新正整数 NUM2。NUM2 为 NUM1 中移除 N 位数字后的结果，需要使得 NUM2 的值最小。
 * 输入
 * 1. 输入的第一行为一个字符串，字符串由 0-9 字符组成，记录正整数 NUM1，NUM1 长度小于 32。
 * 2. 输入的第二行为需要移除的数字的个数，小于 NUM1 长度。
 * 输出
 * 输出一个数字字符串，记录最小值 NUM2。
 * 示例一
 * 输入
 * 2615371
 * 4
 * 输出
 * 131
 * 说明
 * 移除 2、6、5、7 这四个数字，剩下 1、3、1 按原有顺序排列组成 131 为最小值。
 * 示例二
 * 输入
 * 12345
 * 2
 * 输出
 * 123
 * 示例三
 * 输入
 * 10345
 * 2
 * 输出
 * 034
 *
 */
public class Work2024EFindMinNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入的第一行为一个字符串，字符串由 0-9 字符组成，记录正整数 NUM1
        String NUM1 = scanner.nextLine();
        int n = scanner.nextInt();
        // 移除的数字个数
        int rest_n = n;
        // 创建一个栈，用于存储移除后的数字
        Stack<Character> stack = new Stack<>();
        // 遍历字符串，将每个字符加入栈中，并判断是否需要移除
        for (char ch : NUM1.toCharArray()) {
            while (!stack.isEmpty() && ch < stack.peek() && rest_n > 0) {
                stack.pop();
                rest_n--;
            }
            stack.push(ch);
        }

        StringBuilder result = new StringBuilder();
        int len = NUM1.length() - n;
        for (int i = 0; i < len; i++) {
            result.append(stack.get(i));
        }

        System.out.println(result.toString());
    }


}
