package cn.uuf.ltxxt.record.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.excelutils.ExcelUtils;

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
import cn.uuf.domain.record.Retdepart;
import cn.uuf.domain.record.Retrecord;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.record.service.RetdepartService;
import cn.uuf.ltxxt.record.service.RetrecordService;
import cn.uuf.util.Paginate;

/**
 * 通信录
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-28
 */
@Controller
@RequestMapping("{retrecord:retrecord;*.?}")
public class RetrecordController extends BaseController{

	private final String LIST_ACTION = "redirect:/retrecord";
	@Resource
	private RetrecordService cService;
	@Resource
	private RetdepartService dService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retrecord d){
		ModelAndView mav = new ModelAndView("record/record/index");
		try{
			int s = (page - 1) * size;
			Long count = cService.getCount(d);
			List<Retrecord> list = cService.queryList(d,s, size);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("dlist",dService.getAll());
			mav.addObject("d",d);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("record/record/create");
		mav.addObject("dlist",dService.getAll());
		return mav;
	}
	
	@RequestMapping("{save:save;*.?}")
	public ModelAndView save(Long pid,@Valid Retrecord d,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("d",d);
					return new ModelAndView("redirect:/retrecord/create");
				}
			}
			if(pid != null)
				d.setDeparts(dService.getById(pid));
			cService.save(d);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("record/record/update");
		try{
			mav.addObject("d",cService.getById(id));
			mav.addObject("dlist",dService.getAll());
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("{update:update;*.?}")
	public ModelAndView update(Long pid,@Valid Retrecord r,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("d",r);
					return new ModelAndView("redirect:/retrecord/"+r.getId()+"/create");
				}
			}
			if(pid != null)
				r.setDeparts(dService.getById(pid));
			cService.update(r);
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
	
	@RequestMapping("{importexecl:importexecl;*.?}")
	public ModelAndView importpl(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("record/record/upload");
		return mav;
	}
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping("{download:download;*.?}")
	public void downxiazai(HttpServletRequest request, HttpServletResponse response){
		try {
			String file = request.getSession().getServletContext().getRealPath("/") + "model/retrecord.xls";
			response.reset(); 
			response.setContentType("application/vnd.ms-excel"); 
			response.setHeader("Content-Disposition","attachment;filename=retrecord.xls"); 			
			ExcelUtils.export(file, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ;
	}
	
	/**
	 * 导入更新
	 * @param uploadFile 文件名称
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("{dcExcel:dcExcel;*.?}")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView uploadplgx(@RequestParam("uploadFile") MultipartFile uploadFile,HttpServletRequest request, HttpServletResponse response,RedirectAttributes redAttr)throws Exception{
		try{
			Map<String,Retdepart> maps = new LinkedHashMap<String,Retdepart>();
			List<Retdepart> ll = dService.getAll();
			for(Retdepart p : ll)
				maps.put(p.getName(),p);
			Workbook workbook = WorkbookFactory.create(uploadFile.getInputStream());
		    Sheet sheet = workbook.getSheetAt(0);
		    for(int i=1;i<sheet.getLastRowNum()+1;i++){
			   Row row = sheet.getRow(i);
			   Retrecord m = new Retrecord();
			   if(row != null){
				   Cell cell0 = row.getCell(0);
				   row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				   if(cell0.getStringCellValue() != null){
					   m.setName(row.getCell(0).getStringCellValue());
					   if(row.getCell(1) != null){
						   row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						   m.setDeparts(maps.get(row.getCell(1).getStringCellValue()));
					   }
					   if(row.getCell(2) != null){
						   row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
						   m.setBgdh(row.getCell(2).getStringCellValue());
					   }
					   if(row.getCell(3) != null){
						   row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
						   m.setMobile(row.getCell(3).getStringCellValue());
					   }
					   cService.save(m);
				   }
			   }
		    }
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "导入成功！");
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "导入失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
}

