package com.yuan.suanfa.work;


import java.util.HashMap;

/**
 * LC290. 单词规律
 *
 *给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * 示例1:
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 * 提示:
 * - 1 <= pattern.length <= 300
 * - pattern 只包含小写英文字母
 * - 1 <= s.length <= 3000
 * - s 只包含小写英文字母和 ' '
 * - s 不包含 任何前导或尾随对空格
 * - s 中每个单词都被 单个空格 分隔
 *
 */
public class LC290 {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("aaa", "aa aa aa aa"));
    }

    //该题何LC205同构字符串 很相似基本解法一致
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> dic1 = new HashMap<>();
        HashMap<String, Character> dic2 = new HashMap<>();
        String[] split = s.split(" ");
        // 如果 pattern 和分割后的数组长度不等，直接返回 false
        if (pattern.length() != split.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = split[i];
            if (dic1.containsKey(ch)&&!dic1.get(ch).equals(word)) {
                return false;
            }
            if(dic2.containsKey(word)&&dic2.get(word)!=ch){
                return false;
            }
            if(!dic1.containsKey(ch)){
                dic1.put(ch,word);
            }
            if(!dic2.containsKey(word)){
                dic2.put(word,ch);
            }
        }
        return true;
    }

}
