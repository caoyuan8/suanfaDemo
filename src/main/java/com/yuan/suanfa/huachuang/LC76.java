package com.yuan.suanfa.huachuang;


/**
 * LC76. 最小覆盖子串
 *
 *给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 *
 * 提示：
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 */
public class LC76 {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }

    public static String minWindow(String s, String t) {
        // 定义结果字符串
        String result = "";
        // 定义长度
        int sLength = s.length();
        int tLength = t.length();
        // 如果t的长度比s打，直接返回
        if (tLength > sLength) {
            return "";
        }
        // 如果s中包含t，直接返回
        if (s.contains(t)) {
            return t;
        }
        // 计算t的字母的数量
        int[] tLetterCount = new int[58];
        for (char c : t.toCharArray()) {
            tLetterCount[c - 'A']++;
        }
        // 定义滑动窗口的左右指针（闭区间）
        int left = 0;
        int right = t.length() - 1;
        // 计算s第一个子串中，字母的数量
        int[] subLetterCount = new int[58];
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            subLetterCount[c - 'A']++;
        }
        // 统计最小子串长度
        int minLength = Integer.MAX_VALUE;
        // 记录最小字符串的左右端点
        int resultLeft = 0;
        int resultRight = 0;
        // 开始滑动窗口
        for (left = 0; left < sLength - tLength + 1; left++) {
            // 当左端点开始向右滑动时，需要将 左端点移除字母的数量 减1
            if (left > 0) {
                // 找到移除的字母是什么
                char c = s.charAt(left - 1);
                // 数量-1
                subLetterCount[c - 'A']--;
            }
            // 无论左端点是否移动，右端点都不重置
            while (right < sLength) {
                boolean flag = true;
                // 遍历子串
                for (int i = 0; i < subLetterCount.length; i++) {
                    // 判断 子串的每个字母 的数量 是否小于 t 的对应字母数量
                    if (subLetterCount[i] < tLetterCount[i]) {
                        // 如果是，则直接返回，后面再执行 右端点向右移动1位
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    // 如果子串的每个字母 的数量 都大于等于 t 的对应字母数量
                    int temp = right - left;
                    // 如果子串长度更小，记录最终结果的左右端点（比每次都获取子串速度更快）
                    if (temp < minLength) {
                        minLength = temp;
                        resultLeft = left;
                        resultRight = right;
                    }
                    break;
                } else {
                    // 如果子串的每个字母 的数量 存在小于 t 的对应字母数量，
                    // 右端点向右移动1位（不超过数组边界），并且新增字母的数量+1
                    right++;
                    if (right < sLength) {
                        subLetterCount[s.charAt(right) - 'A']++;
                    }
                }
            }
        }
        // 返回结果
        return minLength == Integer.MAX_VALUE ? "" : s.substring(resultLeft, resultRight + 1);
    }
}
