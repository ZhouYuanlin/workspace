package cn.uuf.ltxxt.folder.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Folder;
import cn.uuf.domain.User;
import cn.uuf.ltxxt.folder.service.FolderService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.permission.service.UserService;
import cn.uuf.util.DateUtil;
import cn.uuf.util.DeleteFile;
import cn.uuf.util.OpenOffice2HtmlUtil;
import cn.uuf.util.Paginate;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-08
 * 类说明	：文件夹控制器
 */
@Controller
@RequestMapping("/folder")
public class FolderController extends BaseController{
	private final String LIST_ACTION = "redirect:/folder";
	private final String NO_PERMISSON = "周计划、月重点工作、工作月报";//这些文不允许删除
	private final String NO_DELETE = "19103,19104,19105,19106,24401,36300,69405";//这些文不允许删除
	@Autowired
	FolderService folderService;
	@Autowired
	UserService userService;
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Folder f,Long pid,HttpServletRequest request,HttpServletResponse response,Long dwId,String startDate,String endDate){
		ModelAndView mav = new ModelAndView("folder/index");
		try{
			Folder ff = new Folder();
			if(pid != null){
				ff = folderService.getById(pid);
				f.setParent(ff);
			}
			int d = (page - 1) * size;
			Long count = folderService.getCount(f);
			List<Folder> list = folderService.queryByPage(f, d, size);
			mav.addObject("list",list);
			mav.addObject("folder",f);	
			paginate = new Paginate(list,count, size, page);
			mav.addObject("paginate",paginate);
			mav.addObject("pid",pid);
			mav.addObject("pfolder", ff);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id,Long pid){
		ModelAndView mav = new ModelAndView("folder/update");
		try{
			mav.addObject("pid",pid);
			mav.addObject("r",folderService.getById(id));
			Folder f = new Folder();
			mav.addObject("plist",folderService.queryByPage(f,0,size));
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	/**
	 * 修改文档
	 * @param f
	 * @param res
	 * @param red
	 * @return
	 */
	@RequestMapping("{update:update;*.?}")
	public ModelAndView update(Long pid,@Valid Folder f,BindingResult res,RedirectAttributes red){
		try{
			Folder fo = folderService.getById(f.getId());
			fo.setFileName(f.getFileName());
			if(pid != null){
				fo.setParent(folderService.getById(pid));
			}else
				fo.setParent(null);
			folderService.update(fo);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	/**
	 * 通用地删除
	 * @param request
	 * @param red
	 * @param id
	 * @return
	 */
	@RequestMapping("{delete:delete;*.?}")
	public ModelAndView delete(HttpServletRequest request,RedirectAttributes red,Long pid,Long... id){
		try{
			for(Long i : id){
				if(NO_DELETE.contains(i+"")){
					red.addFlashAttribute(Constants.MESSAGE_NAME,"包含文件不允许删除【"+NO_PERMISSON + "】");
					red.addAttribute("pid",pid);
					return new ModelAndView(LIST_ACTION);
				}
			}
			String separator = File.separator;
			String sql = "update uf_folder set parent_id='' where parent_id=";
			for(Long i : id){
				try{
					String path = request.getSession().getServletContext().getRealPath("") ;
					Folder folder = folderService.getById(i);
					String fileUrl = folder.getFileUrl();
					String delUrl = fileUrl.substring(0,fileUrl.lastIndexOf(separator));
					path += delUrl;
					File file = new File(path);
					DeleteFile.deleteFile(file);
				}catch(Exception e){}
				sql += i;
				folderService.updateSql(sql);
				folderService.delete(i);
			}
			red.addAttribute("pid",pid);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping("{save:save;*.?}")
	public ModelAndView createFolder(RedirectAttributes red,String fileName,Long pid){
		try{
			Folder folder = new Folder();
			folder.setFileName(fileName);
			folder.setUser(userService.getById(this.getCurrentUser().getUsername()));
//			folder.setCreateDate(DateUtil.getCuurentDate(new Date(), "yyyy-MM-dd"));
			folder.setCreateDate(new Date());
			folder.setFileType(Constants.FOLDER);
			folder.setType("folder");
			folder.setStatus(Constants.PUBLIC);
			//说明该文件夹是在某一文件夹下被创建的
			if(pid!=null){
				folder.setParent(folderService.getById(pid));
			}
			folderService.save(folder);
			folder.setSort(folder.getId()+"");
			folderService.update(folder);
			red.addAttribute("pid",pid);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"创建成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"创建失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	/**
	 * ajax
	 * 重命名文件夹
	 * */
	@RequestMapping(value="ajaxrename",method = RequestMethod.POST)
	public ModelAndView renameFolder(HttpServletRequest request,HttpServletResponse response,String sub_val,Long ref)throws Exception{
		ModelAndView mav = new ModelAndView("folder/_read");
		try {
			Folder folder = folderService.getById(ref);
			folder.setFileName(sub_val);
			folderService.update(folder);
			mav.addObject("f",folder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * 转向上传文档页
	 * */
	@RequestMapping("gotoupload")
	public ModelAndView goUpload(Long pid,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav=new ModelAndView("folder/upload");
		String maxFileSize=request.getParameter("maxFileSize");
		mav.addObject("pid",pid);
		if(maxFileSize!=null){
			mav.addObject("error","上传文件大小超过"+maxFileSize+"M");
		}
		return mav;
	}
	/**
	 * 我的文档和文件夹下上传文档（应该用隐藏域）
	 * */
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView upload(@Valid Folder folder,BindingResult binding,
			@RequestParam(value = "uploadFile", required = true) CommonsMultipartFile uploadFile,
			HttpServletRequest request,HttpServletResponse response,RedirectAttributes red,Long pid)throws Exception{
		try{
			String username = this.getCurrentUser().getUsername();
			User currentUser = userService.getById(username);
			String path = request.getSession().getServletContext().getRealPath("/") ;
			String separator = File.separator;
			String childPath =  "upload"+separator+"document"+separator+DateUtil.getMSDateTime(new Date(), "")+separator;
			path += childPath;
			File file = new File(path);
			if(!file.exists())
				file.mkdirs();
			String fileName = uploadFile.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
			String msDateTime = DateUtil.getMSDateTime(new Date(), "");
			fileName = msDateTime+"."+fileType;//重新生成文件名避免重复
			String absUrl = separator+childPath+fileName;
			
			String newPath = path+fileName;
			File inputfile = new File(newPath);
			FileCopyUtils.copy(uploadFile.getBytes(),inputfile);
			
			//输出的文件名
			String ouputFileName = absUrl.substring(0,absUrl.lastIndexOf("."));
			
			if(isPreview(fileType)){
				
				File outputFile = new File(path+msDateTime+".html");
//				File pdfFile = new File(path+DateUtil.getMSDateTime(new Date(), "")+".pdf");
//				String swfPath = absUrl.substring(0,absUrl.lastIndexOf("."));
//				swfPath += ".swf"; 
//				OpenOfficeToPdfUtil oop = new OpenOfficeToPdfUtil(inputfile,pdfFile);
//				oop.start();
				OpenOffice2HtmlUtil.file2Html(inputfile, outputFile);
				folder.setNewUrl(ouputFileName);
				folder.setFileType(Constants.FILE_PREVIEW);
			}else{
				folder.setFileType(Constants.FILE_NOPREVIEW);
			}
			folder.setFileUrl(absUrl);
			folder.setType(fileType);
			folder.setUser(currentUser);
//			folder.setCreateDate(DateUtil.getCuurentDate(new Date(), "yyyy-MM-dd"));
			folder.setCreateDate(new Date());
			if(pid != null){
				folder.setParent(folderService.getById(pid));
			}
			folderService.save(folder);
			folder.setSort(folder.getId()+"");
			folderService.update(folder);
			red.addAttribute("pid",pid);
			red.addFlashAttribute(Constants.MESSAGE_NAME, "上传成功！");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME, "上传失败！");//重定向该参数不会丢 其他参数都丢了 防止重复提交请求
		}
		return new ModelAndView(LIST_ACTION);
	}
	/**
	 * 文档下载
	 * */
	@RequestMapping(value="/{id}/download")
	public void download(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redAttr){
		try{
			String username = this.getCurrentUser().getUsername();
			Folder folder = folderService.getById(id);
			String fileURL = folder.getFileUrl();
			String path = request.getSession().getServletContext().getRealPath("/");
	    	File file = new File(path + fileURL);
	    	String fileName = fileURL.substring(fileURL.lastIndexOf(File.separator)+1);
	    	response.reset();
		    response.setContentType("application/ms-excel");
		    fileName = new String (fileName.getBytes("gbk"),"iso-8859-1");
		    response.setHeader("Content-Disposition","attachment;filename="+fileName+"");  
	    	FileInputStream fis = new FileInputStream(file);
	    	OutputStream output = response.getOutputStream();
		    byte[] b = new byte[(int)file.length()];
		    int j = 0;
		    while((j = fis.read(b)) > 0){
		      output.write(b, 0, j);
		    }
		    output.flush();
		    fis.close();
		    output.close();
			this.writer("下载文档",request.getRemoteAddr(),username);
		}catch(Exception e){
			e.printStackTrace();
		}
//		return new ModelAndView(LIST_ACTION);
	}
	/**
	 * 预览文档详细页面
	 * */
	@RequestMapping("/{id}/detail")
	public ModelAndView detail(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav=new ModelAndView("folder/detail");
		try {
			Folder folder = folderService.getById(id);
			mav.addObject("f", folder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	/**
	 * 预览文档详细页面
	 * */
	@RequestMapping("/{id}/noschmadetail")
	public ModelAndView noschmadetail(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav=new ModelAndView("folder/noschmadetail");
		try {
			String path = request.getSession().getServletContext().getRealPath("/");
			Folder folder = folderService.getById(id);
			String newPath = folder.getNewUrl();
			File file = new File(path+newPath+".html");
			String[] split = newPath.split(System.getProperty("file.separator"));
			newPath ="/"+ split[1]+ "/"+split[2]+ "/"+split[3];
			
			String htmlString = OpenOffice2HtmlUtil.toHtmlString(file,newPath);
			mav.addObject("str", htmlString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxdetail(Long id,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("folder/_swffile");
		try{
			String path = request.getSession().getServletContext().getRealPath("/");
			Folder folder = folderService.getById(id);
			String type = folder.getType();
			String newPath = folder.getNewUrl();
			if(StringUtils.isNotBlank(type)&&(type.equals("pptx")||type.equals("ppt"))){
				String substring = newPath.substring(0, newPath.lastIndexOf(File.separator));
				File file = new File(path+substring);
				File[] listFiles = file.listFiles();
				List<String> list = new ArrayList<String>();
				for (File file2 : listFiles) {
					String name = file2.getName();
					if(name.endsWith("jpg")){
						list.add(name);	
					}
				}
				StringBuffer sb = new StringBuffer();
				for(int i=0;i<list.size();i++){
					sb.append("<img src=\""+substring+File.separator+"img"+i+".jpg"+"\">");
				}
				mav.addObject("str", sb.toString());
			}else{
				File file = new File(path+newPath+".html");
				String[] split;
				if(isWindowsSystem()){
					split = newPath.split("\\\\");
				}else{
					split = newPath.split("/");
				}
				newPath ="/"+ split[1]+ "/"+split[2]+ "/"+split[3];
				String htmlString = OpenOffice2HtmlUtil.toHtmlString(file,newPath);
				mav.addObject("str", htmlString);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	//判断是否为如下类型
	boolean isPreview(String fileType){
		String[] types = new String[]{"doc","docx","xls","xlsx","pdf","ppt","pptx","txt"}; 
		boolean isPreview = false;
		for(int i = 0;i< types.length;i++){
			if(fileType.equals(types[i])){
				isPreview = true;
			}
		}
		return isPreview;
	}
	/**
	 * 升降序
	 * @param id自己
	 * @param nid要交换的id
	 * @return
	 */
	@RequestMapping("/{id}/{nid}/sort")
	public ModelAndView asc(@PathVariable Long id,@PathVariable Long nid,RedirectAttributes red){
		try{
			Folder f = folderService.getById(id);
			Folder fn = folderService.getById(nid);
			if(f != null && fn != null){
				String s = f.getSort();
				f.setSort(fn.getSort());fn.setSort(s);
				folderService.update(f);folderService.update(fn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	 private static boolean isWindowsSystem() {
	      String p = System.getProperty("os.name");
	      return p.toLowerCase().indexOf("windows") >= 0 ? true : false;
	  }
}
