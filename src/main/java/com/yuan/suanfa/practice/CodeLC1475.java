package com.yuan.suanfa.practice;


import java.util.Arrays;
import java.util.Stack;

/**
 * LC1475.商品折扣后的最终价格
 *
 *给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 * 示例 1：
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 * 解释：
 * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 * 商品 3 和 4 都没有折扣。
 * 示例 2：
 * 输入：prices = [1,2,3,4,5]
 * 输出：[1,2,3,4,5]
 * 解释：在这个例子中，所有商品都没有折扣。
 * 示例 3：
 * 输入：prices = [10,1,1,6]
 * 输出：[9,0,1,6]
 *
 * 提示：
 * - 1 <= prices.length <= 500
 * - 1 <= prices[i] <= 10^3
 *
 */
public class CodeLC1475 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices(new int[]{8,4,6,2,3})));
        System.out.println(Arrays.toString(finalPrices(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(finalPrices(new int[]{10,1,1,6})));
    }

    public static int[] finalPrices(int[] prices) {
        //原数组的长度
        int len = prices.length;
        //初始化结果数组用于返回
        int[] ans = new int[len];
        //创建一个栈，用于存储价格
        Stack<Integer> stack = new Stack<>();
        //从后往前遍历,从后往前遍历是为了找到比当前价格小的价格，如果找到就减去当前价格，如果没有找到就直接返回当前价格
        for (int i = len-1; i >=0 ; i--) {
            //获取当前的价格
            int price = prices[i];
            //如果栈不为空，并且栈顶元素大于当前价格，则将栈顶元素弹出，直到栈为空或者栈顶元素小于当前价格
            while (!stack.isEmpty()&&stack.peek()>price){
                stack.pop();
            }
            //计算当前价格与栈顶元素的差值，如果栈为空，则当前价格没有折扣，否则当前价格有折扣
            ans[i] = stack.isEmpty()?price:price-stack.peek();
            //将当前价格入栈
            stack.push(price);
        }
        //返回结果数组
        return ans;
    }


}
