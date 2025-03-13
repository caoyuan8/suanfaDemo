package com.yuan.suanfa.huachuang;


import java.util.*;

/**
 * 2024E-字符串摘要
 *
 *题目描述
 * 给定一个字符串的摘要算法，请输出给定字符串的摘要值
 * 1. 去除字符串中非字母的符号
 * 2. 对于去除非字母符号后的字符串：
 *   - 如果出现连续字符（不区分大小写），则输出: 该字母（小写) + 连续出现的次数
 *   - 如果是非连续的字符（不区分大小写），则输出: 该字母（小写）之后字符串中出现的该字符的次数
 * 3. 对按照以上方式表示后的字符串进行排序：字母和紧随的数字作为一组进行排序，数字大的在前，数字相同的则按字母进行排序，字母小的在前。
 *
 * 输入描述
 * 一行字符串，长度为[1,200]
 *
 * 输出描述
 * 转换后的摘要字符串
 *
 * 示例一
 * 输入
 * aabbcc
 * 输出
 * a2b2c2
 * 说明
 *
 * 示例二
 * 输入
 * bAaAcBb
 * 输出
 * a3b2b2c0
 * 说明
 * 第一个b非连续字母，该字母之后字符串中还出现了2次 (最后的两个Bb) ，所以输出b2；
 * a连续出现3次，输出a3；
 * c非连续，该字母之后字符串再没有出现过c，输出c0；
 * Bb连续2次，输出b2。
 * 对b2a3c0b2进行排序，最终输出a3b2b2c0。
 */
public class C2024EStrZhaiYao {

    /**
     * 生成字符串摘要
     * 该方法将输入字符串中的字母转换为小写，并统计每个字母的连续出现次数
     * 最后，它将生成一个摘要字符串，其中包含每个字母及其连续出现的次数，并按照出现次数降序排序
     * 如果出现次数相同，则按照字母顺序升序排序
     *
     * @param input 输入字符串，可以包含任何字符
     * @return 返回生成的摘要字符串
     */
    public static String getSummary(String input) {
        // 构建器用于存储处理后的字母
        StringBuilder sb = new StringBuilder();
        // 遍历输入字符串的每个字符
        for (char c : input.toCharArray()) {
            // 如果字符是字母，则将其转换为小写并添加到StringBuilder中
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        // 将处理后的字母转换为字符串
        String cleanedString = sb.toString();

        // 创建一个映射来统计每个字母的出现次数
        Map<Character, Integer> charCountMap = new HashMap<>();
        // 遍历处理后的字符串的每个字符
        for (char c : cleanedString.toCharArray()) {
            // 更新映射中字符的计数
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // 构建器用于存储最终结果
        StringBuilder result = new StringBuilder();
        // 初始化前一个字符和其计数
        char prevChar = '\0';
        int prevCount = 0;
        // 遍历处理后的字符串的每个字符
        for (char c : cleanedString.toCharArray()) {
            // 如果当前字符与前一个字符相同，增加计数
            if (c == prevChar) {
                prevCount++;
            } else {
                // 如果前一个字符不为空，将前一个字符及其计数添加到结果中
                if (prevChar != '\0') {
                    result.append(prevChar).append(prevCount);
                }
                // 更新前一个字符和其计数
                prevChar = c;
                prevCount = 1;
            }
        }

        // 如果最后一个字符不为空，将其及其计数添加到结果中
        if (prevChar != '\0') {
            result.append(prevChar).append(prevCount);
        }

        // 列表用于存储结果字符串的各个部分
        List<String> parts = new ArrayList<>();
        // 分割结果字符串为各个部分，并添加到列表中
        for (String part : result.toString().split("(?=[0-9])")) {
            if (!part.isEmpty()) {
                parts.add(part);
            }
        }

        // 对列表中的部分按照出现次数降序排序，如果次数相同，则按照字母顺序升序排序
        parts.sort((a, b) -> {
            String numStrA = a.replaceAll("\\D+", "");
            String numStrB = b.replaceAll("\\D+", "");

            int numA = numStrA.isEmpty() ? 0 : Integer.parseInt(numStrA);
            int numB = numStrB.isEmpty() ? 0 : Integer.parseInt(numStrB);

            if (numA != numB) {
                return Integer.compare(numB, numA);
            } else {
                return a.compareTo(b);
            }
        });

        // 构建器用于存储排序后的结果
        StringBuilder sortedResult = new StringBuilder();
        // 遍历排序后的部分并添加到构建器中
        for (String part : parts) {
            sortedResult.append(part);
        }

        // 返回排序后的结果字符串
        return sortedResult.toString();
    }

    public static void main(String[] args) {
        String input = "bAaAcBb";
        String summary = getSummary(input);
        System.out.println(summary);
    }

}
