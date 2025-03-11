package com.yuan.suanfa.tanxin;


/**
 *
 *LC605. 种花问题
 *
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 *
 *
 */
public class LC605 {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
// 遍历数组，在遍历过程中，采取贪心的思路，并不需要【每个位置】都去查看是否可以种花
        // 1、当前位置已经种花，那么后一个位置明显不能种花，可以跳过去
        // 2、当前位置没有种花，需要考虑后面一个位置是否种花
        for( int i = 0 ; i < flowerbed.length && n > 0;){
            // 1、当前位置已经种花，那么后一个位置明显不能种花，可以跳过去
            // 所以让 i 执行加 2 操作，跳过了加 1 后的那个位置
            if(flowerbed[i] == 1){
                // 让 i 执行加 2 操作
                i += 2;
                // 2、说明当前位置没有种花 flowerbed[i] == 0
                // 3、如果这个位置是数组的最后一个位置，说明后一个位置不存在，没有限制，说明 flowerbed[i] 可以种花
                // 4、如果这个位置【不是】数组的最后一个位置，那么只有后一个位置【没有种花】，才有资格在 flowerbed[i] 位置种花
            }else if(i == flowerbed.length - 1 || flowerbed[i + 1] == 0){
                // 以上两种条件都可以在 flowerbed[i] 位置种花
                // 成功之后，所需目标减 1
                n--;
                // 在 flowerbed[i] 位置种花之后，i + 1 位置不需要去考虑了，因为它明显不能种花，可以跳过去
                // 让 i 执行加 2 操作
                i += 2;
                // 5、说明当前位置没有种花 flowerbed[i] == 0
                // 6、但是后一个位置已经种花了，那么当前位置无法采取种花操作
            }else{
                // i + 1 位置已经种花，不用再去访问一遍
                // i + 2 位置考虑到 i + 1 位置已经种花，所以也无法种花，不用再去访问
                // 让 i 执行加 3 操作
                i += 3;
            }
        }
        // 最后查看是否用完了 n
        return n <= 0;
    }

}
