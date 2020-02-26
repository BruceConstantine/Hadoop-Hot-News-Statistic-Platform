package mr2db.tableDBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class TblWritable_str_int implements Writable, DBWritable {
	String varchar_field;
	int int_field;
	public TblWritable_str_int() {
	}
	public TblWritable_str_int(String name, int age) {
		this.varchar_field = name;
		this.int_field = age;
	}
	@Override
	public void readFields(ResultSet resultset) throws SQLException {
		this.varchar_field = resultset.getString(1);
		this.int_field = resultset.getInt(2);
	}
	@Override
	public void write(PreparedStatement statement) throws SQLException {
		statement.setString(1, this.varchar_field);
		statement.setInt(2, this.int_field);
	}
	@Override
	public void readFields(DataInput dataInput) throws IOException {
		this.varchar_field = dataInput.readUTF();
		this.int_field = dataInput.readInt();
	}
	@Override
	public void write(DataOutput dataOutput) throws IOException {
		dataOutput.writeUTF(varchar_field);
		dataOutput.writeInt(int_field);
	}
	public String toString() {
		return new String(this.varchar_field + " " + this.int_field);
	}
}