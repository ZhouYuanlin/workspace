package cn.uuf.ltxxt.system.permission.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.excelutils.ExcelUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.CodeDwb;
import cn.uuf.domain.Role;
import cn.uuf.domain.User;
import cn.uuf.domain.record.Retdepart;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.record.service.RetdepartService;
import cn.uuf.ltxxt.system.code.service.CodeDwbService;
import cn.uuf.ltxxt.system.permission.service.AccountService;
import cn.uuf.ltxxt.system.permission.service.RoleService;
import cn.uuf.ltxxt.system.permission.service.UserService;
import cn.uuf.util.AddSQLQuery;
import cn.uuf.util.Paginate;
/**
 * @author wyl
 * @date May 26, 2014
 */
@Controller
@RequestMapping("/{account:account;?.*}")
public class AccountController extends BaseController{

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@Resource
	private RetdepartService depService;
	@Resource
	private CodeDwbService codeDwbService;
	
	private final String LIST_ACTION = "redirect:/account";
	
	@RequestMapping
	public ModelAndView index(Integer page,User u,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("permission/account/index");
		try{
			page = page == null || page < 0 ? 1 : page;
			int start = (page - 1) * size;
			Long count = userService.getCount(u);//accountService.getCount(acc);
			List<User> list = userService.queryList(u,start, size);//accountService.queryList(acc, start, size);
			for (User user : list) {
				String sfzh = user.getSfzh();
				Account account = accountService.getByUserName(sfzh);
				if(account!=null){
					List<Role> roles = account.getRoles();
					if(!CollectionUtils.isEmpty(roles)){
						Role role = roles.get(0);
						user.setRole(role.getName());
					}
				}
			}
			mav.addObject("list",list);
			paginate = new Paginate(list,count, size, page);
			mav.addObject("paginate",paginate);
			mav.addObject("acc",u);
//			mav.addObject("roles",roleService.getAll());
		}catch(Exception e){
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("create")
	public ModelAndView create(Account acc,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("permission/account/create");
		mav.addObject("roleList",roleService.getAll());
		mav.addObject("dwblist",dwbService.getAll());
		return mav;
	}
	/**
	 * 异步验证用户名
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("checkUName")
	public @ResponseBody String checkName(HttpServletRequest request,HttpServletResponse response){
		String info=null;
		try{
			String uname = request.getParameter("name");
			Account account=accountService.queryByLoginName(uname);
			if (account!=null) {
				info="1";
			}
		}catch(Exception e){
			info = "用户验证失败！";
		}
		return info;
	}
	
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,@Valid Long ssgw, @Valid User user,BindingResult re,RedirectAttributes redAttr,Long... rId){
		try{
			if(re.hasErrors()){
				for(ObjectError oe : re.getAllErrors()){
					redAttr.addFlashAttribute(Constants.MESSAGE_NAME,oe.getDefaultMessage());
					redAttr.addFlashAttribute("user", user);
					return new ModelAndView("redirect:/account/create");					
				}
			}
			CodeDwb codeDwb = codeDwbService.getById(ssgw);
			Retdepart retdepart = depService.getById(ssgw);
			Account acc = accountService.getByUserName(user.getSfzh());
			boolean isret = false;
			if(acc == null){
				List<Role> list = new ArrayList<Role>();
				for(Long id : rId){
					Role role = roleService.getById(id);
					if(role.getScope().equals(Constants.INFOGR))
						isret = true;
					list.add(role);
				}
				acc = new Account();
				acc.setUsername(user.getSfzh());
				acc.setGzzh(user.getGzzh());
				acc.setLxdh(user.getLxdh());
				acc.setPassword(new Md5Hash(user.getSfzh().substring(user.getSfzh().length() - 6)).toHex());
				acc.setStyleColor(Constants.DEFAULTCOLOR);
				acc.setStatus(Constants.ENABLE);//初始化为起用
				acc.setRealname(user.getXm());
				acc.setRoles(list);
				acc.setDqsj(user.getRole());
				if(!isret){
					accountService.save(acc);
					if(codeDwb!=null || retdepart!=null){
						if(codeDwb!=null){
							user.setCodedwb(codeDwb);
						}
					}
					userService.save(user);
				}else{
//					Retirement ret = new Retirement();
//					ret.setSfzh(user.getSfzh());ret.setXm(user.getXm());ret.setLxdh(user.getLxdh());ret.setXb(user.getXb());
//					ret.setGzzh(user.getGzzh());//ret.setDwb(user.getDwb());
//					mentService.save(ret);
				}
			}else{
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "用户名已存在，请重新输入！");
				redAttr.addFlashAttribute("user", user);
				return new ModelAndView("redirect:/account/create");
			}
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加用户成功");
			this.writer("添加用户",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加用户失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	/**
	 *修改的第一步
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{id}/edit")
	public ModelAndView modify(@PathVariable String id,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("permission/account/update");
		try{
			mav.addObject("roleList",roleService.getAll());
			mav.addObject("deplist",depService.getAll());
			mav.addObject("dwblist",dwbService.getAll());
			User u=userService.getById(id);
			Account acc=accountService.queryByLoginName(id);
			u.setRole(acc.getDqsj());//将到期时间交付给临时字段
			mav.addObject("acc",acc);
			mav.addObject("user",u);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	
	/**
	 * 修改的第二步
	 * @param request
	 * @param response
	 * @param u
	 * @param result
	 * @param redAttr
	 * @param rId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("update")
	@Transactional(rollbackFor =  Exception.class)
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response,@Valid Long ssgw, @Valid User u,BindingResult result,RedirectAttributes redAttr,Long... rId)throws Exception{
		try{
			if(result.hasErrors()){
				for(ObjectError oe : result.getAllErrors()){
					redAttr.addFlashAttribute(Constants.MESSAGE_NAME,oe.getDefaultMessage());
					return new ModelAndView("redirect:/account/"+u.getSfzh()+"/edit");					
				}

			}
			CodeDwb codeDwb = codeDwbService.getById(ssgw);
			Retdepart retdepart = depService.getById(ssgw);
			List<Role> list = new ArrayList<Role>();
			boolean hasKs = false;
			String scope = "";
			for(Long id : rId){
				Role role = roleService.getById(id);
				scope = role.getScope();
				list.add(role);
				if(role.getScope().equals(Constants.INFOGR))
					hasKs = true;
			}
			Account account = accountService.queryByLoginName(u.getSfzh());
			account.setRoles(list);
			User user = userService.getById(account.getUsername());
			user = (User) AddSQLQuery.setObjectValue(u,user);
			user.setSfzh(account.getUsername());
			if(codeDwb!=null || retdepart!=null){
				if(codeDwb!=null){
					user.setCodedwb(codeDwb);
				}
			}
			account.setRealname(user.getXm());
			account.setDqsj(user.getRole());//将临时字段中的值交还给account
			userService.update(user);
			accountService.update(account);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "修改用户成功");
			this.writer("修改用户",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "修改用户失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping(value="delete")
	@Transactional(rollbackFor =  Exception.class)
	public ModelAndView  delete(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redAttr,String... id)throws Exception{
		try{
			for(String i : id){
				Account acc = accountService.queryByLoginName(i);
				userService.delete(i);
				accountService.delete(acc);
			}
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除用户成功");
			this.writer("删除用户",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除用户失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping(value="doExcel")
	public ModelAndView  doExcel(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView model=new ModelAndView("permission/account/upload");
		return model;
	}	
	/**
	 * 导入方法
	 * @param uploadFile
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/importExcel")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView importExcel(@RequestParam("uploadFile") MultipartFile uploadFile,HttpServletRequest request, HttpServletResponse response,RedirectAttributes redAttr)throws Exception{
		try{
			if(hasRoleScope().equals(Constants.INFOALL)){
				//角色表
				List<Role> roles=roleService.getAll();
				Map<String,Role> roleMap=new HashMap<String, Role>();
				for (int i = 0; i < roles.size(); i++) {
					Role tm=roles.get(i);
					if (!tm.getScope().equals(Constants.INFOGR)) {
						roleMap.put(roles.get(i).getName(), roles.get(i));
					}
				}
				Map<String,Retdepart> maps = new LinkedHashMap<String,Retdepart>();
				List<Retdepart> ll = depService.getAll();
				for(Retdepart d : ll){
					maps.put(d.getName(),d);
				}
				Workbook workbook = WorkbookFactory.create(uploadFile.getInputStream());
			    Sheet sheet = workbook.getSheetAt(0);
			    StringBuffer strBuf=new StringBuffer();
			    strBuf.append("******************失败原因*********************<br/>");
			    
			    int count=0;
			    boolean vFlag=false;
			    for(int i=1;i<sheet.getLastRowNum()+1;i++){
				   Row row = sheet.getRow(i);
				   User user = new User();
				   Account account=null;
				   List<Role> list = new ArrayList<Role>();
				   if(row != null){
					   Cell cell0 = row.getCell(0);
					   if (cell0!=null) {
						   cell0.setCellType(Cell.CELL_TYPE_STRING);
						   if(cell0.getStringCellValue() != null && !cell0.getStringCellValue().trim().equals("")){
							   account=accountService.queryByLoginName(cell0.getStringCellValue());
							   if (account!=null) {//重复用户名不处理
								   //标记不合法的数据导入
								   vFlag=true;
								   count++;
								   if (count>1) {
										strBuf.append(";");
									   }
								   if (count>=5) {
									   count=0;
									   strBuf.append("<br/>");
								   }
								   strBuf.append(cell0.getStringCellValue()+"用户已存在");
								   continue;
							   }
							   
							   Account acc = new Account();
							   acc.setUsername(cell0.getStringCellValue());
							   row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
							   acc.setRealname(row.getCell(1).getStringCellValue());
							   acc.setPassword(new Md5Hash(acc.getUsername().substring(acc.getUsername().length() - 6)).toHex());
							   acc.setStatus(Constants.ENABLE);
							   acc.setStyleColor(Constants.DEFAULTCOLOR);//初始化每个用户都有一个默认样式，后期用户可自定义样式(通过此字段来换肤)
							   if(row.getCell(2) != null){
								   row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
								   user.setXb(row.getCell(2).getStringCellValue());
							   }
							   if(row.getCell(3) != null){
								   row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
								   user.setLxdh(row.getCell(3).getStringCellValue());
							   }
							   row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
							   String rl=row.getCell(4).getStringCellValue().trim();
							   Role roleTmp=null;
							   roleTmp = roleMap.get(rl);
							   if (roleTmp != null) {
								   list.add(roleTmp);
							   }else{
								   vFlag=true;
								   count++;
								   if (count>1) {
										strBuf.append(";");
									   }
								   if (count>=5) {
									   count=0;
									   strBuf.append("<br/>");
								   }
								   strBuf.append(cell0.getStringCellValue()+"角色不存在");
								   continue;
							   }
							   user.setSfzh(acc.getUsername());
							   user.setXm(acc.getRealname());
							   userService.save(user);
							   acc.setRoles(list);
							   accountService.save(acc);
						   }						
					}
					
				   }
			    }
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "导入成功！");
				if (vFlag) {
					ModelAndView mv=new ModelAndView("/permission/account/repeatInfo");
					mv.addObject("data", strBuf);
					return mv;					
				}
			}else
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "您无权限导入！");
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "导入失败");
			
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping("downExcel")
	public void downExcel(HttpServletRequest request, HttpServletResponse response){
		try {
			String file = request.getSession().getServletContext().getRealPath("/") + "model/user.xls";
			response.reset(); 
			response.setContentType("application/vnd.ms-excel"); 
			response.setHeader("Content-Disposition","attachment;filename=user.xls"); 			
			ExcelUtils.export(file, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ;
	}
	
	@RequestMapping("{id}/resetPassword")
	public ModelAndView resetPassword(@PathVariable String id){
		ModelAndView mav=new ModelAndView("permission/account/reset");
		try {
			Account account=accountService.queryByLoginName(id);
			mav.addObject("acc", account);
		} catch (Exception e) {
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
			e.printStackTrace();
		}
		return mav;
	}
	/**
	 * 自定义列的导出----第一步
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxUserExport;*.?}")
	public ModelAndView beforexp(){
		return new ModelAndView("/permission/account/_export");
	} 
	
	/**
	 * 自定义列的导出----第二步
	 * @param list
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/UserExport")
	public void export(@ModelAttribute("accounts") Accounts accoutns,HttpServletResponse response) throws IOException
	{
		OutputStream out = response.getOutputStream();//定义输出的out对象
		Workbook wb = new HSSFWorkbook();//创建工作表
		Sheet createSheet = wb.createSheet("sheet1");//创建sheet
		Row row = createSheet.createRow(0);//创建标题
		try {
			List<Account> list=accoutns.getList();
			if(list==null)
			{
				return;
			}
			int f=0,l=0,listSize=list.size();
			//开写入标题
			for(int i=0;i<listSize;i++){
				if(StringUtils.isNotEmpty(list.get(i).getGzzh())){//判断是否为空,过虑非选中的列
					Cell cell=row.createCell(f);
					cell.setCellValue(list.get(i).getLxdh());//写入
					f++;
				}
			}
			
			//标题写入完成
			List<Account> accounts=accountService.getAll();//得到所有用户
			String v=null;
			for(int i=0,size=accounts.size();i<size;i++)//循环遍历完查询到的数据
			{
				Row dataRow = createSheet.createRow((short) i+1);//新建第n行
				l=0;//第l列
				for(int j=0;j<listSize;j++)
				{
					if(StringUtils.isNotEmpty(list.get(j).getGzzh())){//判断是否为空,过虑非选中的列
						Cell dataCell = dataRow.createCell(l);//创建表格
						try {
							v=BeanUtils.getProperty(accounts.get(i), list.get(j).getGzzh());//通过反射得到值
							dataCell.setCellValue(v == null ? "" : v);//写入表格
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							dataCell.setCellValue(v == null ? "" : v);//写入表格
						}
						l++;
					}
				}
			}
			
			Date d=new Date(System.currentTimeMillis());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
			response.setHeader("Content-Disposition", "attachment;filename="+sdf.format(d)+".xls");// 设定输出文件头
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");// 定义输出类型
			wb.write(out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			out.flush();
			out.close();
		}
	}
	
	@RequestMapping(value="updatePassword",method=RequestMethod.POST)
	public ModelAndView updatePassword(Account account,RedirectAttributes attributes){
		try {
			String pwd=new Md5Hash(account.getPassword()).toHex();
			account=accountService.getById(account.getId());
			account.setPassword(pwd);
			accountService.update(account);
		} catch (Exception e) {
			attributes.addFlashAttribute(Constants.MESSAGE_NAME, "修改密码失败！");
			e.printStackTrace();
		}
		attributes.addFlashAttribute(Constants.MESSAGE_NAME, "修改密码成功！");
		return new ModelAndView(LIST_ACTION);
	}
	
	
	//自定义列
	public class Accounts{
		private List<Account> list;

		public List<Account> getList() {
			return list;
		}
		public void setList(List<Account> list) {
			this.list = list;
		}
	}
	
	
	@ModelAttribute("accounts")
	public Accounts initAccounts() {
		Accounts accounts = new Accounts();
		return accounts;
	}
}

