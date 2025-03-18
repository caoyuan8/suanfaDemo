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
        //(sub (mul 2 4) (div 9 3))
        // 遍历字符串，逐个字符处理  转换成逆波兰表达式的形式
        StringBuilder current = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == ')') {
                // 如果当前有未处理的字符，先加入集合
                if (current.length() > 0) {
                    ops.add(current.toString());
                    current.setLength(0); // 清空StringBuilder
                }
                // 将括号加入集合
                ops.add(String.valueOf(c));
            } else if (c == ' ') {
                // 如果当前有未处理的字符，加入集合
                if (current.length() > 0) {
                    ops.add(current.toString());
                    current.setLength(0); // 清空StringBuilder
                }
            } else {
                // 将字符加入当前字符串
                current.append(c);
            }
        }

        Stack<String> stack = new Stack<>();
        boolean isError = false;

        // 遍历ops中的所有符号  此操作类似于LC150逆波兰表达式求值
        for (String ch : ops) {
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
