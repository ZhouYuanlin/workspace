package cn.uuf.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;
import org.apache.shiro.SecurityUtils;

import cn.uuf.domain.Account;
import cn.uuf.util.Image;

/**
 * @author <a href="mailto:waxwing819230@sina.com">lth</a>
 * @date 2015-11-27
 */
public class ImageUploadServlet extends HttpServlet {

	private static final long serialVersionUID = -9135204016276572308L;
	
	private static final String ENCODING = "utf-8";
	public static final String DEFAULT_UPLOAD_DIR = "upload";
	public static final String TEMP_DIR = "temp";
	public static final int DEFAULT_ZOOM_WIDTH = 300;
	public static final int DEFAULT_ZOOM_HEIGHT = 300;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		JSONObject data=new JSONObject();
		String fromUrl = "";
		String fileName = null;
		req.setCharacterEncoding(ENCODING);
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (!isMultipart){
			data.put("success", false);
			data.put("messsage", "数据类型不正确！");
		} else {
			File repositoryDir = new File(getBaseDir() + DEFAULT_UPLOAD_DIR + File.separator + TEMP_DIR);
			if (!repositoryDir.exists())
				repositoryDir.mkdirs();
			// create factory and file cleanup tracker
			FileCleaningTracker tracker = FileCleanerCleanup.getFileCleaningTracker(getServletContext());
			DiskFileItemFactory factory = new DiskFileItemFactory(
					DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD, repositoryDir);
			factory.setFileCleaningTracker(tracker);
			// save upload file to disk
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try {
				@SuppressWarnings("unchecked")
				List<FileItem> items = upload.parseRequest(req);
				File saveFile = null;
				Map<String, String> fileInfo = null;
				int count = 0;
				for (FileItem item : items){
					if (!item.isFormField()){
						// 确定是文件而不是一个普通的表单字段
						if (count > 0) break;
						count++;
						fileName = item.getName();
						fromUrl = req.getRealPath(fileName);
						
	  					Pattern reg = Pattern.compile("[\\.](jpg|JPG|png|jpeg|gif)$");
	  					Matcher matcher= reg.matcher(fileName);
	  					if(!matcher.find()) {
	  						data.put("success", false);
	  						data.put("messsage", URLEncoder.encode("请上传jpg|JPG|png|jpeg|gif格式的图片！", "UTF-8"));
	  						break;
	  					}
//	  					System.out.println(item.getSize()+"**************************");//文件大小
	  					File tempDir = null;
	  					String saveFileName = null, saveFilePath = null;
	  					String fileNameSuffix = fileName.substring(fileName.lastIndexOf("."));
	  					String paramType = req.getParameter("type");
	  					if ("avator".equals(paramType)) {
	  						Account currentUser = getCurrentUser();
	  						String userId = currentUser != null ? currentUser.getUsername() : null;
	  						//临时的值
//	  						userId = "123abc321";
	  						if (userId == null) {
		  						data.put("success", false);
		  						data.put("messsage", "您还没有登录！");
		  						break;	  							
	  						}
	  						saveFileName = "original" + fileNameSuffix;
	  						saveFilePath = DEFAULT_UPLOAD_DIR + "/user/" + userId;
	  						tempDir = new File(getBaseDir() + File.separator + DEFAULT_UPLOAD_DIR 
	  								+ File.separator + "user" + File.separator + userId);
	  					} else {
	  						String paramTemp = req.getParameter("tempDir");
	  						if (paramTemp == null)
	  							paramTemp = TEMP_DIR;
	  						saveFileName = UUID.randomUUID() + fileNameSuffix;
	  						saveFilePath = DEFAULT_UPLOAD_DIR + "/" + paramTemp;
	  						tempDir = new File(getBaseDir() + File.separator + DEFAULT_UPLOAD_DIR + File.separator + paramTemp);
	  					}
						if (!tempDir.exists()) {
							tempDir.mkdirs();
						}
						saveFile = new File(tempDir, saveFileName);
						item.write(saveFile);
						if (fileInfo == null) {
							fileInfo = new TreeMap<String, String>();
						}
						fileInfo.put("fileName", fileName);
						fileInfo.put("saveFileName", saveFileName);
						fileInfo.put("filePath", saveFilePath);
						
						Image image = new Image(saveFile);
						String paramZoomWidth = req.getParameter("zoomWidth");
						String paramZoomHeight= req.getParameter("zoomHeight");
						int zoomWidth = paramZoomWidth != null ? Integer.parseInt(paramZoomWidth) : DEFAULT_ZOOM_WIDTH;
						int zoomHeight = paramZoomHeight != null ? Integer.parseInt(paramZoomHeight) : DEFAULT_ZOOM_HEIGHT;
						EnumMap<ImageInfo, Object> scaleInfo = getImageScaleInfo(image, zoomWidth, zoomHeight);
						int scaleW = (Integer)scaleInfo.get(ImageInfo.WIDTH);
						int scaleH = (Integer)scaleInfo.get(ImageInfo.HEIGHT);
 						fileInfo.put("width", String.valueOf(scaleW));
						fileInfo.put("height",String.valueOf(scaleH));
						data.put("success", true);
						data.put("fileInfo", fileInfo);
					}
				}
			} catch (Exception e) {
				data.put("success", false);
				data.put("message", "IO错误！");
			}
		}
		PrintWriter out = resp.getWriter();
		data.put("error",0);
		data.put("url",fileName);
		out.print(data.toString());
		out.flush();
		out.close();
	}
	
	/**
	 * @return
	 */
	private String getBaseDir(){
		return this.getServletContext().getRealPath("/");
	}
	
	private Account getCurrentUser() {
		Account user = (Account)SecurityUtils.getSubject().getPrincipal();
		if (user != null) {
			return user;
		}
		
		return null;
	}
	
	private EnumMap<ImageInfo, Object> getImageScaleInfo(Image image, int zoomWidth, int zoomHeight) {
		int width = image.getWidth();
		int height = image.getHeight();
		int originalWidth = width;
		int originalHeight = height;
		int scaleBy = 0;
		boolean scaleWidth = false, scaleHeight = false;
		float scaleWidthPercent = 0, scaleHeightPercent = 0, scalePercent = 0;

		if (width > zoomWidth)
			scaleWidth = true;
		if (height > zoomHeight)
			scaleHeight = true;
		
		if (scaleWidth || scaleHeight) {
			if (scaleWidth)
				scaleWidthPercent = width/(float)zoomWidth;
			if (scaleHeight)
				scaleHeightPercent = height/(float)zoomHeight;
			if (scaleWidthPercent > scaleHeightPercent) {
				width = zoomWidth;
				height = Math.round(height/scaleWidthPercent);
				scalePercent = scaleWidthPercent;
				scaleBy = 1;
			} else {
				height = zoomHeight;
				width = Math.round(width/scaleHeightPercent);
				scaleBy = 2;
			}
		}
		
		EnumMap<ImageInfo, Object> data = new EnumMap<ImageInfo, Object>(ImageInfo.class);
		data.put(ImageInfo.ORIGINAL_WIDTH, originalWidth);
		data.put(ImageInfo.ORIGINAL_HEIGHT, originalHeight);
		data.put(ImageInfo.WIDTH, width);
		data.put(ImageInfo.HEIGHT, height);
		data.put(ImageInfo.SCALE_PERCENT, scalePercent);
		data.put(ImageInfo.SCALE_BY, scaleBy);
		
		return data;
	}
}

enum ImageInfo {
	ORIGINAL_WIDTH,
	ORIGINAL_HEIGHT,
	WIDTH,
	HEIGHT,
	SCALE_PERCENT,
	SCALE_BY;
}