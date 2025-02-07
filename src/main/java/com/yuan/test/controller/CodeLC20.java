package com.yuan.test.controller;

import java.util.Stack;

public class CodeLC20 {

    /**
     * LC20.有效的括号
     *
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     *
     * 示例 1：
     *
     * 输入：s = "()"
     *
     * 输出：true
     *
     * 示例 2：
     *
     * 输入：s = "()[]{}"
     *
     * 输出：true
     *
     * 示例 3：
     *
     * 输入：s = "(]"
     *
     * 输出：false
     *
     * 示例 4：
     *
     * 输入：s = "([])"
     *
     * 输出：true
     */

    public static void main(String[] args) {
//        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([])"));
    }

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
