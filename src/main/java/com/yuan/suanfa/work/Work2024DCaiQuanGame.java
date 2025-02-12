package com.yuan.suanfa.work;


import java.util.*;

/**
 * 2024D-石头剪刀布游戏
 *
 *题目描述
 * 石头剪刀布游戏有 3 种出拳形状：石头、剪刀、布。分别用字母 A , B , C 表示。
 * 游戏规则:
 * 1. 出拳形状之间的胜负规则如下： A > B；B > C；C > A；">"左边一个字母，表示相对优势形状。右边一个字母，表示相对劣势形状。
 * 2. 当本场次中有且仅有一种出拳形状优于其它出拳形状，则该形状的玩家是胜利者。否则认为是平局。
 * 3. 当发生平局，没有赢家。有多个胜利者时，同为赢家。
 *
 * 例如 1： 三个玩家出拳分别是A, B, C ，由于出现三方优势循环(即没有任何一方优于其它出拳者)，判断为平局。
 * 例如 2： 三个玩家，出拳分别是 A, B ，出拳 A 的获胜。
 * 例如 3： 三个玩家，出拳全部是 A ，判为平局。
 * 输入描述
 * 在一场游戏中，每个玩家的信息为一行。玩家数量不超过 1000 。每个玩家信息有 2 个字段，用空格隔开：
 * 1. 玩家 ID：一个仅由英文字母和数字组成的字符串
 * 2. 出拳形状：以英文大写字母表示, A 、B 、C 形状。 例：
 * abc1 A
 * xyz B
 * 解释：玩家 abc1 出拳为石头( A )。玩家 xyz 出拳为剪刀( B )
 * 输出描述
 * 输出为赢家的玩家 ID 列表(一个或多个)，每个 ID 一行，按字符串升序排列。如果没有赢家，输出为"NULL"字符串。例如：
 * abc1
 * 示例一
 * 输入
 * abc1 A
 * xyz B
 * 输出
 * abc1
 * 说明
 * A 比 B 有优势，abc1 胜出
 * 示例二
 * 输入
 * abc1 A
 * xyz A
 * 输出
 * NULL
 * 说明
 * 没有优胜的出拳形状，平局
 * 示例三
 * 输入
 * abc1 A
 * def A
 * alic A
 * xyz B
 * 输出
 * abc1
 * alic
 * def
 * 说明
 * A 为优胜方，有三个赢家。
 *
 */
public class Work2024DCaiQuanGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 创建一个map，用来存储每个出拳的玩家ID,key为出拳，value为出拳的玩家ID
        HashMap<String, List<String>> map = new HashMap<>();
        while (scanner.hasNext()) {
            // 玩家ID
            String name = scanner.next();
            // 出拳
            String k = scanner.next();
            // 如果map中不包含当前出拳，则创建一个list
            if(!map.containsKey(k)){
                map.put(k,new ArrayList<>());
            }
            // 将玩家ID添加到list中
            map.get(k).add(name);
        }
        // 如果map中包含两个出拳，则输出每个出拳的玩家ID
        if(map.size()!=2){
            System.out.println("NULL");
        }else{
            // 创建一个list，用来存储每个出拳的玩家ID
            List<String> ans = new ArrayList<>();
            if (map.containsKey("A") && map.containsKey("B")) {
                ans = map.get("A");
            } else if (map.containsKey("B") && map.containsKey("C")) {
                ans = map.get("B");
            } else {
                ans = map.get("C");
            }
            //排序
            Collections.sort(ans);
            // 输出list中的玩家ID
            for (String s : ans) {
                System.out.println(s);
            }
        }
    }


}
