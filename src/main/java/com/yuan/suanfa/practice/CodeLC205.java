package com.yuan.suanfa.practice;


import java.util.HashMap;

/**
 * LC205. 同构字符串
 *
 *给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 * 提示：
 * - 1 <= s.length <= 5 * 10^4
 * - t.length == s.length
 * - s 和 t 由任意有效的 ASCII 字符组成
 *
 */
public class CodeLC205 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        // 设置一个哈希集合用来存储字符串 s 当中的元素
        HashMap<Character, Character> dicS = new HashMap<>();
        // 设置一个哈希集合用来存储字符串 t 当中的元素
        HashMap<Character, Character> dicT = new HashMap<>();
        // 由于 t.length == s.length
        // 按照顺序访问 s 和 t 中对应的元素
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            // 3、访问的元素 s[i] 不存在于 dicS 中
            // 存放到哈希集合中
            if (!dicS.containsKey(sChar)) {
                dicS.put(sChar, tChar);
            }
            // 3、访问的元素 t[i] 不存在于 dicT 中
            // 存放到哈希集合中
            if (!dicT.containsKey(tChar)) {
                dicT.put(tChar, sChar);
            }
            // 1、访问的元素 s[i] 存在于 dicS 中
            // 并且发现它对应的元素值和当前 t 中元素 t[i] 不相同
            // 返回 false
            if (dicS.containsKey(sChar) && dicS.get(sChar) != tChar) {
                return false;
            }
            // 2、访问的元素 t[i] 存在于 dicT 中
            // 并且发现它对应的元素值和当前 s 中元素 s[i] 不相同
            // 返回 false
            if (dicT.containsKey(tChar) && dicT.get(tChar) != sChar) {
                return false;
            }
        }
        // 返回 true
        return true;
    }

}
