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
		// 1 ��ȡ������Ϣ������job����ʵ��
				Configuration configuration = new Configuration();
				// 8 �����ύ��yarn������,windows��Linux������һ��
//				configuration.set("mapreduce.framework.name", "yarn");
//				configuration.set("yarn.resourcemanager.hostname", "hadoop103");
				Job job = Job.getInstance(configuration, "Partition");
				
				// 6 ָ���������jar�����ڵı���·��
//				job.setJar("/home/atguigu/wc.jar");
				job.setJarByClass(dataAnals.partition.ExtractDriver.class);
				
				// 2 ָ����ҵ��jobҪʹ�õ�mapper/Reducerҵ����
				job.setMapperClass(dataAnals.partition.ExtractMapper.class);
				
				// 3 ָ��mapper������ݵ�kv����
				job.setMapOutputKeyClass(NullWritable.class);
				job.setMapOutputValueClass(dataAnals.partition.Column.class);
				
				// 4 ָ��������������ݵ�kv����
				job.setOutputKeyClass(dataAnals.partition.Column.class);
				job.setOutputValueClass(NullWritable.class);
				
				// 5 ָ��job������ԭʼ�ļ�����Ŀ¼
				FileInputFormat.setInputPaths(job ,new Path("/news1.csv"));
				FileOutputFormat.setOutputPath(job,new Path(FileIPathConst.InputfilePathStr));
				//6.1 set Paritioner
				job.setPartitionerClass(dataAnals.partition.ColumnsPartition.class);
				
				//6.2 set up reduce task number
				job.setNumReduceTasks(5);
				
				// 7 ��job�����õ���ز������Լ�job���õ�java�����ڵ�jar���� �ύ��yarnȥ����
//				job.submit();
				return job.waitForCompletion(true);
	}
}
 