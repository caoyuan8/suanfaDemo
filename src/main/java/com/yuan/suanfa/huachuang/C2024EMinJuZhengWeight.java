package com.yuan.suanfa.huachuang;


import java.util.*;

/**
 * 2024E-最小矩阵宽度
 *题目描述
 * 给定一个矩阵，包含N*M个整数，和一个包含K个整数的数组，现在要求在这个矩阵中找一个宽度最小的子矩阵，要求子矩阵包含数组中所有的整数。
 *
 *
 * 输入描述
 * 第一行输入两个正整数N，M，表示矩阵大小。
 * 接下来N行M列表示矩阵内容。下一行包含一个正整数K。下一行包含K个整数，表示所需包含的数组，K个整数可能存在重复数字。
 * 所有输入数据小于1000。
 *
 *
 * 输出描述
 * 输出包含一个整数，表示满足要求子矩阵的最小宽度，若找不到，输出-1
 *
 *
 * 示例
 * 输入
 * 2 5
 * 1 2 2 3 1
 * 2 3 2 3 2
 * 3
 * 1 2 3
 *
 * 输出
 * 2
 *
 */
public class C2024EMinJuZhengWeight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入矩阵的行数n
        int n = scanner.nextInt();
        // 输入矩阵的列数m
        int m = scanner.nextInt();
        int[][] mat = new int[n][m];
        // 输入矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        int k = scanner.nextInt();
        int[] nums = new int[k];
        // 输入数组
        for (int i = 0; i < k; i++) {
            nums[i] = scanner.nextInt();
        }
        List<Map<Integer, Integer>> colContainsList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            colContainsList.add(new HashMap<>());
        }
        //
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int val = mat[i][j];
                colContainsList.get(j).put(val, colContainsList.get(j).getOrDefault(val, 0) + 1);
            }
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> windowCountMap = new HashMap<>();
        int answer = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < m; right++) {
            for (Map.Entry<Integer, Integer> entry : colContainsList.get(right).entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                windowCountMap.put(key, windowCountMap.getOrDefault(key, 0) + value);
            }

            while (check(countMap, windowCountMap)) {
                answer = Math.min(answer, right - left + 1);

                for (Map.Entry<Integer, Integer> entry : colContainsList.get(left).entrySet()) {
                    int key = entry.getKey();
                    int value = entry.getValue();
                    windowCountMap.put(key, windowCountMap.get(key) - value);
                }

                left++;
            }
        }

        System.out.println(answer != Integer.MAX_VALUE ? answer : -1);
    }

    public static boolean check(Map<Integer, Integer> countMap, Map<Integer, Integer> windowCountMap) {
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (windowCountMap.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }


}
