package com.yuan.suanfa.work;

/**
 * LeetCode 1614、括号的最大嵌套深度
 *
 * 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
 * 示例 1：
 * 输入：s = "(1+(2*3)+((8)/4))+1"
 * 输出：3
 * 解释：数字 8 在嵌套的 3 层括号中。
 * 示例 2：
 * 输入：s = "(1)+((2))+(((3)))"
 * 输出：3
 * 提示：
 * - 1 <= s.length <= 100
 * - s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成
 * - 题目数据保证括号表达式 s 是 有效的括号表达式
 *
 */
public class LC1614 {

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
    }

    public static int maxDepth(String s) {
        int result = 0;
        int deep = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '('){
                deep++;
                result = Math.max(result,deep);
            }else if (s.charAt(i) == ')'){
                deep--;
            }
        }
        return result;
    }
}
