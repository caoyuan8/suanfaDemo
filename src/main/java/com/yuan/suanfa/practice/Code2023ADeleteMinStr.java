package com.yuan.suanfa.practice;


import java.util.*;

/**
 * 2023A-删除最少字符
 *
 *题目
 * 删除字符串s中出现次数最少的字符，如果多个字符出现次数一样则都删除。
 * 输入
 * 输入只包含小写字母
 * 输出描述
 * 输出删除后剩余的字符串；若删除后字符串长度为0，则输出字符串"empty"
 * 示例一
 * 输入
 * abcdd
 * 输出
 * dd
 * 示例二
 * 输入
 * aabbccdd
 * 输出
 * empty
 *
 *
 */
public class Code2023ADeleteMinStr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Integer min = Collections.min(map.values());
        HashSet<Character> set = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == min){
                set.add(entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(!set.contains(c)){
                sb.append(c);
            }
        }
        System.out.println(sb.length()==0?"empty":sb.toString());
    }

}
