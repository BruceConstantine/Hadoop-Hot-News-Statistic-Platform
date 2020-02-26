package mr2db.tableDBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class CommentTblWritable implements Writable, DBWritable {
	String type;
	int comment_sum;
	public CommentTblWritable() {
	}
	public CommentTblWritable(String name, int age) {
		this.type = name;
		this.comment_sum = age;
	}
	@Override
	public void readFields(ResultSet resultset) throws SQLException {
		this.type = resultset.getString(1);
		this.comment_sum = resultset.getInt(2);
	}
	@Override
	public void write(PreparedStatement statement) throws SQLException {
		statement.setString(1, this.type);
		statement.setInt(2, this.comment_sum);
	}
	@Override
	public void readFields(DataInput dataInput) throws IOException {
		this.type = dataInput.readUTF();
		this.comment_sum = dataInput.readInt();
	}
	@Override
	public void write(DataOutput dataOutput) throws IOException {
		dataOutput.writeUTF(type);
		dataOutput.writeInt(comment_sum);
	}
	public String toString() {
		return new String(this.type + " " + this.comment_sum);
	}
}