package com.yuan.suanfa.mockTest.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 寻找密码
 */
public class C2023AFindPassWord {


    /**
     * 题目描述
     * 小王在进行游戏大闯关，有一个关卡需要输入一个密码才能通过，密码获得的条件如下：在一个密码本中，每一页都有一个由 26 个小写字母组成的若干位密码，从它的末尾开始依次去掉一位得到的新密码也在密码本中存在。请输出符合要求的最长密码，如果由多个符合要求的密码，则返回字典序最大的密码。若没有符合要求的密码，则返回空字符串。
     * 输入
     * 密码本由一个字符串数组组成，不同元素之间使用空格隔开，每一个元素代表密码本每一页的密码。
     * 输出
     * 一个字符串
     * 示例一
     * 输入
     * h he hel hell hello
     * 输出
     * hello
     * 说明
     * "hello" 从末尾依次去掉一位得到的 "hell", "hel", "he", "h"在密码本中都存在。
     * 示例二
     * 输入
     * b eredderd bw bww bwwl bwwlm bwwln
     * 输出
     * bwwln
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] passwordArray = scanner.nextLine().split(" ");
        //对输入的字符串数组进行升序排序
        Arrays.sort(passwordArray);
        //初始化一个表示有效密码的哈希集合，初始化其中仅包含空字符串
        HashSet<String> validSet = new HashSet<>();
        validSet.add("");
        //初始化答案为空字符串
        String ans = "";
        //从头到尾遍历升序字符串数组passwordArray中的密码password
        for (String password : passwordArray) {
            //如果password去掉最后一位的结果，位于validSet哈希集合中
            //说明当前的password是一个有效密码，将其加入validSet，同时更新ans
            if (password.substring(0, password.length() - 1).equals("") || validSet.contains(password.substring(0, password.length() - 1))) {
                validSet.add(password);
                if (password.length() >= ans.length()) {
                    ans = password;
                }
            }
        }

        System.out.println(ans);
    }

}
