package dataAnals.partition;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import dataAnals.FileIPathConst;

public class ExtractDriver {
	public boolean run(String inputFilePath, String outputFilePath) throws IllegalArgumentException, IOException, ClassNotFoundException, InterruptedException {
		// 1 获取配置信息，或者job对象实例
				Configuration configuration = new Configuration();
				// 8 配置提交到yarn上运行,windows和Linux变量不一致
//				configuration.set("mapreduce.framework.name", "yarn");
//				configuration.set("yarn.resourcemanager.hostname", "hadoop103");
				Job job = Job.getInstance(configuration, "Partition");
				
				// 6 指定本程序的jar包所在的本地路径
//				job.setJar("/home/atguigu/wc.jar");
				job.setJarByClass(dataAnals.partition.ExtractDriver.class);
				
				// 2 指定本业务job要使用的mapper/Reducer业务类
				job.setMapperClass(dataAnals.partition.ExtractMapper.class);
				
				// 3 指定mapper输出数据的kv类型
				job.setMapOutputKeyClass(NullWritable.class);
				job.setMapOutputValueClass(dataAnals.partition.Column.class);
				
				// 4 指定最终输出的数据的kv类型
				job.setOutputKeyClass(dataAnals.partition.Column.class);
				job.setOutputValueClass(NullWritable.class);
				
				// 5 指定job的输入原始文件所在目录
				FileInputFormat.setInputPaths(job ,new Path("/news1.csv"));
				FileOutputFormat.setOutputPath(job,new Path(FileIPathConst.InputfilePathStr));
				//6.1 set Paritioner
				job.setPartitionerClass(dataAnals.partition.ColumnsPartition.class);
				
				//6.2 set up reduce task number
				job.setNumReduceTasks(5);
				
				// 7 将job中配置的相关参数，以及job所用的java类所在的jar包， 提交给yarn去运行
//				job.submit();
				return job.waitForCompletion(true);
	}
}
 