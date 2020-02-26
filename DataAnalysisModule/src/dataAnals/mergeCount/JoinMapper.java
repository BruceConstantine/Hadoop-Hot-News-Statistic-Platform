package dataAnals.mergeCount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class JoinMapper extends Mapper<LongWritable , Text , Text, IntWritable>{
	private ArrayList<String> comment = new ArrayList<String>();
	@Override
	protected void setup(Context context) throws IOException, InterruptedException {
		// read all comments in the part-r-00002 file, and cache them in list.
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("part-r-00002"))));
		String line;
		while(StringUtils.isNotEmpty(line = reader.readLine())) {
			comment.add(line);
		}
		reader.close();
	}
	
	private Text type = new Text();
	private IntWritable aComment = new IntWritable();
	private int index_count = 0;
	@Override 
	protected void map(LongWritable key, Text value,Context context) throws IOException, InterruptedException {
		type.set(value.toString());
		int comment_value = comment.get(index_count).isEmpty() ? 0 : Integer.parseInt( comment.get(index_count));
		aComment.set(comment_value);
		index_count++;
		context.write(type, aComment);
	}

}
