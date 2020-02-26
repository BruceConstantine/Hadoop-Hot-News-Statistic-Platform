package dataAnals.partition;

import java.io.IOException;
 
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class ExtractMapper extends Mapper<LongWritable , Text , NullWritable, Column>{



	@Override
	protected void map(LongWritable key, Text value,Context context) throws IOException, InterruptedException {
		  int id = 0;
		// 1 将maptask传给我们的文本内容先转换成String
		String line = value.toString();

		
		// 2 根据空格将这一行切分成单词
		String[] fields = line.split(",");
		
		if(fields.length > 3) {
			Column type = new Column (1, fields[1]);
			Column comment = new Column (2, fields[1], fields[2]);
			 
			
			String time_s = fields[3];
				int delimiter = time_s.indexOf(" ");
				int simecolom = time_s.lastIndexOf(":"); 
				time_s = time_s.isEmpty() ? time_s: time_s.substring(delimiter+1, simecolom);
			Column time = new Column(3, time_s);

			Column source = new Column (4, fields[5]);
			Column [] arr = {type,comment,time,source};
			for (Column col: arr) {
				context.write(NullWritable.get(), col); 
			} 
		}
		
	}
}
