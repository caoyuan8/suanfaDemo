package com.yuan.suanfa.mockTest.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 解压报文
 *
 */
public class C2024EJieYaBaoWen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> chStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        //初始化第一个数字
        int num = 0;
        for (char c : s.toCharArray()) {
            //如果是数字 计算num
            if(Character.isDigit(c)){
                num = num*10+(c-'0');
                //如果是字母 计算res
            }else if(Character.isLetter(c)){
                res.append(c);
                //如果遇到[则入栈然后初始化
            }else if(c =='['){
                numStack.push(num);
                chStack.push(res);
                num = 0;
                res = new StringBuilder();
                //遇到]需要解析
            }else if(c == ']'){
                Integer pop = numStack.pop();
                StringBuilder out = chStack.pop();
                for (int i = 0; i < pop; i++) {
                    out.append(res.toString());
                }
                res = out;
            }
        }
        System.out.println(res);


    }



}
