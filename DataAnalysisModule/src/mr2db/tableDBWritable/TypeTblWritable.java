package mr2db.tableDBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class TypeTblWritable implements Writable, DBWritable {
	String type;
	int count;
	public TypeTblWritable() {
	}
	public TypeTblWritable(String name, int age) {
		this.type = name;
		this.count = age;
	}
	@Override
	public void readFields(ResultSet resultset) throws SQLException {
		this.type = resultset.getString(1);
		this.count = resultset.getInt(2);
	}
	@Override
	public void write(PreparedStatement statement) throws SQLException {
		statement.setString(1, this.type);
		statement.setInt(2, this.count);
	}
	@Override
	public void readFields(DataInput dataInput) throws IOException {
		this.type = dataInput.readUTF();
		this.count = dataInput.readInt();
	}
	@Override
	public void write(DataOutput dataOutput) throws IOException {
		dataOutput.writeUTF(type);
		dataOutput.writeInt(count);
	}
	public String toString() {
		return new String(this.type + " " + this.count);
	}
}