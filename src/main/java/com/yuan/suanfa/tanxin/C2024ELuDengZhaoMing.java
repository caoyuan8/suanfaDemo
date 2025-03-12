package com.yuan.suanfa.tanxin;

import java.util.*;

/**
 * 2024E-路灯照明问题
 *
 *题目描述
 * 在一条笔直的公路上安装了N个路灯，从位置0开始安装，路灯之间间距固定为100米。每个路灯都有自己的照明半径，请计算第一个路灯和最后一个路灯之间，无法照明的区间的长度和。
 * 注意：除了第一个和最后一个路灯，第i个路灯的照明区域为[100*i-r, 100*i+r]，即照明半径表示该路灯其前后区域都能照明。
 * 输入描述
 * 第一行为一个数N，表示路灯个数，1 <= N <= 100000
 * 第二行为N个空格分隔的数，表示路灯的照明半径，1 <= 照明半径 <= 100000*100
 *
 * 输出描述
 * 第一个路灯和最后一个路灯之间，无法照明的区间的长度和
 * 示例一
 * 输入
 * 2
 * 50 50
 * 输出
 * 0
 * 说明
 * 路灯1覆盖0-50，路灯2覆盖50-100，路灯1和路灯2之间(0米-100米)无未覆盖的区间。
 * 示例二
 * 输入
 * 4
 * 50 70 20 70
 * 输出
 * 20
 * 说明
 * 路灯1 覆盖0-50，路灯2 覆盖30-170，路灯3覆盖180-220，路灯4覆盖230-370。没覆盖的区域是170-180和220-230，一共20米。
 *
 * 示例三
 * 输入
 * 4
 * 120 20 20 50
 * 输出
 * 90
 *
 * 示例四
 * 输入
 * 4
 * 120 20 20 200
 * 输出
 * 0
 */
public class C2024ELuDengZhaoMing {
    // 结构体类表示路灯的照明区域
    static class Interval implements Comparable<Interval> {
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
        // 构建照明区间数组
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int rad = scanner.nextInt();
            intervals.add(new Interval(i * 100 - rad, i * 100 + rad));
        }
        // 按照起始位置排序
        Collections.sort(intervals);
        // 初始化答案变量
        int ans = 0;
        // 初始化【上个结束位置】为第一个区间的终止位置
        int preEnd = intervals.get(0).end;
        // 遍历 intervals 数组
        for (int i = 1; i < n; i++) {
            Interval current = intervals.get(i);
            int start = current.start;
            int end = current.end;
            // 如果【上个结束位置】小于【当前开始位置】，说明出现了未覆盖区域
            if (preEnd < start) {
                ans += start - preEnd;
                preEnd = end;
            } else {
                // 更新【上个结束位置】为较大的终止位置
                preEnd = Math.max(preEnd, end);
            }
        }
        // 输出结果
        System.out.println(ans);
        scanner.close();
    }


}
