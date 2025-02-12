package com.yuan.suanfa.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LC49. 字母异位词分组
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * 提示：
 * - 1 <= strs.length <= 10^4
 * - 0 <= strs[i].length <= 100
 * - strs[i] 仅包含小写字母
 *
 */
public class CodeLC49 {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        //创建一个map用来储存异位词,key为词中各个字母数量的字符串,例如a1e1t1，value为异位词集合
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 由于都是小写字母，因此直接用 26 个长度的数组代替原来的 HashMap ，比直接使用 HashMap 更优秀
            // cnt 代表每个小写字母出现的频次
            int[] cnt =  new int[26];
            // 利用 for 循环，统计 str 当中每个字母出现的频次
            for (int i = 0; i < str.length(); i++) {
                // 对于数组类型，其下标为 int 类型
                // 可以直接使用 char 类型变量，默认强制转换，存储的就是字母对应的 ASCII 码
                // 比如 str.charAt(i) 是 b 字符，那么 b - a = 1，即 counts[1] 表示记录 b 出现的频次
                cnt[str.charAt(i)-'a']++;
            }
            // String 类是不可变类，即一旦一个 String 对象被创建以后，包含在这个对象中的字符序列是不可改变的，直至这个对象被销毁。
            // Java 提供了两个可变字符串类 StringBuffer 和 StringBuilder，中文翻译为“字符串缓冲区”
            // StringBuffer：线程安全
            // StringBuilder：线程不安全
            StringBuilder sb = new StringBuilder();
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            for (int i = 0; i < 26; i++) {
                if(cnt[i]!=0){
                    // 先记录字母，比如记录了字母 k
                    sb.append((char)('a'+i));
                    // 再记录次数，比如记录了次数 9
                    sb.append(cnt[i]);
                }
            }
            // 转换为字符串的形式，比如为 a1k9x7
            String key = sb.toString();
            // 在哈希表 map 当中找出这个 key 对应的字符串 str 来
            // 1、如果有这个 key，那么这个 key 对应的 数组 会新增一个 str 进去
            // 2、如果没有这个 key，那么会初始化一个数组，用来新增这个 str
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }

}
