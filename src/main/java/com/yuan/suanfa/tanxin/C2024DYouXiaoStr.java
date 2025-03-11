package com.yuan.suanfa.tanxin;

import java.util.Scanner;

/**
 * 【贪心】2024D-有效子字符串
 *题目
 * 输入两个字符串S和L，都只包含小写字母，len(S) <= 100，len(L) <= 500000。判断S是否是L的有效子字符串。
 * - 判定规则：S中的每个字符在L中都能找到（可以不连续），且S在L中字符的前后顺序与S中顺序要保持一致。
 * 例如：
 * S = "ace"是L = "abcde"的一个子序列，且有效字符是a、c、e，而"aec"不是有效子序列，且有效字符只有a、e（因为相对位置不同）。
 * 输入
 * 输入两个字符串S和L，都只包含小写字母，len(S) <= 100，len(L) <= 500000，先输入S再输入L
 * 每个字符串占一行。
 * 输出描述
 * S串最后一个有效字符在L中的位置，首位从0开始计算。无有效字符返回 -1
 *
 * 示例一
 * 输入
 * ace
 * abcde
 * 输出
 * 4
 * 示例二
 * 输入
 * fgh
 * abcde
 * 输出
 * -1
 *
 */
public class C2024DYouXiaoStr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入S和L
        String S = scanner.nextLine();
        String L = scanner.nextLine();
        int ans = -1;
        int ns = S.length(), nl = L.length();
        int ps = 0, pl = 0;
        while (ps < ns && pl < nl) {
            // 如果S[ps]等于L[pl]，先记录pl为ans，且ps和pl都向前移动
            if (S.charAt(ps) == L.charAt(pl)) {
                ans = pl;
                ps++;
                pl++;
            }
            // 如果S[ps]不等于L[pl]，只有pl向前移动
            else {
                pl++;
            }
        }

        System.out.println(ans);
    }


}
