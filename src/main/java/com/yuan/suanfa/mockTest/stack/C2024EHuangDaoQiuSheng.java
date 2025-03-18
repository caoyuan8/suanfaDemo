package com.yuan.suanfa.mockTest.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 荒岛求生
 */
public class C2024EHuangDaoQiuSheng {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = split.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if(num>0){
                stack.push(num);
            }else {
                while (!stack.isEmpty()&&stack.peek()>0&&num!=0){
                    if(Math.abs(num)>stack.peek()){
                        Integer pop = stack.pop();
                        num += pop;
                    } else if (Math.abs(num) == stack.peek()) {
                        stack.pop();
                        num = 0;
                    } else if (Math.abs(num) < stack.peek()) {
                        Integer pop = stack.pop();
                        stack.push(pop+num);
                        num = 0;
                    }
                }
                if (num != 0) {
                    stack.push(num);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            result.append(stack.get(i));
            if (i < stack.size() - 1) {
                result.append(" ");
            }
        }

        System.out.println(result.toString());


    }


}
