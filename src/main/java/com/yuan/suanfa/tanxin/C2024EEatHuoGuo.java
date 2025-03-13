package com.yuan.suanfa.tanxin;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 2024E-吃火锅
 *
 *题目描述
 * 入职后，导师会请你吃饭，你选择了火锅。火锅里会在不同时间下很多菜，不同食材要煮不同时间，才能变得刚好合适，你希望吃到最多的刚好合适的菜，但是你的手速不够快，用m代替手速，即每次下手捞菜后至少要过m秒才能再捞（每次只能捞一个），那么用最合理的策略，最多能吃到多少刚好合适的菜。
 *
 * 输入描述
 * 第一行两个整数n，m。其中n代表往锅里下菜的个数，m代表手速。
 * 接下来有n行，每行有两个数x，y。代表第x秒下的菜过y秒才能变得刚好合适
 * （1 < m, n < 1000），（1 < x, y < 1000）
 *
 * 输出描述
 * 输出一个整数代表用最合理的策略，最多能吃到刚好合适的菜的数量。
 *
 * 示例一
 * 输入
 * 2 1
 * 1 2
 * 2 1
 * 输出
 * 1
 * 说明
 * 一共下了两个菜，在第一秒下的菜，需要到第三秒吃。在第二秒下的菜，也要到第三秒吃，所以只能吃一个.
 *
 * 示例二
 * 输入
 * 3 1
 * 1 2
 * 1 3
 * 2 3
 * 输出
 * 3
 * 说明
 * 一共下了三个菜，每秒捞一个，第一个在第一秒下的菜，需要到第三秒吃，第二个在第一秒下的菜需要到第四秒吃，在第二秒下的菜，需要到第五秒吃，所以三个都能吃。
 */
public class C2024EEatHuoGuo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            list.add(x+y);
        }
        Collections.sort(list);
        int ans = 0;
        //记录上一次吃菜时间
        int preTime = 0;
        for (Integer i : list) {
            if (i-preTime >= m){
                ans++;
                preTime = i;
            }
        }
        System.out.println(ans);
    }


}
