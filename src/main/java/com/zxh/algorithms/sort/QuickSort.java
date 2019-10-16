package com.zxh.algorithms.sort;

/**
 * 快速排序学习：
 *  一般策略是先任意选择一个a[low]作为切分元素，即那个将会被排定的元素，
 *  然后我们从数组的左端开始向右扫描直到找到大于等于它的元素，再从数组的右端开始向左扫描直到找到小于等于它的元素。
 *  这两个元素显然是没有排定的，因此我们交换它们的位置。
 *  如此继续我们就可以保证左指针i的左侧元素都是不大于切分元素的，右指针j的右侧元素都是不小于切分元素的。
 *  当两指针相遇时，我们只需要将切分元素的a[low]和左子数组最右侧的元素a[j]交换然后返回j即可。
 */
public class QuickSort {
    public static void quickSort1(int[] num, int low, int high){
        if(low >= high)
            return ;
        int i = low;
        int j = high+1;
        int temp = num[low];
        while(true) {

            while (i < j && num[++i] < temp){
                if(i == high)
                    break;
            }
            while (i < j && num[--j] > temp){
                if(j == low)
                    break;
            }
            if(i >= j) break;
            if (i < j) {
                int t = num[i];
                num[i] = num[j];
                num[j] = t;
            }
        }
        num[low] = num[i];
        num[i] = temp;

        quickSort1(num, low, j-1);
        quickSort1(num, j+1, high);
    }
    // 分治法快速排序
    public static void quickSort(int array[], int low, int high) {// 传入low=0，high=array.length-1;
        int pivot, p_pos, i, t;// pivot->位索引;p_pos->轴值。
        if (low < high) {
            p_pos = low;
            pivot = array[p_pos];
            for (i = low + 1; i <= high; i++)
                if (array[i] < pivot) {
                    p_pos++;
                    t = array[p_pos];
                    array[p_pos] = array[i];
                    array[i] = t;
                }
            t = array[low];
            array[low] = array[p_pos];
            array[p_pos] = t;
            // 分而治之
            quickSort(array, low, p_pos - 1);// 排序左半部分
            quickSort(array, p_pos + 1, high);// 排序右半部分
        }
    }
    public static void main(String[] args) {
        int[] a = {2, 34, 56, 7, 9, 12, 33};
        quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
