package com.yuan.suanfa.tanxin;


import java.util.Scanner;

/**
 * 【贪心】2024E-求字符串中所有整数的最小和
 *
 * 题目描述
 * 1. 字符串 s，只包含 a-z，A-Z，+-；
 * 2. 合法的整数包括
 * 1） 正整数 一个或者多个0-9组成，如 0 2 3 002 102
 * 2）负整数 负号 - 开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
 *
 * 输入描述
 * 包含数字的字符串
 *
 * 输出描述
 * 所有整数的最小和
 *
 * 示例一
 * 输入
 * bb1234aa
 * 输出
 * 10
 * 说明
 *
 * 示例二
 * 输入
 * bb12-34aa
 * 输出
 * -31
 * 说明
 * 1+2+(-34) = -31
 *
 */
public class C2024EStrMinIntSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入原字符串
        String s = scanner.nextLine();
        // flag为遇到负号"-"的标志
        boolean flag = false;
        // 用于记录字符串中的负数的变量num
        int num = 0;
        // 答案变量
        int ans = 0;
        // 遍历s中的所有字符ch
        for (char ch : s.toCharArray()) {
            // 遇到负号，将num加入ans中（此时num可能是负数，也可能是0）
            // 重置num为0，设置flag为true，表示后续应该考虑一个负数
            if (ch == '-') {
                ans += num;
                num = 0;
                flag = true;
            }
            // 遇到数字
            else if (Character.isDigit(ch)) {
                // 如果flag为true，说明此时ch正处于一个负数中
                // num扩大10倍后减去ch - '0'，进行延长
                if (flag) {
                    num = num * 10 - (ch - '0');
                }
                // 如果flag为false，说明此时ch正处于一个正数中
                // 为了使得总和尽可能小，直接将ch - '0'加入ans中即可
                else {
                    ans += ch - '0';
                }
            }
            // 遇到其他字符，将num加入ans中（此时num可能是负数，也可能是0）
            // 重置num为0，设置flag为false，表示后续不用考虑负数
            else {
                ans += num;
                num = 0;
                flag = false;
            }
        }
        // 最后一个负数可能位于字符串末尾，
        // 还需要再做一次相加才能得到正确答案
        ans += num;
        System.out.println(ans);
    }
}
