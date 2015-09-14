package cn.scu01.hadoop;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class HDFSDemo {

	FileSystem fs = null;
	@Before
	public void init() throws IOException, URISyntaxException, InterruptedException{
		fs = FileSystem.get(new URI("hdfs://scu01:9000"), new Configuration(),"root");
	}
	
	@Test
	public void TestUpload() throws Exception{
		InputStream in = new FileInputStream("/Users/mumutongxue/words.txt");
		OutputStream out = fs.create(new Path("/test.txt"));
		IOUtils.copyBytes(in, out, 4096, true);
	}
	
	@Test
	public void testDownload() throws IllegalArgumentException, IOException{
		fs.copyToLocalFile(new Path("/jdk"), new Path("/Users/mumutongxue/jdk2"));
		
	}
	
	@Test
	public void testDel() throws IllegalArgumentException, IOException{
		boolean flag =  fs.delete(new Path("/wcout"), true);
		System.out.print(flag);
	}
	
	@Test
	public void testMKdir() throws IllegalArgumentException, IOException{
		boolean mkdir = fs.mkdirs(new Path("/scu01"));
		System.out.print(mkdir);
	}
	
	public static void main(String[] args) throws Exception{
		FileSystem fs = FileSystem.get(new URI("hdfs://scu01:9000"), new Configuration());
		InputStream in = fs.open(new Path("/jdk"));
		OutputStream out = new FileOutputStream("/Users/mumutongxue/jdk1.7");
		IOUtils.copyBytes(in, out, 4096, true);
		
		
		
	}

}
