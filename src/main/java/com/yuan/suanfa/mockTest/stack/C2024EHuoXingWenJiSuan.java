package com.yuan.suanfa.mockTest.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 火星文计算
 */
public class C2024EHuoXingWenJiSuan {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Stack<Integer> stack = new Stack<>();
        //处理连续的数字
        int num = 0;
        //记录是否为#,优先级#>$,默认为false
        Boolean flag = false;
        //确保最后一个数字也能被压入栈中
        s +=  " ";
        for (char c : s.toCharArray()) {
            //如果为数字
            if(Character.isDigit(c)){
                num = num*10 + Character.getNumericValue(c);
            }else {
                //遇到了符号,将数字加入栈中,并且初始化
                stack.push(num);
                num = 0;
                if(flag){
                    Integer pop = stack.pop();
                    Integer pop1 = stack.pop();
                    stack.push(cell1(pop1,pop));
                }
                if( c == '#'){
                    flag = true;
                }else {
                    flag = false;
                }
            }
        }
        //处理#
        Integer ans = stack.get(0);
        for (int j = 1; j < stack.size(); j++) {
            Integer i1 = stack.get(j);
            ans = cell2(ans,i1);
        }
        System.out.println(ans);
    }

    /**
     * 处理#
     * @param x
     * @param y
     * @return
     */
    public static int cell1(int x,int y){
        return 4*x+3*y+2;
    }

    /**
     * 处理$
     * @param x
     * @param y
     * @return
     */
    public static int cell2(int x,int y){
        return 2*x+y+3;
    }

}
