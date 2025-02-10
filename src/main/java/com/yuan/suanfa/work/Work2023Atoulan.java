package com.yuan.suanfa.work;

import java.util.Scanner;
import java.util.Stack;

/**
 * 【栈】2023A-投篮大赛
 *
 *题目描述
 * 你现在是一场采用特殊赛制投篮大赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * 1. 整数 x 表示本回合新获得分数 x
 * 2. + 表示本回合新获得的得分是前两次得分的总和。
 * 3. D 表示本回合新获得的得分是前一次得分的两倍。
 * 4. C 表示本回合没有分数，并且前一次得分无效，将其从记录中移除。
 * 请你返回记录中所有得分的总和。
 * 输入
 * 输入为一个字符串数组
 * 输出描述
 * 输出为一个整形数字
 * 备注
 * 1. 1 ≤ ops.length ≤ 1000
 * 2. ops[i] 为 C、D、+，或者一个表示整数的字符串。整数范围是 [−3×10^4,3×10^4]
 * 3. 需要考虑异常的存在，如有异常情况，请返回-1：
 * 4. 对于 + 操作，题目数据不保证记录此操作时前面总是存在两个有效的分数
 * 5. 对于 C 和 D 操作，题目数据不保证记录此操作时前面存在一个有效的分数
 * 6. 题目输出范围不会超过整型的最大范围
 * 示例一
 * 输入
 * 5 2 C D +
 * 输出
 * 30
 * 说明
 * 5 记录加 5 ，记录现在是 [5]
 * 2 记录加 2 ，记录现在是 [5, 2]
 * C 使前一次得分的记录无效并将其移除，记录现在是 [5].
 * D 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
 * + 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
 * 所有得分的总和 5 + 10 + 15 = 30
 * 示例二
 * 输入
 * 5 -2 4 C D 9 + +
 * 输出
 * 27
 * 说明
 * 5 记录加 5 ，记录现在是 [5]
 * -2 记录加 -2 ，记录现在是 [5, -2]
 * 4 记录加 4 ，记录现在是 [5, -2, 4]
 * C 使前一次得分的记录无效并将其移除，记录现在是 [5, -2]
 * D 记录加 2 * -2 = -4 ，记录现在是 [5, -2, -4]
 * 9 记录加 9 ，记录现在是 [5, -2, -4, 9]
 * + 记录加 -4 + 9 = 5 ，记录现在是 [5, -2, -4, 9, 5]
 * + 记录加 9 + 5 = 14 ，记录现在是 [5, -2, -4, 9, 5, 14]
 * 所有得分的总和 5 + -2 + -4 + 9 + 5 + 14 = 27
 * 示例三
 * 输入
 * 1
 * 输出
 * 1
 * 示例四
 * 输入
 * +
 * 输出
 * -1
 *
 */
public class Work2023Atoulan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ops = scanner.nextLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        boolean isError = false;
        for (String op : ops) {
            if(!op.equals("C")&&!op.equals("D")&&!op.equals("+")){
                stack.push(Integer.parseInt(op));
            } else if (op.equals("D")&&stack.size()>=1) {
                stack.push(stack.peek()*2);
            } else if (op.equals("C")&&stack.size()>=1) {
                stack.pop();
            } else if (op.equals("+")&&stack.size()>1){
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2);
                stack.push(pop1);
                stack.push(pop1+pop2);
            } else {
                isError = true;
                break;
            }
        }
        int sum = 0;
        if(!isError){
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }
        }
        System.out.println(isError?-1:sum);
        scanner.close();
    }


}
