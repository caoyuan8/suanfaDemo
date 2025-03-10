package com.yuan.suanfa.work;


/**
 * LC11-盛最多水的容器
 *
 * https://leetcode.cn/problems/container-with-most-water/description/
 */
public class LC11 {


    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        //最大面积
        int max = 0;
        int left= 0;
        int right = height.length - 1;
        while (left < right){
            int w = right-left;
            int h = Math.min(height[left],height[right]);
            int area = w*h;
            max = Math.max(max,area);
            // 如果左边的高度小于右边的高度，则左边向右移动一位，反之右边向左移动一位1
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
