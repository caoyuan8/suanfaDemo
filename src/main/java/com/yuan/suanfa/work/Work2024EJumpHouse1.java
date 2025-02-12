package com.yuan.suanfa.work;


import java.util.HashMap;
import java.util.Scanner;

/**
 *2024E-跳房子I
 *
 *题目描述
 * 跳房子，也叫跳飞机，是一种世界性的儿童游戏。 游戏参与者需要分多个回合按顺序跳到第1格直到房子的最后一格
 * 跳房子的过程中，可以向前跳，也可以向后跳。
 * 假设房子的总格数是count，小红每回合可能连续跳的步教都放在数组steps中，请问数组中是否有一种步数的组合，可以让小红两个回合跳到最后一格? 如果有，请输出索引和最小的步数组合。
 * 注意:
 * - 数组中的步数可以重复，但数组中的元素不能重复使用。
 * - 提供的数据保证存在满足题目要求的组合，且索引和最小的步数组合是唯一的。
 *
 * 输入描述
 * 第一行输入为每回合可能连续跳的步数，它是整数数组类型。
 * 第二行输入为房子总格数count，它是int整数类型。
 *
 * 输出描述
 * 返回索引和最小的满足要求的步数组合(顺序保持steps中原有顺序)
 * 备注
 * - count ≤ 1000
 * - 0 ≤ steps.length ≤ 5000
 * - -100000000 ≤ steps ≤ 100000000
 *
 * 示例一
 * 输入
 * [1,4,5,2]
 * 7
 * 输出
 * [5,2]
 *
 *
 * 示例二
 * 输入
 * [-1,2,4,9,6]
 * 8
 * 输出
 * [-1,9]
 *
 */
public class Work2024EJumpHouse1 {

    //类似于两数之和,用目标tagret-a =b来进行计算,唯一的区别是多引入了一个索引之和最小值
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.substring(1, input.length() - 1);
        String[] split = input.split(",");
//        String[] split = scanner.nextLine().substring(1, scanner.nextLine().length() - 1).split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        //输入房子总格数即目标值
        int target = scanner.nextInt();
        //最小索引和
        int minSumIndex = Integer.MAX_VALUE;
        //结果数组
        int[] ans = new int[2];
        //构建哈希表，储存每一种步数首次出现的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int restNum = target - num;
            if(map.containsKey(restNum)){
                if(minSumIndex>i+map.get(restNum)){
                    minSumIndex = i+map.get(restNum);
                    ans[0] = restNum;
                    ans[1] = num;
                }

            }
            if(!map.containsKey(num)){
                map.put(num,i);
            }
        }
        System.out.println("[ "+ans[0]+", "+ans[1]+" ]");
    }


}
