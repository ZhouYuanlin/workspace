package cn.uuf.ltxxt.mess.controller;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.Role;
import cn.uuf.domain.message.Notice;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.mess.service.NoticeService;
import cn.uuf.ltxxt.record.service.RetdepartService;
import cn.uuf.ltxxt.system.code.service.CodeDwbService;
import cn.uuf.ltxxt.system.permission.service.AccountService;
import cn.uuf.ltxxt.system.permission.service.UserService;
import cn.uuf.util.AddSQLQuery;
import cn.uuf.util.DateUtil;
import cn.uuf.util.FileHelper;
import cn.uuf.util.Paginate;
import cn.uuf.util.PhotoUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 通知公告
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-21
 */
@Controller
@RequestMapping("{retirenotice:retirenotice;*.?}")
public class RetirenoticeController extends BaseController{

	private final String LIST_ACTION = "redirect:/retirenotice";
	@Resource
	private NoticeService nService;
	@Resource
	private UserService uService;
	@Resource
	private RetdepartService depService;
	@Resource
	private AccountService accountService;
	@Resource
	private CodeDwbService codeDwbService;
	
	private final String PHOTO_PATH = "//upload/file//";
	private static Properties properties=null;
	static{
		try {
			org.springframework.core.io.Resource resource = new ClassPathResource("/thaus.properties");
			properties = PropertiesLoaderUtils.loadProperties(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Notice n){
		ModelAndView mav = new ModelAndView("notice/index");
		try{
			List<Role> rs = this.getCurrentUser().getRoles();
			int s = (page - 1) * size;
			for(Role r : rs){
				if(!r.getName().contains("管理员"))
					n.setDwbs(uService.getById(this.getCurrentUser().getUsername()).getCodedwb().getId()+"");
			}
			Long count = nService.getCount(n);
			List<Notice> list = nService.queryList(n, s, size);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("n",n);
			mav.addObject("user",this.getCurrentUser().getRealname());
			mav.addObject("dwblist",codeDwbService.getAll());
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("notice/create");
		mav.addObject("dwblist",codeDwbService.getAll());
		return mav;
	}
	
	@RequestMapping("{save:save;*.?}")
	public ModelAndView save(@Valid Notice n,BindingResult res,RedirectAttributes red,@RequestParam(value = "imgFile", required = true) CommonsMultipartFile imgFile,HttpServletRequest request){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("n",n);
					return new ModelAndView("redirect:/retirenotice/create");
				}
			}
			n.setFbz(this.getCurrentUser().getRealname());
			n.setCreateDate(new Date());
			n.setContent(n.getContent() == null ? "" : n.getContent().replaceAll("/retirenotice/",""));
			nService.save(n);
			if(!(imgFile.getOriginalFilename() ==null || "".equals(imgFile.getOriginalFilename()))){
				uploadFile(red, imgFile, n, request);
			}
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	private void uploadFile(RedirectAttributes red,CommonsMultipartFile imgFile,Notice n,HttpServletRequest request){
		try{
			//可上传的文件类型  
			String include=properties.getProperty("attachType");
	        if(!(imgFile.getOriginalFilename() ==null || "".equals(imgFile.getOriginalFilename()))) {
	        	String fileName = imgFile.getOriginalFilename();
	        	//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	        	n.setAttach(fileName);
	        	//获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名  
	            String ext = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
	            String fname=fileName.substring(0,fileName.lastIndexOf("."));//sdf.format(new Date())
	            String name = fname + "." + ext.replace(".","");
	            n.setAttach(name);
	            //对扩展名进行小写转换  
	            ext = ext.toLowerCase();  
	            File file = null;  
	            if(Arrays.asList(include.split(",")).contains(ext)) {
	            	String path = request.getSession().getServletContext().getRealPath(this.PHOTO_PATH) ;
	            	String imgPath = path + File.separator + n.getId() + File.separator + name;
	            	file = new File(imgPath);
	            	if(!file.getParentFile().exists())
	    				file.getParentFile().mkdirs();
	            	FileCopyUtils.copy(imgFile.getBytes(),file);//spring copy文件 完成上传
	            	nService.update(n);
	            }else{
	            	red.addFlashAttribute(Constants.MESSAGE_NAME, "附件上传失败必须是"+properties.getProperty("attachType")+"格式的，请重新选择！");
	            }
	        }
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("notice/update");
		mav.addObject("n",nService.getById(id));
		mav.addObject("dwblist",codeDwbService.getAll());
		return mav;
	}
	
	@RequestMapping(value="{update:update;*.?}",method=RequestMethod.POST)
	public ModelAndView update(@Valid Notice n,BindingResult res,RedirectAttributes red,@RequestParam(value = "imgFile", required = true) CommonsMultipartFile imgFile,HttpServletRequest request){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("n",n);
					return new ModelAndView("redirect:/retirenotice/"+n.getId()+"/edit");
				}
			}
			Notice no = nService.getById(n.getId());
			no = (Notice) AddSQLQuery.setObjectValue(n,no);
			no.setContent(no.getContent() == null ? "" : no.getContent().replaceAll("/retirenotice/",""));
			nService.update(no);
			if(!(imgFile.getOriginalFilename() ==null || "".equals(imgFile.getOriginalFilename()))){
				 uploadFile(red, imgFile, no, request);
			}
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("{delete:delete;*.?}")
	public ModelAndView delete(RedirectAttributes red,Long... id){
		try{
			nService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView detail(Long id) throws Exception{
		ModelAndView mav = new ModelAndView("notice/_detail");
		Notice notice = nService.getById(id);
		Account account = accountService.getByUserName(notice.getFbz());
		mav.addObject("account", account);
		mav.addObject("n",notice);
		return mav;
	}
	
	/**
	 * 附件下载
	 * */
	@RequestMapping(value = "/{id}/download")
	public ModelAndView download(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redAttr){
		try{
			//下载文件
			String sysPath = request.getSession().getServletContext().getRealPath(this.PHOTO_PATH) ;
			Notice n = nService.getById(id);
			String fj=n.getAttach();
			if (fj != null) {
				File f = new File(sysPath+File.separator+ n.getId()+File.separator+n.getAttach());
		    	if(fj.indexOf(".zip")!=-1||fj.indexOf(".rar")!=-1){	//压缩文件
		    		FileHelper.downloadZip(f,response);
		    	}else{
			    	response.reset();
				    response.setContentType("application/octet-stream");
				    response.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(f.getName(),"UTF-8"));  
			    	
			    	BufferedInputStream fis = new BufferedInputStream(new FileInputStream(f), 512*1024);
			    	OutputStream output = response.getOutputStream();
				    byte[] b = new byte[512*1024];
				    while(fis.read(b)!=-1){
				      output.write(b);
				    }
				    output.flush();
				    fis.close();
				    output.close();
		    	}
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "附件下载成功");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 异步上传图片
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="ajaxupload")
	public void  doUpload(HttpServletRequest request,@RequestParam("imgFile") MultipartFile ufile, 
			HttpServletResponse response)throws Exception{
		response.reset();
		response.setCharacterEncoding("UTF-8");     
        response.setContentType("text/html");     
		PrintWriter writer=null;
		try{
			writer=response.getWriter();
			//定义允许上传的文件扩展名
			HashMap<String, String> extMap = new HashMap<String, String>();
			extMap.put("image", "gif,jpg,jpeg,png,bmp");
			//检查扩展名
			String fileExt = ufile.getOriginalFilename().substring(ufile.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
			if(!Arrays.<String>asList(extMap.get("image").split(",")).contains(fileExt)){
				writer.println(getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get("image") + "格式。",null));
				writer.flush();
				return;
			}
			//最大文件大小(1M)
			int maxSize =1024*1024;
			int comSize =1024*300;
			long fileSize = ufile.getSize();
			//检查文件大小
			if(fileSize> maxSize){
				writer.println(getError("上传文件大小(1M)超过限制。",null));
				return;
			}
			String path = request.getSession().getServletContext().getRealPath("/");
			String childPath =  "upload"+File.separator+"file"+File.separator+"img"+File.separator+DateUtil.getMSDateTime(new Date(), "");
			path += childPath;
			File file = new File(path);
			String fileName=ufile.getOriginalFilename();
			String preFix=fileName.substring(fileName.lastIndexOf("."));
			if(!file.exists())
				file.mkdirs();
				long systime=System.currentTimeMillis();
				String newFileName=systime+preFix;
				String newPath = path+File.separator+newFileName;
				String absUrl = File.separator+childPath+File.separator+newFileName;
				DataOutputStream out = new DataOutputStream(new FileOutputStream(newPath));
				InputStream is = ufile.getInputStream();
				byte[] buffer = new byte[2048]; 
				while(is.read(buffer)>0){ 
		    	  out.write(buffer);
		        } 
				is.close();
				out.close();
				if (fileSize>comSize) {
					String flag="x";
					newFileName=systime+flag+preFix;
					String outFile=path+File.separator+newFileName;
					absUrl = File.separator+childPath+File.separator+newFileName;//处理过的图片
					boolean res=PhotoUtil.compressPic(newPath,outFile, 500, 500, true);//.compressImg(new File(newPath), comSize, new File(outFile));	
					if (res) {
						File ofl=new File(newPath);
						if (ofl.isFile()) {
							ofl.delete();//删除原图
						}
					}
				}
				writer.println(getError(null,absUrl));
				writer.flush();
		}catch(IOException e){
			writer.println(getError("图片上传失败！",null));
			writer.flush();
		}finally{
			if(writer!=null){
				try{
				writer.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			} 
		}
	}
	
	private String getError(String message,String url) {
		Gson gson=new GsonBuilder().serializeNulls().create();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("error", url == null ? 1 : 0);
		if(url == null)
			map.put("message", message);
		else
			map.put("url",url);
		return gson.toJson(map);
	}
}

