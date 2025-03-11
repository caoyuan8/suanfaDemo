package com.yuan.suanfa.tanxin;


import java.util.Scanner;

/**
 * 【贪心】2024D-停车找车位
 *
 *题目描述
 * 停车场有一横排车位，0 代表没有停车，1 代表有车。至少停了一辆车在车位上，也至少有一个空位没有停车。
 * 为了防剐蹭，需为停车人找到一个车位，使得距停车人的车最近的车辆的距离是最大的，返回此时的最大距离。
 * 输入描述
 * 1、一个用半角逗号分割的停车标识字符串，停车标识为 0 或 1，0 为空位，1 为已停车。
 * 2、停车位最多 100 个。
 * 输出描述
 * 输出一个整数记录最大距离。
 * 示例一
 * 输入
 * 1,0,0,0,0,1,0,0,1,0,1
 * 输出
 * 2
 * 说明
 * 选择第2个车位，最近的停车位为第0个车位，距离为2。或选择第3个车位，最近的停车位为第5个车位，距离为2
 * 示例二
 * 输入
 * 1,1,0,0,1,0,0,0,0,0,1
 * 输出
 * 3
 * 说明
 * 选择第7个车位，最近的停车位为第4个车位和第10个车位，距离均为3。
 */
public class C2024DTingCarFindCheWei {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(",");
        int[] lst = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            lst[i] = Integer.parseInt(parts[i]);
        }
        int n = lst.length;
        int left = 0, right = 0;
        // 寻找最左边的1的位置left
        for (int i = 0; i < n; i++) {
            if (lst[i] == 1) {
                left = i;
                break;
            }
        }
        // 寻找最右边的1的位置right
        for (int i = n - 1; i >= 0; i--) {
            if (lst[i] == 1) {
                right = i;
                break;
            }
        }
        // 寻找最左边和最右边的1之间的距离，并更新最大距离
        int ans = Math.max(left, n - 1 - right);
        // 遍历中间的1，计算距离，并更新最大距离
        //3. 然后遍历剩下的区间lst[left+1:right+1]，每找到一个1，就计算其位置i和上一个1的位置pre之间的距离的一半(i-pre)/2，
        // 即为停在区间lst[pre:i+1]中的车，能取得的距离左右辆车的最大距离，再将该结果和原先的ans比较并更新即可。
        int pre = left;
        for (int i = left + 1; i <= right; i++) {
            if (lst[i] == 1) {
                ans = Math.max(ans, (i - pre) / 2);
                pre = i;
            }
        }

        System.out.println(ans);
    }


}
