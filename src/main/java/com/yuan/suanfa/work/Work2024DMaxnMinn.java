package com.yuan.suanfa.work;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 2024D-最大N个数与最小N个数的和
 *
 *
 * 题目描述
 * 给定一个数组，编写一个函数来计算它的最大N个数与最小N个数的和。你需要对数组进行去重。
 *
 * 输入描述
 * 第一行输入M， M标识数组大小
 * 第二行输入M个数，标识数组内容
 * 第三行输入N，N表达需要计算的最大、最小N个数
 * 输出描述
 * 输出最大N个数与最小N个数的和。
 * 补充说明
 * 数组中数字范围[0，1000]
 * 最大N个数与最小N个数不能有重叠，如有重叠返回-1
 * 示例
 * 输入
 * 5
 * 95 88 83 64 100
 * 2
 *
 * 输出
 * 342
 *
 */
public class Work2024DMaxnMinn {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            list.add(scanner.nextInt());
        }
        int n = scanner.nextInt();
        //使用TreeSet进行去重+排序
        TreeSet<Integer> treeSet = new TreeSet<>(list);
        //再将set转为list
        ArrayList<Integer> arrayList = new ArrayList<>(treeSet);
        //如果长度<2n则代表有重叠返回-1
        if(arrayList.size()<2*n){
            System.out.println(-1);
        }else{
            int sum = 0;
            //返回队首和队尾之和 依次向内取队首队尾
            for (int i = 0; i < n; i++) {
                sum += arrayList.get(i)+arrayList.get(arrayList.size()-1-i);
            }
            System.out.println(sum);
        }
    }

}
