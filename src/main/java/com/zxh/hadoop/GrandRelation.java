package com.zxh.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: ningque
 * @Date: 2020/8/21
 * @Version 1.0
 */
public class GrandRelation {
    public static class TokenizerMapper extends Mapper<Object, Text, Text, Text> {
        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String[] strs = value.toString().split(",[\\\\s]*?");
            context.write(new Text(strs[0]), new Text(strs[0] + " " + strs[1]));
            context.write(new Text(strs[1]), new Text(strs[0] + " " + strs[1]));
        }
    }

    public static class IntSumReducer extends Reducer<Text, Text, Text, Text> {
        @Override
        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            ArrayList<String> bigger = new ArrayList<String>();
            ArrayList<String> smaller = new ArrayList<String>();
            for (Text s : values) {
                String[] strs = s.toString().split(" ");
                if (strs[0].equals(key.toString())){
                    smaller.add(strs[1]);
                } else if (strs[1].equals(key.toString())) {
                    bigger.add(strs[0]);
                }
            }

            for (String small : smaller) {
                for (String big : bigger) {
                    context.write(new Text(small), new Text(big));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration = new Configuration();
        String[] otherArgs = new GenericOptionsParser(configuration, args).getRemainingArgs();
        if (otherArgs.length < 2){
            System.err.println("Usage: GrandRelation <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(configuration, "grandrelation");
        job.setJarByClass(GrandRelation.class);
        job.setMapperClass(TokenizerMapper.class);
//        job.setCombinerClass(IntSumReducer.class); //这个是本地节点具合，会reduce两次，容易bug，value为字符串就不行了
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
