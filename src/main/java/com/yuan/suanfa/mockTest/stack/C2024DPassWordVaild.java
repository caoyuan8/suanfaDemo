package com.yuan.suanfa.mockTest.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 密码输入检测
 */
public class C2024DPassWordVaild {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c!='<'){
                stack.push(c);
            } else if (c == '<' && !stack.isEmpty()) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        boolean a = sb.length() >= 8;
        boolean b = false;
        boolean c = false;
        boolean d = false;
        boolean e = false;
        for (char c1 : sb.toString().toCharArray()) {
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
            System.out.println(sb.toString()+",true");
        }else{
            System.out.println(sb.toString()+",false");
        }

    }

}
