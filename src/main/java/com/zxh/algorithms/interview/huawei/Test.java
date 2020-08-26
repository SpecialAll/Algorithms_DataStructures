package com.zxh.algorithms.interview.huawei;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author: ningque
 * @Date: 2020/5/13
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] date = str.split("｜");
        String date1 = date[0].substring(0, 10);
        char week = date[0].charAt(11);
        int w = week - '0';

        Date d1 = new SimpleDateFormat("yyyy MM dd").parse(date1);
        Date d2 = new SimpleDateFormat("yyyy MM dd").parse(date[1]);

        long start = d1.getTime();
        long end = d2.getTime();

        long ss= (end-start)/(1000); //共计秒数
        int MM = (int)ss/60; //共计分钟数
        int hh=(int)ss/3600; //共计小时数
        int day=(int)hh/24; //共计天数
        char ans = (char) (day%7+w+'0');
        System.out.println(ans);
    }
}
