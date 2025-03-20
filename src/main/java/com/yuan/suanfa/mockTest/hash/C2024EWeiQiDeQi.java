package com.yuan.suanfa.mockTest.hash;


import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

/**
 * 围棋的气
 */
public class C2024EWeiQiDeQi {

    // 上下左右四个方向的偏移量数组
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // 本函数用于计算某种颜色的气的个数
    static int calQiNum(HashSet<Pair<Integer, Integer>> setColor, HashSet<Pair<Integer, Integer>> setOtherColor) {
        // 构建气的哈希集合
        HashSet<Pair<Integer, Integer>> setQi = new HashSet<>();
        // 考虑所有同色棋子
        for (Pair<Integer, Integer> p : setColor) {
            int i = p.first;
            int j = p.second;
            // 遍历上下左右四个方位
            for (int[] dir : D) {
                // 考虑近邻点 (i, j)
                int ni = i + dir[0];
                int nj = j + dir[1];
                // 近邻点不越界，且为空位（既不是黑棋，也不是白棋）
                if (0 <= ni && ni <= 18 && 0 <= nj && nj <= 18 &&
                        !setColor.contains(new Pair<>(ni, nj)) &&
                        !setOtherColor.contains(new Pair<>(ni, nj))) {
                    // 此时近邻点为一个气，加入哈希集合 setQi 中
                    setQi.add(new Pair<>(ni, nj));
                }
            }
        }
        // 返回哈希集合的大小，即为该种颜色的气的个数
        return setQi.size();
    }

    public static void main(String[] args) {
        // 输入数据
        Scanner scanner = new Scanner(System.in);
        //黑棋坐标 22一对
        String blackInput = scanner.nextLine();
        //白旗坐标 22一对
        String whiteInput = scanner.nextLine();

        // 解析输入数据
        HashSet<Pair<Integer, Integer>> setBlack = new HashSet<>();
        HashSet<Pair<Integer, Integer>> setWhite = new HashSet<>();
        Scanner blackScanner = new Scanner(blackInput);
        Scanner whiteScanner = new Scanner(whiteInput);
        while (blackScanner.hasNext()) {
            int x = blackScanner.nextInt();
            int y = blackScanner.nextInt();
            setBlack.add(new Pair<>(x, y));
        }
        while (whiteScanner.hasNext()) {
            int x = whiteScanner.nextInt();
            int y = whiteScanner.nextInt();
            setWhite.add(new Pair<>(x, y));
        }

        // 分别调用 calQiNum，计算黑棋和白棋的气的个数
        int ansBlack = calQiNum(setBlack, setWhite);
        int ansWhite = calQiNum(setWhite, setBlack);
        // 输出答案
        System.out.println(ansBlack + " " + ansWhite);
    }

    // 自定义 Pair 类
    static class Pair<T, U> {
        T first;
        U second;

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        // 重写 equals 和 hashCode 方法
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) obj;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }


}
