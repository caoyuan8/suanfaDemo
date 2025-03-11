package com.yuan.suanfa.tanxin;


import java.util.Scanner;

/**
 * 2024D-伐木工
 *
 *题目描述
 * 一根X米长的树木，伐木工切割成不同长度的木材后进行交易，交易价格为每根木头长度的乘积。
 * 规定切割后的每根木头长度都为正整数，也可以不切割，直接拿整根树木进行交易。
 * 请问伐木工如何尽量少的切割，才能使收益最大化？
 *
 * 输入描述
 * 木材的长度 (X<=50)
 *
 * 输出描述
 * 输出最优收益时的各个树木长度，以空格分割，按升序排列
 *
 * 示例
 * 输入
 * 10
 *
 * 输出
 * 3 3 4
 *
 */
public class C2024DFaMuGong {

    //1. 尽量分成长度为3的小段，这样才能使得乘积的收益尽可能大。
    //2. 当X <= 4时，不进行切割。注意4不会被切割为2 2，因为虽然2 2也能得到4的总收益，但是并不是切割数最小的方式
    //3. 当X > 4且X % 3 == 0时，分成n // 3组长度为3的小段。
    //4. 当X > 4且X % 3 == 2时，分成n // 3组长度为3的小段，1组长度为2的小段。
    //5. 当X > 4且X % 3 == 1时，分成n // 3 - 1组长度为3的小段，1组长度为4的小段。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        scanner.close();
        if (X <= 4) {
            System.out.println(X);
        } else {
            if (X % 3 == 0) {
                int num = X / 3;
                for (int i = 0; i < num; i++) {
                    System.out.print("3 ");
                }
            } else if (X % 3 == 2) {
                System.out.print("2 ");
                int num = X / 3;
                for (int i = 0; i < num; i++) {
                    System.out.print("3 ");
                }
            } else if (X % 3 == 1) {
                int num = X / 3 - 1;
                for (int i = 0; i < num; i++) {
                    System.out.print("3 ");
                }
                System.out.print("4");
            }
        }
    }


}
