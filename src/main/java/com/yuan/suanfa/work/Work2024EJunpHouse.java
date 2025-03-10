package com.yuan.suanfa.work;

import java.util.*;

/**
 * 【双指针】2024E-跳房子II
 *题目描述
 * 跳房子，也叫跳飞机，是一种世界性的儿童游戏。
 * 游戏参与者需要分多个回合按顺序跳到第1格直到房子的最后一格，然后获得一次选房子的机会，直到所有房子都被选完，房子最多的人获胜。
 * 跳房子的过程中，如果有踩线等违规行为会结束当前回合，甚至可能倒退几步。
 * 假设房子的总格数是count，小红每回合可能连续跳的步数都放在数据steps中，请问数组中是否有一种步数的组合，可以让小红三个回合跳到最后一格？如果有，请输出索引和最小的步数组合，数据保证索引和最小的步数组合是唯一的。
 * 注意：数组中的步数可以重复，但数组中的元素不能重复使用。
 *
 * 输入描述
 * 第一行输入为房子总格数count，它是整数类型int。
 * 第二行输入为每回合可能连续跳过的步数，它是整数数组类型。
 *
 * 输出描述
 * 返回索引和最小满足要求的步数组合。
 * 注意：顺序保持steps中的原有顺序。
 * 备注
 * - count <= 10000；
 * - 3 <= steps.length <= 10000；
 * - -100000 <= steps[i] <= 100000；
 *
 * 示例一
 * 输入
 * 1,4,5,2,0,2
 * 9
 * 输出
 * 4,5,0
 * 说明
 *
 * 示例二
 * 输入
 * 1,5,2,0,2,4
 * 9
 * 输出
 * 5,2,2
 *
 * 示例三
 * 输入
 * -1,2,4,9
 * 12
 * 输出
 * -1,4,9
 *
 */
public class Work2024EJunpHouse{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取一行包含逗号分隔数字的数组
        String line = scanner.nextLine();
        // 使用 StringTokenizer 分割数字
        StringTokenizer tokenizer = new StringTokenizer(line, ",");
        List<Integer> lst = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            lst.add(Integer.parseInt(tokenizer.nextToken()));
        }
        // 读取下一行的数字
        int target = scanner.nextInt();
        // 获得原数组长度 n
        int n = lst.size();
        // 对原 nums 数组进行排序，同时需要记录在原数组中的下标 i，作为排序的第二个依据
        List<Pair> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(new Pair(lst.get(i), i));
        }
        Collections.sort(nums);
        // 初始化一个长度为 3 的数组，用于储存三个数的下标，初始化均为 n
        List<Integer> ansIdx = new ArrayList<>(Arrays.asList(n, n, n));
        // 考虑第一个数 first
        for (int i = 0; i < n - 2; i++) {
            // 如果发现第 i、第 i+1、第 i+2 个数的和加起来超过 target
            // 则更靠后的选择肯定和更大，直接退出循环
            if (nums.get(i).first + nums.get(i + 1).first + nums.get(i + 2).first > target) {
                break;
            }
            // 去重操作，如果遇到连续两个数相等，那么考虑 nums[i] 和考虑 nums[i-1] 所作的计算是一样的
            // 直接跳过 nums[i] 的计算
            if (i != 0 && nums.get(i).first == nums.get(i - 1).first) {
                continue;
            }
            // 构建相向双指针 left 和 right
            int left = i + 1, right = n - 1;
            while (left < right) {
                // 计算三个数的和
                int sum3 = nums.get(i).first + nums.get(left).first + nums.get(right).first;
                // 三数和太大，right 左移
                if (sum3 > target) {
                    right--;
                }
                // 三数和太小，left 右移
                else if (sum3 < target) {
                    left++;
                }
                // 三数和等于 target，如果三个下标和比之前记录过的三数下标和更小
                // 则更新 ansIdx
                else {
                    if (ansIdx.get(0) + ansIdx.get(1) + ansIdx.get(2) > nums.get(i).second + nums.get(left).second + nums.get(right).second) {
                        ansIdx = Arrays.asList(nums.get(i).second, nums.get(left).second, nums.get(right).second);
                    }
                    // 注意此处，只需要写 righ-- 就行，不需要加上 left++
                    // 1. 只写right -= 1就可以保证代码不会陷入死循环
                    // 因为只需要保证每一个if分支中，至少有一个指针是在变化的（也就是我们选择的right）
                    // 那么while中的left < right条件就一定会有不成立的时候
                    // 2. 由于排序时先按照num大小排列，再按照num在原数组中的索引排列。
                    // 如果此时存在 nums[right-1][0] == nums[right][0]
                    // 那么nums[right-1][1]会小于nums[right][1]
                    // i, nums[left][1]和nums[right-1][1]可以构成更小的索引和
                    // 如果加上了 left++ ，可能会漏算全局最小的索引和
                    right--;
                }
            }
        }
        // 退出循环，ansIdx 为在原数组中的三个数的下标
        // 答案需要按照下标大小进行排列
        Collections.sort(ansIdx);
        for (int i = 0; i < 3; i++) {
            System.out.print(lst.get(ansIdx.get(i)));
            if (i < 2) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    static class Pair implements Comparable<Pair> {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.first, other.first);
        }
    }

}
