package cn.hadoop.fs;

import java.io.OutputStream;
import java.net.URI;

import junit.framework.Assert;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.hamcrest.core.Is;

public class ListStatus {

	public static void main(String[] args) throws Exception{
		String[] arg = {"hdfs://172.16.85.128/", "hdfs://172.16.85.128/VirtualBox VMs"};
		String uri = arg[0];
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
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
