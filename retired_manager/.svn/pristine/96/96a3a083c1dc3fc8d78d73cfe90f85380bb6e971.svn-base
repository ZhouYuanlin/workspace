package cn.uuf.ltxxt.honor.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.honor.Retirehonor;
import cn.uuf.ltxxt.honor.service.RetirehonorService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.Paginate;

/**
 * 表彰
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
@Controller
@RequestMapping("{retirehonor:retirehonor;*.?}")
public class RetirehonorController extends BaseController{

	private final String LIST_ACTION = "redirect:/retirehonor";
	@Resource
	private RetirehonorService hService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retirehonor h,String kssj,String jssj){
		ModelAndView mav = new ModelAndView("honor/index");
		try{
			int s = (page - 1) * size;
			Long count = hService.getCount(h,kssj,jssj);
			List<Retirehonor> list = hService.queryList(h, s, size,kssj,jssj);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("h",h);
			mav.addObject("kssj",kssj);
			mav.addObject("jssj",jssj);
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"no data");
		}
		return mav;
	}
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("honor/create");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		mav.addObject("cd", sdf.format(new Date()));
		getCodeInf(mav);
		return mav;
	}
	@RequestMapping(value="{save:save;*.?}",method=RequestMethod.POST)
	public ModelAndView save(@Valid Retirehonor h,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("h",h);
					return new ModelAndView("redirect:/retirehonor/create");
				}
			}
			hService.save(h);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("honor/update");
		mav.addObject("h",hService.getById(id));
		getCodeInf(mav);
		return mav;
	}
	
	@RequestMapping(value="{update:update;*.?}",method=RequestMethod.POST)
	public ModelAndView update(@Valid Retirehonor h,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("h",h);
					return new ModelAndView("redirect:/retirehonor/"+h.getId()+"/edit");
				}
			}
			hService.update(h);
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
			hService.delete(id);
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
		ModelAndView mav = new ModelAndView("honor/_info");
		try{
			mav.addObject("p",hService.getById(id));
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	/*
	 * 跳转导入
	 */
	@RequestMapping(value="/importexecl")
	public ModelAndView importexecl(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("honor/upload");
		return mav;
	}
	@RequestMapping("{dcExcel:dcExcel;*.?}")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView uploadxsl(@RequestParam("uploadFile") MultipartFile uploadFile,HttpServletRequest request, HttpServletResponse response,RedirectAttributes red)throws Exception{
		try{
			Workbook workbook = WorkbookFactory.create(uploadFile.getInputStream());
		    Sheet sheet = workbook.getSheetAt(0);
		    Retirement m = null;
		    for(int i=1;i<sheet.getLastRowNum()+1;i++){
				Row row = sheet.getRow(i);
				Retirehonor p = new Retirehonor();
				List<Retirehonor> lp = new ArrayList<Retirehonor>();
				if(row != null && row.getCell(0) != null){
					Cell cell0 = row.getCell(0);
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if(cell0.getStringCellValue() != null)
						p.setBzmc(cell0.getStringCellValue());
					if(row.getCell(1) != null){
						row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						p.setBzsj(row.getCell(1).getStringCellValue());
					}
					if(row.getCell(2) != null){
						row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
						p.setBzjb(row.getCell(2).getStringCellValue());
					}
					if(row.getCell(3) != null){
						row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
						p.setBzdw(row.getCell(3).getStringCellValue());
					}
					lp = hService.queryByVo(p);
					if(row.getCell(4) != null){
						row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
						p.setCyhs(row.getCell(4).getStringCellValue());
						m = mentService.getById(p.getCyhs());
					}
					if(row.getCell(5) != null){
						row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
						p.setCyxms(row.getCell(5).getStringCellValue());
					}else
						p.setCyxms(m.getXm());
					if(row.getCell(6) != null){
						row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
						p.setBznr(row.getCell(6).getStringCellValue());
					}
					if(row.getCell(7) != null){
						row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
						p.setBz(row.getCell(7).getStringCellValue());
					}
					if(lp.size() > 0){
						Retirehonor h = lp.get(0);
						h.setCyhs(h.getCyhs() !=null ? h.getCyhs() + ";" + p.getCyhs() : p.getCyhs() + ";");
						h.setCyxms(h.getCyxms() != null ? h.getCyxms() + ";" + p.getCyxms() : p.getCyxms() + ";");
						StringBuffer cyxm = new StringBuffer();
						String cyxms = h.getCyxms();
						String[] split = cyxms.split(";");
						List<String> list =new ArrayList<>();
						for(int j =0;j<split.length;j++){
							if(!list.contains(split[j])){
								if(j>0 && j<split.length){
									cyxm.append(";");
								}
								list.add(split[j]);
								cyxm.append(split[j]);
							}
						}
						h.setCyxms(cyxm.toString());
						hService.update(h);
					}else{
						hService.save(p);
					}
				}else{
					red.addFlashAttribute(Constants.MESSAGE_NAME,"表彰名称不能为空");
					return new ModelAndView(LIST_ACTION);
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
	public void exportExcel(Retirehonor p,HttpServletResponse response){
		try{
			Workbook wb = new HSSFWorkbook();//创建工作表
			Sheet createSheet = wb.createSheet("sheet1");//创建sheet
			Row row = createSheet.createRow(0);//创建标题
			String[] cellTitle = {
				"表彰名称","表彰时间","表彰级别","表彰单位","表彰人员","表彰内容","备注"};
			for (int i = 0; i < cellTitle.length; i++) {
				createSheet.setColumnWidth(i, 3500);
				Cell createCell = row.createCell(i);
				createCell.setCellValue(cellTitle[i]);
			}
			List<Retirehonor> list = hService.queryByVo(p);
			int s = 1;String xx = "",us="";
			for(Retirehonor r : list){
				Row dataRow = createSheet.createRow((short) s);
				for(int i = 0;i<cellTitle.length;i++){
					Cell da = dataRow.createCell(i);
					switch (i) {
						case 0:
							da.setCellValue(r.getBzmc());
							break;
						case 1:
							da.setCellValue(r.getBzsj());
							break;
						case 2:
							da.setCellValue(r.getBzjb());
							break;
						case 3:
							da.setCellValue(r.getBzdw());
							break;
						case 4:
							da.setCellValue(r.getCyxms());
							break;
						case 5:
							da.setCellValue(r.getBznr());
							break;
						case 6:
							da.setCellValue(r.getBz());
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

