package com.zxh.algorithms.heredity.functionoptimization;

import java.util.Random;

import static java.lang.Math.pow;

/**
 * @Author: ningque
 * @Date: 2020/4/27
 * @Version 1.0
 *
 * 基于遗传算法求解函数优化问题
 */
public class FunctionOptimization {
    /**
     * 种群数量 N，
     * 精英数量 E，
     * 迭代次数 Times，
     * 两点交叉概率 Pc，
     * 单点变异概率 Pm；
     */
    private int N = 100, E = 5, Times = 500;
    private double Pc = 0.8, Pm = 0.1, PI = 3.1415926;
    /**
     * 随机数
     */
    private Random rand = new Random();

    /**
     * 随机创建N个个体的初始基因型：int Individual[N][33]
     */
    public void Initialize(int[][] Individual)
    {
        //随机创建N个个体的初始基因型 遍历每个个体v
        for (int i = 0; i < N; i++) {
            //每个个体随机33位01基因序列
            for (int j = 0; j < 32; j++) {
                Individual[i][j] = (int) (rand.nextInt(2));
            }
        }
    }

    /**
     *  解码
     */
    public double Decode(int[][] Indivisual, int i) {
        //声明解码值x1,x2
        double x1 = 0, x2 = 0;
        //解码x1
        int TempSum = 0;
        for (int j = 15, k = 0; j >= 0; j--, k++) {
            TempSum += (int) pow(2, k) * Indivisual[i][j];
        }
        x1 = TempSum * 4.096 / 65535 - 2.048;
        //解码x2
        TempSum = 0;
        for (int j = 31, k = 0; j >= 16; j--, k++) {
            TempSum += (int) pow(2, k) * Indivisual[i][j];
        }
        x2 = TempSum * 4.096/ 65535 -2.048;
        //返回fit值
        return 100*(x2-(x1*x1))*(x2-(x1*x1))+(1-x1)*(1-x1);
    }

    /**
     * 计算个体的表现型
     */
    public void ComFit(int[][] Individual, double[] Fit)
    {
        for (int i = 0; i < N; i++)
        {
            //个体i的基因型解码为表现型
            Fit[i] = Decode(Individual, i);
        }
    }

    /**
     * 精英保留
     */
    public void Save(int[][] Individual, int[] EliteNum, int[][] EliteGene,double[] Fit,double[] EliteValue)
    {

        /**
         * 精英保留E个最优个体直接进入下一代种群  循环找出E个精英交叉池编号  i表示第i个精英
         */
        for (int i = 0; i < E; i++)//找出E个
        {
            double MaxFit = 0;
            //遍历所有个体适应值，找出第i个精英   j表示当前个体
            for (int j = 0; j < N; j++)
            {
                //  判断当前最大适应值是否小于等于当前个体适应值
                if (MaxFit < Fit[j])
                {
                    int repeat = 0;
                    //遍历所有精英，判断当前精英是否重复
                    for (int k = 0; k < E; k++)
                    {
                        if (j == EliteNum[k])
                        {
                            repeat = 1;
                            break;
                        }

                    }
                    //当前精英未重复
                    if (repeat == 0) {
                        MaxFit = Fit[j];
                        EliteValue[i] = MaxFit;
                        EliteNum[i] = j;
                        for (int ii = 0; ii < 32; ii++)
                        {
                            EliteGene[i][ii] = Individual[j][ii];
                        }

                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /**
     * 把父代Individual[][]中第i个体放入交叉池pool中
     */
    public void CopyIn(int[][] Pool, int[][] Individual, int i, int j)
    {
        for (int k = 0; k < 32; k++) {
            Pool[i][k] = Individual[j][k];
        }
        return;
    }

    /**
     * 建立交叉池
     */
    public void CreatePool(int[][] Individual, int[][] Pool, double[] Fit)
    {
        //首先，计算个体的适应度占总适应度的比值pi，然后，计算个体的累计适应度qi。
        double[] pi = new double[N];
        double[] qi = new double[N];
        //求总适应度sum_fit
        double sum_fit = 0;
        for (int i = 0; i < N; i++) {
            sum_fit += Fit[i];
        }
        //遍历所有个体适应度，求每个个体/比值pi，每个个体累计适应度qi
        for (int i = 0; i < N; i++)
        {
            pi[i] = Fit[i] / sum_fit;
            if (i == 0) {
                qi[i] = pi[i];
            } else {
                qi[i] = qi[i - 1] + pi[i];
            }
        }
        for (int i = 0; i < N; i++)
        {
            //轮盘赌选择概率p
            double p = ( rand.nextInt(10000) / 10001.0);
            for (int j = 0; j < N; j++) {
                if (qi[j] > p)
                {
                    // 把N个体放入交叉池
                    CopyIn(Pool, Individual, i, j);
                    break;
                }
            }

        }
    }

    //在交叉池内进行两点交叉
    public void TwoPointCross(int[][] Pool, int i)
    {
        int left = rand.nextInt(32), right = rand.nextInt(32);
        if (left > right)
        {
            int t = left;
            left = right;
            right = t;
        }
        for (int j = left; j <= right; j++)
        {
            int temp = Pool[i][j];
            Pool[i][j] = Pool[i + 1][j];
            Pool[i + 1][j] = temp;
        }
    }

    //单点变异
    public void SinglePointVariation(int[][] Pool, int i, double Pm)
    {
        for (int j = 0; j < 32; j++)
        {
            if (Pm > (rand.nextInt(10000) / 10001.0))
            {
                Pool[i][j] = (Pool[i][j] + 1) % 2;
            }
        }
    }

    /**
     *两点交叉，单点变异
     */
    public void IndiCrossVariation(int[][] Pool)
    {
        for (int i = 0; i < N / 2; i++)
        {
            //随机值小于交叉概率则进行两点交叉
            if (Pc > (rand.nextInt(10000) / 10001.0))
            {
                //在交叉池内进行两点交叉
                TwoPointCross(Pool, i);
                //对交叉的个体的两个后代进行单点变异
                SinglePointVariation(Pool, i, Pm);
            }
        }
    }
    /**
     * 计算交叉池个体的表现型
     */
    public void CalculationFit(int[][] DoubleIndi, double[] DoubleFit)
    {
        //计算表现型
        for (int i = 0; i < N*2; i++)
        {
            //个体i的基因型解码为表现型
            DoubleFit[i] = Decode(DoubleIndi, i);
        }
    }

    //计算累计适应度
    void CalculationDoubleQi(double[] DoubleFit, double[] DoublePi , double[] DoubleQi)
    {
        //求总适应度sum_fit
        double SumFitAll = 0;
        int i;
        for (i = 0; i < N*2; i++) {
            SumFitAll += DoubleFit[i];
        }
        //遍历所有个体适应度，求每个个体/比值，每个个体累计适应度
        for (i = 0; i < N*2; i++)
        {
            DoublePi[i] = DoubleFit[i] / SumFitAll;
            if (i == 0) {
                DoubleQi[i] = DoublePi[i];
            } else {
                DoubleQi[i] = DoubleQi[i - 1] + DoublePi[i];
            }
        }
    }
    public void UpdataPopulation(int[][] Individual, int[][] Pool, int[][] EliteGene)
    {
        //把父代和子代放入种群池DoubleIndi
        int[][] DoubleIndi = new int[2*N][32];
        int i, j;
        for (i = 0; i < N; i++)
        {
            for (j = 0; j < 32; j++)
            {
                DoubleIndi[i][j] = Individual[i][j];
            }
        }
        for (i = N; i < 2 * N; i++)
            for (j = 0; j < 32; j++)
            {
                DoubleIndi[i][j] = Pool[i - N][j];
            }

        //创建适应度数组
        double[] DoubleFit = new double[2 * N];
        //创建个体的适应度占总适应度的比值
        double[] DoublePi = new double[2 * N];
        //创建累计适应度数组
        double[] DoubleQi = new double[2 * N];

        //计算所有个体适应度,返回 DoubleFit
        CalculationFit(DoubleIndi, DoubleFit);

        //计算累计适应度，返回DoubleQi
        CalculationDoubleQi(DoubleFit, DoublePi, DoubleQi);

        //从种群 DoubleIndi中轮盘赌选择 N-E 个个体进入下一代 Individual[N][33]
        for (i = 0; i < N - E; i++)
        {
            double p2 = rand.nextInt(10000) / 10001.0;
            //cout << p2 << endl;
            for (j = 0; j < N * 2; j++)
            {
                if (DoubleQi[j] > p2)
                {
                    CopyIn(Individual, DoubleIndi, i, j);
                    break;
                }
            }
        }
        //精英个体EliteGene[E][33]直接加入下一代 Individual[N][33]
        for (j = 0; j < E; j++, i++)
        {
            for (int k = 0; k < 32; k++) {
                Individual[i][k] = EliteGene[j][k];
            }
        }
    }

    public void Decodex1(int[][] EliteGene, double[] x1)
    {
        //解码x1
        for (int i = 0; i < E; i++)
        {
            int TempSum = 0;
            for (int j = 15, k = 0; j >= 0; j--, k++)
            {
                TempSum += (int)pow(2, k) * EliteGene[i][j];
            }
            x1[i] = TempSum * 4.096/ 65535 -2.048;
        }

    }
    public void Decodex2(int[][] EliteGene, double[] x2)
    {
        //解码x2
        for (int i = 0; i < E; i++)
        {
            int TempSum = 0;
            for (int j = 31, k = 0; j >= 16; j--, k++)
            {
                TempSum += (int)pow(2, k) * EliteGene[i][j];
            }
            x2[i] = TempSum * 4.096/ 65535 -2.048;
        }
    }

    //输出精英的适应值和基因码
    public void OutputElite(double[] EliteValue, int[][] EliteGene,int Current_t,double[] x1,double[] x2)
    {

        Decodex1(EliteGene, x1);
        Decodex2(EliteGene, x2);
        //输出精英的适应值
        for (int i = 0; i < E; i++)
        {
            System.out.println("第" + Current_t + "代第" + i + "个精英个体的适应值：" + EliteValue[i]);
            System.out.println("它的f(x1,x2)=(" + x1[i] + "," + x2[i] + ") " + "   基因码：");
            for (int j = 0; j < 32; j++)
            {
                System.out.print(EliteGene[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        FunctionOptimization optimization = new FunctionOptimization();

        Random random = new Random(System.currentTimeMillis());

        //N个个体 求出对应个体的表现型 Fit[N]
        int[][] Individual = new int[optimization.N][32];
        double[] Fit = new double[optimization.N];
        //寻找精英
        int[] EliteNum = new int[optimization.E];
        //精英保存数组
        int[][] EliteGene = new int[optimization.E][32];
        //精英适应值EliteValue[]
        double[] EliteValue = new double[optimization.E];
        //初始化，随机创建N个个体的初始基因型：int Individual[N][33]
        optimization.Initialize(Individual);

        //迭代
        for (int Current_t = 0; Current_t < optimization.Times; Current_t++)
        {
            //计算个体的表现型
            optimization.ComFit(Individual, Fit);
            //保留精英：
            optimization.Save(Individual, EliteNum, EliteGene, Fit, EliteValue);
            //轮盘赌
            int[][] Pool = new int[optimization.N][32];
            optimization.CreatePool(Individual, Pool, Fit);
            //种群个体间基因在交叉池两点交叉以及单点变异 产生在交叉池中的子代 int Pool[N][33]
            optimization.IndiCrossVariation(Pool);

            //把父代和子代合并，进行轮盘赌选择N-E个个体，更新种群个体 Individual[N-E][33]
            optimization.UpdataPopulation(Individual, Pool,EliteGene);

            //输出当前代的精英表现形（适应值）以及基因型
            double[] x1 = new double[optimization.E];
            double[] x2 = new double[optimization.E];
            optimization.OutputElite(EliteValue, EliteGene,Current_t,x1,x2);
        }
    }
}
