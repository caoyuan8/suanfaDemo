package com.yuan.suanfa.mockTest.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 投篮大赛
 */
public class C2023ATouLanDaSai {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        Boolean flag = false;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if(!"C".equals(s)&&!"D".equals(s)&&!"+".equals(s)){
                stack.push(Integer.parseInt(s));
            }else if("D".equals(s)&&stack.size()>=1){
                stack.push(stack.peek()*2);
            } else if("C".equals(s)&&stack.size()>=1){
                stack.pop();
            } else if ("+".equals(s)&&stack.size()>=2) {
                Integer pop = stack.pop();
                Integer pop1 = stack.pop();
                stack.push(pop1);
                stack.push(pop);
                stack.push(pop1+pop);
            }else {
                flag = true;
                break;
            }
        }
        int sum = 0;
        if(!flag){
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }
        }
        System.out.println(flag?-1:sum);
    }


}
