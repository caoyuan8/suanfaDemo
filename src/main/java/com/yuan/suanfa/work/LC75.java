package com.yuan.suanfa.work;


import java.util.Arrays;

/**
 * LC75.颜色分类
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 */
public class LC75 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortColors(new int[]{2,0,2,1,1,0})));
        System.out.println(Arrays.toString(sortColors(new int[]{2,0,1}) ));
    }


    public static int[] sortColors(int[] nums) {
        // left  指向数组的开始的位置，它指向的位置左侧都是 0
        int left = 0;
        // right  指向数组的结束的位置，它指向的位置右侧都是 2
        int right = nums.length - 1;
        // index 指向数组的开始位置
        int index = 0;
        // index 向后移动，当它越过 right 时跳出循环，不需要再判断了
        // 因为此时说明 index 右侧的都已经是 2
        while(index <= right){
            // 获取当前的元素值
            int cur = nums[index];
            // 如果 index 位置上的元素值为 0
            if(cur == 0){
                // 说明是红色，要放在最前面去
                // 最前面的那个元素被 left 指着，所以让 index 指向的元素和 left 指向位置上的元素进行交换
                swap(nums,left,index);

                // index 可以向后移动
                index++;
                // left 可以向后移动，它的左侧区域都是 0
                left++;

                // 如果 index 位置上的元素值为 1
            }else if(cur == 1){
                // 说明是白色，就应该放在中间，不用管它，继续移动 index
                index++;

                // 如果 index 位置上的元素值为 2
            }else if(cur == 2){

                // 说明是蓝色，要放在最后面
                // 所以让 index 指向的元素和 right 指向位置上的元素进行交换
                swap(nums,index,right);

                // 由于原先 right 指向的元素可能为 0、1、2 这三种的任何一种
                // 交换到了 index 后，还需要继续观察一轮，所以 index 先不移动
                right--;
            }
        }
        return nums;
    }


    // 通过中间变量，交换两个元素的值
    // nums[i] 的值变为了 nums[j] 的值
    // nums[j] 的值变为了 nums[i] 的值
    private static int[] swap(int[] nums, int i ,int j){
        // 使用临时变量 temp，保存 nums[i] 的值
        int temp = nums[i];

        // nums[i] 的值修改为 nums[j] 的值
        nums[i] = nums[j];

        // nums[i] 的值修改为 temp 的值
        nums[j] = temp;
        return nums;
    }
}
