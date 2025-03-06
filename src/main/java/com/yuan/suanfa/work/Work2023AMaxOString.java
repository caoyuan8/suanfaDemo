package com.yuan.suanfa.work;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 【双指针】2023A-最长的元音字符串
 *
 *
 * 题目
 * 定义当一个字符串只有元音字母(a,e,i,o,u,A,E,I,O,U)组成,称为元音字符串，现给定一个字符串，请找出其中最长的元音字符串，并返回其长度，如果找不到请返回0。
 * 字符串中任意一个连续字符组成的子序列称为该字符串的子串。
 * 输入
 * 一个字符串s。字符串长度满足0 < len(s) < 10^5，字符串仅由字符a-z或A-Z组成
 * 输出描述
 * 一个整数，表示最长的元音字符子串的长度。
 * 示例一
 * 输入
 * asdbuiodevauufgh
 * 输出
 * 3
 * 说明
 * 最长的元音字符子串为uio和auu长度都为3，因此输出3
 *
 */
public class Work2023AMaxOString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        // 元音集合
        HashSet<Character> vowelSet = new HashSet<>();
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
        // 最后一个非元音所在的索引位置
        int lastNotVowel = -1;
        // 答案
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!vowelSet.contains(c)){
                lastNotVowel = i;
            }else {
                ans = Math.max(ans, i - lastNotVowel);
            }
        }
        System.out.println(ans);
    }


}
