package com.yuan.suanfa;

import com.yuan.suanfa.controller.CodeLC1603;
import org.junit.Test;

public class CodeLC1603Test {

    @Test
    public void test1() {
        // 测试逻辑
        CodeLC1603 codeLC1603 = new CodeLC1603(1, 1, 0);
        System.out.println(codeLC1603.addCar(1));
        System.out.println(codeLC1603.addCar(2));
        System.out.println(codeLC1603.addCar(3));
        System.out.println(codeLC1603.addCar(1));
    }


}
