package com.my.webspider;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class WritingToHDFS {
	public void putFileToHDFS(File file) throws Exception{
		Configuration configuration = new Configuration();
		
		FileSystem fs = FileSystem.get(new URI("hdfs://hadoop-s0:9000"),configuration, "hadoop");
		
		FileInputStream inStream = new FileInputStream(file); //new File("e:/hello.txt")
		
		String putFileName = "hdfs://hadoop-s0:9000/news1.csv";
		Path writePath = new Path(putFileName);

		FSDataOutputStream outStream = fs.create(writePath);

		try{
			IOUtils.copyBytes(inStream, outStream, 4096, false);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			IOUtils.closeStream(inStream);
			IOUtils.closeStream(outStream);
		}
	}

}
