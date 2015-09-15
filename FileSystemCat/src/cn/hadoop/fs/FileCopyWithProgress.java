package cn.hadoop.fs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;


public class FileCopyWithProgress {
	public static void main(String[] args) throws Exception {
		String localStr = "/Users/mumutongxue/python/test.csv";
		String dst = "hdfs://172.16.85.128:50070/";
		InputStream in = new BufferedInputStream(new FileInputStream(localStr));
		
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(dst), conf);
		OutputStream out = fs.create(new Path(dst), new Progressable() {
			public void progress() {
				System.out.print(".");
			}
		});
		
		IOUtils.copyBytes(in, out, 4096, true);
		
	}
}