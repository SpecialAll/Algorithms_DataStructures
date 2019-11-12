package com.zxh.nowCoder.jianzhi_offer;

/**
 *
 题目描述
 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

 这个问题的中心思想其实就是使用二分查找的方法，逐步的逼近这个最小值，首先这个旋转数组将一个非递减的数组分成了两个子数组，前一个数组的值都比后一个数组的值大，并且两个子数组都是非递减的数组，而且我们可以知道这个最小值肯定是在前一个数组和后一个数组的交界出。也就是后一个数组的第一个值。

 采用二分法解答这个问题

 mid  =  low + （high - low）/2;

 //首先说下不要使用（low + high）/2这种方式去求数组的中间位置，可能会造成溢出，可以使用我现在用的这种也可以使用以下这种： mid = (low + high) / 2;

 需要考录三种情况:

 （1）array[mid] > array[high];

 出现这种情况array类似[3, 4, 5, 0, 1, 2],此时最小数字移动在mid的右边。low = mid + 1；

 （2）array[mid] == array[high]

 出现这种情况array类似[0, 1, 1, 1, 1,]或者[1, 1, 1, 0, 1],此时最小数字不好判断在mid左边还是右边，这个时候治好一个个的试

 high = high - 1;

 （3）(3)array[mid] < array[high]:
 出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左边。因为右边必然都是递增的。 high = mid
         注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
         比如 array = [4,6]
         array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
         如果high = mid - 1，就会产生错误， 因此high = mid
         但情形(1)中low = mid + 1就不会错误
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array){
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            /**
             * 注意这里不要使用 mid = (left + right)/2
             * 可能会出现溢出问题！！！！！！
             */
            int mid = left + (right - left)/2;
            if(array[mid] > array[right]){
                left = mid + 1;
            } else if(array[mid] == array[right]){
                right--;
            } else {
                right = mid;
            }
        }
        return array[left];
    }
}
