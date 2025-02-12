package com.yuan.suanfa.work;


import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 *2024D-密码解密
 *
 * 给定一段"密文"字符串s，其中字符都是经过"密码本"映射的，现需要将"密文"解密并且输出。
 * 映射的规则 ："a-i"分别用"1-9"表示，"j-z" 分别用"10*-26*"表示
 * 约束：映射始终唯一
 *
 *
 * 输入描述
 * “密文”字符串
 *
 * 输出描述
 * 明文字符串
 *
 * 补充说明
 * 翻译后的文本的长度在100以内
 *
 * 示例一
 * 输入
 * 20*19*20*
 *
 * 输出
 * tst
 *
 * 示例二
 * 输入
 * 12320*12319*20*
 *
 * 输出
 * abctabcst
 *
 */
public class Work2024DPasswordjiemi {

    public static void main(String[] args) {
        //先创建一个map，用来储存1-26和字母a-z的映射关系
        HashMap<String, Character> map = new HashMap<>();
        for (int i = 0; i <= 26; i++) {
            map.put(String.valueOf(i), (char) ('a' + i - 1));
        }
        Scanner scanner = new Scanner(System.in);
        //获取输入加密的字符串
        String s = scanner.nextLine();
        //需要注意遇到*的时候 需要把*前面的两个当成一个整体 满足后进先出的规则,可以考虑用栈
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                //从栈中弹出*前面的两个数字 先弹出来的是个位 后弹出来的是十位
                String pop1 = stack.pop();
                String pop10 = stack.pop();
                //再把组合起来的两位数重新压入栈中
                stack.push(pop10+pop1);
            }else{
                //如果不是*号 代表是数字 直接压入栈中
                stack.push(String.valueOf(c));
            }
        }
        // 最后栈中的所有元素即为数字字符串，使用dic进行从数字到字母的映射之后再合并即可
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(map.get(stack.pop()));
        }
        System.out.println(sb.reverse().toString());
    }

}
