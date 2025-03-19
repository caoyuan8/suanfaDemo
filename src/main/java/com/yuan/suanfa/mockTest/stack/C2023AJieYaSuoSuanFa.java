package com.yuan.suanfa.mockTest.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 解压缩算法
 */
public class C2023AJieYaSuoSuanFa {

    //输入{A3B1{C}3}3
    //输出AAABCCCAAABCCCAAABCCC

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Stack<String> stack = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //如果是数字
            if (Character.isDigit(ch)) {
                //继续读入数字
                num = num * 10 + (ch - '0');
                //如果不是最后一个字符，并且下一个字符不是数字，则把数字压栈，并重置num为0
                if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    int repeat = num;
                    num = 0;
                    String top = stack.pop();
                    StringBuilder repeated = new StringBuilder();
                    while (repeat-- > 0) {
                        repeated.append(top);
                    }
                    stack.push(repeated.toString());
                }
            } else if (ch == '{' || Character.isLetter(ch)) {
                stack.push(String.valueOf(ch));
            } else if (ch == '}') {
                // 从栈中弹出字符串，直到遇到左括号，然后将字符串反转压回栈中
                StringBuilder strInBracket = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("{")) {
                    strInBracket.insert(0, stack.pop());
                }
                stack.pop();
                stack.push(strInBracket.toString());
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        System.out.println(result.toString());
    }


}
