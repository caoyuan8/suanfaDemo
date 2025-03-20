package com.yuan.suanfa.mockTest.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 英文输入法
 */
public class C2024EEnglishInput {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 从输入获取字符串s和前缀pre
        String s = scanner.nextLine();
        String pre = scanner.nextLine();

        // 初始化列表lst用于存放所有单词
        ArrayList<String> lst = new ArrayList<>();
        lst.add("");

        // 遍历s中的所有字符ch
        for (char ch : s.toCharArray()) {
            // 如果ch是字母，则加入到lst最后一个元素的末尾，即延长当前单词
            if (Character.isLetter(ch)) {
                int lastIndex = lst.size() - 1;
                lst.set(lastIndex, lst.get(lastIndex) + ch);
            } else {
                // 如果ch不是字母，说明遇到一个标点符号，结束当前单词的获取，lst的末尾插入一个新的空字符串""
                lst.add("");
            }
        }

        // 用哈希集合去重lst中可能出现的重复单词
        HashSet<String> set = new HashSet<>(lst);
        // 去重后进行排序，排序后在转化为列表lstSorted
        ArrayList<String> lstSorted = new ArrayList<>(set);
        Collections.sort(lstSorted);

        // 初始化答案数组
        ArrayList<String> ans = new ArrayList<>();
        // 获得pre的长度，用于切片
        int preLength = pre.length();

        // 遍历lstSorted中的每一个单词
        for (String word : lstSorted) {
            // 如果word前preLength个字符的切片等于pre
            // 说明word的前缀是pre，将其加入答案数组ans中
            if (word.length() >= preLength && word.substring(0, preLength).equals(pre)) {
                ans.add(word);
            }
        }

        // 如果ans长度大于0，说明至少存在一个单词的前缀是pre，输出由所有单词组成的字符串
        // 如果ans长度等于0，说明不存在任何一个单词的前缀是pre，返回pre
        if (ans.size() > 0) {
            System.out.println(String.join(" ", ans));
        } else {
            System.out.println(pre);
        }
    }


}
