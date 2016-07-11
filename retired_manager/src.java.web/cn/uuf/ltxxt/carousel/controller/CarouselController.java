package cn.uuf.ltxxt.carousel.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.data.Carousel;
import cn.uuf.ltxxt.carousel.service.CarouselService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.Paginate;

/**
 * @author lth
 *
 */
@Controller
@RequestMapping("{carousel:carousel;*.?}")
public class CarouselController extends BaseController {

	@Resource
	private CarouselService carouselService;

	private final String LIST_ACTION = "redirect:/carousel";


	private final String PHOTO_PATH = File.separator + "upload"+ File.separator + "images" ;
	// 主页面
	@RequestMapping
	public ModelAndView index(Integer page, Carousel carousel,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView("carousel/index");
		try {
			page = page == null || page < 0 ? 1 : page;
			int start = (page - 1) * size;
			Long count = carouselService.getCount(carousel);
			List<Carousel> list = carouselService.queryList(carousel, start,size);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("c", carousel);
			mav.addObject("list", list);
			mav.addObject("paginate", paginate);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
		}
		return mav;
	}

	// 进入增加页面
	@RequestMapping("create")
	public ModelAndView create(Carousel carousel, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("carousel/create");
		return mav;
	}

	// 保存功能
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(@Valid
	Carousel carousel, BindingResult binding,
			@RequestParam(value = "imgFile", required = true)
			CommonsMultipartFile imgFile,
			HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redAttr) throws Exception {
		try {
			// 定义一个数组，用于保存可上传的文件类型
			List<String> fileTypes = new ArrayList<String>();
			fileTypes.add("jpg");
			fileTypes.add("png");
			fileTypes.add("bmp");
			fileTypes.add("gif");
			if (!(imgFile.getOriginalFilename() == null || "".equals(imgFile
					.getOriginalFilename()))) { 
				String fileName = imgFile.getOriginalFilename();
				// 获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，
				// 最后得到扩展名。==>后缀名!
				String ext = fileName.substring(fileName.lastIndexOf(".") + 1,
						fileName.length());
				// 对扩展名进行小写转换
				ext = ext.toLowerCase();
				File file = null;
				if (fileTypes.contains(ext)) {
					// 取得服务器路径
					String path = request.getSession().getServletContext()
							.getRealPath(this.PHOTO_PATH);
					SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			        long temp = df1.parse(df1.format(new Date())).getTime();//设置时间戳
//			        String imgpath = this.PHOTO_PATH +File.separator + temp + "." + ext;
			        carousel.setImgpath(temp + "." + ext);
	            	file = new File( path+File.separator + temp + "." + ext);
					if (!file.getParentFile().exists())
						file.getParentFile().mkdirs();
					FileCopyUtils.copy(imgFile.getBytes(), file);// spring
					// copy图片
					// 完成上传
					imgFile.transferTo(file); // 保存上传的图片
					// 属性
					carousel.setIp(request.getRemoteAddr());
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");// 设置日期格式
					Date date = df.parse(df.format(new Date())); // 得到系统当前时间并转换成Date
					carousel.setCreateDate(date);// new Date()为获取当前系统时间
					carouselService.save(carousel);
				} else {
					redAttr.addFlashAttribute("c", carousel);
					redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "上传图片必须是"
							+ fileTypes.toString() + "格式的，请重新选择！");
					return new ModelAndView("redirect:/carousel/create");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(LIST_ACTION);
	}

	@RequestMapping(value = "/{ids}/edit")
	public ModelAndView modify(@PathVariable Long ids, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView("carousel/update");
		try {
			Carousel carousel = carouselService.getById(ids);
			mav.addObject("c", carousel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	@RequestMapping(value = "/update")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView update( HttpServletRequest request,
			HttpServletResponse response, @Valid
			Carousel carousel, BindingResult result, Long xsh,
			RedirectAttributes redAttr,@RequestParam(value = "imgFile", required = true)
	CommonsMultipartFile imgFile) throws Exception {
		try {
			if (result.hasErrors()) {
				for (ObjectError oe : result.getAllErrors()) {
					redAttr.addFlashAttribute(Constants.MESSAGE_NAME, oe.getDefaultMessage());
					redAttr.addFlashAttribute("c",carousel);
					return new ModelAndView("redirect:/carousel/"+carousel.getId()+"/edit");
				}
			}
			// 定义一个数组，用于保存可上传的文件类型
			List<String> fileTypes = new ArrayList<String>();
			fileTypes.add("jpg");
			fileTypes.add("png");
			fileTypes.add("bmp");
			fileTypes.add("gif");
			if (!(imgFile.getOriginalFilename() == null || "".equals(imgFile
					.getOriginalFilename()))) { 
				String fileName = imgFile.getOriginalFilename();
				// 获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，
				// 最后得到扩展名。==>后缀名!
				String ext = fileName.substring(fileName.lastIndexOf(".") + 1,
						fileName.length());
				// 对扩展名进行小写转换
				ext = ext.toLowerCase();
				File file = null;
				if (fileTypes.contains(ext)) {
					// 取得服务器路径
					String path = request.getSession().getServletContext()
							.getRealPath(this.PHOTO_PATH);
					SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			        long temp = df1.parse(df1.format(new Date())).getTime();//设置时间戳
//						        String imgpath = this.PHOTO_PATH +File.separator + temp + "." + ext;
			        carousel.setImgpath(temp + "." + ext);
	            	file = new File( path+File.separator + temp + "." + ext);
					if (!file.getParentFile().exists())
						file.getParentFile().mkdirs();
					FileCopyUtils.copy(imgFile.getBytes(), file);// spring
					// copy图片
					// 完成上传
					imgFile.transferTo(file); // 保存上传的图片
				}
			}
			carousel.setIp(request.getRemoteAddr());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");// 设置日期格式
			Date date = df.parse(df.format(new Date())); // 得到系统当前时间并转换成Date
			carousel.setCreateDate(date);// new Date()为获取当前系统时间
			carouselService.update(carousel);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "修改图片成功");
		} catch (Exception e) {
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "修改图片失败");
		}
		return new ModelAndView(LIST_ACTION);
	}

	@RequestMapping(value = "delete")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redAttr,
			Long... ids) throws Exception {
		try {
			Carousel c = null;
			for (Long id : ids) {
				c = carouselService.getById(id);
				File imgFile = new File(request.getRealPath("") + this.PHOTO_PATH +File.separator + c.getImgpath());
				if(imgFile.isFile()){
					imgFile.delete();
				}
				carouselService.delete(id);
			}
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除图片成功");
		} catch (Exception e) {
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除图片失败");
		}
		return new ModelAndView(LIST_ACTION);
	}

}
