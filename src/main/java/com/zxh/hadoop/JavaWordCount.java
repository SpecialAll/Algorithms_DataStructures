package com.zxh.hadoop;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;
import java.util.Arrays;
import java.util.Iterator;


/**
 * @Author: ningque
 * @Date: 2020/8/21
 * @Version 1.0
 */
public class JavaWordCount {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        // java的程序 一定是使用JavaAPI 去实现
        JavaSparkContext sc = new JavaSparkContext(conf);

        // 读数据
        JavaRDD<String> lines = sc.textFile(args[0]);

        // 切分并压平 输入和输出参数
        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                // 调用Arrays 生成指定类型
                return Arrays.asList(s.split(" ")).iterator();
            }
        });
        // 组装  第一个：输入参数  输出参数（String，Int）
        JavaPairRDD<String, Integer> wordAndOne = words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                // 组装元组
//                return Tuple2.apply(s,1);
                return new Tuple2<>(s, 1);
            }
        });

        // 分组聚合  两个输入参数  一返回值类型
        JavaPairRDD<String, Integer> result = wordAndOne.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1 + v2;
            }
        });

        // 排序 先把k -v 互换  然后调用 sortByKey   然后再调换回来

        JavaPairRDD<Integer, String> beforeSwap = result.mapToPair(new PairFunction<Tuple2<String, Integer>, Integer, String>() {
            @Override
            public Tuple2<Integer, String> call(Tuple2<String, Integer> tp) throws Exception {
                // 元素交换
                return tp.swap();
            }
        });

        // 默认是升序  传false的参数
        JavaPairRDD<Integer, String> sortedTp = beforeSwap.sortByKey(false);

        JavaPairRDD<String, Integer> finalRes = sortedTp.mapToPair(new PairFunction<Tuple2<Integer, String>, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(Tuple2<Integer, String> integerStringTuple2) throws Exception {
                return integerStringTuple2.swap();
            }
        });

        // 存储 写到hdfs中
        finalRes.saveAsTextFile(args[1]);

        sc.stop();
    }
}
