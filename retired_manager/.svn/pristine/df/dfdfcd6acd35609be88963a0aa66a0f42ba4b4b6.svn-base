package cn.uuf.ltxxt.activity.controller;

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
import cn.uuf.domain.activity.Retireactivother;
import cn.uuf.domain.honor.Retirehonor;
import cn.uuf.ltxxt.activity.service.RetireactivotherService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.Paginate;

/**
 * 品牌活动
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
/**
 * 说明：此处的品牌活动为微信端的活动信息
 * @author：huangdawei;
 * @Date：2016-5-11
 * */
@Controller
@RequestMapping("{retireactother:retireactother;*.?}")
public class RetireactivotherController extends BaseController{

	private final String LIST_ACTION = "redirect:/retireactother";
	@Resource
	private RetireactivotherService oService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retireactivother t,String hdsjq,String hdsjz){
		ModelAndView mav = new ModelAndView("activ/other/index");
		try{
			if(hdsjq != null)hdsjq = hdsjq.equals("") ? null : hdsjq;
			if(hdsjz != null)hdsjz = hdsjz.equals("") ? null : hdsjz;
			int s = (page - 1) * size;
			Long count = oService.getCount(t,hdsjq,hdsjz);
			List<Retireactivother> list = oService.queryList(t, s, size,hdsjq,hdsjz);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("hdsjq",hdsjq);
			mav.addObject("hdsjz",hdsjz);
			mav.addObject("p",t);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	//进入活动添加页
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("activ/other/create");
		getCodeInf(mav);
		return mav;
	}
	
	@RequestMapping(value="{save:save;*.?}",method=RequestMethod.POST)
	public ModelAndView save(@Valid Retireactivother t,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("p",t);
					return new ModelAndView("redirect:/retireactother/create");
				}
			}
			oService.save(t);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
		}catch(Exception e){
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("activ/other/update");
		mav.addObject("p",oService.getById(id));
		getCodeInf(mav);
		return mav;
	}
	
	@RequestMapping("{update:update;*.?}")
	public ModelAndView update(@Valid Retireactivother t,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("p",t);
					return new ModelAndView("redirect:/retireactother/"+t.getId()+"edit");
				}
			}
			oService.update(t);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	/**
	 * 查看活动详情
	 * @param sfzh
	 * @param red
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView detail(Long id,RedirectAttributes redirectAttributes){
		ModelAndView mav = new ModelAndView("activ/other/detail");
		try{
			Retireactivother retireactivother = oService.getById(id);
			mav.addObject("p", retireactivother);
		}catch(Exception e){
			e.printStackTrace();
			redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME,"未查询到活动信息");
			return new ModelAndView(LIST_ACTION);
		}
		return mav;
	}
	
	
	@RequestMapping("{delete:delete;*.?}")
	public ModelAndView delete(RedirectAttributes red,Long... id){
		try{
			oService.delete(id);
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
				Retireactivother p = new Retireactivother();
				if(row != null){
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if(row.getCell(0).getStringCellValue() != null){
						p.setName(row.getCell(0).getStringCellValue());
							if( row.getCell(1) != null){
								row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
								p.setHddd(row.getCell(1).getStringCellValue());
							}
							if(row.getCell(2) != null){
								row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
								p.setHdsj(row.getCell(2).getStringCellValue());
							}
							if(row.getCell(3) != null){
								row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
								p.setFzr(row.getCell(3).getStringCellValue());
							}
							if(row.getCell(4) != null){
								row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
								p.setCyrys(row.getCell(4).getStringCellValue());
							}
							if(row.getCell(5) != null){
								row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
								p.setBz(row.getCell(5).getStringCellValue());
							}
							oService.save(p);
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
	public void exportExcel(Retireactivother p,HttpServletResponse response){
		try{
			Workbook wb = new HSSFWorkbook();//创建工作表
			Sheet createSheet = wb.createSheet("sheet1");//创建sheet
			Row row = createSheet.createRow(0);//创建标题
			String[] cellTitle = {
				"活动名称","活动地点","活动时间","负责人","参与人员","说明"};
			for (int i = 0; i < cellTitle.length; i++) {
				createSheet.setColumnWidth(i, 3500);
				Cell createCell = row.createCell(i);
				createCell.setCellValue(cellTitle[i]);
			}
			List<Retireactivother> list = oService.queryByVo(p);
			int s = 1;
			for(Retireactivother r : list){
				Row dataRow = createSheet.createRow((short) s);
				for(int i = 0;i<cellTitle.length;i++){
					Cell da = dataRow.createCell(i);
					switch (i) {
						case 0:
							da.setCellValue(r.getName());
							break;
						case 1:
							da.setCellValue(r.getHddd());
							break;
						case 2:
							da.setCellValue(r.getHdsj());
							break;
						case 3:
							da.setCellValue(r.getFzr());
							break;
						case 4:
							da.setCellValue(r.getCyrys());
							break;
						case 5 :
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

