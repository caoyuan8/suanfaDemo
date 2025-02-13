package com.yuan.suanfa.work;


import java.util.*;

/**
 *2024D-测试用例执行计划
 *
 *题目描述
 * 某个产品当前迭代周期内有 N 个特性（F1, F2, ..., FN）需要进行覆盖测试，每个特性都被评估了对应的优先级，特性使用其 ID 作为下标进行标识。
 * 设计了 M 个测试用例（T1, T2, ..., TN ），每个用例对应了一个覆盖特性的集合，测试用例使用其 ID 作为下标进行标识，测试用例的优先级定义为其覆盖的特性的优先级之和。
 * 在开展测试之前，需要制定测试用例的执行顺序，规则为：优先级大的用例先执行，如果存在优先级相同的用例，用例 ID 小的先执行。
 *
 * 输入描述
 * 第一行输入为 N 和 M ，N  表示特性的数量，M  表示测试用例的数量，0＜N<=100 ，0＜M<=100
 * 之后 N 行表示特性 ID=1 到特性 ID=N 的优先级。
 * 再接下来 M 行表示测试用例 ID=1 到测试用例 ID=M 关联的特性的 ID 的列表。
 *
 * 输出描述
 * 按照执行顺序（优先级从大到小）输出测试用例的 ID，每行一个 ID。
 * 测试用例覆盖的 ID 不重复。
 *
 * 示例一
 * 输入
 * 5 4
 * 1
 * 1
 * 2
 * 3
 * 5
 * 1 2 3
 * 1 4
 * 3 4 5
 * 2 3 4
 *
 * 输出
 * 3
 * 4
 * 1
 * 2
 * 说明
 * 测试用例的优先级计算如下：
 * T1=Pf1+Pf2+Pf3=1+1+2=4
 * T2=Pf1+Pf4=1+3=4
 * T3=Pf3+Pf4+Pf5=2+3+5=10
 * T4=Pf2+Pf3+Pf4=1+2+3=6
 * 按照优先级从大到小，以及相同优先级，ID 小的先执行的规则，执行顺序为 T3,T4,T1,T2
 *
 * 示例二
 * 输入
 * 3 3
 * 3
 * 1
 * 5
 * 1 2 3
 * 1 2 3
 * 1 2 3
 *
 * 输出
 * 1
 * 2
 * 3
 * 说明
 * 测试用例的优先级计算如下：
 * T1=Pf1+Pf2+Pf3=3+1+5=9
 * T2=Pf1+Pf2+Pf3=3+1+5=9
 * T3=Pf1+Pf2+Pf3=3+1+5=9
 * 每个优先级一样，按照 ID 从小到大执行，执行顺序为 T1,T2,T3
 *
 */
public class Work2024DTestRunPlan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入特性个数N，测试用例个数M
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // 构建一个哈希表，用于储存每一个特性的优先级
        Map<Integer, Integer> dic = new HashMap<>();
        // 输入N行，key为编号i，value为该特性的优先级
        for (int i = 1; i <= N; i++) {
            int priority = scanner.nextInt();
            dic.put(i, priority);
        }
        scanner.nextLine(); // Consume newline character

        // 构建答案哈希表
        Map<Integer, Integer> ansDic = new HashMap<>();
        // 输入M行
        for (int i = 1; i <= M; i++) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);

            // 获得第i个测试用例对应的特性
            List<Integer> nums = new ArrayList<>();
            while (lineScanner.hasNextInt()) {
                int num = lineScanner.nextInt();
                nums.add(num);
            }
            // 将所有特性的优先级进行求和，得到用例i的特性
            int sum = 0;
            for (int num : nums) {
                sum += dic.get(num);
            }
            ansDic.put(i, sum);

            lineScanner.close();
        }

        // 对所有的id根据优先级大小进行排序，先按照优先级降序排序，优先级相同再按照id大小升序排序
        List<Integer> ids = new ArrayList<>(ansDic.keySet());
        Collections.sort(ids, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int diff = ansDic.get(b) - ansDic.get(a);
                return diff != 0 ? Integer.compare(diff, 0) : Integer.compare(a, b);
            }
        });

        // 然后逐行输出
        for (int idx : ids) {
            System.out.println(idx);
        }

        scanner.close();
    }


}
