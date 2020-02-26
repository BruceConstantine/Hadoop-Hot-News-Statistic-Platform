package dataAnals.partition;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;


public class ColumnsPartition extends Partitioner<NullWritable, Column > {

	@Override // 1-type; 2-comment; 3-time; 4-source;
	public int getPartition(NullWritable id, Column  field, int numPartitions) {
		if (field.getCol_type()==1) {
			return 1;
		} else if (field.getCol_type()==2) {
			return 2;
		}  else if (field.getCol_type()==3) {
			return 3;
		}  else if (field.getCol_type()==4) {
			return 4;
		}  else {
			return 0;
		}
	}	
}
