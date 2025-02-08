package com.yuan.suanfa.work;

import java.util.Stack;

/**
 * LC1047. 删除字符串中的所有相邻重复项
 *
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * 提示：
 * 1. 1 <= S.length <= 20000
 * 2. S 仅由小写英文字母组成。
 *
 */
public class LC1047 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        // 1、两个相邻且相同字符会被同时删除
        // 2、删除字符串中两个相邻并且相同的字符后可能会产生一组新的相邻并且相同的字符，需要继续删除
        // 说明需要记录之前的元素，将最靠近现在访问的元素与现在正在访问的元素进行对比
        // 使用栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            Character c = s.charAt(i);
            //1、如果栈为空，直接把当前访问的元素添加进去
            if(stack.empty()) {
               stack.add(c);
                // 2、如果栈不为空，并且栈顶元素不等于正在访问的元素
            }else if(stack.peek()!=c){
                stack.add(c);
                // 3、如果栈不为空，并且栈顶元素等于正在访问的元素
            }else {
                // 说明这两个元素应该被删除，那么不仅当前这个元素无法加入到栈，同时和这个元素相同的栈顶元素得从栈中移除
                stack.pop();
            }
        }
        // 把栈中的元素转化为字符串的形式
        StringBuilder res = new StringBuilder();
        // 遍历栈，把一个个元素都添加到 res 上
        while (!stack.empty()){
            // 把一个个元素都添加到 res 上
            res.append(stack.pop());
        }
        // 由于上述遍历过程，是从栈顶开始添加的，所以最好需要翻转一下
        return res.reverse().toString();
    }

}
