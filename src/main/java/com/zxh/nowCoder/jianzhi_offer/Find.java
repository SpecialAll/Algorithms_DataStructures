package com.zxh.nowCoder.jianzhi_offer;

/**
 *
 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 把每一行看成有序递增的数组，
 利用二分查找，
 通过遍历每一行得到答案，
 时间复杂度是nlogn
 */
public class Find {
    public boolean Find(int target, int [][] array) {
        int len = array.length;
        for(int i=0; i<len; i++){
            int low = 0;
            int high = array[i].length - 1; //注意这里只能是length-1
            while(low <= high){ //这里只能是 <= ,可以通过debug测试！！！
                int mid = (low + high)/2;
                if(array[i][mid] > target)
                    high = mid - 1;
                else if(array[i][mid] < target)
                    low = mid + 1;
                else
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Find find = new Find();
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find.Find(7,array));
    }
}
