package cn.uuf.ltxxt.party.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.excelutils.ExcelUtils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirefamily;
import cn.uuf.domain.Retirement;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.party.service.RetirepartyService;
import cn.uuf.util.Paginate;

/**
 * 党费基数
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-18
 */
@Controller
@RequestMapping("{retiredues:retiredues;*.?}")
public class RetireduesController extends BaseController{

	private final String LIST_ACTION = "redirect:/retiredues";
	@Resource
	private RetirepartyService ptService;
	
	private String sfzh;//此页面中代表的身份证号
	/**
	 * 党费基数index界面
	 * @param page
	 * @param m
	 * @return
	 */
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue = "1") Integer page,Retirement m){
		ModelAndView mav = new ModelAndView("party/dues/index");
		try{
			int s = (page - 1) * size;
			m.setDfjs("notnull");//随便给个值，主要是用来查出党费基数不为空的人员
			Long count = mentService.getCount(m,null,null,null,null,null,null);
			List<Retirement> list = mentService.queryList(m,s, size,null,null,null,null,null,null);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("ret",m);
			mav.addObject("plist",ptService.getAll());
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	/**
	 * 添加党费基数第一步
	 * @return
	 */
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		
		 ModelAndView mav = new ModelAndView("party/dues/create");
		 getCodeInf(mav);
		 return mav;
	}
	/**
	 * 添加党费基数第二步
	 * @param m
	 * @param red
	 * @return
	 */
	@RequestMapping("{save:save;*.?}")
	public ModelAndView save(Retirement m,RedirectAttributes red){
		try{
			sfzh=m.getSfzh();
			if(sfzh != null &&sfzh.length() > 0){
				Retirement mm = mentService.getById(splitSfzh(sfzh));
				if(mm !=null){
					mm.setDfjs(m.getDfjs());
					mentService.update(mm);
					red.addFlashAttribute(Constants.MESSAGE_NAME,"添加党费基数成功");
				}else
					red.addFlashAttribute(Constants.MESSAGE_NAME,m.getSfzh()+"未找到离退休人员");
			}else
				red.addFlashAttribute(Constants.MESSAGE_NAME,"身份证号不能为空");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加党费基数失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	/**
	 * 修改第一步：修改时显示的数据
	 * @param sfzh
	 * @return
	 */
	@RequestMapping("/{sfzh}/edit")
	public ModelAndView edit(@PathVariable String sfzh){
		ModelAndView mav = new ModelAndView("party/dues/update");
		Retirefamily r=new Retirefamily();
		r.setRet(mentService.getById(sfzh));
		mav.addObject("p",r);
		return mav;
	}
	/**
	 * 修改第二步：更新数据库
	 * @param m
	 * @param red
	 * @return
	 */
	@RequestMapping("{update:update;*.?}")
	public ModelAndView update(Retirement m,RedirectAttributes red){
		try{
			sfzh=m.getSfzh();
			if( sfzh!= null && sfzh.length() > 0){
				Retirement mm = mentService.getById(sfzh);
				if(mm !=null){
					mm.setDfjs(m.getDfjs());
					mentService.update(mm);
					red.addFlashAttribute(Constants.MESSAGE_NAME,"维护党费基数成功");
				}else
					red.addFlashAttribute(Constants.MESSAGE_NAME,m.getSfzh()+"未找到离退休人员");
			}else
				red.addFlashAttribute(Constants.MESSAGE_NAME,"身份证号不能为空");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("{delete:delete;*.?}")
	public ModelAndView delete(HttpServletRequest request,RedirectAttributes redAttr,String... sfzh){
		try{
			for(int i=0;i<sfzh.length;i++){
				Retirement ment = mentService.getById(sfzh[i]);
				ment.setDfjs(null);
				mentService.update(ment);
			}
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	/**
	 * 导入
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/import")
	public ModelAndView importpl(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("party/dues/upload");
		return mav;
	}
	
	/**
	 * 下载模板
	 * @param request
	 * @param response
	 */
	@RequestMapping("download")
	public void downxiazai(HttpServletRequest request, HttpServletResponse response){
		try {
			String file = request.getSession().getServletContext().getRealPath("/") + "model/retmendues.xls";
			response.reset(); 
			response.setContentType("application/vnd.ms-excel"); 
			response.setHeader("Content-Disposition","attachment;filename=retmendues.xls"); 			
			ExcelUtils.export(file, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ;
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
						if(m != null && row.getCell(1) != null){
							row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
							m.setDfjs(row.getCell(1).getStringCellValue());
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
	public void exportExcel(Retirement m,HttpServletResponse response){
		try{
			Workbook wb = new HSSFWorkbook();//创建工作表
			Sheet createSheet = wb.createSheet("sheet1");//创建sheet
			Row row = createSheet.createRow(0);//创建标题
			String[] cellTitle = {
				"身份证号","姓名","性别","联系电话","原工作单位","民族","职务","职级","类型","党费基数"};
			for (int i = 0; i < cellTitle.length; i++) {
				createSheet.setColumnWidth(i, 3500);
				Cell createCell = row.createCell(i);
				createCell.setCellValue(cellTitle[i]);
			}
			m.setDfjs("notnull");//随便给个值，主要是用来查出党费基数不为空的人员
			List<Retirement> list = mentService.queryByVo(m);
			int s = 1;
			for(Retirement r : list){
				Row dataRow = createSheet.createRow((short) s);
				for(int i = 0;i<cellTitle.length;i++){
					Cell da = dataRow.createCell(i);
					switch (i) {
						case 0:
							da.setCellValue(r.getSfzh());
							break;
						case 1:
							da.setCellValue(r.getXm() != null ? r.getXm() : "");
							break;
						case 2:
							da.setCellValue(r.getXb() != null ? r.getXb() : "");
							break;
						case 3:
							da.setCellValue(r.getLxdh() != null ? r.getLxdh() : "");
							break;
						case 4:
							da.setCellValue(r.getDwb() != null ? r.getDwb().getName() : "");
							break;
						case 5:
							da.setCellValue(r.getMzb() != null ? r.getMzb().getName() : "");
							break;
						case 6:
							da.setCellValue(r.getZwb() != null ? r.getZwb().getName() : "");
							break;
						case 7:
							da.setCellValue(r.getZjb() != null ? r.getZjb().getName() : "");
							break;
						case 8:
							da.setCellValue(r.getLxb() != null ? r.getLxb().getName() : "");
							break;
						case 9:
							da.setCellValue(r.getDfjs() != null ? r.getDfjs() : "");
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

