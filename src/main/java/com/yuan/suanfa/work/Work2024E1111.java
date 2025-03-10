package com.yuan.suanfa.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 【双指针】2024E-双十一
 *
 * 题目描述
 * 双十一众多商品进行打折销售，小明想购买一些自己心仪的商品，但由于受购买资金限制，所以他决定从众多心意商品中购买 3 件，而且想尽可能的花完资金，现在请你设计一个程序帮助小明计算尽可能花费的最大资金额。
 * 输入
 * 第一行为整型数组 M，数组长度小于100，数组元素记录单个商品的价格；
 * 单个商品价格小于1000；
 * 第二行输入为购买资金的额度R，R < 100000。
 * 输出
 * 输出为满足上述条件的最大花费额度
 * 如果不存在满足上述条件的商品请返回-1
 * 示例一
 * 输入
 * 23,26,36,27
 * 78
 *
 * 23    26   27    36
 * i     left=i+1   right=n-1
 * first second     third
 * 输出
 * 76
 *
 * 示例二
 * 输入
 * 23,30,40
 * 26
 * 输出
 * -1
 *
 *
 */
public class Work2024E1111 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        for (String string : split) {
            list.add(Integer.parseInt(string));
        }
        int target = scanner.nextInt();
        int ans = -1;
        int n = list.size();
        Collections.sort(list);
/*        if(n < 3){
            System.out.println(ans);
        }*/
        for (int i = 0; i < n-2; i++) {
            if (list.get(i) + list.get(i + 1) + list.get(i + 2) > target) {
                break;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = list.get(i) + list.get(left) + list.get(right);
                if (sum <= target) {
                    ans = Math.max(ans, sum);
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(ans);
    }


}
