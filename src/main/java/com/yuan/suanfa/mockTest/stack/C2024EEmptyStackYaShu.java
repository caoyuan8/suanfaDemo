package com.yuan.suanfa.mockTest.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 空栈压数
 */
public class C2024EEmptyStackYaShu {

    static boolean flagContinueLoop;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> nums = new Stack<>();
        String[] split = scanner.nextLine().split(" ");
        int n = split.length;
        for (String s : split) {
            nums.push(Integer.parseInt(s));
        }
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            flagContinueLoop = true;
            while (flagContinueLoop) {
                num = checkStackTop(stack, num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static int checkStackTop(Stack<Integer> stack,int num){
        int topSum = 0;
        int idx = stack.size() - 1;
        while (topSum < num && idx >= 0) {
            topSum += stack.get(idx);
            idx--;
        }
        if (topSum == num) {
            flagContinueLoop = true;
            while (stack.size() > idx + 1) {
                stack.pop();
            }
            return num * 2;
        } else {
            flagContinueLoop = false;
            return num;
        }
    }

}
