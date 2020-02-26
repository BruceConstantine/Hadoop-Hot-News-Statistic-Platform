package dataAnals.wordCount;

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
 

public class WordCountDriver {
	public boolean run(String inputFilePath, String outputFilePath) throws IllegalArgumentException, IOException, ClassNotFoundException, InterruptedException {
		Configuration configuration = new Configuration();
		configuration.set("mapreduce.framework.name", "yarn");
		Job job = Job.getInstance(configuration, "Count");
		job.setJarByClass(dataAnals.wordCount.WordCountDriver.class);
		job.setMapperClass(dataAnals.wordCount.WordCountMapper.class);
		job.setReducerClass(dataAnals.wordCount.WordCountReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputFormatClass(DBOutputFormat.class);
		FileInputFormat.setInputPaths(job ,new Path("/news1.csv"));
		job.setOutputFormatClass(DBOutputFormat.class);
		DBOutputFormat.setOutput(job, "t_type", "type", "count");  
		return job.waitForCompletion(true);
	}

	public boolean run(String newstimefiledir) {
		return false;
	}
	
}
 