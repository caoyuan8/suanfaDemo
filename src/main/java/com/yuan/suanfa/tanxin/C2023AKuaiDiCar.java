package com.yuan.suanfa.tanxin;

import java.util.Arrays;
import java.util.Scanner;

/**
 *【贪心】2023A-快递货车
 * 题目
 * 一辆具有最大载重量的运送快递的货车正在运送若干重量不一的快递中，试计算出该货车最多能运载的快递数目。快递数量最多为1000个，货车的最大载重最为50000。
 * 注：不考虑快递的体积。
 * 输入
 * 第一行输入每个快递的重量，用英文逗号隔开，如 5,10,2,11
 * 第二行输入货车的最大载重量，如 20
 * 输出
 * 输出最多能装多少个快递，如 3
 * 示例一
 * 输入
 * 5,10,2,11
 * 20
 * 输出
 * 3
 *
 */
public class C2023AKuaiDiCar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        int target = scanner.nextInt();
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(nums);
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            if(sum>target){
                break;
            }
            ans++;
        }
        System.out.println(ans);
    }

}
