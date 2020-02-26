package dataAnals.jobScheduler;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.junit.Test;

import dataAnals.FileIPathConst;
import dataAnals.mergeCount.JoinDriver;
import dataAnals.partition.ExtractDriver;
import dataAnals.wordCount.source.WordCountDriver_Source;
import dataAnals.wordCount.time.WordCountDriver_Time;
import dataAnals.wordCount.type.WordCountDriver_Type;

public class JobShedular {
	public boolean analysis() throws Exception{
		boolean isFinishedParition = new ExtractDriver().run("/news1.csv",FileIPathConst.InputfilePathStr);
		while(!isFinishedParition) {}  // block the thread until it finish
		boolean isFinishedWordCount_type	= new WordCountDriver_Time().run();		
		boolean isFinishedWordCount_source	= new WordCountDriver_Type().run();
		boolean isFinishedWordCount_time 	= new WordCountDriver_Source().run();		
		boolean isFinishedMerge_comment 	= new JoinDriver().run();	
		return isFinishedWordCount_type && isFinishedWordCount_source && 
				isFinishedWordCount_time &&
				isFinishedMerge_comment ;
	}
	@Test
	public void test() throws Exception{
		boolean result = analysis();
	} 
}
 