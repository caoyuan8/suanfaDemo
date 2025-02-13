package com.yuan.suanfa.work;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 2024E-英文输入法
 *
 *主管期望你来实现英文输入法单词联想功能，需求如下：
 * 1. 依据用户输入的单词前缀，从已输入的英文语句中联想出用户想输入的单词。
 * 2. 按字典序输出联想到的单词序列，如果联想不到，请输出用户输入的单词前缀。
 * 注意：
 * 1. 英文单词联想时区分大小写
 * 2. 缩略形式如"don't" 判定为两个单词"don"和 "t"
 * 3. 输出的单词序列不能有重复单词，且只能是英文单词，不能有标点符号
 * 输入
 * 输入两行。
 * 首行输入一段由英文单词word和标点构成的语句str，接下来一行为一个英文单词前缀pre。
 * 0 < word.length() <= 20，0 < str.length() <= 10000，0 < pre.length() <= 20
 * 输出
 * 输出符合要求的单词序列或单词前缀。存在多个时，单词之间以单个空格分割
 * 示例一
 * 输入
 * I love you
 * He
 * 输出
 * He
 * 说明
 * 用户已输入单词语句"I love you"，可以提炼出"I","love","you"三个单词。接下来用户输入"He" ，
 * 从已经输入信息中无法联想到符合要求的单词，所以输出用户输入的单词前缀。
 * 示例二
 * 输入
 * The furthest distance in the world,Is not between life and death,But when I stand in front or you,Yet you don't know that I love you.
 * f
 * 输出
 * front furthest
 *
 */
public class Work2024EShuRuFa {

    //该题难点在于对输入的字符串进行处理,因为最开始可能带有标点等
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //接受目标字符串和前缀
        String words = scanner.nextLine();
        String pre = scanner.nextLine();
        //创建一个list储存单词,先在list中储存空字符
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        for (char c : words.toCharArray()) {
            //如果是字母就添加到list最后,如果为空刚好替代了""
            if(Character.isLetter(c)){
                int i = list.size() - 1;
                list.set(i,list.get(i) + c);
            }else {
                //如果不是字母就添加一个空字符进行占位
                list.add("");
            }
        }
        //set进行去重
        HashSet<String> set = new HashSet<>(list);
        ArrayList<String> arrayList = new ArrayList<>(set);
        //去重后在进行排序
        Collections.sort(arrayList);
        //目标前缀长度
        int length = pre.length();
        ArrayList<String> ans = new ArrayList<>();
        for (String s : arrayList) {
//            if(s.startsWith(pre)){
            //如果长度大于等于目标长度,并且前缀相同就添加到ans中
            if (s.length()>=length&&s.substring(0,length).equals(pre)) {
                ans.add(s);
            }
        }
        if (ans.size() > 0) {
            System.out.println(String.join(" ", ans));
        } else {
            System.out.println(pre);
        }

    }


}
