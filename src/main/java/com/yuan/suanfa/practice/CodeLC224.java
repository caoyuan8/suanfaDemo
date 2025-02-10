package com.yuan.suanfa.practice;

import java.util.Stack;

/**
 *  LC224. 基本计算器
 *
 *一、题目描述
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * 提示：
 * - 1 <= s.length <= 3 * 105
 * - s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * - s 表示一个有效的表达式
 *
 */
public class CodeLC224 {

    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("2147483647"));
    }
    public static int calculate(String s) {
        int res = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i <length; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int value = c - '0';
                while (i+1<length&&Character.isDigit(s.charAt(i+1))){
                    i++;
                    value = value*10+s.charAt(i)-'0';
                }
                res = res + sign*value;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (c == ')') {
                //+或者-
                Integer pop = stack.pop();
                //res
                Integer pop1 = stack.pop();
                res = pop1 +pop*res;
            }
        }
        return res;
    }


}
