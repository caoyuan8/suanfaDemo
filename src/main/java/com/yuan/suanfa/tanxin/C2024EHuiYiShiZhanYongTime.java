package com.yuan.suanfa.tanxin;


import java.util.*;

/**
 *【贪心】2024E-会议室占用时间
 *
 *题目描述
 * 现有若干个会议，所有会议共享一个会议室，用数组表示各个会议的开始时间和结束时间，格式为：
 * [[会议1开始时间, 会议1结束时间], [会议2开始时间, 会议2结束时间]]
 * 请计算会议室占用时间段。
 *
 * 输入描述
 * 第一行输入一个整数n，表示会议数量
 * 之后输入n行，每行两个整数，以空格分隔，分别表示会议开始时间，会议结束时间
 *
 *
 * 输出描述
 * 输出多行，每个两个整数，以空格分隔，分别表示会议室占用时间段开始和结束
 *
 * 补充说明
 * - 会议室个数范围：[1, 100]
 * - 会议室时间段：[1, 24]
 *
 * 示例一
 * 输入
 * 4
 * 1 4
 * 2 5
 * 7 9
 * 14 18
 *
 * 输出
 * 1 5
 * 7 9
 * 14 18
 * 说明
 * 输入：[[1,4],[2,5],[7,9],[14,18]]
 * 输出：[[1,5],[7,9],[14,18]]
 * 说明：时间段[1,4]和[2,5]重叠，合并为[1,5]
 *
 * 示例二
 * 输入
 * 2
 * 1 4
 * 4 5
 *
 * 输出
 * 1 5
 * 说明
 * 输入：[[1,4],[4,5]]
 * 输出：[[1,5]]
 * 说明：时间段[1,4]和[4,5]连续
 *
 */
public class C2024EHuiYiShiZhanYongTime {
    // 会议区间类
    static class Interval implements Comparable<Interval>{
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 构建区间列表
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals.add(new Interval(start, end));
        }

        // 根据起始位置排序
        Collections.sort(intervals);
        // 初始化答案列表 ans 为第一个区间
        List<Interval> ans = new ArrayList<>();
        ans.add(intervals.get(0));

        // 遍历 intervals 数组
        for (int i = 1; i < n; i++) {
            Interval lastInterval = ans.get(ans.size() - 1); // 获取上一个区间
            Interval currentInterval = intervals.get(i);

            // 若上一个区间的【终止位置】小于当前区间的【起始位置】
            if (lastInterval.end < currentInterval.start) {
                // 直接加入当前区间
                ans.add(currentInterval);
            } else {
                // 合并区间，更新上一个区间的【终止位置】
                lastInterval.end = Math.max(lastInterval.end, currentInterval.end);
            }
        }

        // 遍历 ans 并输出合并后的区间
        for (Interval interval : ans) {
            System.out.println(interval.start + " " + interval.end);
        }

        scanner.close();
    }

}
