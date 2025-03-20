package com.yuan.suanfa.mockTest.deque;

import java.util.*;

/**
 * 不开心小朋友
 */
public class C2023BBuKaiXinFrind {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] children = scanner.nextLine().split(" ");
        Queue<String> waitQueue = new LinkedList<>();
        //用一个哈希表记录每一个小朋友的状态，默认值为一个长度为3的列表
        //分别表示：是否之前出现过/是否玩上了摇摇车/是否已经离开
        Map<String, List<Boolean>> childrenState = new HashMap<>();
        int playNum = 0;
        int angryNum = 0;

        for (String child : children) {
            if (!childrenState.containsKey(child)) {
                childrenState.put(child, Arrays.asList(false, false, false));
            }

            if (!childrenState.get(child).get(0)) {
                childrenState.get(child).set(0, true);
                if (playNum < n) {
                    childrenState.get(child).set(1, true);
                    playNum++;
                } else {
                    waitQueue.add(child);
                }
            } else {
                childrenState.get(child).set(2, true);
                if (childrenState.get(child).get(1)) {
                    playNum--;
                    while (!waitQueue.isEmpty() && playNum < n) {
                        String nxtChild = waitQueue.poll();
                        if (!childrenState.get(nxtChild).get(2)) {
                            childrenState.get(nxtChild).set(1, true);
                            playNum++;
                        }
                    }
                } else {
                    angryNum++;
                }
            }
        }

        System.out.println(angryNum);
    }

}
