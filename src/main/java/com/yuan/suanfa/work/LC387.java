package com.yuan.suanfa.work;


/**
 * 387. 字符串中的第一个唯一字符
 *
 * 一、题目描述
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: 0
 *
 * 示例 2:
 * 输入: s = "loveleetcode"
 * 输出: 2
 *
 * 示例 3:
 * 输入: s = "aabb"
 * 输出: -1
 * 提示:
 * - 1 <= s.length <= 10^5
 * - s 只包含小写字母
 *
 */
public class LC387 {


    public static void main(String[] args) {
        System.out.println(new LC387().firstUniqChar("leetcode"));
        System.out.println(new LC387().firstUniqChar("loveleetcode"));
        System.out.println(new LC387().firstUniqChar("aabb"));
    }

    public int firstUniqChar(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(cnt[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;

    }


}
