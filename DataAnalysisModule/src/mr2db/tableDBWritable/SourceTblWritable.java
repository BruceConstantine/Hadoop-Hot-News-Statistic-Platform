package mr2db.tableDBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class SourceTblWritable implements Writable, DBWritable {
	String source;
	int source_cnt;
	public SourceTblWritable() {
	}
	public SourceTblWritable(String name, int age) {
		this.source = name;
		this.source_cnt = age;
	}
	@Override
	public void readFields(ResultSet resultset) throws SQLException {
		this.source = resultset.getString(1);
		this.source_cnt = resultset.getInt(2);
	}
	@Override
	public void write(PreparedStatement statement) throws SQLException {
		statement.setString(1, this.source);
		statement.setInt(2, this.source_cnt);
	}
	@Override
	public void readFields(DataInput dataInput) throws IOException {
		this.source = dataInput.readUTF();
		this.source_cnt = dataInput.readInt();
	}
	@Override
	public void write(DataOutput dataOutput) throws IOException {
		dataOutput.writeUTF(source);
		dataOutput.writeInt(source_cnt);
	}
	public String toString() {
		return new String(this.source + " " + this.source_cnt);
	}
}