package com.yuan.suanfa.practice;

import java.util.Stack;

/**
 * LC394. 字符串解码
 *
 *一、题目描述
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * 提示：
 * - 1 <= s.length <= 30
 * - s 由小写英文字母、数字和方括号 '[]' 组成
 * - s 保证是一个 有效 的输入。
 * - s 中所有整数的取值范围为 [1, 300]
 *
 */
public class CodeLC394 {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
    }
    public static String decodeString(String s) {
        // 创建数字栈，在遍历编码字符串过程中记录出现的数字
        Stack<Integer> numStack = new Stack<>();
        // 创建字符栈，在遍历编码字符串过程中记录出现的字符串
        Stack<StringBuilder> stringStack = new Stack<>();
        // 在访问编码字符串的过程中，用来记录访问到字符串之前出现的数字，一开始为 0
        int digit = 0;
        // 在访问编码字符串的过程中，把得到的结果存放到 res 中
        StringBuilder res = new StringBuilder();
        //遍历字符
        for (char c : s.toCharArray()) {
            //如果是数字
            if(Character.isDigit(c)){
                int i = c - '0';
                digit = digit * 10 + i;
            }else if(c>='a'&&c<='z'){
                res.append(c);
                // 如果是"["
                // 出现了嵌套的内层编码字符串，而外层的解码需要等待内层解码的结果
                // 那么之前已经扫描的字符需要存放起来，等到内层解码之后再重新使用
            }else if(c=='['){
                numStack.push(digit);
                stringStack.push(res);
                //重置
                digit = 0;
                res = new StringBuilder();
            }else if(c==']'){
                // 此时，内层解码已经有结果，需要把它和前面的字符串进行拼接
                // 第一步，先去查看内层解码的字符串需要被重复输出几次
                // 比如 e3[abc]，比如内层解码结果 abc 需要输出 3 次
                // 通过数字栈提取出次数
                int count = numStack.pop();
                // 第二步，通过字符串栈提取出之前的解码字符串
                StringBuilder outString = stringStack.pop();
                // 第三步，不断的把内层解码的字符串拼接起来
                for (int j = 0; j < count; j++) {
                    // 拼接到 outString 后面，拼接 count 次
                    outString.append(res.toString());
                }
                // 再把此时得到的结果赋值给 res
                res = outString;
            }
        }
        return res.toString();
    }


}
