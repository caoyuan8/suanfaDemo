package com.yuan.suanfa.tanxin;


import java.util.Scanner;

/**
 * 2024E-环中最长子串
 *
 * 题目描述
 * 给你一个字符串s,首尾相连成一个环形,请你在环中找出o字符出现了偶数次最长子字符串的长度。
 *
 * 输入描述
 * 输入由一个小写字母组成的字符串s
 * 1 <= s.lenth <= 5x10^5
 *
 * 输出描述
 * 输出是一个整数
 * 示例一
 * 输入
 * alolobo
 * 输出
 * 6
 * 说明
 * 最长子字符串之一是alolob,它包含2个o
 * 示例二
 * 输入
 * looxdolx
 * 输出
 * 7
 * 说明
 * 最长子字符串oxdolxl,由于是首尾连接一起的,
 * 所以最后一个x和开头的l是连接在一起的此字符串包含2个o
 * 示例三
 * 输入
 * bcbcbc
 * 输出
 * 6
 * 说明
 * 这个示例中,字符串bcbcbc本身就是最长的,
 * 因为o都出现了0次
 *
 */
public class C2024EHuanMaxStr {

    //- 字符o在原字符串中出现的次数为偶数次，为了使得所选子串尽可能长，那么把整个字符串都选上，一定是最长的符合要求的子串。此时子串长度为len(s)。
    //- 字符o在原字符串中出现的次数为奇数次，为了使得所选子串尽可能长，那么保留一个o不去选择，那么剩余字符串中o出现的次数必然为偶数次，
    // 把删除一个o之后的所有字符都选上，一定是最长的符合要求的子串。此时子串长度为len(s)-1。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        // 统计字符串中o出现的次数
        int num_o = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'o') {
                num_o++;
            }
        }
        int n = s.length();
        // 如果o出现的次数为偶数次，那么子串长度为len(s)。否则，子串长度为len(s)-1。
        if (num_o % 2 == 0) {
            System.out.println(n);
        } else {
            System.out.println(n - 1);
        }
    }

}
