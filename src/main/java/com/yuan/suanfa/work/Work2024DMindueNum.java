package com.yuan.suanfa.work;


import java.util.*;

/**
 * 2024D-查找众数及中位数
 *
 *
 * 题目描述
 * 1. 众数是指一组数据中出现次数最多的那个数，众数可以是多个
 * 2. 中位数是指把一组数据从小到大排列，最中间的那个数，如果这组数据的个数是奇数，那最中间那个就是中位数，如果这组数据的个数为偶数，那就是中间的两个数之和除以2，所以得的结果就是中位数
 * 3. 查找整型数组中元素的众数并组成一个新的数组，求新数组的中位数
 *
 * 输入描述
 * 输入一个一维整型数组，数组大小取值范围0 < N < 1000，数组中每个元素取值范围 0 < E < 1000
 *
 * 输出描述
 * 输出众数组成的新数组的中位数
 *
 *
 * 示例一
 * 输入
 * 10 11 21 19 21 17 21 16 21 18 15
 *
 * 输出
 * 21
 *
 *
 * 示例二
 * 输入
 * 2 1 5 4 3 3 9 2 7 4 6 2 15 4 2 4
 *
 * 输出
 * 3
 *
 */
public class Work2024DMindueNum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        //计算每个数字出现的频率,需要使用到HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //获取最大频率
        Integer max = Collections.max(map.values());
        //获取出现频率最大的数字加入到集合中
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==max){
                list.add(entry.getKey());
            }
        }
        //将找出来的所有众数进行排列,方便计算出中位数
        Collections.sort(list);
        int size = list.size();
        //如果为奇数,最中间的数就是中位数
        if(size%2 ==1){
            System.out.println(list.get(size/2));
        }else{
            System.out.println((list.get(size / 2) + list.get(size / 2 - 1)) / 2);
        }
    }



}
