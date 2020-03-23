package com.zxh.algorithms.interview.meituan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/19
 */

/**
 * 最长上升子串构造
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 给出一个长度为n的由正整数构成的序列，你需要从中删除一个正整数，很显然你有很多种删除方式，你需要对删除这个正整数以后的序列求其最长上升子串，请问在所有删除方案中，最长的上升子串长度是多少。
 *
 * 这里给出最长上升子串的定义：即对于序列中连续的若干个正整数，满足a_{i+1}>a_i，则称这连续的若干个整数构成的子串为上升子串，在所有的上升子串中，长度最长的称为最长上升子串。
 *
 * 输入
 * 输入第一行仅包含一个正整数n，表示给出的序列的长度。(1<=n<=100000)
 *
 * 接下来一行有n个正整数，即这个序列，中间用空格隔开。(1<=a_i<=100000)
 *
 * 输出
 *   输出仅包含一个正整数，即删除一个数字之后的最长上升子串长度。
 *
 *
 * 样例输入
 * 5
 * 2 1 3 2 5
 * 样例输出
 * 3
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        char[] ch = n.toCharArray();
        int num = ch[0] - '0';
        ArrayList<Integer> list = new ArrayList<>();
        String str = sc.nextLine();
        char[] ch2 = str.toCharArray();
        for(int i=0; i<ch2.length; i++){
            if(ch2[i] != ' '){
                list.add(ch2[i]-'0');
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        int max = 0;
        //每次删除一个进行判断
        for(int i=0; i<list.size(); i++){
            temp = list;
            temp.remove(i);
            max = max > findLengthOfLCIS(temp) ? max : findLengthOfLCIS(temp);
        }
        System.out.println(max);
    }

    /**
     * 寻找当前数组的最长上升子串长度
     * @param nums 当前求解数组
     * @return 返回子串长度
     */
    public static int findLengthOfLCIS(ArrayList<Integer> nums) {
        if(nums.size() == 0)
            return 0;
        if(nums.size() == 1)
            return 1;
        int length = nums.size()-1;
        int i = 1,max = 0,temp = 1;
        while(i <= length){
            if(nums.get(i-1) < nums.get(i)){
                i++;
                temp++;
            }
            else{
                if(max<temp){
                    max = temp;
                }
                temp = 1; //每次应该是从1开始的！！！
                i++;
            }
        }
        if(max<temp){ //需要判断一下，因为部分数组是有序的不会进入到else语句！！！
            max = temp;
        }
        return max;
    }
}
