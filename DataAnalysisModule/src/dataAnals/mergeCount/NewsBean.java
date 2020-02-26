package dataAnals.mergeCount;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

// For a news: comment number and its type. 
/// An news bean is an instance of a record of news.
public class NewsBean implements WritableComparable<NewsBean> {

	private int comment_num;
	private String type; 
	
	
	public NewsBean() {
		super();
	}
	public NewsBean(String type,int comment_num) {
		super();
		this.comment_num = comment_num;
		this.type = type;
	}

	public long getComment_num() {
		return comment_num;
	}

	public String getType() {
		return type;
	}

	public void setComment_num(int  comment_num) {
		this.comment_num = comment_num;
	}

	public void setType(String type) {
		this.type = type;
	}

	//Serialization
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeLong(comment_num);
		out.writeUTF(type);
	}

	//de-Serialization
	@Override
	public void readFields(DataInput in) throws IOException {
		this.comment_num = in.readInt();
		this.type = in.readUTF();
	}
	

	@Override
	public String toString() {
		return type+","+comment_num;
	}
	@Override
	public int compareTo(NewsBean o) {
		return this.getComment_num() > o.getComment_num() ? -1 : 1;
	}

}
