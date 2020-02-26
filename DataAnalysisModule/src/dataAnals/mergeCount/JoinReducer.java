package dataAnals.mergeCount;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import mr2db.tableDBWritable.CommentTblWritable;


public class JoinReducer extends Reducer<Text, IntWritable, Text, CommentTblWritable> {

	@Override
	protected void reduce(Text aNewsType, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		
		int sumForANewsType = 0;

		// 1 汇总各个key的个数
		for(IntWritable value:values){
			sumForANewsType += value.get();
		}
		
		// 2输出该key的总次数
		context.write(aNewsType, new CommentTblWritable(aNewsType.toString(), sumForANewsType));

	}
	
}
