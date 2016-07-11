package cn.uuf.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import de.innosystec.unrar.Archive;
import de.innosystec.unrar.exception.RarException;
import de.innosystec.unrar.rarfile.FileHeader;

/**
 * @Description: 文件解压缩工具类
 * @version V1.0
 */
public class FileHelper {
	private static final int BUFFEREDSIZE = 1024;

	/**
	 * 解压zip包的内容到指定的目录下，可以处理其文件夹下包含子文件夹的情况
	 * 
	 * @param zipFilename
	 *            要解压的zip文件
	 * @param outputDirectory
	 *            解压后存放的目录
	 */
	public static List<String> unzip(String zipFilename, String outputDirectory)
			throws IOException {
		List<String> list = new ArrayList<String>();
		File outFile = new File(outputDirectory);
		if (!outFile.exists()) {
			outFile.mkdirs();
		}
		File file = new File(zipFilename);
		ZipFile zip = new ZipFile(zipFilename);
		Enumeration en = zip.getEntries();
		ZipEntry zipEntry = null;
		while (en.hasMoreElements()) {
			zipEntry = (ZipEntry) en.nextElement();
			if (!zipEntry.isDirectory()) {// 仅处理文件
				String strFilePath = outFile.getPath() + File.separator
						+"photo/"+ zipEntry.getName().split("/")[1];
				File f = new File(strFilePath);
				// 判断文件不存在的话，就创建该文件所在文件夹的目录
				if (!f.exists()) {
					String[] arrFolderName = zipEntry.getName().split("/");
					String strRealFolder = "photo" + File.separator;
					strRealFolder = outFile.getPath() + File.separator
							+ strRealFolder;
					File tempDir = new File(strRealFolder);
					// 此处使用.mkdirs()方法，而不能用.mkdir()
					tempDir.mkdirs();
				}
				// ////end///
				f.createNewFile();
				InputStream in = zip.getInputStream(zipEntry);
				FileOutputStream out = new FileOutputStream(f);
				try {
					int c;
					byte[] by = new byte[BUFFEREDSIZE];
					while ((c = in.read(by)) != -1) {
						out.write(by, 0, c);
					}
					out.flush();
				} catch (IOException e) {
					throw e;
				} finally {
					out.close();
					in.close();
				}
				list.add(zipEntry.getName());
			}
		}
		zip.close();
		file.delete();
		return list;
	}

	/**
	 * 对rar文件解压
	 * 
	 * @param rarFileName
	 * @param extPlace
	 * @return
	 */
	public static List<String> unrar(String rarFileName, String extPlace) {
		File rarfile = new File(rarFileName);
		List<String> list = new ArrayList<String>();
		String fileName = "";
		Archive archive = null;
		File out = null;
		File file = null;
		File dir = null;
		FileOutputStream os = null;
		FileHeader fh = null;
		String path, dirPath = "";
		try {
			file = new File(rarFileName);
			archive = new Archive(file);
		} catch (RarException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (file != null) {
				file = null;
			}
		}
		if (archive != null) {
			try {
				fh = archive.nextFileHeader();
				while (fh != null) {// 获取所有文件名
					fileName = "photo/"+ fh.getFileNameString().replaceAll(
							"\\\\", "/").trim().split("/")[1];
					path = (extPlace + File.separator + fileName).replaceAll(
							"\\\\", "/");
					int end = path.lastIndexOf("/");
					if (end != -1) {
						dirPath = path.substring(0, end);
					}
					try {
						dir = new File(dirPath);
						if (!dir.exists()) {
							dir.mkdirs();
						}
					} catch (RuntimeException e1) {
						e1.printStackTrace();
					} finally {
						if (dir != null) {
							dir = null;
						}
					}
					if (fh.isDirectory()) {
						fh = archive.nextFileHeader();
						continue;
					}
					out = new File(extPlace + File.separator + fileName);
					try {
						os = new FileOutputStream(out);
						archive.extractFile(fh, os);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (RarException e) {
						e.printStackTrace();
					} finally {
						if (os != null) {
							try {
								os.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (out != null) {
							out = null;
						}
					}
					fh = archive.nextFileHeader();
					list.add(fileName);
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			} finally {
				fh = null;
				if (archive != null) {
					try {
						archive.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		rarfile.delete();
		return list;
	}
	

	/**
     * 删除空目录
     * @param dir 将要删除的目录路径
     */
    public static String doDeleteEmptyDir(String dir) {
        boolean success = (new File(dir)).delete();
        if (success) {
            return "yes";
        } else {
           return "no";
        }
    }
    
    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     *                 If a deletion fails, the method stops attempting to
     *                 delete and returns "false".
     */
	public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
	
	/**
	 * 下载压缩文件
	 * @param fileList
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static HttpServletResponse downPho(File [] fileList,  HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		try{
			File file = new File(request.getContextPath()+File.separator+"datas.zip");
            if (!file.exists()){   
                file.createNewFile();   
            }
            response.reset();
            FileOutputStream fous = new FileOutputStream(file);
            ZipOutputStream zipOut  = new ZipOutputStream(fous);
            zipFile(fileList, zipOut);
            zipOut.close();
            fous.close();
            return downloadZip(file,response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	/**
	 * 文件打包
	 * @param fileList
	 * @param outputStream
	 */
	  public static void zipFile  (File [] fileList,ZipOutputStream outputStream) {
	 	for (File file : fileList) {
	 		zipFile(file, outputStream);
		}
	 }
	  public static HttpServletResponse downloadZip(File file,HttpServletResponse response) {
	        try {
	            InputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
	            byte[] buffer = new byte[fis.available()];
	            fis.read(buffer);
	            fis.close();
	            // 清空response
	            response.reset();
	            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	            response.setContentType("application/octet-stream");
	            response.setHeader("Content-Disposition", "attachment;filename=" +URLEncoder.encode(file.getName(), "UTF-8"));
	            toClient.write(buffer);
	            toClient.flush();
	            toClient.close();
	            } catch (IOException ex) {
	            	ex.printStackTrace();
	            }finally{
	                 try {
	                        File f = new File(file.getPath());
	                        f.delete();
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }
	            }
	            return response;
	        }
	  /**  
	     * 根据输入的文件与输出流对文件进行打包
	     * @param File
	     * @param org.apache.tools.zip.ZipOutputStream
	     */
	    public static void zipFile(File inputFile, ZipOutputStream ouputStream) {
	        try {
	            if(inputFile.exists()) {
	            	  if (inputFile.isFile()) {
	                      FileInputStream IN = new FileInputStream(inputFile);
	                      BufferedInputStream bins = new BufferedInputStream(IN, 512);
	                      //org.apache.tools.zip.ZipEntry
	                      ZipEntry entry = new ZipEntry(inputFile.getName());
	                      ouputStream.putNextEntry(entry);
	                      // 向压缩文件中输出数据   
	                      int nNumber;
	                      byte[] buffer = new byte[512];
	                      while ((nNumber = bins.read(buffer)) != -1) {
	                          ouputStream.write(buffer, 0, nNumber);
	                      }
	                      // 关闭创建的流对象   
	                      bins.close();
	                      IN.close();
	                  } else {
	                      try {
	                          File[] files = inputFile.listFiles();
	                          for (int i = 0; i < files.length; i++) {
	                              zipFile(files[i], ouputStream);
	                          }
	                      } catch (Exception e) {
	                          e.printStackTrace();
	                      }
	                  }
	              }
	          } catch (Exception e) {
	              e.printStackTrace();
	          }
	      }
}