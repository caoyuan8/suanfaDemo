package com.yuan.suanfa.huachuang;


import java.util.Scanner;

/**
 * 2023A-区块链文件转储系统
 *
 * 题目描述
 * 区块链底层存储是一个链式文件系统，由顺序的 N 个文件组成，每个文件的大小不一，依次为F1, F2, …, Fn 。随着时间的推移，所占存储会越来越大。云平台考虑将区块链按文件转储到廉价的 SATA 盘，只有连续的区块链文件才能转储到 SATA 盘上，且转储的文件之和不能超过 SATA 盘的容量。假设每块 SATA 盘容量为 M，求能转储的最大连续文件大小之和。
 * 输入描述
 * 第一行为 SATA 盘容量 M，1000 ≤ M ≤ 1000000
 * 第二行为区块链文件大小序列 F1, F2, …, Fn。其中 1 ≤ n ≤ 100000，1 ≤ Fi ≤ 500
 * 输出描述
 * 求能转储的最大连续文件大小之和。
 * 示例一
 * 输入
 * 1000
 * 100 300 500 400 400 150 100
 * 输出
 * 950
 * 说明
 * 最大序列和为950，序列为[400, 400, 150]
 * 示例二
 * 输入
 * 1000
 * 100 500 400 150 500 100
 * 输出
 * 1000
 * 说明
 * 最大序列和为 1000，序列为 [100, 500, 400]
 *
 */
public class C2023AQuKuaiLian {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        //将字符串数组转换为int数组
        int[] lst = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            lst[i] = Integer.parseInt(input[i]);
        }
        //最终结果
        int ans = 0;
        //窗口和
        int winSum = 0;
        int left = 0;
        for (int right = 0; right < lst.length; right++) {
            // A1
            winSum += lst[right];
            // A2
            while (winSum > M) {
                winSum -= lst[left];
                left++;
            }
            // A3
            ans = Math.max(ans, winSum);
        }
        System.out.println(ans);
    }


}
