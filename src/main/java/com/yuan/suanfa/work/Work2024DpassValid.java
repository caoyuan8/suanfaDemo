package com.yuan.suanfa.work;


import java.util.Scanner;
import java.util.Stack;

/**
 * 2024D-密码输入检测
 *
 * 题目描述
 * 给定用户密码输入流 input，输入流中字符'<'表示退格，可以清除前一个输入的字符，请你编写程序，输出最终得到的密码字符，并判断密码是否满足如下的密码安全要求。
 * 密码安全要求如下：
 * 1. 密码长度>=8;
 * 2. 密码至少需要包含 1 个大写字母;O
 * 3. 密码至少需要包含 1 个小写字母;
 * 4. 密码至少需要包含 1 个数字;
 * 5. 密码至少需要包含 1 个字母和数字以外的非空白特殊字符
 * 注意空串退格后仍然为空串，且用户输入的字符串不包含'<'字符和空白字符。
 *
 * 输入描述
 * 用一行字符串表示输入的用户数据，输入的字符串中'<'字符标识退格，用户输入的字符串不包含空白字符，例如：ABC<c89%000<
 *
 * 输出描述
 * 输出经过程序处理后，输出的实际密码字符串，并输出改密码字符串是否满足密码安全要求。两者间由','分隔， 例如：ABc89%00,true
 *
 * 示例
 * 输入
 * ABC<c89%000<
 * 输出
 * ABc89%00,true
 *
 */
public class Work2024DpassValid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c!='<'){
                stack.push(c);
            } else if (c == '<'&& !stack.isEmpty()) {
                stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.insert(0,stack.pop());
        }
        boolean a = res.length() >= 8;
        boolean b = false;
        boolean c = false;
        boolean d = false;
        boolean e = false;
        for (char c1 : res.toString().toCharArray()) {
            if(Character.isUpperCase(c1)){
                b = true;
            } else if (Character.isLowerCase(c1)) {
                c = true;
            }else if (Character.isDigit(c1)) {
                d = true;
            }else if (!Character.isLetterOrDigit(c1)&&!Character.isWhitespace(c1)) {
                e = true;
            }
        }
        if(a&&b&&c&&d&&e){
            System.out.println(res.toString()+",true");
        }else{
            System.out.println(res.toString()+",false");
        }

    }

}
