package cn.uuf.ltxxt.party.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.ret.Retireparty;
import cn.uuf.domain.ret.Retirepartywork;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.party.service.RetirepartyService;
import cn.uuf.ltxxt.party.service.RetirepartyworkService;
import cn.uuf.util.Paginate;

/**
 * 党建工作
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-14
 */
@Controller
@RequestMapping("{retirepartywork:retirepartywork;*.?}")
public class RetirepartyworkController extends BaseController{

	private final String LIST_ACTION = "redirect:/retirepartywork";
	@Resource
	private RetirepartyworkService wService;
	@Resource
	private RetirepartyService pService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue = "1") Integer page,Retirepartywork m,String kssj,String jssj){
		ModelAndView mav = new ModelAndView("party/work/index");
		try{
			int s = (page - 1) * size;
			Long count = wService.getCount(m,kssj,jssj);
			
			List<Retirepartywork> list = wService.queryList(m,s, size,kssj,jssj);
			for (Retirepartywork retirepartywork : list) {
				String kfdzb = retirepartywork.getKfdzb();
				Retireparty retireparty = pService.queryByName(kfdzb);
				retirepartywork.setRetireparty(retireparty);
			}
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("kfdzb", m.getKfdzb());
			mav.addObject("party", pService.getAll());
			mav.addObject("list", list);
			mav.addObject("p",m);
			mav.addObject("kssj",kssj);
			mav.addObject("jssj",jssj);
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}

	@RequestMapping(value="{create:create;*.?}")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("party/work/create");
		mav.addObject("plist",pService.getAll());
		this.getCodeInf(mav);
		return mav;
	}

	@RequestMapping(value="{save:save;*.?}",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, @Valid Retirepartywork p, BindingResult result,RedirectAttributes redAttr) {
		try{
			if(result.hasErrors()){
				for (ObjectError oe : result.getAllErrors()) {
					redAttr.addFlashAttribute(Constants.MESSAGE_NAME, oe.getDefaultMessage());
					redAttr.addFlashAttribute("p", p);
					return new ModelAndView("redirect:/retirepartywork/create");
				}
			}
			wService.save(p);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView modify(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("party/work/update");
		try{
			mav.addObject("plist",pService.getAll());
			mav.addObject("p",wService.getById(id));
			this.getCodeInf(mav);
		}catch(Exception e){}
		return mav;
	}
	
	@RequestMapping("{update:update;*.?}")
	@Transactional(rollbackFor=Exception.class)
	public ModelAndView update(HttpServletRequest request,@Valid Retirepartywork p,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for (ObjectError oe : res.getAllErrors()) {
					red.addFlashAttribute(Constants.MESSAGE_NAME, oe.getDefaultMessage());
					red.addFlashAttribute("p", p);
					return new ModelAndView("redirect:/retirepartywork/"+p.getId()+"/edit");
				}
			}
			wService.update(p);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改成功");
		}catch(Exception e){
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("{delete:delete;*.?}")
	public ModelAndView delete(HttpServletRequest request,RedirectAttributes redAttr,Long... id){
		try{
			wService.delete(id);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	/**
	 * 异步提取人员信息
	 * @param response
	 * @param sfzh
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxDetail(HttpServletResponse response,Long id){
		ModelAndView mav = new ModelAndView("party/work/_work");
		try{
			Retirepartywork m = wService.getById(id);
			String kfdzb = m.getKfdzb();
			Retireparty party = pService.queryByName(kfdzb);
			mav.addObject("p",m);
			mav.addObject("party",party);
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
				Retirepartywork p = new Retirepartywork();
				if(row != null){
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if(row.getCell(0).getStringCellValue() != null){
						p.setTitle(row.getCell(0).getStringCellValue());
						if(row.getCell(1) != null){
							row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
							p.setKfrq(row.getCell(1).getStringCellValue());
						}
						if(row.getCell(2) != null){
							row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
							p.setZcr(row.getCell(2).getStringCellValue());
						}
						if(row.getCell(3) != null){
							row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
							p.setKfdzb(row.getCell(3).getStringCellValue());
						}
						if(row.getCell(4) != null){
							row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
							p.setCfry(row.getCell(4).getStringCellValue());
						}
						if(row.getCell(5) != null){
							row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
							p.setContent(row.getCell(5).getStringCellValue());
						}
						wService.save(p);
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
	public void exportExcel(Retirepartywork p,HttpServletResponse response){
		try{
			Workbook wb = new HSSFWorkbook();//创建工作表
			Sheet createSheet = wb.createSheet("sheet1");//创建sheet
			Row row = createSheet.createRow(0);//创建标题
			String[] cellTitle = {
				"标题","时间","主持人","所在党支部","参会人员","内容"};
			for (int i = 0; i < cellTitle.length; i++) {
				createSheet.setColumnWidth(i, 3500);
				Cell createCell = row.createCell(i);
				createCell.setCellValue(cellTitle[i]);
			}
			List<Retirepartywork> list = wService.queryByVo(p);
			int s = 1;
			for(Retirepartywork r : list){
				Row dataRow = createSheet.createRow((short) s);
				for(int i = 0;i<cellTitle.length;i++){
					Cell da = dataRow.createCell(i);
					switch (i) {
						case 0:
							da.setCellValue(r.getTitle());
							break;
						case 1:
							da.setCellValue(r.getKfrq());
							break;
						case 2:
							da.setCellValue(r.getZcr());
							break;
						case 3:
							da.setCellValue(r.getKfdzb());
							break;
						case 4:
							da.setCellValue(r.getCfry());
							break;
						case 5:
							da.setCellValue(r.getContent());
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
	
	@RequestMapping(value="selUnit",method=RequestMethod.POST)
	public @ResponseBody String preUnit(HttpServletRequest request,HttpServletResponse response){
		String dwId=request.getParameter("id");
		if (dwId!=null && dwId.matches("^[0-9]*$")) {
			try {
				String hql = "select sfzh,xm from Retirement where sfsc='否' and party_id="+dwId;
				List ments = mentService.queryByHql(hql);
				List<Retirement> res=new ArrayList<Retirement>();
				Retirement data =null;
				for(int i = 0 ;i< ments.size();i++){
					data = new Retirement();
					Object[] obj=(Object[])ments.get(i);
					data.setSfzh((String)obj[0]);
					data.setXm((String)obj[1]);
					res.add(data);
				}
				Gson gson = new GsonBuilder().serializeNulls().create();

				return gson.toJson(res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}

