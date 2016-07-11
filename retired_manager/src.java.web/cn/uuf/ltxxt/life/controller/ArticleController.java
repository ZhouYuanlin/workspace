package cn.uuf.ltxxt.life.controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Folder;
import cn.uuf.domain.life.Article;
import cn.uuf.ltxxt.life.service.ArticlesService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.permission.service.UserService;
import cn.uuf.util.DateUtil;
import cn.uuf.util.OpenOffice2HtmlUtil;
import cn.uuf.util.OpenOfficeToPdfUtil;
import cn.uuf.util.Paginate;


/**
 * @author: lth
 * @creation: Oct 15, 2013 10:21:57 AM
 * 类说明	：文章分享
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {
	private final String LIST_ACTION = "redirect:/article";
	@Autowired
	private ArticlesService	articlesService;
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public ModelAndView index(Integer page,Article p,HttpServletRequest request,HttpServletResponse response,RedirectAttributes re){
		ModelAndView mav = new ModelAndView("life/article/index");
		try{
			page = page == null || page < 0 ? 1 : page;
			int start = (page - 1) * size;
			List<Article> list = articlesService.queryByPage(p, start, size);
			Long count = articlesService.getCount(p);
			paginate = new Paginate(list,count, size, page);
			mav.addObject("paginate",paginate);
			mav.addObject("list",list);
			mav.addObject("appsList",SpUtil.list);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
		}
		return mav;
	}
	/**
	 * 增加
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/create")
	public ModelAndView create(HttpServletRequest request,HttpServletResponse response,Article r,String msg)throws Exception{
		ModelAndView mav = new ModelAndView("life/article/create");
		try {
		List<Article> list = articlesService.getAll();
		mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject(Constants.MESSAGE_NAME, msg);
		return mav;
	}
	/**
	 * 显示详情
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/{id}/view")
	public ModelAndView showDetail(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("life/article/detail");
		try {
			Article article  = articlesService.getById(id);
			
			mav.addObject("article", article);
			mav.addObject("list", articlesService.getAll());
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
			Article article  = articlesService.getById(id);
			
			mav.addObject("f", article);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxdetail(Long id,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("life/article/_swffile");
		try{
			String path = request.getSession().getServletContext()
					.getRealPath("/");
			Article article = articlesService.getById(id);
			String newPath = article.getNewUrl();
			File file = new File(path + newPath);
			String[] split;
			if (isWindowsSystem()) {
				split = newPath.split("/");
			} else {
				split = newPath.split("/");
			}
			newPath = "/" + split[1] + "/" + split[2] + "/" + split[3]+"/"+split[4]+"/";
			try {
				String htmlString = OpenOffice2HtmlUtil.toHtmlString(file, newPath);
				mav.addObject("str", htmlString);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	
	
	
	
	
	
	
	/**
	 * 上传
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/doUpload")
	public ModelAndView doUpload(@RequestParam("uploadFile") MultipartFile files,HttpServletRequest request,HttpServletResponse response,@Valid Article article,BindingResult result,RedirectAttributes redirect)throws Exception{
		ModelAndView mav = new ModelAndView(LIST_ACTION);
		try{
			if(result.hasErrors()){
				List<ObjectError> ls = result.getAllErrors();
				for(ObjectError oe : ls){
					return create(request,response,article,oe.getDefaultMessage());
				}
				
			}
			String path = request.getSession().getServletContext().getRealPath("/") ;
			String separator = "/";
			String childPath =  "upload"+separator+"life"+separator+"article"+separator+ DateUtil.getMSDateTime(new Date(), "")+separator;
			path += childPath;
			File file = new File(path);
			if(!file.exists())
				file.mkdirs();
			String fileName = files.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			fileName = DateUtil.getMSDateTime(new Date(), "")+fileType;
			fileName = new String(fileName.getBytes(),"utf-8"); 
			String newPath = path+fileName;
			String absUrl = separator+childPath+fileName;
			DataOutputStream out = new DataOutputStream(new FileOutputStream(newPath));
			InputStream is = files.getInputStream();
			byte[] buffer = new byte[2048]; 
			while(is.read(buffer)>0){ 
	    	  out.write(buffer);
	        } 
			is.close();
			out.close();
			File inputFile = new File(newPath);
			String name = fileName.substring(0,fileName.lastIndexOf("."));
			String htmlPath = path+name+".html";
			File outputFile = new File(htmlPath);
			OpenOffice2HtmlUtil.file2Html(inputFile, outputFile);
			article.setCdate(DateUtil.getCuurentDate(new Date(),  "yyyy-MM-dd"));
			article.setUrl(absUrl);
			String swfPath = absUrl.substring(0,absUrl.lastIndexOf("."));
			swfPath += ".html";
			article.setNewUrl(swfPath);
			article.setDelUrl(path);
			article.setZjh(this.getCurrentUser().getRealname());
			article.setStatus(Constants.APP_WAIT);
			articlesService.save(article);
			redirect.addFlashAttribute(Constants.MESSAGE_NAME, "上传成功！");
			this.writer("上传文章成功", request.getRemoteAddr(), this.getCurrentUser().getUsername());
		}catch(Exception e){
			e.printStackTrace();
			redirect.addFlashAttribute(Constants.MESSAGE_NAME, "上传失败！");
		}
		return mav;
	}
	/**
	 * 删除
	 * @author: lth
	 * @creation: Oct 10, 2013 2:34:25 PM
	 * @return: ModelAndView
	 */
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirect,Long... id)throws Exception{
		try{
			Article article = new Article();
			for(Long ids:id){
				article = articlesService.getById(ids);
				articlesService.delete(article);
			}
			redirect.addFlashAttribute(Constants.MESSAGE_NAME, "删除文章成功！");
			this.writer("成功删除文章信息",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			e.printStackTrace();
			redirect.addFlashAttribute("message", "删除失败！");
		}
		return new ModelAndView(LIST_ACTION);
	}
	/**
	 * 审批
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/approve")
	public ModelAndView approve(HttpServletRequest request,HttpServletResponse response,Long[] spid,String spjg)throws Exception{
		try {
			for(Long id : spid){
				Article article = articlesService.getById(id);
				article.setUser(userService.getById(this.getCurrentUser().getUsername()));
				article.setStatus(spjg);
				article.setApproveDate(DateUtil.getCuurentDate(new Date(),""));
				articlesService.update(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(LIST_ACTION);
	}
	//下载文章
	@RequestMapping("downloadFile")
	public void download(HttpServletRequest request,HttpServletResponse response)throws Exception{
		try{
			String articleUrl = request.getParameter("articleUrl");
			String path = request.getSession().getServletContext().getRealPath("/");
	    	File f = new File(path + articleUrl);
	    	String fileName = articleUrl.substring(articleUrl.lastIndexOf("/"));
	    	response.reset();
		    response.setContentType("application/ms-excel");
		    fileName = new String (fileName.getBytes("gbk"),"iso-8859-1");
		    response.setHeader("Content-Disposition","attachment;filename="+fileName+"");  
	    	FileInputStream fis = new FileInputStream(f);
	    	OutputStream output = response.getOutputStream();
		    byte[] b = new byte[(int)f.length()];
		    int j = 0;
		    while((j = fis.read(b)) > 0){
		      output.write(b, 0, j);
		    }
		    output.flush();
		    fis.close();
		    output.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return;
	}
	
	/**
	 * 文档下载
	 * */
	@RequestMapping(value="/{id}/download")
	public void download(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redAttr){
		try{
			String username = this.getCurrentUser().getUsername();
			Article article = articlesService.getById(id);
			String path = request.getSession().getServletContext().getRealPath("/");
	    	File file = new File(path + article.getUrl());
	    	response.reset();
		    response.setContentType("application/ms-excel");
		    String url = article.getUrl();
		    String fileName = url.substring(url.lastIndexOf("/")+1);
		    fileName = fileName.substring(fileName.lastIndexOf("."));
		    fileName = new String ((article.getTitle()+fileName).getBytes("utf-8"),"iso-8859-1");
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
			this.writer("下载文章",request.getRemoteAddr(),username);
		}catch(Exception e){
			e.printStackTrace();
		}
//		return new ModelAndView(LIST_ACTION);
	}
	
	 private static boolean isWindowsSystem() {
	      String p = System.getProperty("os.name");
	      return p.toLowerCase().indexOf("windows") >= 0 ? true : false;
	  }
	
}
