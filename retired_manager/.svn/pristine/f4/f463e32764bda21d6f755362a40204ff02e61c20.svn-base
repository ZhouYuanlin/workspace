package cn.uuf.ltxxt.life.controller;
/**
 * 类说明	：删除系统文件
 */
import java.io.File;

public class DeleteFile {
	/**
	 * 删除一个文件夹及下面的所有文件
	 * @author: pgf
	 * @creation: Oct 23, 2013 2:36:36 PM
	 * @param file
	 * @return: void
	 */
	@SuppressWarnings("static-access")
	public static void deleteFile(File file){
		if(file.isFile()){//表示该文件不是文件夹
			file.delete();
		}else{
			//首先得到当前的路径
			String[] childFilePaths = file.list();
			for(String childFilePath : childFilePaths){
				File childFile=new File(file.getAbsolutePath()+file.separator+childFilePath);
				deleteFile(childFile);
			}
			file.delete();
		}
	}
}

