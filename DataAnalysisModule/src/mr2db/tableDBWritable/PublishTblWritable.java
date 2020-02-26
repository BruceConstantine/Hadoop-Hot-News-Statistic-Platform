package mr2db.tableDBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class PublishTblWritable implements Writable, DBWritable {
	int time_hour;
	int publish_cnt;
	public PublishTblWritable() {
	}
	public PublishTblWritable(int name, int age) {
		this.time_hour = name;
		this.publish_cnt = age;
	}
	@Override
	public void readFields(ResultSet resultset) throws SQLException {
		this.time_hour = resultset.getInt(1);
		this.publish_cnt = resultset.getInt(2);
	}
	@Override
	public void write(PreparedStatement statement) throws SQLException {
		statement.setInt(1, this.time_hour);
		statement.setInt(2, this.publish_cnt);
	}
	@Override
	public void readFields(DataInput dataInput) throws IOException {
		this.time_hour = dataInput.readInt();
		this.publish_cnt = dataInput.readInt();
	}
	@Override
	public void write(DataOutput dataOutput) throws IOException {
		dataOutput.writeInt(time_hour);
		dataOutput.writeInt(publish_cnt);
	}
	public String toString() {
		return new String(this.time_hour + " " + this.publish_cnt);
	}
}