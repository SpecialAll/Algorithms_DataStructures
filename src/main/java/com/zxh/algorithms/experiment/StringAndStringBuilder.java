package com.zxh.algorithms.experiment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/2/27
 */
public class StringAndStringBuilder {
    public static void main1(String[] args) {
        String str = "";
        long start,end;
        start = System.currentTimeMillis();
        for(int i = 0; i<100000; i++){
            String s = "zxh";
            str += s;
        }

        end = System.currentTimeMillis();
        System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");
    }
    // start time:1582799858057; end time:1582799864373; Run Time:6316(ms)

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        long start,end;
        start = System.currentTimeMillis();
        for(int i = 0; i<100000; i++){
            String s = "zxh";
            str.append(s);
        }

        end = System.currentTimeMillis();
        System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");
    }
    // start time:1582799975893; end time:1582799975911; Run Time:18(ms)
}
