package com.yuan.suanfa.practice;


/**
 * 383. 赎金信
 *
 *给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */
public class CodeLC383 {

    //该题和LC242基本类似 都是把字符串中每个字符出现的次数进行比较 放到数组中计数
    public static void main(String[] args) {
        System.out.println(canConstruct("a","b"));
        System.out.println(canConstruct("aa","ab"));
        System.out.println(canConstruct("aa","aab"));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        int[] table = new int[26];
        for (char c : magazine.toCharArray()) {
            table[c-'a']++;
        }
        for (char c : ransomNote.toCharArray()){
            table[c-'a']--;
            if(table[c-'a']<0){
                return false;
            }
        }
        return true;
    }

}
