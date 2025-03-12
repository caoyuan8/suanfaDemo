package com.yuan.suanfa.tanxin;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 【DP/贪心】2024E-观看文艺汇演
 *
 *某公园将举行多场文艺表演，很多演出都是同时进行，一个人只能同时观看一场演出，且不能迟到早退，由于演出分布在不同的演出场地，所以连续观看的演出最少有 15 分钟的时间间隔，小明是一个狂热的文艺迷，想观看尽可能多的演出。现给出演出时间表，请帮小明计算他最多能观看几场演出。
 * 输入
 * 第一行为一个数 N，表示演出场数，1 <= N <= 1000。
 * 接下来 N 行，每行两个空格分割的整数，第一个整数 T 表示演出的开始时间，第二个整数 L 表示演出的持续时间，T 和 L 的单位为分钟，0 <= T <= 1440, 0 < L <= 100。
 * 输出
 * 最多能观看的演出场数。
 * 示例一
 * 输入
 * 2
 * 720 120
 * 840 120
 * 输出
 * 1
 * 说明
 * 第一场演出开始时间是第720分钟，经过120分钟演出结束，即第840分钟结束，此时还需要15分钟的间隔时间，即要等到第855分钟才可以看下一场演出，故来不及看第二场在第840分钟开始的演出。最多只能看1场演出。
 *
 * 示例二
 * 输入
 * 2
 * 20 60
 * 100 60
 * 输出
 * 2
 * 说明
 * 第一场演出开始时间是第20分钟，经过60分钟演出结束，即第80分钟结束，此时还需要15分钟的间隔时间，即要等到第95分钟才可以看下一场演出，第二场演出在第100分钟开始的演出，赶得上观看第二场演出。最多可以观看2场演出。
 *
 * 示例三
 * 输入
 * 4
 * 10 20
 * 100 20
 * 150 60
 * 80 40
 * 输出
 * 3
 *
 */
public class C2024EViewWenYiHuiYan {

    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Interval other) {
            return this.start - other.start;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int start = scanner.nextInt();
            int during = scanner.nextInt();
            int end = start + during + 15;
            intervals.add(new Interval(start, end));
        }
        Collections.sort(intervals);
        int ans = 0;
        // 前一次结束时间
        int preEnd = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            int start = interval.start;
            int end = interval.end;
            //如果当前的开始时间大于等于前一次结束时间，则说明可以观看，更新preEnd为当前结束时间，ans加1
            if (start >= preEnd) {
                ans++;
                preEnd = end;
                // 如果当前的开始时间小于前一次结束时间，则说明不能观看，更新preEnd为当前结束时间
            } else if (start < preEnd && preEnd <= end) {
                continue;
            } else if (preEnd > end) {
                preEnd = end;
            }
        }

        System.out.println(ans);
    }

}
