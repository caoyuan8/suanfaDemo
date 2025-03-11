package com.yuan.suanfa.tanxin;

import java.util.Scanner;
import java.util.Stack;

/**
 * 2024E-变换最小字符串
 *
 *题目描述
 * 给定一个字符串s，最多只能进行一次变换，返回变换后能得到的最小字符串（按照字典序进行比较）
 * 变换规则： 交换字符串中任意两个不同位置的字符。
 *
 * 输入描述
 * 一串小写字母组成的字符串s
 *
 * 输出描述
 * 按照要求进行变换得到的最小字符串
 *
 * 补充说明
 * s是都是小写字符组成
 * 1 <= s.length <= 1000
 *
 *
 * 示例一
 * 输入
 * edcba
 *
 * 输出
 * adcbe
 * 说明
 * 选择索引0的e和索引4的a进行交换，得到字典序最小的字符串adcbe
 *
 *
 * 示例二
 * 输入
 * abcdef
 *
 * 输出
 * abcdef
 * 说明
 * 原字符串已经是最小字典序的字符了，无需进行交换。
 *
 */
public class C2024EBianHuanMinStr {

    public static void main(String[] args) {
        //main1 方法1 暴力解
        //mian2 方法2 贪心解
    }

    public void  main1(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] ans = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // 令下标对(i, j)对应的两个字符进行交换
                char temp = ans[i];
                ans[i] = ans[j];
                ans[j] = temp;

                // 把交换后得到的字符串和ans进行比较，更新ans
                String current = new String(ans);
                if (current.compareTo(s) < 0) {
                    s = current;
                }

                // 判断完毕后，下标对(i, j)对应的两个字符重新交换回去
                temp = ans[i];
                ans[i] = ans[j];
                ans[j] = temp;
            }
        }

        System.out.println(s);
    }

    public void main2(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] ans = s.toCharArray();
        int n = s.length();
        char[] lst = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        // 逆序遍历字符串s
        for (int i = n - 1; i >= 0; i--) {
            // 如果栈是空栈，或者当前下标i对应的字符lst[i]小于栈顶下标对应的字符lst[stack.peek()]
            // 则将坐标i加入stack
            if (stack.isEmpty() || lst[i] < lst[stack.peek()]) {
                stack.push(i);
            }
        }
        // 正序遍历字符串s
        for (int i = 0; i < n; i++) {
            // 若出现空栈情况，则退出循环
            if (stack.isEmpty()) {
                break;
            }
            // 如果当前下标i位于栈顶元素stack.peek()的左边
            // 则可以进行后续判断
            if (i < stack.peek()) {
                // 若当前字符大于栈顶元素对应的字符，则可以进行交换
                if (lst[i] > lst[stack.peek()]) {
                    char temp = lst[i];
                    lst[i] = lst[stack.peek()];
                    lst[stack.peek()] = temp;
                    ans = new String(lst).toCharArray();
                    break;
                }
                // 否则，考虑下一个i
            }
            // 如果当前下标i不位于栈顶元素stack.peek()的左边
            // 则弹出栈顶元素，考虑下一个字典序较大但是位于较右位置的字符
            else {
                stack.pop();
            }
        }

        System.out.println(new String(ans));
    }


}
