package com.yuan.suanfa.practice;


import java.util.Stack;

/**
 * LC232.用栈实现队列
 *
 *请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 *
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *
 *
 * 提示：
 *
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 *
 */
public class CodeLC232 {

    //负责进栈操作
    Stack<Integer> stackIn;
    //负责出栈操作
    Stack<Integer> stackOut;

    //初始化
    public CodeLC232() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        // 新添加的元素添加到 stackIn 中
        stackIn.push(x);
    }

    public int pop() {
        // 如果 stackOut 为空，首先需要将 stackIn 中的所有元素添加到 stackOut 中
        // 注意 stackIn 是栈，栈的性质是先进后出，后进先出，所以是不断的将 stackIn 中的栈顶元素添加进 stackOut 中
        if (stackOut.isEmpty()) {
            // 通过 while 循环将 stackIn 中的所有元素都取出
            while (!stackIn.isEmpty()) {
                // stackOut 不断的添加 stackIn 的栈顶元素
                stackOut.push(stackIn.pop());
            }
        }
        // 此时，stackIn 已经为空，直接「移除」 stackOut 的栈顶元素
        return stackOut.pop();
    }

    public int peek() {
        // peek 和 pop 的区别在于是返回栈顶元素而非删除栈顶元素
        // 如果 stackOut 为空，首先需要将 stackIn 中的所有元素添加到 stackOut 中
        // 注意 stackIn 是栈，栈的性质是先进后出，后进先出，所以是不断的将 stackIn 中的栈顶元素添加进 stackOut 中
        if (stackOut.isEmpty()) {
            // 通过 while 循环将 stackIn 中的所有元素都取出
            while (!stackIn.isEmpty()) {
                // stackOut 不断的添加 stackIn 的栈顶元素
                stackOut.push(stackIn.pop());
            }
        }

        // peek 和 pop 的区别在于是返回栈顶元素而非删除栈顶元素
        // 此时，stackIn 已经为空，直接「返回」 stackOut 的栈顶元素
        return stackOut.peek();
    }

    public boolean empty() {
        // 队列是否为空，判断 stackIn 和 stackOut 是否同时不存在元素
        return stackIn.isEmpty() && stackOut.isEmpty();
    }




}
