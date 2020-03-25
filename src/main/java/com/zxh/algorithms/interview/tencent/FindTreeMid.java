package com.zxh.algorithms.interview.tencent;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/3/24
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 *
 * 于一棵满二叉排序树深度为k，节点数为2^k-1;节点值为1至（2^k - 1）,给出k和任意三个节点的值，输出包含该三个节点的最小子树的根节点。
 *
 * 样例输入：4 10 15 13
 *
 * 样例输出：12
 *
 * 题目解析：
 *首先，我们来理解一下满二叉排序树，如下就是一个4层的满二叉排序树：
 *
 *  *            8
 *  *        /      \
 *  *       4        12
 *  *      / \      /  \
 *  *     2   6    10   14
 *  *    /\   /\   /\  / \
 *  *   1 3  5 7  9 11 13 15
 * 根据上图可以看出，满二叉排序树的中序遍历是从1到(2^k-1)的递增序列（k为层数）。所以，只要给出层数我们就能够确定这个二叉排序树。同时，观察可知，二叉排序树从上到下的根节点刚好是所有元素进行二分查找的中间节点。
 *
 * 根据上面的规律要解决三个节点的最小子树的根节点这个问题可以得到如下几点：
 * 1. 无须建立二叉树，从1~(2^k-1)的递增数组即就是一个满二叉排序树的中序遍历的结果
 * 2. 当输入的三个元素在二分节点两侧时，当前的二分节点就是要查找的最小子树的根节点（根据这个规则，我们也无需判断三个元素，只需判断最大元素和最小元素的位置即可）
 * 3. 当最小节点的值大于二分节点的值，则继续在二分的右半部分进行查找
 * 4. 当最大节点的值小于二分节点的值，则继续在二分的左半部分进行查找
 *
 */
public class FindTreeMid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[3];
        for (int i=0; i<3; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        int right = (n<<1) - 1;
        int ans = findMid(arr, 0, right);
        System.out.println(ans);
    }

    /**
     * 查询最小子树的根节点
     * @param arr   输入的三节点
     * @param left  子树的最小值
     * @param right 子树的最大值
     * @return       返回int类型的根节点
     */
    private static int findMid(int[] arr, int left, int right){
        int mid = ((right + left) >> 1) + left;
        if(mid>arr[0] && mid<arr[2]){
            return mid;
        } else if(mid < arr[0]){
            return findMid(arr, mid+1, right);
        } else if(mid > arr[2]){
            return findMid(arr, left, mid-1);
        }
        return 0;
    }
}
