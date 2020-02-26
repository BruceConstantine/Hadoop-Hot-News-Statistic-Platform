package dataAnals.wordCount.source;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import mr2db.tableDBWritable.SourceTblWritable;
import mr2db.tableDBWritable.TypeTblWritable;
 


public class WordCountReducer extends Reducer<Text, IntWritable, Text, SourceTblWritable> {
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Context context)
											throws IOException, InterruptedException {
		int count = 0;
		for(IntWritable value:values){
			count +=value.get();
		}
		context.write(key, new SourceTblWritable(key.toString(),count));
	}
}
