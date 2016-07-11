package cn.uuf.ltxxt.retire.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.Role;
import cn.uuf.domain.User;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.code.service.CodeDwbService;
import cn.uuf.ltxxt.system.permission.service.AccountService;
import cn.uuf.ltxxt.system.permission.service.RoleService;
import cn.uuf.ltxxt.system.permission.service.UserService;
import cn.uuf.util.AddSQLQuery;
import cn.uuf.util.Paginate;

/**
 * 生活服务
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-3
 */
@Controller
@RequestMapping("{retlife:retlife;*.?}")
public class RetlifeController extends BaseController{

	private final String LIST_ACTION = "redirect:/retlife";
	@Resource
	private RoleService roleService;
	@Resource
	private AccountService accountService;
	@Resource
	private CodeDwbService codeDwbService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retirement r){
		ModelAndView mav = new ModelAndView("retire/life/index");
		try{
			int s = (page - 1) * size;
			if(hasRoleScope().equals(Constants.INFOYX)){
				if(codeDwbService.getById(getUser().getCodedwb().getId()).getSfejdw().equals(Constants.HASYES)){
					r.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}
			}
			Long count = mentService.getCount(r,null,null,null,null,null,null);
			List<Retirement> list = mentService.queryList(r, s, size,null,null,null,null,null,null);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("r",r);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		getCodeInf(mav);
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("retire/life/create");
		getCodeInf(mav);
		return mav;
	}
	
	@RequestMapping("{save:save;*.?}")
	public ModelAndView save(String sfzh,Retirement ret,RedirectAttributes red){
		try{
			sfzh = splitSfzh(sfzh);
			if(sfzh != null || sfzh.length() > 0){
				Retirement m = mentService.getById(sfzh);
				m.setWsjfs(ret.getWsjfs());
				m.setJjyjt(ret.getJjyjt());
				m.setGgywx(ret.getGgywx());
				m.setZzgbjs(ret.getZzgbjs());
//				m = (Retirement) AddSQLQuery.setObjectValue(ret,m);
				mentService.update(m);
				red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
			}else{
				red.addFlashAttribute(Constants.MESSAGE_NAME,"身份证号不能为空");
			}
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable String id){
		ModelAndView mav = new ModelAndView("retire/life/update");
		try{
			mav.addObject("r",mentService.getById(id));
			this.getCodeInf(mav);
		}catch(Exception e){}
		return mav;
	}
	@RequestMapping("{update:update;*.?}")
	@Transactional(rollbackFor=Exception.class)
	public ModelAndView update(HttpServletRequest request,@Valid Retirement ret,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for (ObjectError oe : res.getAllErrors()) {
					red.addFlashAttribute(Constants.MESSAGE_NAME, oe.getDefaultMessage());
					red.addFlashAttribute("ret", ret);
					return new ModelAndView("redirect:/retlife/"+ret.getSfzh()+"/edit");
				}
			}
			Retirement m = mentService.getById(ret.getSfzh());
			m = (Retirement) AddSQLQuery.setObjectValue(ret,m);
			mentService.update(m);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改成功");
		}catch(Exception e){
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("{dcExcel:dcExcel;*.?}")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView uploadxsl(@RequestParam("uploadFile") MultipartFile uploadFile,HttpServletRequest request, HttpServletResponse response,RedirectAttributes red)throws Exception{
		try{
			Workbook workbook = WorkbookFactory.create(uploadFile.getInputStream());
			Sheet sheet = workbook.getSheetAt(0);
			for(int i=1;i<sheet.getLastRowNum()+1;i++){
				Row row = sheet.getRow(i);
				Retirement m = null;
				if(row != null){
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if(row.getCell(0).getStringCellValue() != null){
						m = mentService.getById(row.getCell(0).getStringCellValue());
						if(m != null){
							if(row.getCell(1) != null){
								row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
								m.setWsjfs(row.getCell(1).getStringCellValue());
							}
							if(row.getCell(2) != null){
								row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
								m.setJjyjt(row.getCell(2).getStringCellValue());
							}
							if(row.getCell(3) != null){
								row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
								m.setGgywx(row.getCell(3).getStringCellValue());
							}
							if(row.getCell(4) != null){
								row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
								m.setZzgbjs(row.getCell(4).getStringCellValue());
							}
							mentService.update(m);
						}
					}
				}
			}
			red.addFlashAttribute(Constants.MESSAGE_NAME,"导入成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"导入失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	/**
	 * 导出到excel
	 * @param m
	 * @param response
	 * @return
	 */
	@RequestMapping("{export:export;*.?}")
	public void exportExcel(Retirement p,HttpServletResponse response){
		try{
			Workbook wb = new HSSFWorkbook();//创建工作表
			Sheet createSheet = wb.createSheet("sheet1");//创建sheet
			Row row = createSheet.createRow(0);//创建标题
			String[] cellTitle = {
				"姓名","身份证号","性别","类型","原工作单位","卫生间扶手","急救一键通","公共意外险","在职干部结对"};
			for (int i = 0; i < cellTitle.length; i++) {
				createSheet.setColumnWidth(i, 3500);
				Cell createCell = row.createCell(i);
				createCell.setCellValue(cellTitle[i]);
			}
			List<Retirement> list = mentService.queryByVo(p);
			int s = 1;
			for(Retirement r : list){
				Row dataRow = createSheet.createRow((short) s);
				for(int i = 0;i<cellTitle.length;i++){
					Cell da = dataRow.createCell(i);
					switch (i) {
						case 0:
							da.setCellValue(r.getXm());
							break;
						case 1:
							da.setCellValue(r.getSfzh());
							break;
						case 2:
							da.setCellValue(r.getXb() != null ? r.getXb() : "");
							break;
						case 3:
							da.setCellValue(r.getLxb() != null ? r.getLxb().getName() : "");
							break;
						case 4://"姓名","身份证号","性别","类型","原工作单位","所在党支部","党费基数","缴费周期","金额","缴费时间"
							da.setCellValue(r.getDwb() != null ? r.getDwb().getName() : "");
							break;
						case 5:
							da.setCellValue(r.getWsjfs() != null ? r.getWsjfs() : "");
							break;
						case 6:
							da.setCellValue(r.getJjyjt() != null ? r.getJjyjt() : "");
							break;
						case 7:
							da.setCellValue(r.getGgywx() != null ? r.getGgywx() : "");
							break;
						case 8:
							da.setCellValue(r.getZzgbjs() != null ? r.getZzgbjs() : "");
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

