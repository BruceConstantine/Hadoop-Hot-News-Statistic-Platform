package dataAnals.mergeCount;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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

public class JoinDriver {
	public boolean run(String inputFilePath, String outputFilePath) throws IllegalArgumentException, IOException, ClassNotFoundException, InterruptedException, URISyntaxException {
		Configuration configuration = new Configuration();
		configuration.set("mapreduce.framework.name", "yarn");
		Job job = Job.getInstance(configuration);
		job.setJarByClass(JoinDriver.class);
		job.setMapperClass(JoinMapper.class);
		job.setReducerClass(JoinReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.setInputPaths(job ,new Path("/news1.csv"));
		job.setOutputFormatClass(DBOutputFormat.class);
		DBOutputFormat.setOutput(job, "t_comment", "type", "comment_sum");  
		job.addCacheFile(new URI("file:/"+FileIPathConst.InputfilePathStr+FileIPathConst.NewsCommentFilename));
		return job.waitForCompletion(true);
	}

	public boolean run(String newstimefiledir) throws IllegalArgumentException, ClassNotFoundException, IOException, InterruptedException, URISyntaxException {
		return this.run("", "");
	}
	public boolean run() throws IllegalArgumentException, ClassNotFoundException, IOException, InterruptedException, URISyntaxException {return this.run("","");}

	
}
 