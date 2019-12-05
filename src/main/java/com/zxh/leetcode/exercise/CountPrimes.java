package com.zxh.leetcode.exercise;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/5
 */
public class CountPrimes {
    public int countPrimes1(int n) {
        int count = 0;
        if(n==0 || n == 1)
            return count;
        for(int i=2; i < n; i++){
            if(isPrim(i))
                count++;
        }
        return count;
    }
    public boolean isPrim(int n){
        //注意这里遍历到sqrt（n)就可以了！ 可以比n/2更少一些！！！
        for(int i=2; i * i <= n; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }

    /**
     * 首先从 2 开始，我们知道 2 是一个素数，那么 2 × 2 = 4, 3 × 2 = 6, 4 × 2 = 8... 都不可能是素数了。
     *
     * 然后我们发现 3 也是素数，那么 3 × 2 = 6, 3 × 3 = 9, 3 × 4 = 12... 也都不可能是素数了。
     *
     */
    public int countPrimes2(int n) {
        boolean[] ans = new boolean[n+1];
        if(n==0 || n == 1)
            return 0;
        for(int i=0; i < n; i++){
            ans[i] = true;
        }
        for(int i=2; i<n; i++){
            if(ans[i]){
                //i的倍数不可能是素数
                for(int j = 2*i; j<n; j+=i){
                    ans[j] = false;
                }
            }
        }
        int count = 0;
        for(int i=2; i<n; i++){
            if(ans[i])
                count++;
        }
        return count;
    }

    /**
     * 首先，回想刚才判断一个数是否是素数的 isPrime 函数，由于因子的对称性，其中的 for 循环只需要遍历 [2,sqrt(n)] 就够了。
     * 这里也是类似的，我们外层的 for 循环也只需要遍历到 sqrt(n)：
     *
     * for (int i = 2; i * i < n; i++)
     *     if (isPrim[i])
     *         ...
     * 除此之外，很难注意到内层的 for 循环也可以优化。我们之前的做法是：
     *
     * for (int j = 2 * i; j < n; j += i)
     *     isPrim[j] = false;
     * 这样可以把 i 的整数倍都标记为 false，但是仍然存在计算冗余。
     *
     * 比如 n = 25，i = 4 时算法会标记 4 × 2 = 8，4 × 3 = 12 等等数字，但是这两个数字已经被 i = 2 和 i = 3 的 2 × 4 和 3 × 4 标记了。
     *
     * 我们可以稍微优化一下，让 j 从 i 的平方开始遍历，而不是从 2 * i 开始：
     *
     * for (int j = i * i; j < n; j += i)
     *     isPrim[j] = false;
     * 这样，素数计数的算法就高效实现了，其实这个算法有一个名字，叫做 Sieve of Eratosthenes。看下完整的最终代码：
     *
     */
    public int countPrimes3(int n) {
        boolean[] ans = new boolean[n+1];
        if(n==0 || n == 1)
            return 0;
        for(int i=0; i < n; i++){
            ans[i] = true;
        }
        for(int i=2; i*i<n; i++){
            if(ans[i]){
                //i的倍数不可能是素数
                for(int j = i*i; j<n; j+=i){
                    ans[j] = false;
                }
            }
        }
        int count = 0;
        for(int i=2; i<n; i++){
            if(ans[i])
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        CountPrimes primes = new CountPrimes();
        primes.countPrimes1(10);
    }
}
