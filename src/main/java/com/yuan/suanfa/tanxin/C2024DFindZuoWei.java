package com.yuan.suanfa.tanxin;


import java.util.Scanner;

/**
 * 【贪心】2024D-座位调整/2024D-找座位
 *题目描述
 * 疫情期间课堂的座位进行了特殊的调整，不能出现两个同学紧挨着，必须隔至少一个空位。
 * 给你一个整数数组 desk 表示当前座位的占座情况，由若干 0 和 1 组成，其中 0 表示没有占位，1 表示占位。在不改变原有座位秩序情况下，还能安排坐几个人？
 * 输入
 * 第一行是个子数组表示作为占座情况，由若干 0 和 1 组成，其中 0 表示没有占位，1 表示占位
 * 输出
 * 输出数值表示还能坐几个人
 * 说明
 * 1 <= desk.length <= 2 * 10^4
 * 示例一
 * 输入
 * 1,0,0,0,1
 * 输出
 * 1
 *
 * 说明
 * 只有 desk[2] 的位置可以坐一个人
 *
 * 示例二
 * 输入
 * 0,0,0,0,0
 * 输出
 * 3
 *
 */
public class C2024DFindZuoWei {

    //本题和LC605种花的问题很像
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lst = scanner.nextLine().split(",");
        int ans = 0;
        int i = 0;
        while (i < lst.length) {
            if (lst[i].equals("1")) {
                i += 2;
            } else {
                if (i == lst.length - 1 || lst[i + 1].equals("0")) {
                    ans += 1;
                    i += 2;
                } else {
                    i += 3;
                }
            }
        }
        System.out.println(ans);
    }

}
