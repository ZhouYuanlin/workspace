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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.health.Rethoscosts;
import cn.uuf.ltxxt.health.service.RethoscostsService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.Paginate;

/**
 * 医疗费用
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-29
 */
@Controller
@RequestMapping("{rethoscost:rethoscost;*.?}")
public class RethoscostsController extends BaseController{

	private final String LIST_ACTION = "redirect:/rethoscost";
	@Resource
	private RethoscostsService cService;
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Rethoscosts w,String gksj,String gjsj){
		ModelAndView mav = new ModelAndView("care/cost/index");
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
			Long count = cService.getCount(w,gksj,gjsj);
			List<Rethoscosts> list = cService.queryList(w,s, size,gksj,gjsj);
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
		ModelAndView mav = new ModelAndView("care/cost/create");
		getCodeInf(mav);
		return mav;
	}
	@RequestMapping(value="{save:save;*.?}",method=RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request,String sfzh,@Valid Rethoscosts w,BindingResult res,RedirectAttributes red){
		try{
			sfzh=splitSfzh(sfzh);
			if(sfzh != null){
				Retirement m = mentService.getById(sfzh);
				if(m != null){
					w.setRet(m);
					cService.save(w);
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
		ModelAndView mav = new ModelAndView("care/cost/update");
		try{
			mav.addObject("r",cService.getById(id));
		}catch(Exception e){
		}
		return mav;
	}
	@RequestMapping(value="{update:update;*.?}",method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request,String sfzh,@Valid Rethoscosts w,BindingResult res,RedirectAttributes red){
		try{
			if(sfzh != null){
				w.setRet(mentService.getById(sfzh));
				cService.update(w);
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
			cService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
			this.writer(this.getCurrentUser().getRealname()+"删除人员" + id.toString(),request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxDetail(HttpServletResponse response,Long id){
		ModelAndView mav = new ModelAndView("care/cost/_work");
		try{
			Rethoscosts m = cService.getById(id);
			mav.addObject("r",m);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("{dcExcel:dcExcel;*.?}")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView uploadxsl(@RequestParam("uploadFile") MultipartFile uploadFile,HttpServletRequest request, HttpServletResponse response,RedirectAttributes red)throws Exception{
		try{
			Workbook workbook = WorkbookFactory.create(uploadFile.getInputStream());
			Sheet sheet = workbook.getSheetAt(0);
			for(int i=1;i<sheet.getLastRowNum()+1;i++){
				Row row = sheet.getRow(i);
				Rethoscosts p = new Rethoscosts();
				Retirement m = null;
				if(row != null){
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if(row.getCell(0).getStringCellValue() != null){
						m = mentService.getById(row.getCell(0).getStringCellValue());
						if(m != null && row.getCell(1) != null){
							p.setRet(m);
							row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
							p.setLqrq(row.getCell(1).getStringCellValue());
							if(row.getCell(2) != null){
								row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
								p.setLqje(row.getCell(2).getStringCellValue());
							}
							if(row.getCell(3) != null){
								row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
								p.setLqr(row.getCell(3).getStringCellValue());
							}
							if(row.getCell(4) != null){
								row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
								p.setYbrgx(row.getCell(4).getStringCellValue());
							}
							if(row.getCell(5) != null){
								row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
								p.setSpr(row.getCell(5).getStringCellValue());
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
	public void exportExcel(Rethoscosts p,HttpServletResponse response){
		try{
			Workbook wb = new HSSFWorkbook();//创建工作表
			Sheet createSheet = wb.createSheet("sheet1");//创建sheet
			Row row = createSheet.createRow(0);//创建标题
			String[] cellTitle = {
				"姓名","身份证号","性别","类型","原工作单位","领取日期","领取金额","领取人","与本人关系"};
			for (int i = 0; i < cellTitle.length; i++) {
				createSheet.setColumnWidth(i, 3500);
				Cell createCell = row.createCell(i);
				createCell.setCellValue(cellTitle[i]);
			}
			List<Rethoscosts> list = cService.queryByVo(p);
			int s = 1;
			for(Rethoscosts r : list){
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
							da.setCellValue(r.getLqrq());
							break;
						case 6:
							da.setCellValue(r.getLqje());
							break;
						case 7:
							da.setCellValue(r.getLqr());
							break;
						case 8:
							da.setCellValue(r.getYbrgx());
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

