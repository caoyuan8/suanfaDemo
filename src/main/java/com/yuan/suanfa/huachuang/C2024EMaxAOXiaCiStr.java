package com.yuan.suanfa.huachuang;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 2024E-最长的指定瑕疵度的元音子串
 *
 *头和结尾都是元音字母（aeiouAEIOU）的字符串为元音字符串，其中混杂的非元音字母数量为其瑕疵度。比如:
 * - "a"，"aa"是元音字符串，其瑕疵度都为 0
 * - "aiur"不是元音字符串（结尾不是元音字符）
 * - "abira"是元音字符串，其瑕疵度为 2
 * 给定一个字符串，请找出指定瑕疵度的最长元音字符子串，并输出其长度，如果找不到满足条件的元音字符子串，输出 0。
 * 子串：字符串中任意个连续的字符组成的子序列称为该字符串的子串。
 * 输入描述
 * 首行输入是一个整数，表示预期的瑕疵度flaw，取值范围[0, 65535]。
 * 接下来一行是一个仅由字符a-z和A-Z组成的字符串，字符串长度(0, 65535]。
 * 输出描述
 * 输出为一个整数，代表满足条件的元音字符子串的长度。
 * 示例一
 * 输入
 * 0
 * asdbuiodevauufgh
 * 输出
 * 3
 * 说明
 * 满足条件的最长元音字符子串有两个，分别为uio和auu，长度为 3。
 *
 * 示例二
 * 输入
 * 2
 * aeueo
 * 输出
 * 0
 * 说明
 * 没有满足条件的元音字符子串，输出 0
 *
 * 示例三
 * 输入
 * 1
 * aabeebuu
 * 输出
 * 5
 * 说明
 * 满足条件的最长元音字符子串有两个，分别为aabee和eebuu，长度为 5
 *
 */
public class C2024EMaxAOXiaCiStr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入瑕疵度
        int k = scanner.nextInt();
        scanner.nextLine();  // 读取换行符
        // 输入原字符串
        String s = scanner.nextLine();

        // 构建包含元音的集合
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');
        int n = s.length();
        int left = n;
        // 找到第一个元音
        for (int i = 0; i < n; i++) {
            if (vowelSet.contains(s.charAt(i))) {
                left = i;
                break;
            }
        }
        // 如果不存在元音
        if (left == n) {
            System.out.println(0);
        } else {
            int ans = 0;
            // 滑窗子串对应的瑕疵度
            int winConsonantNum = 0;
            for (int right = left; right < n; right++) {
                char ch = s.charAt(right);
                // 如果 ch 是元音
                if (vowelSet.contains(ch)) {
                    if (winConsonantNum == k) {
                        ans = Math.max(ans, right - left + 1);
                    }
                } else {  // 如果 ch 是辅音
                    winConsonantNum++;
                    // 如果滑窗子串对应的瑕疵度超过了阈值 k
                    while (left < n && (winConsonantNum > k || !vowelSet.contains(s.charAt(left)))) {
                        if (!vowelSet.contains(s.charAt(left))) {
                            winConsonantNum--;
                        }
                        left++;
                    }
                }
            }
            // 输出结果
            System.out.println(ans);
        }
    }


}
