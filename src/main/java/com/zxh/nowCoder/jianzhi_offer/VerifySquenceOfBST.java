package com.zxh.nowCoder.jianzhi_offer;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/22
 *
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public static void main(String[] args) {
        int[] sequence = {7,4,9,3,8,11,12,10};
        System.out.println(VerifySquenceOfBST(sequence));
    }
    /**
     * 使用非递归的方式
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        if(len == 0)
            return false;
        int i = 0;
        while(--len > 0){
            while(sequence[i] < sequence[len]){
                i++;
            }
            while(i<len && sequence[i] > sequence[len]){
                i++;
            }

            if(i < len)
                return false;
            i = 0;
        }
        return true;
    }

    /**
     * 使用递归的方法
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST1(int [] sequence) {
        if(sequence.length == 0)
            return false;
        return judge(sequence, 0, sequence.length-1);
    }
    public boolean judge(int[] sequence, int start, int end){
        if(end <= start)
            return true;
        int i = start;
        for(; i<end; i++){
            if(sequence[i] > sequence[end])
                break;
        }
        for(int j=i; j<end; j++){
            if(sequence[j] < sequence[end])
                return false;
        }
        return judge(sequence, start, i-1) && judge(sequence, i, end-1);
    }
}
