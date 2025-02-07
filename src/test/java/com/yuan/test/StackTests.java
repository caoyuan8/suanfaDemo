package com.yuan.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootTest
public class StackTests {

    /**
     * 数组的基本操作
     */
    @Test
    void studyArry() {
        /* 初始化数组 */
        int[] ints1 ={1,2,3,4,5};
        int[] ints2 = new int[5];
        int[] ints3 = new int[]{1,2,3,4,5};
        int[] ints4 = new int[]{1,2,3,4,5};
        System.out.println("当前数组1为" + Arrays.toString(ints1));
        /* 访问数组元素 */
        int i0 = ints1[0];
        int i1 = ints1[1];
        int i2 = ints1[2];
        System.out.println("数组1元素：" + i0 + " " + i1 + " " + i2);
        /* 随机访问数组元素 */
        int i = ThreadLocalRandom.current().nextInt(0, ints1.length);
        System.out.println("随机访问数组1元素：" + ints1[i]);
        /* 修改数组元素 */
        ints3[0] = 10;
        System.out.println("修改后新数组3为：" + Arrays.toString(ints3));
        /* 插入数组元素 */
        int index = 3;// 插入下标
        int tag = 9;// 插入元素
        for (int j = ints3.length-1; j >index; j--) {
            ints3[j] = ints3[j-1];
        }
        ints3[index] = tag;
        System.out.println("插入后新数组3为：" + Arrays.toString(ints3));
        /* 删除数组元素 */
        int index1 = 3;
        for (int j = index1; j < ints4.length-1; j++) {
            ints4[j] = ints4[j+1];
        }
//        ints4[ints4.length-1] = 0;
        System.out.println("删除后新数组4为：" + Arrays.toString(ints4));
        int count = 0;
        // 通过索引遍历数组
        for (int a = 0; a < ints3.length; a++) {
            count += ints3[a];
        }
        // 直接遍历数组元素
        /*for (int num : ints3) {
            count += num;
        }*/
        System.out.println("数组元素和为：" + count);
        /* 倒序遍历数组 */
        for (int j = ints3.length-1, k=0; j >= 0; j--,k++) {
            ints2[k] = ints3[j];
        }
        System.out.println("倒序后新数组3为：" + Arrays.toString(ints2));



    }

    /**
     * 栈的基本操作
     */
    @Test
    void studyStack() {
        /* 初始化栈 */
        Stack<Integer> stack = new Stack<>();
        /* 入栈操作 */
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        /* 访问栈顶元素 */
        Integer peek = stack.peek();
        /* 元素出栈 */
        Integer pop = stack.pop();
        /* 获取栈长度 */
        int size = stack.size();
        /* 判断栈是否为空 */
        boolean empty = stack.empty();
        System.out.println("栈顶元素：" + peek);
        System.out.println("出栈元素：" + pop);
        System.out.println("栈长度：" + size);
        System.out.println("栈是否为空：" + empty);
    }

}
