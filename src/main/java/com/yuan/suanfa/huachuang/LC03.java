package com.yuan.suanfa.huachuang;


import java.util.HashSet;

/**
 * LC3. 无重复字符的最长子串
 *
 *给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 */
public class LC03 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 滑动窗口模板化解题，五步走策略
        // 【1、定义需要维护的变量】
        // 对于此题来说，要求是最大长度
        int maxLen = 0;
        // 同时又涉及去重，因此需要一个哈希表
        HashSet<Character> hash = new HashSet<Character>();
        // 【2、定义窗口的首尾端 (start, end)， 然后滑动窗口】
        // 窗口的左端位置从 0 开始
        int start = 0;
        // 窗口的右端位置从 0 开始，可以一直移动到尾部
        for( int end = 0 ; end < s.length() ; end++ ){
            // 【3、更新需要维护的变量, 有的变量需要一个 if 语句来维护 (比如最大最小长度)】
            // 【4、如果题目的窗口长度可变: 这个时候一般涉及到窗口是否合法的问题】
            //  如果当前窗口不合法时, 用一个 while 去不断移动窗口左指针, 从而剔除非法元素直到窗口再次合法
            // 如果哈希表中存储了即将加入滑动窗口的元素
            while(hash.contains(s.charAt(end))){
                // 那么需要不断的把窗口左边的元素移除窗口
                // 把 s.charAt(start) 移除记录
                hash.remove(s.charAt(start));
                // 窗口左端向右移动
                start++;
            }
            // 此时，滑动窗口可以接纳 s.charAt(end)
            hash.add(s.charAt(end));
            // 维护变量 maxLen
            maxLen = Math.max(maxLen,end - start + 1);
        }
        // 【5、返回所需要的答案】
        return maxLen;
    }

}
