package com.zxh.algorithms.CatalanAnalysis;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
public class Stack {
    public static void main(String[] args){

        StackProblemCatalan test= new StackProblemCatalan();
        try {
            test.calc_push_pop();
        } catch (IOException e) {

            e.printStackTrace();
        }

        System.out.println("可能的出栈序列为："+test._push_pop_num);

    }

}

