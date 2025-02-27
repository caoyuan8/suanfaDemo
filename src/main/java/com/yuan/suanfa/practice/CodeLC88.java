package com.yuan.suanfa.practice;


/**
 *
 * LC88. 合并两个有序数组
 *
 *给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 */
public class CodeLC88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j>=0){
            // 如果nums1[i]大于nums2[j]
            if(i>=0&&nums1[i]>nums2[j]){
                //将nums1[i]赋值给nums1[k]
                nums1[k] = nums1[i];
                // 接下来去确定 k 前面一个元素应该放什么数字
                k--;
                // 此时，索引 i 需要向前移动
                i--;
                // 否则，如果 num1 中的索引位置为 i 的元素小于或者等于 num2 中索引位置为 j 的元素
            }else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }



}
