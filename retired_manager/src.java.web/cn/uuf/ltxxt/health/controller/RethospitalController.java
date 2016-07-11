package cn.uuf.ltxxt.health.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.CodeDwb;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.health.Rethospital;
import cn.uuf.domain.honor.Retirehonor;
import cn.uuf.ltxxt.health.service.RethospitalService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.DateUtil;
import cn.uuf.util.Paginate;

/**
 * 住院
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-29
 */
@Controller
@RequestMapping("{rethospital:rethospital;*.?}")
public class RethospitalController extends BaseController{

	private final String LIST_ACTION = "redirect:/rethospital";
	@Resource
	private RethospitalService hService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Rethospital w,String gksj,String gjsj){
		ModelAndView mav = new ModelAndView("care/hospitail/index");
		try{
			if(gksj != null)gksj = gksj.equals("") ? null : gksj;
			if(gjsj != null)gjsj = gjsj.equals("") ? null : gjsj;
			int s = (page - 1) * size;
			Retirement retirement = null;
			if(hasRoleScope().equals(Constants.INFOYX)){
				if(w.getRet()!=null){
					retirement = w.getRet();
					retirement.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}else{
					retirement = new Retirement();
					retirement.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}
				w.setRet(retirement);
			}
			Long count = hService.getCount(w,gksj,gjsj);
			List<Rethospital> list = hService.queryList(w,s, size,gksj,gjsj);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("w",w);
			mav.addObject("gksj",gksj);
			mav.addObject("gjsj",gjsj);
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("care/hospitail/create");
		getCodeInf(mav);
		return mav;
	}
	@RequestMapping(value="{save:save;*.?}",method=RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request,String sfzh,String djrq,@Valid Rethospital w,BindingResult res,RedirectAttributes red){
		try{
			sfzh=splitSfzh(sfzh);
			if(sfzh != null){
				Retirement m = mentService.getById(sfzh);
				if(m != null){
					w.setRet(m);
					if(StringUtils.isNotEmpty(getCurrentUser().getRealname())){
						w.setDjr(getCurrentUser().getRealname());
					}else{
						w.setDjr(getCurrentUser().getUsername());
					}
					w.setDjrq(DateUtil.getDate());
					hService.save(w);
					m.addHospital(w);
					mentService.update(m);
					red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
					this.writer(this.getCurrentUser().getRealname() + "添加["+w.getRet().getXm()+"]的工作经历", request.getRemoteAddr(), this.getCurrentUser().getUsername());
				}else{
					red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败，【"+sfzh+"】退休人员不存在");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("care/hospitail/update");
		try{
			mav.addObject("r",hService.getById(id));
		}catch(Exception e){
		}
		return mav;
	}
	@RequestMapping(value="{update:update;*.?}",method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request,String sfzh,@Valid Rethospital w,BindingResult res,RedirectAttributes red){
		try{
			if(sfzh != null){
				w.setRet(mentService.getById(sfzh));
				if(StringUtils.isNotEmpty(getCurrentUser().getRealname())){
					w.setDjr(getCurrentUser().getRealname());
				}else{
					w.setDjr(getCurrentUser().getUsername());
				}
				hService.update(w);
				red.addFlashAttribute(Constants.MESSAGE_NAME,"修改成功");
				this.writer(this.getCurrentUser().getRealname()+"修改【" + w.getRet().getXm() + "】信息",request.getRemoteAddr(),this.getCurrentUser().getUsername());
			}
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping("{delete:delete;*.?}")
	public ModelAndView delete(HttpServletRequest request,RedirectAttributes red,Long... id){
		try{
			hService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
			this.writer(this.getCurrentUser().getRealname()+"删除人员" + id.toString(),request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxDetail(HttpServletResponse response,Long id){
		ModelAndView mav = new ModelAndView("care/hospitail/_work");
		try{
			Rethospital m = hService.getById(id);
			mav.addObject("r",m);
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
		ModelAndView mav = new ModelAndView("care/hospitail/upload");
		return mav;
	}
	@RequestMapping("{dcExcel:dcExcel;*.?}")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView uploadxsl(@RequestParam("uploadFile") MultipartFile uploadFile,HttpServletRequest request, HttpServletResponse response,RedirectAttributes red)throws Exception{
		try{
			Workbook workbook = WorkbookFactory.create(uploadFile.getInputStream());
		    Sheet sheet = workbook.getSheetAt(0);
		    Retirement m = new Retirement();
		    for(int i=1;i<sheet.getLastRowNum()+1;i++){
				Row row = sheet.getRow(i);
				Rethospital p = new Rethospital();
				List<Rethospital> lp = new ArrayList<Rethospital>();
				if(row != null && row.getCell(0) != null){
					Cell cell0 = row.getCell(0);
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if(cell0.getStringCellValue() != null)
						m.setXm(cell0.getStringCellValue());
					if(row.getCell(1) != null){
						row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						m.setXb(row.getCell(1).getStringCellValue());
					}
					if(row.getCell(2) != null){
						row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
						m.setSfzh(row.getCell(2).getStringCellValue());
					}
					if(row.getCell(3) != null){
						row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
						CodeDwb dwb = null;
						List<CodeDwb> all = dwbService.getAll();
						String dw = row.getCell(3).getStringCellValue();
						for (CodeDwb codeDwb : all) {
							if(codeDwb.getName().equals(dw)){
								dwb = dwbService.getById(codeDwb.getId());
							}
						}
						m.setDwb(dwb);
					}
					p.setRet(m);
					lp = hService.queryByVo(p);
					if(row.getCell(4) != null){
						row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
						p.setZyrq(row.getCell(4).getStringCellValue());
					}
					if(row.getCell(5) != null){
						row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
						p.setYymc(row.getCell(5).getStringCellValue());
					}
					if(row.getCell(6) != null){
						row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
						p.setYyks(row.getCell(6).getStringCellValue());
					}
					if(row.getCell(7) != null){
						row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
						p.setYylc(row.getCell(7).getStringCellValue());
					}
					if(row.getCell(8) != null){
						row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
						p.setYycw(row.getCell(8).getStringCellValue());
					}
					if(row.getCell(9) != null){
						row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
						p.setZyyy(row.getCell(9).getStringCellValue());
					}
					if(row.getCell(10) != null){
						row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
						p.setTsry(row.getCell(10).getStringCellValue());
					}
					if(row.getCell(11) != null){
						row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
						p.setTsrq(row.getCell(11).getStringCellValue());
					}
					if(row.getCell(12) != null){
						row.getCell(12).setCellType(Cell.CELL_TYPE_STRING);
						p.setBz(row.getCell(12).getStringCellValue());
					}
					if(lp.size() > 0){
						Rethospital h = lp.get(0);
						h.setRet(h.getRet() !=null ? h.getRet() : null );
						hService.update(h);
					}else
						hService.save(p);
				}
		    }
			red.addFlashAttribute(Constants.MESSAGE_NAME,"导入成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"导入失败,请检查填写的信息是否有误!");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	
	/**
	 * 导出住院管理信息
	 */
	/**
	 * 导出到excel
	 * @param m
	 * @param response
	 * @return
	 */
	@RequestMapping("{export:export;*.?}")
	public void exportExcel(Rethospital w,HttpServletResponse response){
		try{
			Workbook wb = new HSSFWorkbook();//创建工作表
			Sheet createSheet = wb.createSheet("sheet1");//创建sheet
			Row row = createSheet.createRow(0);//创建标题
			String[] cellTitle = {
				"姓名","性别","身份证号","原工作单位","住院日期","医院","科室","楼层","床位","住院原因","探视人员","探视日期","说明"};
			for (int i = 0; i < cellTitle.length; i++) {
				createSheet.setColumnWidth(i, 3500);
				Cell createCell = row.createCell(i);
				createCell.setCellValue(cellTitle[i]);
			}
			List<Rethospital> list = hService.queryByVo(w);
			int s = 1;
			for(Rethospital rethospital : list){
				Row dataRow = createSheet.createRow((short) s);
				for(int i = 0;i<cellTitle.length;i++){
					Cell da = dataRow.createCell(i);
					switch (i) {
						case 0:
							da.setCellValue(rethospital.getRet().getXm());
							break;
						case 1:
							da.setCellValue(rethospital.getRet().getXb() != null ? rethospital.getRet().getXb() : "");
							break;
						case 2:
							da.setCellValue(rethospital.getRet().getSfzh());
							break;
						case 3:
							da.setCellValue(rethospital.getRet().getDwb() != null ? rethospital.getRet().getDwb().getName() : "");
							break;
						case 4:
							da.setCellValue(rethospital.getZyrq() != null ? rethospital.getZyrq() : "");
							break;
						case 5:
							da.setCellValue(rethospital.getYymc() != null ? rethospital.getYymc() : "");
							break;
						case 6:
							da.setCellValue(rethospital.getYyks() != null ? rethospital.getYyks() : "");
							break;
						case 7:
							da.setCellValue(rethospital.getYylc() != null ? rethospital.getYylc() : "");
							break;
						case 8:
							da.setCellValue(rethospital.getYycw() != null ? rethospital.getYycw() : "");
							break;
						case 9:
							da.setCellValue(rethospital.getZyyy() != null ? rethospital.getZyyy() : "");
							break;
						case 10:
							da.setCellValue(rethospital.getTsry() != null ? rethospital.getTsry() : "");
							break;
						case 11:
							da.setCellValue(rethospital.getTsrq() != null ? rethospital.getTsrq() : "");
							break;
						case 12:
							da.setCellValue(rethospital.getBz() != null ? rethospital.getBz() : "");
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

