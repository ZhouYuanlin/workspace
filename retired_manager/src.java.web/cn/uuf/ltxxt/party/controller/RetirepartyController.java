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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.User;
import cn.uuf.domain.ret.Retireparty;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.party.service.RetirepartyService;
import cn.uuf.util.AddSQLQuery;
import cn.uuf.util.Paginate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 党支部管理
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-11
 */
@Controller
@RequestMapping("{retparty:retparty;*.?}")
public class RetirepartyController extends BaseController{

	private final String LIST_ACTION = "redirect:/retparty";
	@Resource
	private RetirepartyService pService;
//	@Resource
//	private UserService uService;
//	@Resource
//	private RetdepartService depService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retireparty p){
		ModelAndView mav = new ModelAndView("party/branch/index");
		try{
			int s = (page - 1) * size;
			p.setSfsc(Constants.HASNO);
			Long count = pService.getCount(p);
			List<Retireparty> list = pService.queryList(p, s,size);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("p",p);
			getCodeInf(mav);
			String sql = "select xm,lxdh from uf_ltx_info";
			mav.addObject("infolist",mentService.queryBySql(sql));
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("party/branch/create");
		try{
			mav.addObject("plist",pService.getAll());
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value="{save:save;*.?}",method=RequestMethod.POST)
	public ModelAndView save(String sfhs,@Valid Retireparty p,BindingResult res,RedirectAttributes red,String... rets){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("r",p);
					return new ModelAndView("redirect:/retparty/create");
				}
			}
			p.setSfsc(Constants.HASNO);
			p.setCreateDate(new Date());
		
			if(p.getDwb().getId()==null){
				p.setDwb(null);
			}
			if(p.getLxb().getId()==null){
				p.setLxb(null);
			}
			
			pService.save(p);
			//更新支委
			if(sfhs != null && sfhs.length() > 0){
				addZws(sfhs,p);
			}
			List<Retirement> list = new ArrayList<Retirement>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for(String s : rets){
				Retirement m = mentService.getById(s);
				m.setRdsj(sdf.format(new Date()));
				m.setParty(p);
				list.add(m);
				mentService.update(m);
			}
			if(list.size() > 0){
				p.setMents(list);
				pService.update(p);
			}
			red.addFlashAttribute(Constants.MESSAGE_NAME,"创建成功");	
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"保存失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("party/branch/update");
		try{
			mav.addObject("plist",pService.getAll());
			mav.addObject("r",pService.getById(id));
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="{update:update;*.?}",method=RequestMethod.POST)
	public ModelAndView update(String sfhs,@Valid Retireparty p,BindingResult res,RedirectAttributes red,String... rets){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("r",p);
					return new ModelAndView("redirect:/retparty/"+p.getId()+"/edit");
				}
			}
			String sql = "update uf_ltx_info set party_id = '' where party_id=" + p.getId();
			mentService.updateHQL(sql);
			sql = "update uf_ltx_info set zw_id='' where party_id="+p.getId();
			mentService.updateHQL(sql);
			Retireparty pp = pService.getById(p.getId());
			pp = (Retireparty) AddSQLQuery.setObjectValue(p,pp);
			pService.update(pp);
			if(sfhs != null && sfhs.length() > 0){
				addZws(sfhs,pp);
			}
			addMents(pp,rets);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	public void addZws(String sfhs,Retireparty p){
		List<Retirement> users = new ArrayList<Retirement>();
		for(int i=0;i<sfhs.split(",").length;i++){
			Retirement u = mentService.getById(sfhs.split(",")[i]);
			if(u != null){
				users.add(u);u.setZw(p);
				mentService.update(u);
			}
		}
		if(users.size() > 0){
			p.setZws(users);
			pService.update(p);
		}
	}
	@RequestMapping("{delete:delete;*.?}")
	public ModelAndView delete(RedirectAttributes red,Long... id){
		try{
			String sql = "update uf_ltx_info set party_id = '' where party_id=";
			String ss = "update uf_ltx_info set zw_id = '' where party_id=";
			for(Long i : id){
				Retireparty p = pService.getById(i);
				 sql += i;
				mentService.updateHQL(sql);
				ss += i;
				mentService.updateHQL(ss);
				p.setCanceDate(new Date());
				p.setSfsc(Constants.HASYES);
				pService.update(p);
			}
			red.addFlashAttribute(Constants.MESSAGE_NAME,"注消成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"注消失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	private void addMents(Retireparty pp,String... rets){
		List<Retirement> list = new ArrayList<Retirement>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(String s : rets){
			Retirement m = mentService.getById(s);
			m.setRdsj(sdf.format(new Date()));
			m.setParty(pp);
			list.add(m);
			mentService.update(m);
		}
		if(list.size() > 0){
			pp.setMents(list);
			pService.update(pp);
		}
	}

	/**
	 * 异步提取人员信息
	 * @param response
	 * @param sfzh
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxDetail(HttpServletResponse response,Long id){
		ModelAndView mav = new ModelAndView("party/branch/_show");
		try{
			mav.addObject("r",pService.getById(id));
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("beforeFind")
	public @ResponseBody 
	String beforeApply(@RequestParam String dzbmc){
		try{
			Retireparty r = this.pService.queryByName(dzbmc);
			if(r != null){
				return r.getId()+"";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return StringUtils.EMPTY;
	}
	
	@RequestMapping(value = "autoComplete", method = RequestMethod.POST)
	public @ResponseBody Object[] getUser(@RequestParam String query) {
		Object obj = null;
		Object[] autoComplete = null;
		try {
			StringBuffer strBuf=new StringBuffer();
			strBuf.append("select sfzh from User t where 1=1 ");
			strBuf.append("and  ( t.sfzh like '"+query+"%' or t.xm like '"+query+"%') ");
			List data =  mentService.queryByHql(strBuf.toString());
			autoComplete = new Object[data.size()];
			for(int i = 0 ;i < data.size(); i++){
				obj = (Object) data.get(i);
				autoComplete[i] = obj.toString();
			}
			return autoComplete;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("{dcExcel:dcExcel;*.?}")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView uploadxsl(@RequestParam("uploadFile") MultipartFile uploadFile,HttpServletRequest request, HttpServletResponse response,RedirectAttributes red)throws Exception{
		try{
			Workbook workbook = WorkbookFactory.create(uploadFile.getInputStream());
		    Sheet sheet = workbook.getSheetAt(0);
		    String sfhs = "";
		    for(int i=1;i<sheet.getLastRowNum()+1;i++){
				Row row = sheet.getRow(i);
				Retireparty p = new Retireparty();
				if(row != null){
					Cell cell0 = row.getCell(0);
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if(cell0.getStringCellValue() != null)
						p.setDzbmc(cell0.getStringCellValue());
					if(row.getCell(1) != null){
						row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						p.setDzbjc(row.getCell(1).getStringCellValue());
					}
					if(row.getCell(2) != null){
						row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
						p.setDzbsj(row.getCell(2).getStringCellValue());
					}
					if(row.getCell(3) != null){
						row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
						sfhs = row.getCell(3).getStringCellValue();
					}
					if(row.getCell(4) != null){
						row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
						p.setZblny(row.getCell(4).getStringCellValue());
					}
					if(row.getCell(5) != null){
						row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
						p.setLxdh(row.getCell(5).getStringCellValue());
					}
					if(row.getCell(6) != null){
						row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
						p.setZzms(row.getCell(6).getStringCellValue());
					}
					p.setCreateDate(new Date());p.setSfsc(Constants.HASNO);
					this.pService.save(p);
					if(row.getCell(7) != null){
						row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
						addMents(p, row.getCell(7).getStringCellValue().split(","));
					}
					if(sfhs != null && sfhs.length() > 0){
						addZws(sfhs,p);
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
	public void exportExcel(Retireparty p,HttpServletResponse response){
		try{
			Workbook wb = new HSSFWorkbook();//创建工作表
			Sheet createSheet = wb.createSheet("sheet1");//创建sheet
			Row row = createSheet.createRow(0);//创建标题
			String[] cellTitle = {
				"党支部名称","党支部简称","党支部书记","支委","联络员","联系电话","职责简述","党员"};
			for (int i = 0; i < cellTitle.length; i++) {
				createSheet.setColumnWidth(i, 3500);
				Cell createCell = row.createCell(i);
				createCell.setCellValue(cellTitle[i]);
			}
			p.setSfsc(Constants.HASNO);
			List<Retireparty> list = pService.queryByVo(p);
			int s = 1;
			for(Retireparty r : list){
				Row dataRow = createSheet.createRow((short) s);
				for(int i = 0;i<cellTitle.length;i++){
					String xx = "",us="";
					Cell da = dataRow.createCell(i);
					if(r.getMents().size() > 0){
						for(Retirement m : r.getMents()){
							xx +=m.getXm()+" ";
						}
					}
					if(r.getZws().size() > 0){
						for(Retirement u : r.getZws()){
							us += u.getXm() + " ";
						}
					}
					switch (i) {
						case 0:
							da.setCellValue(r.getDzbmc());
							break;
						case 1:
							da.setCellValue(r.getDzbjc() != null ? r.getDzbjc() : "");
							break;
						case 2:
							da.setCellValue(r.getDzbsj() != null ? r.getDzbsj() : "");
							break;
						case 3:
							da.setCellValue(us);
							break;
						case 4:
							da.setCellValue(r.getZblny() != null ? r.getZblny() : "");
							break;
						case 5:
							da.setCellValue(r.getLxdh() != null ? r.getLxdh() : "");
							break;
						case 6:
							da.setCellValue(r.getZzms() != null ? r.getZzms() : "");
							break;
						case 7:
							da.setCellValue(xx);
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
	public @ResponseBody String selPerson(HttpServletRequest request,HttpServletResponse response){
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
	
	@RequestMapping(value="selUser",method=RequestMethod.POST)
	public @ResponseBody String preUnit(HttpServletRequest request,HttpServletResponse response){
		String dwId=request.getParameter("id");
		if (dwId!=null && dwId.matches("^[0-9]*$")) {
			try {
				String hql = "select sfzh,xm from User where dwb_id="+dwId;
				List ments = mentService.queryByHql(hql);
				List<User> res=new ArrayList<User>();
				User data =null;
				for(int i = 0 ;i< ments.size();i++){
					data = new User();
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

