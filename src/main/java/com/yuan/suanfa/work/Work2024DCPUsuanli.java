package com.yuan.suanfa.work;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * 2024D-CPU算力分配
 *
 *题目描述
 * 现有两组服务器A和B，每组有多个算力不同的CPU，其中Ai是A组第i个CPU的运算能力，Bi是B组第i个CPU的运算能力。一组服务器的总算力是各CPU的算力之和。
 * 为了让两组服务器的算力相等，允许从每组各选出一个CPU进行一次交换，求两组服务器中，用于交换的CPU的算力，并且要求从A组服务器中选出的CPU，算力尽可能小。
 *
 * 输入描述
 * 第一行输入为L1和L2，以空格分隔，L1表示A组服务器中的CPU数量，L2表示B组服务器中的CPU数量
 * 第二行输入为A组服务器中各个CPU的算力值，以空格分隔。
 * 第三行输入为B组服务器中各个CPU的算力值，以空格分隔。
 * 1 <= L1 <= 10000
 * 1 <= L2 <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 *
 *
 * 输出描述
 * 对于每组测试数据，输出两个整数，以空格分隔，依次表示A组选出的CPU算力、B组选出的CPU算力，要求从A组选出的CPU的算力尽可能小。
 *
 *
 * 补充说明
 * 保证两组服务器的初始总算力不同，答案肯定存在。
 *
 *
 * 示例一
 * 输入
 * 2 2
 * 1 1
 * 2 2
 *
 * 输出
 * 1 2
 *
 * 示例二
 * 输入
 * 3 4
 * 1 2 3
 * 1 2 3 4
 *
 * 输出
 * 1 3
 * 说明
 * 有两种可能的选择，选择A组中的1和B组中的3进行交换，或者选择A组中的2和B组中的4进行交换，但由于要求A组选择的算力要尽可能地小，所以选择前者。
 *
 */
public class Work2024DCPUsuanli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //获取初始两个数组的大小
        Integer nA = scanner.nextInt();
        Integer nB = scanner.nextInt();
        int[] A = new int[nA];
        int[] B = new int[nB];
        for (int i = 0; i < nA; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < nB; i++) {
            B[i] = scanner.nextInt();
        }
        int sumA = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        int sumB = 0;
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
        }
        int avg = (sumA+sumB)/2;
        ArrayList<Integer> resList = new ArrayList<>();
        for (int i : B) {
            resList.add(i);
        }
        int aAns = Integer.MAX_VALUE;
        for (int i : A) {
            if(resList.contains(avg-sumA+i)){
                aAns = Math.min(aAns,i);
            }
        }
        int bAns = avg-sumA+aAns;
        System.out.println(aAns+" "+bAns);
    }

    public void test1(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] A = new int[a];
        int[] B = new int[b];
        for (int i = 0; i < a; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < b; i++) {
            B[i] = scanner.nextInt();
        }
        int sumA = 0;
        for (int i : A) {
            sumA += i;
        }
        int sumB = 0;
        for (int i : B) {
            sumB += i;
        }
        int avg = (sumA+sumB)/2;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : B) {
            list.add(i);
        }
        int ansA = Integer.MAX_VALUE;
        for (int i : A) {
            if(list.contains(avg-sumA+i)){
                ansA = Math.min(ansA,i);
            }
        }
        int ansB = avg-sumA+ansA;
        System.out.println(ansA+" "+ansB);
    }

}
