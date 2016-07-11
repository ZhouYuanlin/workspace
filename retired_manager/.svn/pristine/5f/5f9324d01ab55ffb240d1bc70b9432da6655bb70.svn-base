package cn.uuf.ltxxt.daily.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.daily.Workdaily;
import cn.uuf.ltxxt.daily.service.WorkdailyService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.code.service.CodeDwbService;
import cn.uuf.ltxxt.system.permission.service.UserService;
import cn.uuf.util.DateUtil;
import cn.uuf.util.Paginate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 工作日志
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-17
 */
@Controller
@RequestMapping("{workdaily:workdaily;*.?}")
public class WorkdailyController extends BaseController{

	private final String LIST_ACTION = "redirect:/workdaily";
	@Resource
	private WorkdailyService wService;
	@Resource
	private UserService uService;
	@Resource
	private CodeDwbService codeDwbService;
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Workdaily w){
		ModelAndView mav = new ModelAndView("daily/daily");
		try{
			mav.addObject("w",w);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	/**
	 * 跳新增页面
	 * @param d(时间)
	 * @param id修改主键
	 * @return
	 */
	@RequestMapping("{ajaxCreate:ajaxCreate;*.?}")
	public ModelAndView ajaxCreate(String t,String zy,String d,Long id){
		ModelAndView mav = new ModelAndView("daily/_info");
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			
			Workdaily w = new Workdaily();
			if(d != null)
				w.setCreateDate(sdf.parse(d));
			if(id != null)
				w = wService.getById(id);
			String s = w.getCreateDate().after(DateUtil.befoDays()) || (t != null && t.equals("2")) ? "计划,个人" : "日志,个人";
			String z = "普通,重要";
			mav.addObject("tps",s);
			mav.addObject("w",w);
			mav.addObject("sfzy", z);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * 查询日期范围内工作日志信息
	 * @param request
	 * @param response
	 * @param daily
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping(value="ajaxcanlendar",method=RequestMethod.POST)
	public @ResponseBody String canlendarModel(HttpServletRequest request,HttpServletResponse response,Workdaily daily,String startDate,String endDate){
		Gson json=new GsonBuilder().serializeNulls().create();
		String res="";
		try {
			Date stDate=DateUtil.parse(startDate, "yyyy-MM-dd HH:mm:ss");
			Date edDate=DateUtil.parse(endDate, "yyyy-MM-dd HH:mm:ss");
			daily.setSfzh(this.getCurrentUser().getUsername());//每个人查自己的
			List<Workdaily> list=wService.queryCalendarEvents(daily,stDate, edDate);
			List<Map<String,Object>> ls=new ArrayList<Map<String,Object>>();
			Map<String,Object> map=null;
			for (Workdaily workDaily : list) {
				map=new HashMap<String, Object>();
				map.put("id",workDaily.getId());
				map.put("title",StringUtils.isNotEmpty(workDaily.getSfzy())&&workDaily.getSfzy().equals("重要")?"[重要]"+workDaily.getContent():""+workDaily.getContent());
				map.put("start",workDaily.getCreateDate());
				map.put("content",workDaily.getContent());
				map.put("type", workDaily.getType());
				map.put("backgroundColor",workDaily.getType().equals("日志") ? "#7CCD7C" : workDaily.getType().equals("计划") ? "#87CEEB" : "#FF6347");
				map.put("status", workDaily.getStatus());
				ls.add(map);
			}
			res=json.toJson(ls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 保存工作日志
	 * @param request
	 * @param type
	 * @param content
	 * @param date
	 * @return
	 */
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ModelAndView ajaxSave(Workdaily w,String sfzy,HttpServletRequest request,String nf,RedirectAttributes red){
		Date recordDate=DateUtil.parse(nf, "yyyy-MM-dd");
		w.setCreateDate(recordDate);
		w.setSfzh(getCurrentUser().getUsername());
		w.setXm(this.getCurrentUser().getRealname());
		if(codeDwbService.getById(uService.getById(this.getCurrentUser().getUsername()).getCodedwb().getId()).getSfejdw().equals("否")){
			w.setPid(uService.getById(this.getCurrentUser().getUsername()).getCodedwb().getId());
		}
		if (!w.getType().equals(Constants.WORK_NOTE)) {
			w.setStatus(Constants.HASNO);
			w.setSfwc(Constants.HASNO);
		}else{//日志
			w.setStatus(Constants.HASYES);
			w.setSfwc(Constants.HASYES);
		}
		w.setXrsj(new Date());
		wService.saveOrUpdate(w);
		red.addFlashAttribute(Constants.MESSAGE_NAME,"操作成功");
		return new ModelAndView(LIST_ACTION);
	}

	/**
	 * 删除日志
	 * @param red
	 * @param id
	 * @return
	 */
	@RequestMapping("{strike:strike;*.?}")
	public ModelAndView delete(RedirectAttributes red,Long... id){
		try{
			wService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除日志成功");
		}catch (Exception e) {
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	/**
	 * 查询工作日志
	 * @param page
	 * @param daily
	 * @param request
	 * @param response
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @param status
	 * @return
	 */
	@RequestMapping(value="query")
	public ModelAndView query(@RequestParam(defaultValue="1")Integer page,Workdaily daily,HttpServletRequest request,HttpServletResponse response,String name,String startDate,String endDate,String status){
		ModelAndView mav = new ModelAndView("daily/index");
		try {
				daily.setSfzh(this.getCurrentUser().getUsername());
				int start = (page - 1) * size;
				if (status!=null && status.trim().length()>0) {
					daily.setStatus(status);
				}
				daily.setType(Constants.WORK_NOTE);
				List<Workdaily> list=wService.queryList(daily, start, size, startDate, endDate,null,null);
				Long count=wService.getCount(daily,startDate,endDate,null,null);
				paginate = new Paginate(list,count, size, page);
				mav.addObject("paginate",paginate);
				mav.addObject("daily", daily);
				mav.addObject("list", list);
				mav.addObject("startDate", startDate);
				mav.addObject("endDate", endDate);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME, "数据读取失败");
		}
		return mav;
	}
	/**
	 * 查看工作日志
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{id}/view")
	public ModelAndView view(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("daily/detail");
		try{
			if (id!=null) {
				Workdaily daily=wService.getById(id);
				if (daily.getStatus().equals(Constants.HASNO)) {
					daily.setStatus(Constants.HASYES);
					wService.update(daily);					
				}
				mav.addObject("daily", daily);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}	
	/**
	 * 删除工作日志
	 * @param request
	 * @param redirect
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	public ModelAndView delete(HttpServletRequest request,RedirectAttributes redirect,Long...id){
		ModelAndView mav=new ModelAndView("redirect:/workDaily/query");
		try {
			wService.delete(id);
			redirect.addFlashAttribute(Constants.MESSAGE_NAME, "工作日志删除成功！");
			this.writer("工作日志删除成功！",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		} catch (Exception e) {
			redirect.addFlashAttribute(Constants.MESSAGE_NAME, "工作日志删除失败！");
		}
		return mav;
	}
	/**
	 * 根据查询条件导出日志信息
	 * @return: ModelAndView
	 */
	@RequestMapping("/doExport")
	public ModelAndView exportExcel(Workdaily daily,String startDate,String endDate,HttpServletRequest request,HttpServletResponse response)throws Exception{
		try {
			daily.setSfzh(this.getCurrentUser().getUsername());
			daily.setType(Constants.WORK_NOTE);
			List<Workdaily> list = wService.queryList(daily, 0, Integer.MAX_VALUE-1, startDate, endDate,null,null);
			String[] headers = { "工号", "姓名", "日期", "工作内容","是否已阅"};
			String fileName = "workDaily"+DateUtil.getMSDateTime(new Date(), DateUtil.DEFAULT_DATEMS_FORMAT);
			response.setHeader("Content-Disposition", "attachment;filename="+fileName+".xls");// 设定输出文件头
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");// 定义输出类型
			OutputStream out = response.getOutputStream();	
			Workbook workbook = new HSSFWorkbook();
			Sheet sheet = workbook.createSheet("工作日志详情");
			Row row = sheet.createRow(0);
			for (int i = 0; i < headers.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(headers[i]);
			}
			Workdaily work = null;
			for(int i=0;i< list.size();i++){
				Row dataRow = sheet.createRow(i+1);
				work = list.get(i);
				for(int j=0;j<headers.length;j++){
					Cell cell = dataRow.createCell(j);
					switch (j) {
					case 0:
						cell.setCellValue(work.getSfzh() != null ? work.getSfzh() : "");
						break;
					case 1:
						cell.setCellValue(work.getXm() != null ? work.getXm(): "");
						break;
					case 2:
						cell.setCellValue(DateUtil.getDateTime(work.getCreateDate(), "yyyy-MM-dd") != null ? 
								DateUtil.getDateTime(work.getCreateDate(), "yyyy-MM-dd"): "");
						break;
					case 3:
						cell.setCellValue(work.getContent() != null ?work.getContent(): "");
						break;
					case 4:
						cell.setCellValue(work.getStatus() != null ?work.getStatus(): "");
						break;
					}
				}
			}
			workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

