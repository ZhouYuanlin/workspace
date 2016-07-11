package cn.uuf.ltxxt.life.controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
import cn.uuf.domain.life.Video;
import cn.uuf.ltxxt.life.service.VideosService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.permission.service.UserService;
import cn.uuf.util.DateUtil;
import cn.uuf.util.Paginate;

/**
 * 类说明	：视频资源
 */
@Controller
@RequestMapping("/video")
public class VideosController extends BaseController {
	private final String LIST_ACTION = "redirect:/video";
	@Autowired
	private VideosService videosService;
	@Autowired
	private UserService userService;
	@RequestMapping
	public ModelAndView index(Integer page,Video v,HttpServletRequest request,HttpServletResponse response,RedirectAttributes re){
		ModelAndView mav = new ModelAndView("life/video/index");
		try{
			page = page == null || page < 0 ? 1 : page;
			int start = (page - 1) * size;
			List<Video> list = videosService.queryByPage(v, start, size);
			Long count = videosService.getCount(v);
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
	public ModelAndView create(HttpServletRequest request,HttpServletResponse response,Video r,String msg)throws Exception{
		ModelAndView mav = new ModelAndView("life/video/create");
		try {
		List<Video> list = videosService.getAll();
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
		ModelAndView mav = new ModelAndView("life/video/detail");
		try {
			Video video  = videosService.getById(id);
			mav.addObject("video", video);
			mav.addObject("list", videosService.getAll());
		} catch (Exception e) {
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
	public ModelAndView doUpload(@RequestParam("uploadFile") MultipartFile files,@RequestParam("filePic") MultipartFile filePic,HttpServletRequest request,HttpServletResponse response,@Valid Video video,BindingResult result,RedirectAttributes redirect,String title,String content)throws Exception{
		ModelAndView mav = new ModelAndView(LIST_ACTION);
		try{
			if(result.hasErrors()){
				List<ObjectError> ls = result.getAllErrors();
				for(ObjectError oe : ls){
					return create(request,response,video,oe.getDefaultMessage());
				}
				
			}
			String separator = "/";//File.separator;
			String path = request.getSession().getServletContext().getRealPath("/") ;
			String datePath = DateUtil.getMSDateTime(new Date(),"");
			String childPath = "upload"+separator+"life"+separator+"video"+separator+ datePath+separator;
			path += childPath;
			File file = new File(path);
			Long size = files.getSize();
			if(size > 1024*1024*200){
				redirect.addFlashAttribute(Constants.MESSAGE_NAME, "上传失败！单个文件最大为200M");
				return mav;
			}
			if(!file.exists())
				file.mkdirs();
			String fileName = files.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			fileName = DateUtil.getMSDateTime(new Date(), "")+fileType;
			String newPath = path+fileName;
			String absUrl = datePath+separator+fileName;
			DataOutputStream out = new DataOutputStream(new FileOutputStream(newPath));
			InputStream is = files.getInputStream();
			byte[] buffer = new byte[1024*1024]; 
			while(is.read(buffer)>0){ 
	    	  out.write(buffer);
	        } 
			is.close();
			out.flush();
			out.close();
			String slUrl = "";
			if(filePic.getSize()>0){
				String filePicName = filePic.getOriginalFilename();
				String filePicType = filePicName.substring(filePicName.lastIndexOf("."));
				filePicName = DateUtil.getMSDateTime(new Date(), "")+filePicType;
				String newPath2 = path+filePicName;
				slUrl = separator+childPath+filePicName;
				DataOutputStream out2 = new DataOutputStream(new FileOutputStream(newPath2));
				InputStream is2 = filePic.getInputStream();
				byte[] buffer2 = new byte[1024*1024]; 
				while(is2.read(buffer2)>0){ 
					out2.write(buffer2);
				} 
				is2.close();
				out2.close();
			}
			video.setTitle(title);
			video.setContent(content);
			video.setCdate(DateUtil.getCuurentDate(new Date(),  "yyyy-MM-dd"));
			video.setUrl(absUrl);
			video.setSlUrl(slUrl);
			video.setDelUrl(path);
			video.setZjh(this.getCurrentUser().getRealname());
			video.setStatus(Constants.APP_WAIT);
			videosService.save(video);
			redirect.addFlashAttribute(Constants.MESSAGE_NAME, "上传成功！");
			this.writer("上传视频成功", request.getRemoteAddr(), this.getCurrentUser().getUsername());
		}catch(Exception e){
			e.printStackTrace();
			redirect.addFlashAttribute(Constants.MESSAGE_NAME, "上传失败！");
		}
		return mav;
	}

	/**
	 * 删除视频跳转
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/appr")
	public ModelAndView appr(HttpServletRequest request,HttpServletResponse response,Long[] spid,String spjg)throws Exception{
		ModelAndView mav = new ModelAndView("life/video/appr");
		List<Video> list = videosService.getNoAppr();
		mav.addObject("list",list);
		mav.addObject("appsList",SpUtil.list);
		return mav;
	}
	/**
	 * 审核
	 * @return: ModelAndView
	 */
	@RequestMapping("/approve")
	public ModelAndView approve(HttpServletRequest request,HttpServletResponse response,Long[] spid,String spjg)throws Exception{
		Video r = new Video();
		for(Long id : spid){
			r = videosService.getById(id);
			r.setUser(userService.getById(this.getCurrentUser().getUsername()));
			r.setStatus(spjg);
			videosService.update(r);
		}
		return new ModelAndView("LIST_ACTION");
	}
	/**
	 * 删除
	 * @author: lth
	 * @creation: Oct 10, 2013 2:34:25 PM
	 * @return: ModelAndView
	 */
	@RequestMapping("/del")
	public ModelAndView del(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirect,Long... id)throws Exception{
		try{
			Video video = new Video();
			for(Long ids :id){
				video = videosService.getById(ids);
				videosService.delete(video);
				try{
					String filePath = video.getDelUrl();
					File file = new File(filePath);//该文件所在的文件夹
					DeleteFile.deleteFile(file);
				}catch(Exception e){}
			}
			redirect.addFlashAttribute(Constants.MESSAGE_NAME, "删除视频成功！");
			this.writer("成功删除视频信息",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			e.printStackTrace();
			redirect.addFlashAttribute("message", "删除失败！");
		}
		return new ModelAndView("redirect:/video/appr");
	}
}
