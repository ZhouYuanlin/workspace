package cn.hadoop.fs;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;

import junit.framework.Assert;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

public class ListStatus {

	
	public static void main(String[] args) throws Exception{
		String[] arg = {"hdfs://172.16.85.128/", "hdfs://172.16.85.128/VirtualBox VMs"};
		String uri = arg[0];
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
		Path p1 = new Path("hdfs://172.16.85.128/p");
		FileOutputStream out = fs.create(p1);
		Assert.assertEquals(fs.exists(p1), true);
		out.write("content".getBytes("UTF-8"));
		out.flush();
		out.;
		Assert.assertEquals(fs.getFileStatus(p1).getLen(), ((long)"content".length()));
		Path[] paths = new Path[arg.length];
		for (int i = 0; i < paths.length; i++){
			paths[i] = new Path(arg[i]);
		}
		FileStatus[] status = fs.listStatus(paths);
		Path[] listedPaths = FileUtil.stat2Paths(status);
		for(Path p: listedPaths){
			System.out.println(p);
		}
	}
}
