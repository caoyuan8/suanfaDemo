package com.yuan.suanfa;

import com.yuan.suanfa.controller.CodeLC041;
import org.junit.jupiter.api.Test;

public class CodeLC041Test {

    @Test
    void test(){
        CodeLC041 codeLC041 = new CodeLC041(3);
        System.out.println(codeLC041.next(1));
        System.out.println(codeLC041.next(10));
        System.out.println(codeLC041.next(3));
        System.out.println(codeLC041.next(5));
    }

}
