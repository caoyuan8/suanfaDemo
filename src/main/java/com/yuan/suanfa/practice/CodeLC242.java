package com.yuan.suanfa.practice;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 *
 *给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的
 * 字母异位词
 * 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 */
public class CodeLC242 {

    public static void main(String[] args) {
/*        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram("rat","car"));*/
        System.out.println(isAnagram1("anagram","nagaram"));
        System.out.println(isAnagram1("rat","car"));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] charArray = s.toCharArray();
        char[] charArray1 = t.toCharArray();
        Arrays.sort(charArray);
        Arrays.sort(charArray1);
        return Arrays.equals(charArray,charArray1);
    }

    public static boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        //创建一个数组用来统计26个字母都出现了多少次 s中出现一次则+1 t中出现一次则-1
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            table[c-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            table[c-'a']--;
            /*if(table[c-'a']<0){
                return false;
            }*/
        }
        for (int i : table) {
            if(i!=0){
                return false;
            }
        }
        return true;
    }

}
