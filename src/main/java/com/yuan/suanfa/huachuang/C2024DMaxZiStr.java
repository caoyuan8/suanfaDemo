package com.yuan.suanfa.huachuang;


import java.util.Scanner;

/**
 * 2024D-求满足条件的最长子串的长度
 *题目描述
 * 给定一个字符串，只包含字母和数字，按要求找出字符串中的最长 (连续)子串的长度，字符串本身是其最长的子串，子串要求:
 * 1. 只包含1个字母(a~z,A~Z)，其余必须是数字
 * 2. 字母可以在子串中的任意位置;
 * 如果找不到满足要求的子串，如全是字母或全是数字，则返回-1。
 *
 */
public class C2024DMaxZiStr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        // 记录字母和数字的个数
        int alphaNum = 0;
        int digitNum = 0;
        int ans = -1;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (Character.isDigit(ch)) {
                digitNum++;
            } else if (Character.isLetter(ch)) {
                alphaNum++;
            }
            if (alphaNum == 2) {
                while (alphaNum == 2) {
                    if (Character.isDigit(s.charAt(left))) {
                        digitNum--;
                    } else if (Character.isLetter(s.charAt(left))) {
                        alphaNum--;
                    }
                    left++;
                }
            }

            if (alphaNum == 1 && digitNum > 0) {
                ans = Math.max(ans, digitNum + 1);
            }
        }

        System.out.println(ans);
    }

}
