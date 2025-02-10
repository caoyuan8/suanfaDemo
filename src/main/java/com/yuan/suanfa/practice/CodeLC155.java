package com.yuan.suanfa.practice;

import java.util.Stack;

/**
 * LeetCode155、最小栈
 *
 *一、题目描述
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * - push(x) —— 将元素 x 推入栈中。
 * - pop() —— 删除栈顶的元素。
 * - top() —— 获取栈顶元素。
 * - getMin() —— 检索栈中的最小元素。
 * 二、题目解析
 * 由于需要在常数时间内找到最小的元素，那么说明肯定是不能使用遍历，因为遍历是 O(n) 级别的时间复杂度，那么只能使用辅助空间进行存储，这是一种空间换时间的思想。
 * 这里我们设置两个栈：普通栈和辅助栈。
 * 1. push 操作
 * 普通栈：直接添加 push 进来的值
 * 辅助栈：每次 push 一个新元素的时候，将普通栈中最小的元素 push 进辅助栈中
 * 2. pop 操作
 * 普通栈：直接移除普通栈中的栈顶元素
 * 辅助栈：判断普通栈中刚刚移除的栈顶元素值是否和此时辅助栈中的栈顶元素相同，如果是则将辅助栈中的栈顶元素移除，否则不执行操作，这样的目的是为了让辅助栈中的栈顶元素始终是普通栈中的最小值。
 * 3. top 操作
 * 普通栈：返回普通栈的栈顶元素
 * 辅助栈：不执行操作
 * 4. getMin 操作
 * 普通栈：不执行操作
 * 辅助栈：返回辅助栈的栈顶元素
 *
 */
public class CodeLC155 {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public CodeLC155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(!minStack.isEmpty()){
            Integer peek = minStack.peek();
            if(val<=peek){
                minStack.push(val);
            }
        }else {
            minStack.push(val);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        Integer peek = minStack.peek();
        if(pop == peek){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }



}
