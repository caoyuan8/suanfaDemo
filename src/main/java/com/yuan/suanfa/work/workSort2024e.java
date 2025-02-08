package com.yuan.suanfa.work;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 【排序】2024E-身高体重排序
 *
 * 题目描述与示例
 * 题目描述
 * 某学校举行运动，学生们按编号(1、2、3.....n) 进行标识,
 * 现需要按照身高由低到高排列，对身高相同的人，按体重由轻到重排列，对于身高体重都相同的人，维持原有的编号顺序关系。
 * 请输出排列后的学生编号
 * 输入描述
 * 两个序列，每个序列由 n 个正整数组成(0 < n < 100)。第一个序列中的数值代表身高，第二个序列中的数值代表体重。
 * 输出描述
 * 排列结果，每个数值都是原始序列中的学生编号，编号从 1 开始
 * 示例一
 * 输入
 * 4
 * 100 100 120 130
 * 40 30 60 50
 * 输出
 * 2134
 * 示例二
 * 输入
 * 3
 * 90 110 90
 * 45 60 45
 * 输出
 * 132
 *
 */
public class workSort2024e {

    public static void main(String[] args) {
        /*Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int[] h = new int[n];
        int[] w = new int[n];
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
            idx[i] = i + 1;
        }
        int[][] list = new int[n][3];
        for (int i = 0; i < n; i++) {
            list[i][0] = h[i];
            list[i][1] = w[i];
            list[i][2] = idx[i];
        }
        Arrays.sort(
                list, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] a) -> a[1]).thenComparingInt((int[] a) -> a[2])
        );
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(list[i][2]);
        }
        System.out.println(result);*/
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        String[] strings = sortPeople(names, heights);
        System.out.println(Arrays.toString(strings));
    }

    public String test1(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] h = new int[n];
        int[] w = new int[n];
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
            id[i] = i+1;
        }
        int[][] list = new int[n][3];
        for (int i = 0; i < n; i++) {
            list[i][0] = h[i];
            list[i][1] = w[i];
            list[i][2] = id[i];
        }
        Arrays.sort(
                list,Comparator.comparingInt((int[] a)->a[0]).thenComparingInt((int[] a)->a[1]).thenComparingInt((int[] a)->a[2])
        );
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(list[i][2]);
        }
        return res.toString();
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        String[][] list = new String[names.length][2];
        for (int i = 0; i < names.length; i++) {
            list[i][0] = (names[i]);
            list[i][1] = String.valueOf(heights[i]);
        }
        Arrays.sort(
                list,Comparator.comparing((String[] a)->a[1])
        );
        String[] result = new String[names.length];
        for(int i = 0; i < names.length; i++){
            result[i] = list[i][0];
        }
        return result;
    }


}
