package com.yuan.suanfa.tanxin;


import java.util.Scanner;

/**
 * 2024D-分割均衡字符串
 *
 * 均衡串定义: 字符串只包含两种字符，且两种字符的个数相同。
 * 给定一个均衡字符串，请给出可分割成新的均衡子串的最大个数。
 * 约定字符串中只包含大写的X和Y两种字符。
 *
 * 输入描述
 * 均衡串: XXYYXY
 * 字符串的长度[2,10000]。给定的字符串均为均衡串。
 *
 * 输出描述
 * 输出一个数字，表述可分割成新的均衡子串的最大个数。
 * 如上述例子可分割为两个子串，XXYY和XY，输出答案为2。
 *
 * 补充说明
 * 分割后的子串，是原字符串的连续子串。
 *
 * 示例
 * 输入
 * XXYYXY
 *
 * 输出
 * 2
 *
 */
public class C2024DFenGeJunHengStr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int ans = 0, X_num = 0, Y_num = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'X') {
                X_num++;
            } else {
                Y_num++;
            }
            if (X_num == Y_num) {
                ans++;
            }
        }

        System.out.println(ans);
    }


}
