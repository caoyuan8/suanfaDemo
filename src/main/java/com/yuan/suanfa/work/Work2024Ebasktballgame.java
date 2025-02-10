package com.yuan.suanfa.work;


import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 2024E-篮球游戏
 *
 *题目描述
 * 幼儿园里有一个放倒的圆桶，它是一个线性结构，允许在桶的右边将篮球放入，可以在桶的左边和右边将篮球取出。每个篮球有单独的编号，老师可以连续放入一个或多个篮球，小朋友可以在桶左边或右边将篮球取出，当桶里只有一个篮球的情况下，必须从左边取出。
 * 如老师按顺序放入1、2、3、4、5 共5个编号的篮球，那么小朋友可以依次取出的编号为1、2、3、4、5或者3、1、2、4、5编号的篮球，无法取出5、1、3、2、4编号的篮球
 * 其中3、1、2、4、5的取出场景为: 连续放入1、2、3号 -> 从右边取出3号 -> 从左边取出1号 -> 从左边取出2号 -> 放入4号 -> 从左边取出4号 -> 放入5号>从左边取出5号，简单起见，我们以L表示左，R表示右，此时的篮球的依次取出序列为"RLLLL"
 * 输入描述
 * 每次输入包含一个测试用例:
 * 1、第一行的数字作为老师依次放入的篮球编号
 * 2、第二行的数字作为要检查是否能够按照放入顺序取出的篮球编号
 * 其中篮球编号用逗号进行分隔。
 *
 * 输出描述
 * 对于每个篮球的取出序列，如果确实可以获取，请打印出其按照左右方向的操作的取出顺序，如果无法获取则打印"NO"
 *
 * 备注
 * 1、1 <= 篮球的编号，篮球个数 <= 200;
 * 2、篮球上的数字不重复
 * 3、输出的结果中LR的必须为大写:
 *
 * 示例
 * 输入
 * 4,5,6,7,0,1,2
 * 6,4,0,1,2,5,7
 * 输出
 * RLRRRLL
 */
public class Work2024Ebasktballgame {
    //该题和LC946验证栈序列的思路大概一致,先判断进入首位和取出首位是否相同,相同则弹出,下标加1;否则break;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //放入顺序
        String[] pushInput = scanner.nextLine().split(",");
        //取出顺序
        String[] popInput = scanner.nextLine().split(",");
        scanner.close();
        //数组转换
        int[] pushList = new int[pushInput.length];
        int[] popList = new int[popInput.length];
        for (int i = 0; i < pushInput.length; i++) {
            pushList[i] = Integer.parseInt(pushInput[i]);
        }
        for (int i = 0; i < popInput.length; i++) {
            popList[i] = Integer.parseInt(popInput[i]);
        }
        //创建双向队列
        ArrayDeque<Integer> q = new ArrayDeque<>();
        //返回结果
        StringBuilder ans = new StringBuilder();
        //取出列表的首位下标
        int popIdx = 0;
        for (int pushNum : pushList) {
            q.add(pushNum);
            while (!q.isEmpty()) {
                //如果队列首位和取出列表的首位相同，则取出队列首位，下标加1，并记录操作方向为L
                if (q.peek().equals(popList[popIdx])) {
                    q.poll();
                    popIdx++;
                    ans.append("L");
                    //如果队列末位和取出列表的首位相同，则取出队列末位，下标加1，并记录操作方向为R
                } else if (!q.isEmpty() && q.peekLast().equals(popList[popIdx])) {
                    q.pollLast();
                    popIdx++;
                    ans.append("R");
                } else {
                    break;
                }
            }
        }

        if (ans.length() == pushList.length) {
            System.out.println(ans);
        } else {
            System.out.println("NO");
        }

    }


}
