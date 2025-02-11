package com.yuan.suanfa.work;

import java.util.*;

/**
 * 2024D-内存冷热标记
 *
 *
 * 题目描述
 * 现代计算机系统中通常存在多级的存储设备，针对海量workload的优化的一种思路是将热点内存页优先放到快速存储层级，这就需要对内存页进行冷热标记。
 * 一种典型的方案是基于内存页的访问频次进行标记，如果统计窗口内访问次数大于等于设定阈值，则认为是热内存页，否则是冷内存页。
 * 对于统计窗口内跟踪到的访存序列和阈值，现在需要实现基于频次的冷热标记。内存页使用页框号作为标识。
 *
 * 输入描述
 * 第一行为输入为N，表示访存序列的记录条数，0 < N < 10000。
 * 第二行为访存序列，空格间隔的N个内存页框号，页框号范围0-65535，同一页框号可能重复出现，出现的次数即为对应页框号的频次。
 * 第三行为热内存页的频次阈值T，正整数，范围1 < T < 10000
 *
 *
 * 输出描述
 * 第一行输出标记为热内存的内存页个数，如果没有被标记为热内存的，则输出0。
 * 如果第一行>0，则接下来按照访问频次降序输出内存页框号，一行一个，频次一样的页框号，页框号小的排前面。
 *
 *
 * 示例
 * 输入
 * 10
 * 1 2 1 2 1 2 1 2 1 2
 * 5
 *
 * 输出
 * 2
 * 1
 * 2
 * 说明
 * 内存页1和内存页2均被访问了5次，达到了阈值5，因此热内存页有2个。内存页1和内存页2的访问频次相等，页框号小的排前面。
 *
 *
 */
public class Work2024CollHotFlag {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int t = scanner.nextInt();
        //创建map统计nums中各个数字的个数
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num,cnt.getOrDefault(num,0)+1);
        }
        //过滤掉小于阈值的数字
        HashMap<Integer, Integer> cntFilter = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            if(entry.getValue()>=t){
                cntFilter.put(entry.getKey(), entry.getValue());
            }
        }
        //输出符合条件的共有多少个
        System.out.println(cntFilter.size());
        //需要将list排序，排序规则是cntFilter中value值降序，如果value值相同，则按key升序
        ArrayList<Integer> list = new ArrayList<>(cntFilter.keySet());
        list.sort((a,b)->{
            int i = cntFilter.get(b).compareTo(cntFilter.get(a));
            if(i==0){
                return a.compareTo(b);
            }else{
                return i;
            }
        });
        for (Integer i : list) {
            System.out.println(i);
        }
    }

}
