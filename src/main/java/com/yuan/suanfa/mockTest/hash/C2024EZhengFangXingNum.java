package com.yuan.suanfa.mockTest.hash;


import java.util.*;

/**
 *
 * 正方形的数量
 *
 */
public class C2024EZhengFangXingNum {

    // 计算以 (x1, y1) 和 (x2, y2) 作为对角线的正方形
    public static int check(int x1, int y1, int x2, int y2, Set<String> pointsSet) {
        // 计算两个关键值
        int delta1 = (x2 - x1) + (y2 - y1);
        int delta2 = (x2 - x1) - (y2 - y1);

        // 如果 delta1 或 delta2 不能被2整除，则返回0，避免非整数坐标
        if (delta1 % 2 != 0 || delta2 % 2 != 0) {
            return 0;
        }

        // 计算 P3 和 P4 坐标
        int a = delta1 / 2;
        int b = delta2 / 2;

        int x3 = x1 + b;
        int y3 = y1 + a;
        int x4 = x1 + a;
        int y4 = y1 - b;

        // 生成哈希集合的查询字符串（确保整数计算）
        String key3 = x3 + "," + y3;
        String key4 = x4 + "," + y4;

        // 检查 P3 和 P4 是否在哈希集合中
        if (pointsSet.contains(key3) && pointsSet.contains(key4)) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取点的个数

        List<int[]> pointsList = new ArrayList<>();
        Set<String> pointsSet = new HashSet<>();

        // 读取坐标点
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            pointsList.add(new int[]{x, y});
            pointsSet.add(x + "," + y); // 存入哈希集合，方便快速查询
        }
        scanner.close();

        int ans = 0;

        // 两两组合计算以 P1P2 作为对角线的正方形
        for (int i = 0; i < n; i++) {
            int x1 = pointsList.get(i)[0];
            int y1 = pointsList.get(i)[1];

            for (int j = i + 1; j < n; j++) {
                int x2 = pointsList.get(j)[0];
                int y2 = pointsList.get(j)[1];

                ans += check(x1, y1, x2, y2, pointsSet);
            }
        }

        // 由于每个正方形被计算了2次，因此最终结果除以2
        System.out.println(ans / 2);
    }


}
