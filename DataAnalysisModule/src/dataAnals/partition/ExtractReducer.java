package dataAnals.partition;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ExtractReducer extends Reducer<NullWritable, Column , Column , NullWritable> {

	@Override
	protected void reduce(NullWritable id_key, Iterable<Column > fields, Context context)
			throws IOException, InterruptedException {

		
		for(Column aColumn: fields) {
			//output directly
			context.write(aColumn,NullWritable.get());	
		}
	}
	
}
