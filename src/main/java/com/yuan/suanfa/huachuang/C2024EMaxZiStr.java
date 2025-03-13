package com.yuan.suanfa.huachuang;


import java.util.Scanner;

/**
 * 2024E-寻找符合要求的最长子串
 *
 *题目描述
 * 给定一个字符串 s ，找出这样一个子串：
 * 1. 该子串中的任意一个字符最多出现 2 次；
 * 2. 该子串不包含指定某个字符；
 * 请你找出满足该条件的最长子串的长度。
 * 输入
 * 第一行为要求不包含的指定字符，为单个字符，取值范围 [0-9a-zA-Z]
 * 第二行为字符串 s，每个字符范围 [0-9a-zA-Z]，长度范围 [1,10000]
 *
 * 输出
 * 一个整数，满足条件的最长子串的长度；
 * 如果不存在满足条件的子串，则返回 0
 * 示例一
 * 输入
 * D
 * ABC123
 * 输出
 * 6
 *
 * 示例二
 * 输入
 * D
 * ABACD1231
 * 输出
 * 4
 *
 */
public class C2024EMaxZiStr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String s = scanner.nextLine();
        int left = 0;
        int ans = 0;
        int[] hashTable = new int[128];
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            //ch不为应该排除的数：进行滑窗
            if (ch != a.charAt(0)) {
                hashTable[ch]++; // A1
                while (hashTable[ch] == 3) { // A2
                    char leftChar = s.charAt(left);
                    hashTable[leftChar]--;
                    left++;
                }
                ans = Math.max(ans, right - left + 1); // A3
            } else { // ch为应该排除的数：滑窗清空，从right+1开始下一个滑窗
                left = right + 1;
                hashTable = new int[128];
            }
        }

        System.out.println(ans);
    }


}
