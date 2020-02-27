package com.zxh.algorithms.DP;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/2/27
 */
public class StringTran {
    public static int stringTrans(String str){
        char[] chars = str.toCharArray();
        int a = 1, b = 0;
        for(int i=1; i<chars.length; i++){
            int temp = chars[i]-'A' + chars[0] - 'A';
            if(temp > 26){
                b = a;
            } else {
                b = a + b;
            }
        }
        return b;
    }
}
