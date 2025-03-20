package com.yuan.suanfa.mockTest.deque;


import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 篮球游戏
 */
public class C2024ELanQiuGame {


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //进队顺序
        String[] pushInput = scanner.nextLine().split(",");
        //出队顺序
        String[] popInput = scanner.nextLine().split(",");
        scanner.close();
        int[] pushList = new int[pushInput.length];
        int[] popList = new int[popInput.length];

        for (int i = 0; i < pushInput.length; i++) {
            pushList[i] = Integer.parseInt(pushInput[i]);
        }

        for (int i = 0; i < popInput.length; i++) {
            popList[i] = Integer.parseInt(popInput[i]);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        //出队序列的索引
        int popIdx = 0;

        for (int pushNum : pushList) {
            q.add(pushNum);
            while (!q.isEmpty()) {
                if (q.peek().equals(popList[popIdx])) {
                    q.poll();
                    popIdx++;
                    ans.append("L");
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
