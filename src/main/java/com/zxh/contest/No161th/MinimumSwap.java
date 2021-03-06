package com.zxh.contest.No161th;

/**
 * 题目描述：、
 *      有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
 *
 * 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
 *
 * 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
 *
 * 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s1 = "xx", s2 = "yy"
 * 输出：1
 * 解释：
 * 交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。
 * 示例 2：
 *
 * 输入：s1 = "xy", s2 = "yx"
 * 输出：2
 * 解释：
 * 交换 s1[0] 和 s2[0]，得到 s1 = "yy"，s2 = "xx" 。
 * 交换 s1[0] 和 s2[1]，得到 s1 = "xy"，s2 = "xy" 。
 * 注意，你不能交换 s1[0] 和 s1[1] 使得 s1 变成 "yx"，因为我们只能交换属于两个不同字符串的字符。
 * 示例 3：
 *
 * 输入：s1 = "xx", s2 = "xy"
 * 输出：-1
 * 示例 4：
 *
 * 输入：s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
 * 输出：4
 *  
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 1000
 * s1, s2 只包含 'x' 或 'y'。
 *
 *
 *  题目解析：
 *     第一步：特殊情况
 *  如果两条字符串长度不等，返回-1；
 *      第二步：普遍规律
 * 由于要求交换次数尽量少，故：
 * 本来相同位置就有相同的字符，不需要交换。
 * 本来相同位置字符不同，需要交换。交换为两组字符交换，本质上只有两种情形：
 *
 *          (a) 2组相同(2组xy或2组yx，等价于示例1)：
 *          此时，s1[0]与s2[1]交换即可，需要进行11次交换
 *          (b) 2组不同(1组xy，1组yx，等价于示例2)：
 *          此时，将s1[0]与s2[0]交换后与a)相同，需要进行22次交换
 *
 * 综上所述，我们可以得出如下结论：
 *          xy与yx的组数之和必须为偶数，否则返回-1(两两交换)
 *          优先进行(a)类交换，剩余的进行(b)类交换(贪心算法)
 * 第三步：得出结论
 *          由于匹配是两两进行，因此，在确定有MM对xy，NN对yx，且M+NM+N为偶数后：
 *          若MM为偶数，则NN也为偶数，则全部为(a)类交换。总匹配数为：
 *          （M + N）/2
 *
 *          若MM为奇数，则NN也为奇数，则各拿一组进行(b)类交换，其余(a)类交换。总匹配数为：
 *
 * (M−1)/2 + (​N-1)/2 + 2
 *
 * 两者均可写作：
 * (M+1)/2 + (N+1)/2
 * ​
 */
public class MinimumSwap {
    public int minimumSwap(String s1, String s2){
        if(s1.length() != s2.length()) return -1;
        int x = 0, y = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) == 'x')
                x++;
            else
                y++;
        }
        for(int i=0; i<s2.length(); i++){
            if(s2.charAt(i) == 'x')
                x++;
            else
                y++;
        }
        if(x%2==1 || y%2==1) return -1;
        int ans1 = 0, ans2 = 0;
        for(int i=0; i<s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)) {
                if(s1.charAt(i) == 'x')
                    ans1++;
                else
                    ans2++;
            }
        }
        return (ans1+1)/2 + (ans2+1)/2;
    }
}
