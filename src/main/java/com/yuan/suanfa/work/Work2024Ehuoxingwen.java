package com.yuan.suanfa.work;


import java.util.Scanner;
import java.util.Stack;

/**
 * 2024E-火星文计算2
 *
 *题目描述
 * 已知火星人使用的运算符号为 # 、$
 * 他们与地球人的等价公式如下：
 * - x#y = 4*x+3*y+2
 * - x$y = 2*x+y+3
 * 其中 x y 是无符号整数
 * 地球人公式按照 C 语言规则进行计算
 * 火星人公式中 # 符优先级高于 $
 * 相同的运算符按从左到右的顺序运算
 *
 * 输入描述
 * 火星人字符串表达式结尾不带回车换行
 *
 * 输入的字符串说明：
 * 字符串为仅有无符号整数和操作符组成的计算表达式
 * 1. 用例保证字符串中操作数与操作符之间没有任何分隔符
 * 2. 用例保证操作数取值范围为 32 位无符号整数
 * 3. 保证输入以及计算结果不会出现整型溢出
 * 4. 保证输入的字符串为合法的求值报文
 * 例如: 123#4$5#76$78
 * 5. 保证不会出现非法的求值报文
 * 例如：
 * - #4$5 这种缺少操作数；
 * - 4$5# 这种缺少操作数；
 * - 4#$5 这种缺少操作数；
 * - 4 $5 有空格；
 * - 3+4-5*6/7 有其他操作符；
 * - 12345678987654321$54321 32 位整数溢出
 *
 * 输出描述
 * 根据火星人字符串输出计算结果，结尾不带回车换行
 *
 * 示例
 * 输入
 * 7#6$5#12
 * 输出
 * 157
 * 说明
 * 7#6$5#12=(4*7+3*6+2)$5#12
 *         =48$5#12
 *         =48$(4*5+3*12+2)
 *         =48$58
 *         =2*48+58+3
 *         =157
 *
 */
public class Work2024Ehuoxingwen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //创建栈储存数字结果
        Stack<Integer> stack = new Stack<>();
        //优先级为#>$,判断当前操作符是否为#
        boolean flag = false;
        //处理连续的数字
        int num = 0;
        //这里是为了让最后12读完能进到else里 把12压入到栈中,否则进不去
        s += " ";
        for (char c : s.toCharArray()) {
            if(Character.isDigit(c)){
                num = num*10+Character.getNumericValue(c);
            }else{
                stack.push(num);
                num = 0;
                if(flag){
                    //弹出栈顶2个元素进行计算并将结果压回栈中
                    Integer pop = stack.pop();
                    Integer pop1 = stack.pop();
                    stack.push(calWell(pop1,pop));
                }
                flag = c == '#';
            }
        }
        //获得栈的第一个数字结果(从下往上即栈底)
        Integer ans = stack.get(0);
        for (int j = 1; j < stack.size(); j++) {
            Integer i1 = stack.get(j);
            ans = calDollar(ans,i1);
        }
        System.out.println(ans);
    }

    // 处理 "#" 符号的计算函数，接收两个参数 x 和 y
    private static int calWell(int x, int y) {
        return 4 * x + 3 * y + 2; // 按照题目中的规则进行计算
    }

    // 处理 "$" 符号的计算函数，接收两个参数 x 和 y
    private static int calDollar(int x, int y) {
        return 2 * x + y + 3; // 按照题目中的规则进行计算
    }



}
