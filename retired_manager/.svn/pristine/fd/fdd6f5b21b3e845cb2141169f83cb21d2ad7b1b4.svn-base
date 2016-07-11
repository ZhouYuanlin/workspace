package cn.uuf.ltxxt.health.controller;

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
import cn.uuf.domain.Retirement;
import cn.uuf.domain.health.Rethoscard;
import cn.uuf.ltxxt.health.service.RethoscardService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.AddSQLQuery;
import cn.uuf.util.Paginate;

/**
 * 医保卡
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-3
 */
@Controller
@RequestMapping("{rethoscard:rethoscard;*.?}")
public class RethoscardController extends BaseController{

	private final String LIST_ACTION = "redirect:/rethoscard";
	@Resource
	RethoscardService cService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Rethoscard c){
		ModelAndView mav = new ModelAndView("care/card/index");
		try{
			int s = (page - 1) * size;
			Retirement retirement = null;
			if(hasRoleScope().equals(Constants.INFOYX)){
				if(c.getRet()!=null){
					retirement = c.getRet();
					retirement.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}else{
					retirement = new Retirement();
					retirement.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}
				c.setRet(retirement);
			}
			Long count = cService.getCount(c);
			List<Rethoscard> list = cService.queryList(c, s, size);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("w",c);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("care/card/create");
		getCodeInf(mav);
		return mav;
	}
	
	@RequestMapping("{save:save;*.?}")
	public ModelAndView save(String sfzh,@Valid Rethoscard s,BindingResult res,RedirectAttributes red){
		try{
			sfzh=splitSfzh(sfzh);
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					return new ModelAndView("redirect:/rethoscard/create");
				}
			}
			Retirement m = mentService.getById(sfzh);
			Rethoscard th = new Rethoscard();
			th.setRet(m);
			Long count = cService.getCount(th);
			if(count == 0){
				s.setRet(m);
				s.setXgrqh(new Date());
				s.setXgrqo(new Date());
				s.setXgrqt(new Date());
				cService.save(s);
				red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
			}else{
				List<Rethoscard> list = cService.queryByVo(th);
				if(list.size() > 0)
					th = list.get(0);
				red.addFlashAttribute(Constants.MESSAGE_NAME,"【"+th.getRet().getXm()+"】医保卡已存,请修改");
				return new ModelAndView("redirect:/rethoscard/"+th.getId()+"/edit");
			}
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("care/card/update");
		try{
			mav.addObject("r",this.cService.getById(id));
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("{update:update;*.?}")
	public ModelAndView update(@Valid Rethoscard c,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("r",c);
					return new ModelAndView("redirect:/rethoscard/" + c.getId() + "/edit");
				}
			}
			boolean b = false;
			Rethoscard ho = cService.getById(c.getId());
			if(!ho.getJjyyo().equals(c.getJjyyo())){
				c.setXgrqo(new Date());
				b = true;
			}
			if(!ho.getJjyyt().equals(c.getJjyyt())){
				c.setXgrqt(new Date());
				b = true;
			}
			if(!ho.getJjyyh().equals(c.getJjyyh())){
				c.setXgrqh(new Date());
				b = true;
			}
			ho = (Rethoscard) AddSQLQuery.setObjectValue(c,ho);
			cService.update(ho);
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
			cService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
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
				Rethoscard p = new Rethoscard();
				Retirement m = null;
				if(row != null){
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if(row.getCell(0).getStringCellValue() != null){
						m = mentService.getById(row.getCell(0).getStringCellValue());
						if(m != null && row.getCell(1) != null){
							p.setRet(m);
							row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
							p.setFyrq(row.getCell(1).getStringCellValue());
							if(row.getCell(2) != null){
								row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
								p.setSfff(row.getCell(2).getStringCellValue());
							}
							if(row.getCell(3) != null){
								row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
								p.setJjyyo(row.getCell(3).getStringCellValue());
							}
							if(row.getCell(4) != null){
								row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
								p.setJjyyt(row.getCell(4).getStringCellValue());
							}
							if(row.getCell(5) != null){
								row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
								p.setJjyyh(row.getCell(5).getStringCellValue());
							}
							cService.save(p);
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
	public void exportExcel(Rethoscard p,HttpServletResponse response){
		try{
			Workbook wb = new HSSFWorkbook();//创建工作表
			Sheet createSheet = wb.createSheet("sheet1");//创建sheet
			Row row = createSheet.createRow(0);//创建标题
			String[] cellTitle = {
				"姓名","身份证号","性别","类型","原工作单位","发放日期","是否发放","就近医院1","就近医院2","就近医院3"};
			for (int i = 0; i < cellTitle.length; i++) {
				createSheet.setColumnWidth(i, 3500);
				Cell createCell = row.createCell(i);
				createCell.setCellValue(cellTitle[i]);
			}
			List<Rethoscard> list = cService.queryByVo(p);
			int s = 1;
			for(Rethoscard r : list){
				Row dataRow = createSheet.createRow((short) s);
				for(int i = 0;i<cellTitle.length;i++){
					Cell da = dataRow.createCell(i);
					switch (i) {
						case 0:
							da.setCellValue(r.getRet().getXm());
							break;
						case 1:
							da.setCellValue(r.getRet().getSfzh());
							break;
						case 2:
							da.setCellValue(r.getRet().getXb() != null ? r.getRet().getXb() : "");
							break;
						case 3:
							da.setCellValue(r.getRet().getLxb() != null ? r.getRet().getLxb().getName() : "");
							break;
						case 4:
							da.setCellValue(r.getRet().getDwb() != null ? r.getRet().getDwb().getName() : "");
							break;
						case 5:
							da.setCellValue(r.getFyrq());
							break;
						case 6:
							da.setCellValue(r.getSfff());
							break;
						case 7:
							da.setCellValue(r.getJjyyo());
							break;
						case 8:
							da.setCellValue(r.getJjyyt());
							break;
						case 9 :
							da.setCellValue(r.getJjyyh());
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

