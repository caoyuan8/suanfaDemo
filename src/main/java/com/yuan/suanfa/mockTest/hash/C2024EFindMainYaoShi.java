package com.yuan.suanfa.mockTest.hash;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * 寻找关键钥匙
 *
 */
public class C2024EFindMainYaoShi {


    /**
     * 输入abc
     * s,sdf134 A2c4b
     *
     * 输出2
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String K = scanner.nextLine();                  // 输入密码字符串K
        String[] boxes = scanner.nextLine().split(" "); // 输入箱子字符串数组boxes

        int ans = -1;                                   // 初始化答案为-1
        HashSet<Character> K_set = new HashSet<>();     // 得到密码字符串所对应的集合
        for (char ch : K.toCharArray()) {
            K_set.add(ch);
        }

        // 遍历boxes字符串中的所有索引i和字符串s
        for (int i = 0; i < boxes.length; i++) {
            String s = boxes[i];
            HashSet<Character> s_set = new HashSet<>(); // 得到字符串s中所有字母的集合，其中大写字母均转化为小写字母
            for (char ch : s.toCharArray()) {
                if (Character.isLetter(ch)) {
                    s_set.add(Character.toLowerCase(ch));
                }
            }

            if (K_set.equals(s_set)) {                   // 如果该集合与密码集合相等，则得到了符合要求的箱子编号
                ans = i + 1;                             // 注意箱子编号是从1开始的
                break;                                   // 因为只有一个箱子满足要求，所以此时直接退出循环即可
            }
        }

        System.out.println(ans);
        scanner.close();



    }


}
