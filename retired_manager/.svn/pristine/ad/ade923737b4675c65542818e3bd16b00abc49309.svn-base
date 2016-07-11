/**
 * 
 */
package cn.uuf.ltxxt.retire.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.Retirewages;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.retire.service.RetirementService;
import cn.uuf.ltxxt.retire.service.RetiresubsidyService;
import cn.uuf.ltxxt.retire.service.RetirewagesService;
import cn.uuf.util.Paginate;

/**
 * @author 作者 :蒋朋
 * @version 创建时间：2016年3月21日 上午11:35:30 
 * 类说明：工资条的controller
 */
@Controller
@RequestMapping("{retwages:retwages;*.?}")
public class RetwageController extends BaseController {

	

	private final String LIST_ACTION = "redirect:/retwages";
	
	@Resource
	private RetirementService acService;
	
	@Resource
	private RetirewagesService rService;

	@Resource
	private RetiresubsidyService sService;
	
	/**
	 * 查询的方法
	 * @param page--页数
	 * @param gzjs--工资发放时间止
	 * @param ffjbt--是否发放津补贴
	 * @param jbtjs--本级津补贴发放时间止
	 * @param r
	 * @return
	 */
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,String gzjs,String ffjbt,String jbtjs,String ttgzygZ,String jbtyfZ,Retirewages r) {
		ModelAndView model = new ModelAndView("retire/wages/index");

		int s = (page - 1) * size;//页数
		Long count = 0l;//行数
		List<Retirewages> listwages=new ArrayList<Retirewages>();
		try {
			count=rService.getCount(gzjs, jbtjs, r, ffjbt,ttgzygZ,jbtyfZ);
			listwages = rService.queryList(s, size, gzjs, jbtjs, r, ffjbt,ttgzygZ,jbtyfZ);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(5<<2);
		paginate = new Paginate(listwages, count, size, page);
		model.addObject("listwages", listwages);
		model.addObject("paginate", paginate);
		model.addObject("gzjs", gzjs);
		model.addObject("ffjbt", ffjbt);
		model.addObject("jbtjs", jbtjs);
		model.addObject("ttgzygZ", ttgzygZ);
		model.addObject("jbtyfZ", jbtyfZ);
		model.addObject("r", r);
		return model;
	}

	/**
	 * 添加的方法第一步
	 * 
	 * @return
	 */
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("retire/wages/create");
		getCodeInf(mav);
		return mav;
	}
	
	private ModelAndView isWhetherThereErrors(Retirewages r, RedirectAttributes red, BindingResult res,String url)
	{
		if (res.hasErrors()) {
			for (ObjectError e : res.getAllErrors()) {
				red.addFlashAttribute(Constants.MESSAGE_NAME, e.getDefaultMessage());
				red.addFlashAttribute("r", r);
				return new ModelAndView(url);
			}
		}
		return null;
	}
	
	/**
	 * 添加方法第二步
	 * @param YesOrNobfbt
	 * @param r
	 * @param red
	 * @param res
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView save(@RequestParam("YesOrNobfbt") String YesOrNobfbt,Retirewages r, RedirectAttributes red, BindingResult res) {
		ModelAndView model=null;
		try {
			model=isWhetherThereErrors(r, red, res, "redirect:/wages/create");
			Retirewages tempr=new Retirewages();
			tempr.setXm(r.getXm());
			tempr.setSfzh(r.getSfzh());
			tempr.setYf(r.getYf());
			if(rService.getByMonth(tempr)!=null)
			{
				red.addFlashAttribute(Constants.MESSAGE_NAME,"工资发放失败,原因是"+tempr.getXm()+"在"+tempr.getBjjbt().getFfyf()+"已发放过工资");
				return new ModelAndView(LIST_ACTION);
			}
			Date temp=new Date();
			r.setCjsj(temp);
			if (YesOrNobfbt.equals("true")) {//判断是否同时发放列本级补 
				r.getBjjbt().setBcjsj(temp);
				r.getBjjbt().setXm(r.getXm());
				r.getBjjbt().setSfzh(r.getSfzh());
			}
			rService.save(r);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"工资发放成功");
		} catch (Exception e) {
			//TODO: handle exception
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"工资发放失败");
		}
		if(model==null){model=new ModelAndView(LIST_ACTION);}
		return model;
	}
	
	/**
	 * 修改第一步
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView update(Long id)
	{
		ModelAndView model=new ModelAndView("retire/wages/update");
		try {
			Retirewages ret = rService.getById(id);
			model.addObject("r", ret);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
	/**
	 * 修改
	 * @param YesOrNobfbt
	 * @param r
	 * @param red
	 * @param res
	 * @return
	 */
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public ModelAndView modify(@RequestParam("YesOrNobfbt") String YesOrNobfbt,Retirewages r, RedirectAttributes red, BindingResult res)
	{
		ModelAndView model=null;
		try {
			model=isWhetherThereErrors(r, red, res, "redirect:/retwages/update?id="+r.getId());
			Retirewages temp=rService.getById(r.getId());
			r.setSfzh(temp.getSfzh());
			r.getBjjbt().setSfzh(temp.getSfzh());
			r.setCjsj(temp.getCjsj());
			r.getBjjbt().setBcjsj(r.getBjjbt().getBcjsj());
			if (YesOrNobfbt.equals("true")) {// 判断是否同时发放列本级补 
				r.getBjjbt().setBcjsj(new Date());
			}
			
			rService.update(r);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"工资更改成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"工资更改失败");
		}
		if(model==null){model=new ModelAndView(LIST_ACTION);}
		return model;
	}
	/**
	 * 删除
	 * @param red
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ModelAndView delete(RedirectAttributes red,Long... id){
		try{
			rService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"工资记录删除成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"工资记录删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	/**
	 * 查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxRetiWagesDetails;*.?}")
	public ModelAndView details(Long id)
	{
		ModelAndView model=new ModelAndView("retire/wages/_details");
		model.addObject("retDetails",rService.getById(id));
		return model;
	}
	
	/**
	 * 导入----第一步
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxRetiWagesImport;*.?}")
	public ModelAndView beforeim(){
		return new ModelAndView("/retire/wages/_import");
	} 
	
	/**
	 * 导入第二行
	 * @param RetwageFile
	 * @param RetiresubsidyFile
	 * @param request
	 * @param response
	 * @param red
	 * @return
	 */
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public ModelAndView uploadxsl(@RequestParam("RetwageFile") MultipartFile RetwageFile,
			@RequestParam("RetiresubsidyFile") MultipartFile RetiresubsidyFile, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes red) {
		List<Retirewages> list=new ArrayList<Retirewages>();
		if(RetwageFile.getSize()>0)
		{
			list.addAll(this.importRetwageFile(RetwageFile));
		}
		if(RetiresubsidyFile.getSize()>0)
		{
			list.addAll(this.importRetiresubsidyFile(RetiresubsidyFile));
		}
		int size=0;
		Retirewages temp,tempByI;
		BigDecimal Zero=new BigDecimal("0");
		try {
			for(int i=0,listSize=list.size();i<listSize;i++)
			{
				tempByI=list.get(i);
				temp=rService.getByMonth(tempByI);
				if(temp!=null)
				{
					if (tempByI.getSfxj() != null && !tempByI.getSfxj().equals(Zero) && temp.getSfxj() == null) {
						tempByI.setId(temp.getId());
						tempByI.setBjjbt(temp.getBjjbt());
						rService.update(tempByI);
						size++;
					}
					if (tempByI.getBjjbt().getSfgz() != null && !tempByI.getBjjbt().getSfgz().equals(Zero)
							&& temp.getBjjbt().getSfgz() == null) {
						tempByI.getBjjbt().setId(temp.getBjjbt().getId());
						temp.setBjjbt(tempByI.getBjjbt());
						rService.update(temp);
						size++;
					}
				}
				else
				{
					rService.save(tempByI);
					size++;
				}
			}
			if(size==0){throw new Exception();}
			red.addFlashAttribute(Constants.MESSAGE_NAME,"工资记录导入添加"+size+"条工资");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"工资记录导入失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("{ajaxdetail:ajaxRetiWagesExport;*.?}")
	public ModelAndView beforexp(){
		return new ModelAndView("/retire/wages/_export");
	}
	/**
	 * 导出第二步
	 * @param accoutns
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="isFreeExport")
	public void exportExcel(@ModelAttribute("accounts") Accounts accoutns,HttpServletResponse response) throws IOException{
		OutputStream out = response.getOutputStream();
		Workbook wb = new HSSFWorkbook();//创建工作表
		
		CellStyle  titleStyle= wb.createCellStyle();//标题样式
		Font ztFont = wb.createFont();//创建字体对象
		ztFont.setFontHeightInPoints((short)14);// 将字体大小设置为18px
		//ztFont.setStrikeout(true);
		titleStyle.setFont(ztFont);
		titleStyle.setFillForegroundColor(IndexedColors.RED.getIndex());// 前景色
		titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND); 
		titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//居中对齐
		titleStyle.setBorderLeft(CellStyle.BORDER_THIN);
		titleStyle.setBorderRight(CellStyle.BORDER_THIN);
		titleStyle.setBorderBottom(CellStyle.BORDER_THIN);
		titleStyle.setBorderTop(CellStyle.BORDER_THIN);
		CellStyle  contentStyle= wb.createCellStyle();//内容样式

		contentStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//居中对齐
		contentStyle.setBorderLeft(CellStyle.BORDER_THIN);
		contentStyle.setBorderRight(CellStyle.BORDER_THIN);
		contentStyle.setBorderBottom(CellStyle.BORDER_THIN);
		contentStyle.setBorderTop(CellStyle.BORDER_THIN);

		Font contentFont = wb.createFont();//创建字体对象
		contentFont.setFontHeightInPoints((short)11);// 将字体大小设置为18px
		contentStyle.setFont(contentFont);
		Sheet createSheet = wb.createSheet("sheet1");//创建sheet
		Row row = createSheet.createRow(0);//创建标题
		row.setHeightInPoints(22);//设置高
		try{
			List<Account> accountList=accoutns.getList();
			if(accountList==null)
			{
				throw new Exception("没有数据");
			}
			int f=0,l=0,listSize=accountList.size();
			
			int tempI=0;
			//开写入标题
			for(int i=0;i<listSize;i++){
				if(StringUtils.isNotEmpty(accountList.get(i).getGzzh())){//判断是否为空,过虑非选中的列
					Cell cell=row.createCell(f);
					cell.setCellStyle(titleStyle);//加样式
					String temp=accountList.get(i).getLxdh();
					cell.setCellValue(temp);//写入
					System.out.println(temp.length());
					createSheet.setColumnWidth(tempI, temp.length()*1000);
					tempI++;
					f++;
				}
			}
			//标题写入完成
			
			List<Retirewages> list=rService.find();
			String v=null;
			for(int i=0,size=list.size();i<size;i++)//循环遍历完查询到的数据
			{
				Row dataRow = createSheet.createRow((short) i+1);//新建第n行
				dataRow.setHeightInPoints(15);//设置高
				l=0;//第l列
				for(int j=0;j<listSize;j++)
				{
					if(StringUtils.isNotEmpty(accountList.get(j).getGzzh())){//判断是否为空,过虑非选中的列
						Cell dataCell = dataRow.createCell(l);//创建表格
						dataCell.setCellStyle(contentStyle);
						try {
							v=BeanUtils.getProperty(list.get(i), accountList.get(j).getGzzh());//通过反射得到值
							dataCell.setCellValue(v == null ? "" : v);//写入表格
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("姓名为"+list.get(i).getXm()+"的"+accountList.get(j).getLxdh()+"的值为null");
						}
						l++;
					}
				}
			}
			
			Date d=new Date(System.currentTimeMillis());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
			response.setHeader("Content-Disposition", "attachment;filename="+sdf.format(d)+".xls");// 设定输出文件头
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");// 定义输出类型
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			out.flush();
			out.close();
		}
	}
	
	
	//自定义列
	public class Accounts{
		private List<Account> list;

		public List<Account> getList() {
			return list;
		}
		public void setList(List<Account> list) {
			this.list = list;
		}
	}
	
	@ModelAttribute("accounts")
	public Accounts initAccounts() {
		Accounts accounts = new Accounts();
		return accounts;
	}

	Pattern p=Pattern.compile("^[0-9]+(.[0-9]*)?$");
	
	/**
	 * 批量添加--财统工资
	 * @param RetwageFile
	 * @param red
	 * @return
	 */
	private List<Retirewages> importRetwageFile(MultipartFile RetwageFile)
	{
		List<Retirewages> listWages=new ArrayList<Retirewages>();
		Retirewages wages=null;//声明一个实体对象
		int improtError=0;
		try {
			Workbook workbook = WorkbookFactory.create(RetwageFile.getInputStream());//得到Excel文件
			Sheet sheet = workbook.getSheetAt(0);//得到第一个工作表
			for(int i=1,size=sheet.getLastRowNum()+1;i<size;i++)
			{
				improtError=0;
				Row row = sheet.getRow(i);//得到一行
				wages=new Retirewages();
				Retirewages temp=new Retirewages();
				if(row!=null){//排除为空的可能
					if(row.getCell(0) != null)//排除为空--姓名
					{
						row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						try {
							Retirement tempMent=acService.queryByXm(row.getCell(0).getStringCellValue());
							if (tempMent == null) {
								improtError++;
							} else {
								wages.setSfzh(tempMent.getSfzh());
								wages.getBjjbt().setSfzh(tempMent.getSfzh());
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							improtError++;
						}
						wages.setXm(row.getCell(0).getStringCellValue());//将它set到Retirewages对象中
						wages.getBjjbt().setXm(wages.getXm());
						temp.setXm(wages.getXm());
						temp.setSfzh(wages.getSfzh());
					}else{improtError++;}
					if(row.getCell(1) != null)//排除为空--离退休费
					{
						row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(1).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setLtxf(new BigDecimal(row.getCell(1).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(2) != null)//排除为空--生活补
					{
						row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(2).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setShb(new BigDecimal(row.getCell(2).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(3) != null)//排除为空--交通
					{
						row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(3).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setJt(new BigDecimal(row.getCell(3).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(4) != null)//排除为空--在京补
					{
						row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(4).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setZjb(new BigDecimal(row.getCell(4).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(5) != null)//排除为空--电 话补
					{
						row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(5).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setDhb(new BigDecimal(row.getCell(5).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(6) != null)//排除为空--书报费
					{
						row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(6).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setSbf(new BigDecimal(row.getCell(6).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(7) != null)//排除为空--洗理
					{
						row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(7).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setXl(new BigDecimal(row.getCell(7).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(8) != null)//排除为空--护理
					{
						row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(8).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setHl(new BigDecimal(row.getCell(8).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(9) != null)//排除为空--自雇费
					{
						row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(9).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setZgf(new BigDecimal(row.getCell(9).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(10) != null)//排除为空--其他
					{
						row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(10).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setQt(new BigDecimal(row.getCell(10).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(11) != null)//排除为空--其他补贴
					{
						row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(11).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setQtbt(new BigDecimal(row.getCell(11).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(12) != null)//排除为空--补工资
					{
						row.getCell(12).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(12).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setBgz(new BigDecimal(row.getCell(12).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(13) != null)//排除为空--应发小计
					{
						row.getCell(13).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(13).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setYfxj(new BigDecimal(row.getCell(13).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(14) != null)//排除为空--扣款小计
					{
						row.getCell(14).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(14).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setGkxj(new BigDecimal(row.getCell(14).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(15) != null)//排除为空--实发小计
					{
						row.getCell(15).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(15).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.setSfxj(new BigDecimal(row.getCell(15).getStringCellValue()));//将它set到Retirewages对象中
						}else{improtError++;}
					}else{improtError++;}
					if(row.getCell(16) != null)//排除为空--发放时间
					{
						row.getCell(16).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						wages.setFfsj(row.getCell(16).getStringCellValue());//将它set到Retirewages对象中
					}else{improtError++;}
					if(row.getCell(17) != null)//排除为空--发放月份
					{
						row.getCell(17).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						wages.setYf(row.getCell(17).getStringCellValue());//将它set到Retirewages对象中
						temp.getBjjbt().setFfyf(wages.getYf());
					}else{improtError++;}
					wages.setCjsj(new Date());
				}
				if(rService.getByMonth(temp)!=null)
				{
					improtError++;
				}
				if(improtError<1)
				{
					listWages.add(wages);
				}
			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listWages;
	}
	/**
	 * 批量添加--本级津补贴
	 * @param RetiresubsidyFile
	 * @param red
	 * @return
	 */
	private List<Retirewages> importRetiresubsidyFile(MultipartFile RetiresubsidyFile)
	{
		List<Retirewages> listWages=new ArrayList<Retirewages>();
		Retirewages wages=null;//声明一个实体对象
		int improtError=0;
		try {
			Workbook workbook = WorkbookFactory.create(RetiresubsidyFile.getInputStream());//得到Excel文件
			Sheet sheet = workbook.getSheetAt(0);//得到第一个工作表
			for(int i=1,size=sheet.getLastRowNum()+1;i<size;i++)
			{
				improtError=0;
				Row row = sheet.getRow(i);//得到一行
				wages=new Retirewages();
				Retirewages temp=new Retirewages();
				if(row!=null){//排除为空的可能
					if(row.getCell(0) != null)//排除为空--姓名
					{
						row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						try {
							Retirement tempMent=acService.queryByXm(row.getCell(0).getStringCellValue());
							if (tempMent == null) {
								improtError++;
							} else {
								wages.setSfzh(tempMent.getSfzh());
								wages.getBjjbt().setSfzh(tempMent.getSfzh());
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							improtError++;
						}
						wages.getBjjbt().setXm(row.getCell(0).getStringCellValue());//将它set到Retirewages对象中
						wages.setXm(wages.getBjjbt().getXm());
						temp.setXm(wages.getXm());
						temp.setSfzh(wages.getSfzh());
					}else{improtError++;}
					if(row.getCell(1) != null)//排除为空--离休补贴
					{
						row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(1).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.getBjjbt().setLxbt(new BigDecimal(row.getCell(1).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(2) != null)//排除为空--物业补贴
					{
						row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(2).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.getBjjbt().setWybt(new BigDecimal(row.getCell(2).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(3) != null)//排除为空--班车补贴
					{
						row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(3).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.getBjjbt().setBcbt(new BigDecimal(row.getCell(3).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(4) != null)//排除为空--提租补贴
					{
						row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(4).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.getBjjbt().setTzbt(new BigDecimal(row.getCell(4).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(5) != null)//排除为空--适当补贴
					{
						row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(5).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.getBjjbt().setSdbt(new BigDecimal(row.getCell(5).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(6) != null)//排除为空--特贴
					{
						row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(6).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.getBjjbt().setTt(new BigDecimal(row.getCell(6).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(7) != null)//排除为空--未休养补贴
					{
						row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(7).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.getBjjbt().setWxy(new BigDecimal(row.getCell(7).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(8) != null)//排除为空--应发合计
					{
						row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(8).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.getBjjbt().setYfhj(new BigDecimal(row.getCell(8).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(9) != null)//排除为空--代汇补贴
					{
						row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(9).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.getBjjbt().setDh(new BigDecimal(row.getCell(9).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(10) != null)//排除为空--扣款合计
					{
						row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(10).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.getBjjbt().setKkhj(new BigDecimal(row.getCell(10).getStringCellValue()));//将它set到Retirewages对象中
						}
					}
					if(row.getCell(11) != null)//排除为空--实发工资
					{
						row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
						if(isNumeric(row.getCell(11).getStringCellValue(), p))//过虑掉非数值格式
						{
							wages.getBjjbt().setSfgz(new BigDecimal(row.getCell(11).getStringCellValue()));//将它set到Retirewages对象中
						}else{improtError++;}
					}else{improtError++;}
					if(row.getCell(12) != null)//排除为空--发放时间
					{
							row.getCell(12).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
							wages.getBjjbt().setFfsj(row.getCell(12).getStringCellValue());//将它set到Retirewages对象中
							wages.getBjjbt().setBcjsj(new Date());
					}else{improtError++;}
					if(row.getCell(13) != null)//排除为空--发放月份
					{
							row.getCell(13).setCellType(Cell.CELL_TYPE_STRING);//设置表格中的类型
							wages.getBjjbt().setFfyf(row.getCell(13).getStringCellValue());//将它set到Retirewages对象中
							temp.setYf(wages.getBjjbt().getFfyf());
					}else{improtError++;}
					wages.setCjsj(new Date());
				}
				if(rService.getByMonth(temp)!=null){improtError++;}
				if(improtError<1)
				{
					listWages.add(wages);
				}
			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listWages;
	}
	/**
	 * 判断是否为数值类型
	 * @param str
	 * @param pattern
	 * @return
	 */
	private boolean isNumeric(String str,Pattern pattern){ 
	   Matcher isNum = pattern.matcher(str);
	   if( !isNum.matches() ){
	       return false; 
	   } 
	   return true; 
	}
}
