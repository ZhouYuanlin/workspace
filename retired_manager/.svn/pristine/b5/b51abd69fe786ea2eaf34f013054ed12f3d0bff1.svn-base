package cn.uuf.ltxxt.daily.controller;

import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.uuf.contants.Constants;
import cn.uuf.domain.daily.Workdaily;
import cn.uuf.ltxxt.daily.service.WorkdailyService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.code.service.CodeDwbService;
import cn.uuf.ltxxt.system.permission.service.UserService;
import cn.uuf.util.DateUtil;
import cn.uuf.util.Paginate;

/**
 * 工作日志查看
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-19
 */
@Controller
@RequestMapping("{retiredaily:retiredaily;*.?}")
public class RetiredailyController extends BaseController{

	@Resource
	
	private WorkdailyService wService;
	@Resource
	private UserService uService;
	@Resource
	private CodeDwbService codeDwbService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Workdaily w,
			String st,String ed,String xrsjst,String xrsjend){
		ModelAndView mav = new ModelAndView("daily/index");
		try{
			if(hasRoleScope().equals(Constants.INFOGR))
				w.setSfzh(this.getCurrentUser().getUsername());
			else if(hasRoleScope().equals(Constants.INFOYX))
				w.setPid(uService.getById(this.getCurrentUser().getUsername()).getCodedwb().getId());
			int s = (page - 1) * size;
			Long count = wService.getCount(w, st, ed,xrsjst,xrsjend);
			List<Workdaily> list = wService.queryList(w, s, size, st, ed,xrsjst,xrsjend);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("w",w);
			mav.addObject("st",st);
			mav.addObject("ed",ed);
			mav.addObject("xrsjst",xrsjst);
			mav.addObject("xrsjend",xrsjend);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	/**
	 * 根据查询条件导出日志信息
	 * @return: ModelAndView
	 */
	@RequestMapping("/doExport")
	public ModelAndView exportExcel(Workdaily daily,String st,String ed,HttpServletRequest request,HttpServletResponse response)throws Exception{
		try {
			if(hasRoleScope().equals(Constants.INFOGR))
				daily.setSfzh(this.getCurrentUser().getUsername());
			else if(hasRoleScope().equals(Constants.INFOYX)){
				if(codeDwbService.getById(uService.getById(this.getCurrentUser().getUsername()).getCodedwb().getId()).getSfejdw().equals("否")){
					daily.setPid(uService.getById(this.getCurrentUser().getUsername()).getCodedwb().getId());
				}
			}
			//daily.setSfzh(this.getCurrentUser().getUsername());
			List<Workdaily> list = wService.queryList(daily, 0, Integer.MAX_VALUE-1, st, ed,null,null);
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
	
	/**
	 * 根据用户名
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "autoCompleteUser", method = RequestMethod.POST)
	public @ResponseBody Object[] getAllUser(@RequestParam String query) {
		Object[] obj = null;
		Object[] autoComplete = null;
		try {
			StringBuffer strBuf=new StringBuffer();
			strBuf.append("select t.sfzh,t.xm from Workdaily t where 1=1 ");
			strBuf.append("and  ( t.sfzh like '"+query+"%' or t.xm like '"+query+"%') ");//and rownum <9 ");
			if(hasRoleScope().equals(Constants.INFOYX)){
				Long did = getUser() != null ? getUser().getCodedwb().getId() : null;
				if(did != null) strBuf.append(" and t.pid = " + did);
			}
			List data =  wService.queryByHql(strBuf.toString());
			autoComplete = new Object[data.size()];
			for(int i = 0 ;i < data.size(); i++){
				obj = (Object[]) data.get(i);
				autoComplete[i] = obj[0].toString()+"-"+obj[1];
			}
			return autoComplete;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

