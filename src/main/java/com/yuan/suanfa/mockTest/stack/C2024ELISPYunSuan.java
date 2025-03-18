package com.yuan.suanfa.mockTest.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 仿LISP运算
 */
public class C2024ELISPYunSuan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> ops = new ArrayList<>();
        int i = 0;
        int n = s.length();

        // 遍历字符串，将其转化为方便操作的数组形式
        while (i < n) {
            char ch = s.charAt(i);
            // 如果是数字或者负号，拼接数字
            if (Character.isDigit(ch) || ch == '-') {
                if (ops.isEmpty() || ops.get(ops.size() - 1).isEmpty()) {
                    ops.add("");  // 新的数字开始
                }
                ops.set(ops.size() - 1, ops.get(ops.size() - 1) + ch);  // 将数字添加到最后的字符串
                i++;
            }
            // 如果是字母（操作符）
            else if (Character.isLetter(ch)) {
                ops.add(String.valueOf(ch));
                i += 3;  // 跳过操作符和空格
            }
            // 如果是括号
            else if (ch == '(' || ch == ')') {
                ops.add(String.valueOf(ch));
                i++;
            }
            // 如果是空格，表示数字即将开始，添加空字符串
            else {
                ops.add("");
                i++;
            }
        }

        // 删除ops中的空字符串
        List<String> cleanedOps = new ArrayList<>();
        for (String op : ops) {
            if (!op.isEmpty()) {
                cleanedOps.add(op);
            }
        }

        Stack<String> stack = new Stack<>();
        boolean isError = false;

        // 遍历ops中的所有符号
        for (String ch : cleanedOps) {
            if (ch.equals("(") || Character.isLetter(ch.charAt(0))) {
                // 遇到左括号或操作符，入栈
                stack.push(ch);
            } else if (ch.equals(")")) {
                // 遇到右括号，执行运算
                String num2_str = stack.pop();
                String num1_str = stack.pop();
                char op = stack.pop().charAt(0);
                stack.pop();  // 弹出左括号

                int num1 = Integer.parseInt(num1_str);
                int num2 = Integer.parseInt(num2_str);
                int res = 0;

                if (op == 'a') {
                    res = num1 + num2;
                } else if (op == 's') {
                    res = num1 - num2;
                } else if (op == 'm') {
                    res = num1 * num2;
                } else if (op == 'd') {
                    if (num2 == 0) {
                        isError = true;
                        break;
                    }
                    res = (int) Math.floor(num1 / (double) num2);
                }
                stack.push(String.valueOf(res));
            } else {
                // 遇到数字，转换为整数并入栈
                stack.push(ch);
            }
        }

        // 输出结果或错误信息
        if (isError) {
            System.out.println("error");
        } else {
            System.out.println(stack.pop());
        }
    }

}
