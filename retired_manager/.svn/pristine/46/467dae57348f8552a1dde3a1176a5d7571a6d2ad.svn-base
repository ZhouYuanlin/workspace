package cn.uuf.ltxxt.activity.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.activity.Retireactivity;
import cn.uuf.ltxxt.activity.service.RetireactivityService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.AddSQLQuery;
import cn.uuf.util.Paginate;

/**
 * 活动管理
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
@Controller
@RequestMapping("{retireactivity:retireactivity;*.?}")
public class RetireactivityController extends BaseController{

	private final String LIST_ACTION = "redirect:/retireactivity";
	@Resource
	private RetireactivityService rService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retireactivity t){
		ModelAndView mav = new ModelAndView("activ/activity/index");
		try{
			int s = (page - 1) * size;
			Long count = rService.getCount(t);
			List<Retireactivity> list = rService.queryList(t, s, size);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("t",t);
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("activ/activity/create");
		getCodeInf(mav);
		return mav;
	}
	
	@RequestMapping(value="{save:save;*.?}",method=RequestMethod.POST)
	public ModelAndView save(@Valid Retireactivity t,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("t",t);
					return new ModelAndView("redirect:/retireactivity/create");
				}
			}
			t.setCreateDate(new Date());
			rService.save(t);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
		}catch(Exception e){
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("activ/activity/update");
		mav.addObject("t",rService.getById(id));
		getCodeInf(mav);
		return mav;
	}
	
	@RequestMapping("{update:update;*.?}")
	public ModelAndView update(@Valid Retireactivity t,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("t",t);
					return new ModelAndView("redirect:/retireactivity/"+t.getId()+"edit");
				}
			}
			Retireactivity rt = rService.getById(t.getId());
			rt = (Retireactivity) AddSQLQuery.setObjectValue(t,rt);
			rService.update(rt);
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
			rService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	/**
	 * 异步提取信息
	 * @param response
	 * @param sfzh
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxDetail(HttpServletResponse response,Long id){
		ModelAndView mav = new ModelAndView("activ/activity/_info");
		try{
			Retireactivity t = rService.getById(id);
			mav.addObject("t",t);
			String xzcy = t.getXzcy();			
			if(t.getCyzh() != null || !t.getCyzh().equals("")){
					String[] s = t.getCyzh().split(",");
//					String st = "";
					List<Retirement> sele = new ArrayList<>();
					for(int i=0;i<s.length;i++){
//						st += "'" + s[i] + "'" + (i==s.length - 1 ? "" : ",");
						Retirement retirement = mentService.getById(s[i]);
						if(retirement==null){
							Retirement retirement2 = new Retirement();
							String[] xzcysplit = xzcy.split(";");
							if(xzcysplit.length>0){
								retirement2.setXm(xzcysplit[i]);
							}
							
							sele.add(retirement2);
						}else{
							sele.add(retirement);
						}
					}
					
					mav.addObject("list",sele);
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * 导出到excel
	 * @param m
	 * @param response
	 * @return
	 */
	@RequestMapping("{export:export;*.?}")
	public void exportExcel(Long id,HttpServletResponse response){
		try{
			Retireactivity t = rService.getById(id);
			Workbook wb = new HSSFWorkbook();//创建工作表
			Sheet createSheet = wb.createSheet("sheet1");//创建sheet
			Row ro = createSheet.createRow(0);
			createSheet.setColumnWidth(0,3500);
			Cell cr1 = ro.createCell(0);
			cr1.setCellValue("小组名");
			Cell cr2 = ro.createCell(2);
			cr2.setCellValue(t.getTitle());
			Row row = createSheet.createRow(1);//创建标题
			String[] cellTitle = {
				"序号","姓名","支部","联系电话","原工作单位"};
			for (int i = 0; i < cellTitle.length; i++) {
				createSheet.setColumnWidth(i, 3500);
				Cell createCell = row.createCell(i);
				createCell.setCellValue(cellTitle[i]);
			}
			List<Retirement> list = null;
			if(t.getCyzh() != null || !t.getCyzh().equals("")){
				String[] s = t.getCyzh().split(",");
				String st = "";
				for(int i=0;i<s.length;i++){
					st += "'" + s[i] + "'" + (i==s.length - 1 ? "" : ",");
				}
				String hql = "from Retirement m where m.sfzh in (" + st +")";
				list = mentService.queryByHql(hql);
			}
			int s = 2;
			for(Retirement r : list){
				Row dataRow = createSheet.createRow((short) s);
				for(int i = 0;i<cellTitle.length;i++){
					Cell da = dataRow.createCell(i);
					switch (i) {
						case 0:
							da.setCellValue(s-1);
							break;
						case 1:
							da.setCellValue(r.getXm() != null ? r.getXm() : "");
							break;
						case 2:
							da.setCellValue(r.getParty() != null ? r.getParty().getDzbmc() : "");
							break;
						case 3:
							da.setCellValue(r.getLxdh() != null ? r.getLxdh() : "");
							break;
						case 4:
							da.setCellValue(r.getDwb() != null ? r.getDwb().getName() : "");
							break;
					}
				}
				s++;
			}
			
			Date d=new Date(System.currentTimeMillis());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
			response.setHeader("Content-Disposition", "attachment;filename="+sdf.format(d)+".xls");// 设定输出文件头
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");// 定义输出类型
			OutputStream out = response.getOutputStream();
			wb.write(out);
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

