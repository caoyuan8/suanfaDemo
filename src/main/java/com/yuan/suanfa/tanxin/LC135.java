package com.yuan.suanfa.tanxin;


import java.util.Arrays;

/**
 * LC135. 分发糖果
 *
 *n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *
 *
 * 提示：
 *
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 *
 */
public class LC135 {


    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 0, 2}));
        System.out.println(candy(new int[]{1, 2, 2}));
    }

    public static int candy(int[] ratings) {
        // 存储每个孩子的糖果
        int[] candys = new int[ratings.length];
        // 先给所有孩子 1 颗糖
        Arrays.fill(candys, 1);
        // 从左至右遍历数组 ratings
        for(int i = 1; i < ratings.length; i++){
            // 如果发现当前孩子的评分比【左边】的更高
            if(ratings[i] > ratings[i - 1]){
                // 那么当前孩子的糖果数量需要比【左边】孩子的糖果数量多 1 个
                candys[i] = candys[i - 1] + 1;
            }
        }
        // 记录糖果数量，初始为最右边的值
        int result = candys[ratings.length - 1];;
        // 从右至左遍历数组 ratings
        for(int i = ratings.length - 2; i >= 0; i--) {
            // 如果发现当前孩子的评分比【右边】的更高
            if(ratings[i] > ratings[i + 1]){
                // 那么当前孩子的糖果数量需要比【右边】孩子的糖果数量多 1 个
                // 当前孩子在第一轮循环中已经设置了值
                // 所以取这两个值的最大值
                // 这样同时满足左规则和右规则
                candys[i] = Math.max( candys[i + 1] + 1  , candys[i]) ;
            }
            // candys[i] 已经是符合左规则和右规则的值了
            // 累加到 result 上面
            result += candys[i];
        }
        // 返回结果
        return result;
    }
}
