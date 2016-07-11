package cn.uuf.ltxxt.party.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.ret.Retiredonations;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.party.service.RetiredonationsService;
import cn.uuf.ltxxt.party.service.RetirepartyService;
import cn.uuf.util.AddSQLQuery;
import cn.uuf.util.Paginate;

/**
 * 捐款记录
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-14
 */
@Controller
@RequestMapping("{retiredonat:retiredonat;*.?}")
public class RetiredonationsController extends BaseController{

	private final String LIST_ACTION = "redirect:/retiredonat";
	@Resource
	private RetiredonationsService dService;
	@Resource
	private RetirepartyService ptService;
	
	
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retiredonations p,String kssj,String jssj){
		ModelAndView mav = new ModelAndView("party/donat/index");
		try{
			int s = (page - 1) * size;
			Long count = dService.getCount(p,kssj,jssj);
			List<Retiredonations> list = dService.queryList(p, s,size,kssj,jssj);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("p",p);
			mav.addObject("kssj",kssj);
			mav.addObject("jssj",jssj);
			mav.addObject("plist",ptService.getAll());
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("party/donat/create");
		try{
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value="{save:save;*.?}",method=RequestMethod.POST)
	public ModelAndView save(String sfzh,@Valid Retiredonations p,BindingResult res,RedirectAttributes red,String... rets){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("r",p);
					return new ModelAndView("redirect:/retiredonat/create");
				}
			}
			Retirement m = mentService.getById(splitSfzh(sfzh));
			p.setRet(m);
			dService.save(p);
			m.addDonats(p);
			mentService.update(m);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"创建成功");	
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"保存失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("party/donat/update");
		try{
			mav.addObject("p",dService.getById(id));
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="{update:update;*.?}",method=RequestMethod.POST)
	public ModelAndView update(@Valid Retiredonations p,BindingResult res,RedirectAttributes red,String... rets){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("r",p);
					return new ModelAndView("redirect:/retiredonat/"+p.getId()+"/edit");
				}
			}
			Retiredonations d = dService.getById(p.getId());
			d = (Retiredonations) AddSQLQuery.setObjectValue(p,d);
			dService.update(d);
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
			dService.delete(id);
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
				Retiredonations p = new Retiredonations();
				Retirement m = null;
				if(row != null){
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if(row.getCell(0).getStringCellValue() != null){
						m = mentService.getById(row.getCell(0).getStringCellValue());
						if(m != null && row.getCell(1) != null){
							p.setRet(m);
							row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
							p.setJkje(Double.valueOf(row.getCell(1).getStringCellValue()));
							if(row.getCell(2) != null){
								row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
								p.setJkrq(row.getCell(2).getStringCellValue());
							}
							dService.save(p);
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
	public void exportExcel(Retiredonations p,HttpServletResponse response){
		try{
			Workbook wb = new HSSFWorkbook();//创建工作表
			Sheet createSheet = wb.createSheet("sheet1");//创建sheet
			Row row = createSheet.createRow(0);//创建标题
			String[] cellTitle = {
				"姓名","身份证号","性别","类型","原工作单位","捐款金额","捐款日期"};
			for (int i = 0; i < cellTitle.length; i++) {
				createSheet.setColumnWidth(i, 3500);
				Cell createCell = row.createCell(i);
				createCell.setCellValue(cellTitle[i]);
			}
			List<Retiredonations> list = dService.queryByVo(p);
			int s = 1;
			for(Retiredonations r : list){
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
							da.setCellValue(r.getJkje());
							break;
						case 6:
							da.setCellValue(r.getJkrq());
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

