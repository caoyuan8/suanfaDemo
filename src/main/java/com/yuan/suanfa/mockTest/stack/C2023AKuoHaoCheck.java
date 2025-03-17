package com.yuan.suanfa.mockTest.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 括号检查
*/
public class C2023AKuoHaoCheck {

    //利用栈,当遇到左括号的时候进栈,深度+1;遇到右括号出栈,深度-1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int ans = 0;
        int deep = 0;
        Boolean flag = false;
        if(s.length()%2!=0){
            flag = true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('||c=='{'||c == '['){
                stack.push(c);
                deep++;
                ans = Math.max(ans,deep);
            }else {
                if(stack.isEmpty()){
                    flag = true;
                    break;
                }
                Character peek = stack.peek();
                if(peek=='('&&c==')'||peek=='{'&&c=='}'||peek=='['&&c==']'){
                    stack.pop();
                    deep--;
                }
            }
        }
        System.out.println(flag?0:ans);
    }

}
