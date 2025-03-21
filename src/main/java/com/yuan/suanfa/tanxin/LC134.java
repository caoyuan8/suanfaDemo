package com.yuan.suanfa.tanxin;


/**
 * LC134. 加油站
 *
 *在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 *
 *
 * 示例 1:
 *
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 *
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 *
 *
 * 提示:
 *
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 105
 * 0 <= gas[i], cost[i] <= 104
 *
 *
 */
public class LC134 {

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // 加油站的总数
        int n = gas.length;
        //最初默认汽车油量为0
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        if(sum<0){
            return -1;
        }
        // 一开始，默认汽车此时储备的汽油数量为 0
        int currentGas = 0;
        // 一开始，默认汽车出发位置在索引为 0 的加油站
        int i = 0;
        // index 表示最终选择的出发点，默认为 0
        int index = 0;
        // 依次遍历每个加油站，在遍历的过程中，会执行一些【跳跃操作】
        while ( i < n ){
            // 汽车在 i 号加油站加了 gas[i]
            // 开到 i + 1 号加油站消耗了 cost[i] 的汽油
            currentGas += gas[i] - cost[i];

            // 如果发现油箱里面的汽油是非负数
            // 即汽车可以开到  j 号加油站，j >= i + 1，那么就让汽车继续尝试往前开
            // 寻找出从 i 号加油站出发到最远的加油站的位置 j ，在这期间汽车是会从中间的加油站加油的
            if( currentGas >= 0){
                i++;
                // 如果发现油箱里面的汽油是负数
                // 意味着汽车无法从 i 号加油站开到 j 号加油站，同时也意味着无法从 i + 1 号加油站开到 j 号加油站
                // 那么就直接尝试让汽车从 j 号加油站开始重新出发
            }else{
                // 重新初始化汽车油箱油量
                currentGas = 0;
                // 最终选择的出发点为 j 号加油站
                index = i + 1;
                // 开始出发
                i++;
            }
        }
        return index;

    }

}
