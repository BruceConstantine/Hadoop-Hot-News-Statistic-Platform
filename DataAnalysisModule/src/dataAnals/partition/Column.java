package dataAnals.partition;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.Writable;

public class Column implements Writable{
	private int col_type; // 1-type; 2-comment; 3-time; 4-source;
	private String field_1;
	private String field_2;

	@Override
	public void readFields(DataInput in) throws IOException {
		this.field_1 = in.readUTF();
		this.field_2 = in.readUTF();
		this.col_type = in.readInt();
	}
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(field_1);
		out.writeUTF(field_2);
		out.writeInt(col_type);
	}
	@Override
	public String toString() {
		if (null == field_2 || field_2.isEmpty())
			return field_1;
		else 
			return field_1+","+field_2;
	}

	public Column() {
		super();
	}
	public Column(int col_type, String field) {
		this.col_type = col_type;
		this.field_1 = field;
		this.field_2 = StringUtils.EMPTY;
	}

	public Column(int col_type, String field_1, String field_2) {
		this.col_type = col_type;
		this.field_1 = field_1;
		this.field_2 = field_2;
	}
	 
	public int getCol_type() {
		return col_type;
	}
	public void setCol_type(int col_type) {
		this.col_type = col_type;
	}
	public String getField() {
		return field_1;
	}
	public void setField(String in) {
		field_1 = in;
	}
	
	public String getField_1() {
		return field_1;
	}
	public void setField_1(String field_1) {
		this.field_1 = field_1;
	}
	public String getField_2() {
		return field_2;
	}
	public void setField_2(String field_2) {
		this.field_2 = field_2;
	}
}