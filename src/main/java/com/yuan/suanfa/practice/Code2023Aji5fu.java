package com.yuan.suanfa.practice;


import java.util.HashMap;
import java.util.Scanner;

/**
 * 2023A-集五福
 *题目描述
 * 集五福作为近年来大家喜闻乐见迎新春活动，集合爱国福、富强福、和谐福、友善福、敬业福即可分享超大红包。以 0 和 1 组成的长度为 5 的字符串代表每个人所得到的福卡，每一位代表一种福卡，1 表示已经获得该福卡，单类型福卡不超过 1 张，随机抽取一个小于 10 人团队，求该团队最多可以集齐多少套五福？
 * 输入描述
 * 输入若干个由0、1组成的长度等于5的字符串，代表团队中每个人福卡获得情况
 * 注意1：1人也可以是一个团队
 * 注意2：1人可以有0到5张福卡，但福卡不能重复
 * 输出描述
 * 输出该团队最多能凑齐多少套五福
 * 示例一
 * 输入
 * 11001,11101
 * 输出
 * 0
 * 示例二
 * 输入
 * 11101,10111
 * 输出
 * 1
 *
 */
public class Code2023Aji5fu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] team = scanner.nextLine().split(",");
        //创建一个map用来储存福卡数量,key为福卡类型，value为福卡数量
        HashMap<Integer,Integer> map = new HashMap<>();
        for (String person : team) {
            for (int i = 0; i < person.length(); i++) {
                char c = person.charAt(i);
                if(c == '1'){
                    map.put(i,map.getOrDefault(i,0)+1);
                }
            }
        }
        //判断福卡数量是否小于5
        if(map.size()<5){
            System.out.println("0");
        }else {
            int num = Integer.MAX_VALUE;
            for (Integer value : map.values()) {
                //取出最小值 就是最多凑多少套福卡的数量
                num = Math.min(num,value);
            }
            System.out.println(num);
        }
    }

}
