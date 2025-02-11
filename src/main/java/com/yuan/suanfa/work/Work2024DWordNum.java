package com.yuan.suanfa.work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 2024D-掌握单词个数
 *
 *题目描述
 * 有一个字符串数组 words 和一个字符串 chars 。
 * 假如可以用 chars 中的字母拼写出 words 中的某个“单词”（字符串），那么我们就认为你掌握了这个单词。
 * words 的字符仅由 a-z 英文小写字母组成，例如 “abc”
 * chars 由 a-z 英文小写字母和 “?” 组成。其中英文问号 “?” 表示万能字符，能够在拼写时当做任意一个英文字母。例如：“?” 可以当做 “a” 等字母。
 * 注意：每次拼写时，chars 中的每个字母和万能字符都只能使用一次。
 * 输出词汇表 words 中你掌握的所有单词的个数。没有掌握任何单词，则输出 0。
 * 输入描述
 * 第 1 行输入数组 words 的个数，记为 N。
 * 从第 2 行开始到第 N+1 行一次输入数组 words 的每个字符串元素。
 * 第 N+2 行输入字符串 chars。
 * 输入描述
 * 输出一个整数，表示词汇表 words 中你掌握的单词个数。
 *
 *
 * 示例一
 * 输入
 * 4
 * cat
 * bt
 * hat
 * tree
 * atach
 * 输出
 * 2
 * 说明
 * atach可以拼写出单词cat和hat，因此掌握的单词是2个。
 *
 *
 * 示例二
 * 输入
 * 4
 * cat
 * bt
 * hat
 * tree
 * at?ch
 * 输出
 * 3
 * 说明
 * at?ch可以拼写出单词cat、hat和bt，因此掌握的单词是3个。
 *
 */
public class Work2024DWordNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }
        String chars = scanner.nextLine();
        //创建一个map 用来统计chars中的各个字符的数量
        HashMap<Character, Integer> cntChars = new HashMap<>();
        for (char c : chars.toCharArray()) {
            cntChars.put(c,cntChars.getOrDefault(c,0)+1);
        }
        //最终的结果
        int ans = 0;
        //问号的数量,问号有一个则可以替代任意一个字符
        int num = cntChars.getOrDefault('?',0);
        for (String word : words) {
            //统计words中的各个字符的数量
            HashMap<Character, Integer> cntWords = new HashMap<>();
            for (char c : word.toCharArray()) {
                cntWords.put(c,cntWords.getOrDefault(c,0)+1);
            }
            //调用check方法
            ans += check(cntChars, cntWords, num) ? 1 : 0;
        }
        System.out.println(ans);
    }

    public static boolean check(HashMap<Character, Integer> cntChars,HashMap<Character, Integer> cntWords,int num){
        //chars进行循环,如果chars当前循环字符的数量大于等于words中当前字符的数量,则继续判断下一个字符
        for (Character c : cntWords.keySet()) {
            if (cntChars.getOrDefault(c,0)>=cntWords.getOrDefault(c,0)){
                continue;
            }else {
                //否则的话除非有? 不然就不满足 接下来就是看words中比chars中多了多少个 用?的num递减
                num -= cntWords.getOrDefault(c,0)-cntChars.getOrDefault(c,0);
                //问号不够用了
                if(num<0){
                    return false;
                }
            }
        }
        return true;
    }

}
