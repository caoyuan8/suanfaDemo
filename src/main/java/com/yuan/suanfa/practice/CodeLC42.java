package com.yuan.suanfa.practice;


import java.util.Stack;

/**
 * LC42. 接雨水
 *
 * https://leetcode.cn/problems/trapping-rain-water/description/
 *
 */
public class CodeLC42 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
        //如果只有两根柱子,无法形成凹槽,面积为0
        if(height.length==2){
            return 0;
        }
        // 构建一个栈，用来存储对应的柱子的下标
        // 注意：stack 存储的是下标而非高度
        Stack<Integer> stack = new Stack<>();
        //一开始雨水的面积是0
        int result = 0;
        //遍历数组
        for (int i = 0; i < height.length; i++) {
            //如果栈为空，则将当前柱子的下标入栈
            if(stack.isEmpty()){
                stack.push(i);
                // 否则的话，栈里面是有值的，我们需要去判断当前元素、栈顶元素、栈顶之前的元素能否形成一个凹槽
                // 情况一：此时的元素小于栈顶元素，凹槽的右侧不存在，无法形成凹槽
            } else if (height[i] < height[stack.peek()]) {
                // 把当前索引加入到栈中
                stack.push(i);
                // 情况二：此时的元素等于栈顶元素，也是无法形成凹槽
            } else if (height[i] == height[stack.peek()]) {
                // 把当前索引加入到栈中
                stack.push(i);
                // 情况三：此时的的元素大于栈顶元素，有可能形成凹槽
                // 注意是有可能形成，因为比如栈中的元素是 2 、2 ，此时的元素是 3，那么是无法形成凹槽的
            } else {
                // 由于栈中有可能存在多个元素，移除栈顶元素之后，剩下的元素和此时的元素也有可能形成凹槽
                // 因此，我们需要不断的比较此时的元素和栈顶元素
                // 此时的元素依旧大于栈顶元素时，我们去计算此时的凹槽面积
                // 借助 while 循环来实现这个操作
                while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                    // 1、获取栈顶的下标，bottom 为凹槽的底部位置
                    int bottom = stack.peek();
                    // 将栈顶元素推出，去判断栈顶之前的元素是否存在，即凹槽的左侧是否存在
                    stack.pop();
                    // 2、如果栈不为空，即栈中有元素，即凹槽的左侧存在
                    if (!stack.empty()) {
                        // 凹槽左侧的高度 height[stack.peek() 和 凹槽右侧的高度 height[i]
                        // 这两者的最小值减去凹槽底部的高度就是凹槽的高度
                        int h = Math.min(height[stack.peek()], height[i]) - height[bottom];
                        // 凹槽的宽度等于凹槽右侧的下标值 i 减去凹槽左侧的下标值 stack.peek 再减去 1
                        int w = i - stack.peek() - 1;
                        System.out.println("凹槽右侧-->" + i);
                        System.out.println("凹槽左侧-->" + stack.peek());
                        System.out.println("凹槽高度-->" + h);
                        System.out.println("凹槽宽度-->" + w);
                        System.out.println("凹槽面积-->" + h * w);
                        System.out.println("---------------");
                        // 将计算的结果累加到最终的结果上去
                        result += h * w;
                    }
                }
                // 栈中和此时的元素可以形成凹槽的情况在上述 while 循环中都已经判断了
                // 那么，此时栈中的元素必然不可能大于此时的元素，所以可以把此时的元素添加到栈中
                stack.push(i);
            }
        }
        return result;
    }



}
