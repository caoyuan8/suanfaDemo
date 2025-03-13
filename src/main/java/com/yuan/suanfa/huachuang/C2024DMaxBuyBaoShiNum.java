package com.yuan.suanfa.huachuang;


import java.util.Scanner;

/**
 * 2024D-最大可购买的宝石数量
 *
 *   题目描述
 * 橱窗里有一排宝石，不同的宝石对应不同的价格，宝石的价格标记为gems[i],0<=i<n，n = gems.length。宝石可同时出售0个或多个，如果同时出售多个，则要求出售的宝石编号连续；
 * 例如客户最大购买宝石个数为m，购买的宝石编号必须为gems[i],gems[i+1]...gems[i+m-1](0<=i<n,m<=n)。假设你当前拥有总面值为value的钱，请问最多能购买到多少个宝石。如无法购买宝石，则返回0。
 * 输入描述
 * 第一行输入n，参数类型为 int，取值范围：[0,10^6]，表示橱窗中宝石的总数量。
 * 之后n行分别表示从第0个到第n-1个宝石的价格，即gems[0]到gems[n-1]的价格，类型为int，取值范围：(0,1000]。
 * 之后一行输入v，类型为int，取值范围：[0,10^9]表示你拥有的钱。
 * 输出描述
 * 输出int类型的返回值，表示最大可购买的宝石数量。
 * 示例一
 * 输入
 * 7
 * 8
 * 4
 * 6
 * 3
 * 1
 * 6
 * 7
 * 10
 * 输出
 * 3
 * 说明
 * gems = [8,4,6,3,1,6,7], value = 10
 * 最多购买的宝石为gems[2]至gems[4]或者gems[3]至gems[5]
 * 示例二
 * 输入
 * 0
 * 1
 * 输出
 * 0
 * 说明
 * gems = [],value = 1
 * 因为没有宝石，所以返回0
 * 示例三
 * 输入
 * 9
 * 6
 * 1
 * 3
 * 1
 * 8
 * 9
 * 3
 * 2
 * 4
 * 15
 * 输出
 * 4
 * 说明
 * gems = [6, 1, 3, 1, 8, 9, 3, 2, 4],value = 15
 * 最多购买的宝石为gems[0]至gems[3]
 * 示例四
 * 输入
 * 9
 * 1
 * 1
 * 1
 * 1
 * 1
 * 1
 * 1
 * 1
 * 1
 * 10
 * 输出
 * 9
 * 说明
 * gems = [1, 1, 1, 1, 1, 1, 1, 1, 1], value = 10
 * 最多购买的宝石为gems[0]至gems[8]，即全部购买
 *
 * 解题思路
 * 由于购买的宝石的下标必须连续，所以题目本质上是要求找到最长的和小于value的连续子数组。由于所有元素均为正整数，所以考虑滑窗而非前缀和求和。直接考虑滑窗三问三答即可。
 *
 * 滑窗三问
 * Q1：对于每一个右指针right所指的元素num，做什么操作？
 * Q2：什么时候要令左指针left右移？left对应的元素做什么操作？while中的循环不变量是什么？
 * Q3：什么时候进行ans的更新？
 *
 * 滑窗三答
 * A1：将num计入窗口之和win_sum中。
 * A2：win_sum > max_sum，win_sum减去left_num，left右移，直到win_sum <= M成立。
 * A3：win_sum <= M时，可以更新答案，这个过程发生在将num计入窗口之和win_sum中之后。
 *
 *
 * 代码
 * Python
 * # 题目：【不定滑窗】2023C-最大可购买的宝石数量
 * # 分值：100
 * # 作者：许老师-闭着眼睛学数理化
 * # 算法：不定滑窗
 * # 代码看不懂的地方，请直接在群上提问
 *
 *
 * # 输入宝石数组长度
 * n = int(input())
 * nums = list()
 * # 循环n次，每次循环输入一个数，按顺序存入nums数组中
 * for _ in range(n):
 *     nums.append(int(input()))
 *
 * # 输入子数组的最大和
 * max_sum = int(input())
 *
 * # 初始化窗口和
 * win_sum = 0
 * # 初始化左指针和ans
 * left, ans = 0, 0
 *
 * # 进行滑窗
 * for right, num in enumerate(nums):
 *     # A1
 *     win_sum += num
 *     # A3
 *     if win_sum <= max_sum:
 *         ans = max(ans, right-left+1)
 *     # A2
 *     while win_sum > max_sum:
 *         win_sum -= nums[left]
 *         left += 1
 *
 * print(ans)
 * Java
 * import java.util.*;
 *
 * public class Main {
 *     public static void main(String[] args) {
 *         Scanner scanner = new Scanner(System.in);
 *         int n = scanner.nextInt();
 *         int[] nums = new int[n];
 *         for (int i = 0; i < n; i++) {
 *             nums[i] = scanner.nextInt();
 *         }
 *
 *         int maxSum = scanner.nextInt();
 *
 *         int windowSum = 0;
 *         int left = 0;
 *         int ans = 0;
 *
 *         for (int right = 0; right < n; right++) {
 *             windowSum += nums[right];
 *             if (windowSum <= maxSum) {
 *                 ans = Math.max(ans, right - left + 1);
 *             }
 *             while (windowSum > maxSum) {
 *                 windowSum -= nums[left];
 *                 left++;
 *             }
 *         }
 *
 *         System.out.println(ans);
 *     }
 * }
 *
 * C++
 * #include <iostream>
 * #include <vector>
 *
 * int main() {
 *     int n;
 *     std::cin >> n;
 *     std::vector<int> nums(n);
 *
 *     for (int i = 0; i < n; i++) {
 *         std::cin >> nums[i];
 *     }
 *
 *     int maxSum;
 *     std::cin >> maxSum;
 *
 *     int windowSum = 0;
 *     int left = 0;
 *     int ans = 0;
 *
 *     for (int right = 0; right < n; right++) {
 *         windowSum += nums[right];
 *         if (windowSum <= maxSum) {
 *             ans = std::max(ans, right - left + 1);
 *         }
 *         while (windowSum > maxSum) {
 *             windowSum -= nums[left];
 *             left++;
 *         }
 *     }
 *
 *     std::cout << ans << std::endl;
 *
 *     return 0;
 * }
 *
 * 时空复杂度
 * 时间复杂度：O(N)。仅需一次遍历数组nums。
 * 空间复杂度：O(1)。仅需若干常数变量。
 *
 */
public class C2024DMaxBuyBaoShiNum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int maxSum = scanner.nextInt();

        int windowSum = 0;
        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {
            windowSum += nums[right];
            if (windowSum <= maxSum) {
                ans = Math.max(ans, right - left + 1);
            }
            while (windowSum > maxSum) {
                windowSum -= nums[left];
                left++;
            }
        }

        System.out.println(ans);

    }

}
