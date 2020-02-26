package dataAnals.wordCount.type;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import dataAnals.FileIPathConst;
import dataAnals.wordCount.WordCountMapper;
 

public class WordCountDriver_Type {
	public boolean run(String inputFilePath, String outputFilePath) throws IllegalArgumentException, IOException, ClassNotFoundException, InterruptedException {
		Configuration configuration = new Configuration();
		configuration.set("mapreduce.framework.name", "yarn");
		Job job = Job.getInstance(configuration, "Count");
		job.setJarByClass(dataAnals.wordCount.type.WordCountDriver_Type.class);
		job.setMapperClass(dataAnals.wordCount.WordCountMapper.class);
		job.setReducerClass(dataAnals.wordCount.type.WordCountReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputFormatClass(DBOutputFormat.class);
		FileInputFormat.setInputPaths(job ,new Path(FileIPathConst.InputfilePathStr+"\\"+FileIPathConst.NewsTypeFilename));
		DBOutputFormat.setOutput(job, "t_type", "type", "count");  
		return job.waitForCompletion(true);
	}
	public boolean run() throws IllegalArgumentException, ClassNotFoundException, IOException, InterruptedException {return this.run("","");}

	public boolean run(String newstimefiledir) throws IllegalArgumentException, ClassNotFoundException, IOException, InterruptedException {
		return this.run("", "");
	}
	
}
 