package com.yuan.test.controller;

import java.util.Stack;

public class Code {


    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    /**
     * LC20. 有效的括号
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        //如果字符是奇数则不用判断
        if(s.length()%2 == 1){
            return false;
        }
        //字符转为数组
        char[] charArray = s.toCharArray();
        //创建栈存放字符
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <charArray.length; i++) {
            //获取当前字符
            char c = charArray[i];
            if(c == '('){
                stack.push('(');
            } else if (c == '[') {
                stack.push('[');
            } else if (c == '{') {
                stack.push('{');
            }else {
                //否则字符就是)]}中的一种
                if (stack.isEmpty()){
                    return false;
                }
                //如果栈不为空 获取栈顶元素
                char top = stack.peek();
                //将栈顶元素与此时的c进行比较,如果相同则将栈顶移除
                if(top == '('&&c == ')'||top =='['&&c==']'||top=='{'&&c=='}'){
                    stack.pop();
                }else {
                    //如果不相同说明不匹配返回false
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
