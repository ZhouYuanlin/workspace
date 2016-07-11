package cn.uuf.ltxxt.retire.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.jboss.logging.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
import cn.uuf.domain.CodeLxb;
import cn.uuf.domain.CodeMzb;
import cn.uuf.domain.CodeSaveZdytjb;
import cn.uuf.domain.CodeSydb;
import cn.uuf.domain.CodeTjb;
import cn.uuf.domain.CodeZdytjb;
import cn.uuf.domain.CodeZjb;
import cn.uuf.domain.CodeZwb;
import cn.uuf.domain.CodeZzmmb;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.Role;
import cn.uuf.domain.activity.Retireactivity;
import cn.uuf.domain.activity.Retireactivother;
import cn.uuf.domain.activity.Retireoldun;
import cn.uuf.domain.health.Rethoscard;
import cn.uuf.domain.health.Rethospital;
import cn.uuf.domain.health.Retphone;
import cn.uuf.domain.honor.Retirehonor;
import cn.uuf.domain.ret.Retiredonations;
import cn.uuf.domain.ret.Retirepartywork;
import cn.uuf.domain.ret.Retorganize;
import cn.uuf.ltxxt.activity.service.RetireactivityService;
import cn.uuf.ltxxt.activity.service.RetireactivotherService;
import cn.uuf.ltxxt.activity.service.RetireoldunService;
import cn.uuf.ltxxt.health.service.RethoscardService;
import cn.uuf.ltxxt.health.service.RethospitalService;
import cn.uuf.ltxxt.health.service.RetphoneService;
import cn.uuf.ltxxt.health.service.impl.RetphoneServiceImpl;
import cn.uuf.ltxxt.honor.service.RetirehonorService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.party.service.RetiredonationsService;
import cn.uuf.ltxxt.party.service.RetirepartyService;
import cn.uuf.ltxxt.party.service.RetirepartyworkService;
import cn.uuf.ltxxt.party.service.RetorganizeService;
import cn.uuf.ltxxt.retire.service.RetiresaluteService;
import cn.uuf.ltxxt.retire.util.ImportPage;
import cn.uuf.ltxxt.system.code.service.CodeDwbService;
import cn.uuf.ltxxt.system.code.service.CodeGjtjbService;
import cn.uuf.ltxxt.system.code.service.CodeSaveZdytjbService;
import cn.uuf.ltxxt.system.code.service.CodeZdytjbService;
import cn.uuf.ltxxt.system.permission.service.AccountService;
import cn.uuf.ltxxt.system.permission.service.RoleService;
import cn.uuf.util.AddSQLQuery;
import cn.uuf.util.CleanStringUtil;
import cn.uuf.util.DateUtil;
import cn.uuf.util.Paginate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 离退休人员(管理员查看或授权查看)
 * 
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Controller
@RequestMapping("{retment:retment;*.?}")
public class RetmentController extends BaseController {

	private final String LIST_ACTION = "redirect:/retment";
	@Resource
	private RoleService rSerivce;
	@Resource
	private AccountService acService;
	@Resource
	private RetirehonorService hService;
	@Resource
	private RetiresaluteService saluteService;
	@Resource
	private RethoscardService rethoscardService;
	@Resource
	private RetireactivityService retireactivityService;
	@Resource
	private RetorganizeService organizeService;
	@Resource
	private RetireoldunService retireoldunService;
	@Resource
	private RetireactivotherService retireactivotherService;
	@Resource
	private RetirepartyService retirepartyService;
	@Resource
	private RethospitalService rethospitalService;
	@Resource
	private RetphoneService retphoneService;
	@Resource
	private RetiredonationsService retiredonationsService;
	@Resource
	private RetirepartyworkService retirepartyworkService;
	@Resource
	private CodeGjtjbService gjcxbService;
	@Resource
	private CodeZdytjbService zdytjbService;
	@Resource
	private CodeSaveZdytjbService saveZdytjbService;

	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue = "1") Integer page, Retirement m, String ages,
			String convalue) {
		ModelAndView mav = new ModelAndView("retire/person/index");
		try {
			if (ages == null) {
				ages = "50,120";
			}
			Integer agest = null;
			Integer ageend = null;
			Integer ageeq = null;
			if (StringUtils.isNotEmpty(ages)) {
				String[] agearr = ages.split(",");
				agest = Integer.parseInt(agearr[0]);
				ageend = Integer.parseInt(agearr[1]);
				if (agest.equals(ageend)) {
					ageeq = ageend;
				}
			}
			mav.addObject("ages", ages);

			String csrqSend = "";
			String csrqSst = "";
			String csrqSeq = "";
			String beiyong = ""; // 无用的参数,解决接口中方法参数相同问题
			if (ageeq != null) {
				int currentYear = DateUtil.getCurrentYear();
				csrqSeq = (currentYear - ageeq) + "";
			} else {

				if (agest != null) {
					int currentYear = DateUtil.getCurrentYear();
					csrqSst = ((currentYear - agest) + 1) + "-00-00";
				}
				if (ageend != null) {
					int currentYear = DateUtil.getCurrentYear();
					csrqSend = ((currentYear - ageend)) + "-00-00";
				}
			}
			int s = (page - 1) * size;
			if (hasRoleScope().equals(Constants.INFOYX)) {
				if (dwbService.getById(getUser().getCodedwb().getId()).getSfejdw().equals(Constants.HASYES)) {
					m.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}
			}
			Long count = mentService.getCount(m, csrqSst, csrqSend, csrqSeq, beiyong);
			List<Retirement> list = mentService.queryList(m, s, size, csrqSst, csrqSend, csrqSeq, beiyong);
			paginate = new Paginate(list, count, size, page);

			CodeTjb codeTjb = gjcxbService.getUniqueEntity("tjbywm", "ryxxb");
			// List<CodeZdytjb> zdytjbList = codeTjb.getZdytjbs();
			List<CodeZdytjb> zdytjbList = zdytjbService.queryUniqueTable(codeTjb);
			mav.addObject("zdytjbList", zdytjbList);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("ret", m);
			mav.addObject("agest", agest);
			mav.addObject("ageend", ageend);
			mav.addObject("ageeq", ageeq);
			getCodeInf(mav);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
		}
		return mav;
	}

	@RequestMapping(value = "{create:create;*.?}")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("retire/person/create");
		this.getCodeInf(mav);
		if (hasRoleScope().equals(Constants.INFOYX)) {
			List<CodeDwb> list = new ArrayList<CodeDwb>();
			list.add(getUser().getCodedwb());
			mav.addObject("dwblist", list);
		}
		return mav;
	}

	@RequestMapping(value = "{save:save;*.?}", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, @Valid Retirement m, BindingResult result,
			RedirectAttributes redAttr) {
		try {
			if (result.hasErrors()) {
				for (ObjectError oe : result.getAllErrors()) {
					redAttr.addFlashAttribute(Constants.MESSAGE_NAME, oe.getDefaultMessage());
					redAttr.addFlashAttribute("ret", m);
					return new ModelAndView("redirect:/retment/create");
				}
			}
			if (hasRoleScope().equals(Constants.INFOYX)) {
				m.setDwb(getUser() != null ? m.getDwb() : null);
			}
			Retirement ret = (Retirement) CleanStringUtil.CleanObj(m, new Retirement());
			ret.setSfsc(Constants.HASNO);
			mentService.save(ret);// 是否需要可登录
			List<Role> l = new ArrayList<Role>();
			l.add(rSerivce.queryByScope(Constants.INFOGR));
			Account ac = new Account();
			ac.setGzzh(m.getGzzh());
			ac.setUsername(m.getSfzh());
			ac.setRealname(m.getXm());
			ac.setStatus(Constants.ENABLE);
			ac.setStyleColor(Constants.DEFAULTCOLOR);
			ac.setLxdh(m.getLxdh());
			ac.setPassword(new Md5Hash(m.getSfzh().substring(m.getSfzh().length() - 6)).toHex());
			ac.setRoles(l);
			acService.save(ac);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加成功");
			this.writer(this.getCurrentUser().getRealname() + "添加[" + m.getXm() + "]退休人员信息", request.getRemoteAddr(),
					this.getCurrentUser().getUsername());
		} catch (Exception e) {
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}

	@RequestMapping("/{id}/edit")
	public ModelAndView modify(@PathVariable String id, RedirectAttributes red) {
		ModelAndView mav = new ModelAndView("retire/person/update");
		try {
			Retirement m = mentService.getById(id);
			if (hasRoleScope().equals(Constants.INFOYX)) {
				if (getUser() != null && !(m.getDwb().getId() + "").equals(m.getDwb().getId() + "")) {
					red.addFlashAttribute(Constants.MESSAGE_NAME, m.getXm() + "不是您同单位的人员不能修改!");
					return new ModelAndView(LIST_ACTION);
				}
			}
			mav.addObject("ret", m);
			this.getCodeInf(mav);
			if (hasRoleScope().equals(Constants.INFOYX)) {
				List<CodeDwb> list = new ArrayList<CodeDwb>();
				list.add(getUser().getCodedwb());
				mav.addObject("dwblist", list);
			}
		} catch (Exception e) {
		}
		return mav;
	}

	@RequestMapping("{update:update;*.?}")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView update(HttpServletRequest request, @Valid Retirement ret, BindingResult res,
			RedirectAttributes red) {
		try {
			if (res.hasErrors()) {
				for (ObjectError oe : res.getAllErrors()) {
					red.addFlashAttribute(Constants.MESSAGE_NAME, oe.getDefaultMessage());
					red.addFlashAttribute("ret", ret);
					return new ModelAndView("redirect:/retment/" + ret.getSfzh() + "/edit");
				}
			}
			// ret = (Retirement) CleanStringUtil.CleanObj(ret);
			Retirement m = mentService.getById(ret.getSfzh());
			m = (Retirement) AddSQLQuery.setObjectValue(ret, m);
			m.setSfsc(Constants.HASNO);
			mentService.update(m);
			red.addFlashAttribute(Constants.MESSAGE_NAME, "修改成功");
			// this.writer(this.getCurrentUser().getRealname()+"修改【"+m.getXm()+"】退休人员信息",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		} catch (Exception e) {
			red.addFlashAttribute(Constants.MESSAGE_NAME, "修改失败");
		}
		return new ModelAndView(LIST_ACTION);
	}

	@RequestMapping("/{sfzh}/detail")
	public ModelAndView detail(@PathVariable String sfzh, RedirectAttributes red) {
		ModelAndView mav = new ModelAndView("retire/person/detail");
		try {
			Retirement m = mentService.getById(sfzh);
			if (hasRoleScope().equals(Constants.INFOYX)) {
				if (getUser() != null && !(m.getDwb().getId() + "").equals(m.getDwb().getId() + "")) {
					red.addFlashAttribute(Constants.MESSAGE_NAME, m.getXm() + "不是您同单位的人员不能查看!");
					return new ModelAndView(LIST_ACTION);
				}
			}
			mav.addObject("ret", m);
			Retirehonor h = new Retirehonor();
			h.setCyhs(sfzh);
			List<Retirehonor> list = hService.queryByVo(h);// 个人表彰
			mav.addObject("hlist", list);
			// 查慰问记录
			String sql = "from Retiresalute s where s.id in( select u.sid from Retiresaluterecord u where u.sfzh='"
					+ sfzh + "') order by s.wwsj desc";// 慰问
			mav.addObject("salist", saluteService.queryBySql(sql));
			// 查询兴趣小组
			Retireactivity act = new Retireactivity();
			act.setCyzh(sfzh);
			List<Retireactivity> actList = retireactivityService.queryByVo(act);
			mav.addObject("actList", actList);
			// 查询老年大学信息
			Retireoldun old = new Retireoldun();
			old.setRet(m);
			List<Retireoldun> oldList = retireoldunService.queryByVo(old);
			mav.addObject("oldList", oldList);
			// 查询党住院信息
			Rethospital hos = new Rethospital();
			hos.setRet(m);
			List<Rethospital> hosList = rethospitalService.queryByVo(hos);
			mav.addObject("hosList", hosList);
			// 电话联系信息
			String phsql = "from Retphone s where s.sfzh like '%" + sfzh + "%'order by s.lxrq desc";
			List<Retphone> phoList = retphoneService.queryBySql(phsql);
			mav.addObject("phoList", phoList);
			// 捐款信息
			Retiredonations dona = new Retiredonations();
			dona.setRet(m);
			List<Retiredonations> donaList = retiredonationsService.queryByVo(dona);
			mav.addObject("donaList", donaList);
			// 活动信息
			String othsql = "from Retireactivother s where s.cyry like '%" + sfzh + "%'order by s.hdsj desc";
			List<Retireactivother> actOtherList = retireactivotherService.queryBySql(othsql);
			mav.addObject("actOtherList", actOtherList);
			// 党建活动信息
			String pwsql = "from Retirepartywork s where s.cfsf like '%" + sfzh + "%'order by s.kfrq desc";
			List<Retirepartywork> pworkList = retirepartyworkService.queryBySql(pwsql);
			mav.addObject("pworkList", pworkList);
			// 党支部信息

		} catch (Exception e) {
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME, "未找到退休人员");
			return new ModelAndView(LIST_ACTION);
		}
		return mav;
	}

	@RequestMapping("{delete:delete;*.?}")
	public ModelAndView delete(HttpServletRequest request, RedirectAttributes redAttr, String... id) {
		try {
			for (String s : id) {
				if (s != null && s.length() > 0) {
					List<Account> list = acService.queryByLoginName1(s);
					if (list != null) {
						for (Account account : list) {
							if (account != null) {
								acService.delete(account);
							}
						}
					}
					List<Retorganize> organizeList = organizeService.getAll();
					for (Retorganize retorganize : organizeList) {
						String sfyfz = retorganize.getRet().getSfzh();
						if (sfyfz.equals(s)) {
							organizeService.delete(retorganize.getId());
						}
					}
					Rethoscard rethoscard = new Rethoscard();
					rethoscard.setRet(mentService.getById(s));
					List<Rethoscard> cardBySfzh = rethoscardService.getBySfzh(rethoscard);
					for (Rethoscard rethoscard2 : cardBySfzh) {
						if (rethoscard2 != null && rethoscard2.getRet().getSfzh().equals(s)) {
							rethoscardService.delete(rethoscard2.getId());
						}
					}
					mentService.delete(s);
				}
			}
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除成功");
			this.writer(this.getCurrentUser().getRealname() + "删除退休人员信息" + id.toString(), request.getRemoteAddr(),
					this.getCurrentUser().getUsername());
		} catch (Exception e) {
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}

	/*
	 * 批量导入某列
	 */
	@RequestMapping(value = "/importpl")
	public ModelAndView importpl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("retire/person/uploadpl");
		return mav;
	}

	/**
	 * 下载模板(通用的方法，通过页面传需下载的文件名称过来就行。)
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("xiazai")
	public void downxiazai(HttpServletRequest request, HttpServletResponse response) {
		try {// retment
			String file = request.getSession().getServletContext().getRealPath("/") + "model/retmentpl.xls";
			response.reset();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename=retmentpl.xls");
			ExcelUtils.export(file, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 导入更新
	 * 
	 * @param uploadFile
	 *            文件名称
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/plgx")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView uploadplgx(@RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redAttr) throws Exception {
		try {
			Workbook workbook = WorkbookFactory.create(uploadFile.getInputStream());
			Sheet sheet = workbook.getSheetAt(0);
			for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
				Row row = sheet.getRow(i);
				Retirement m = new Retirement();
				if (row != null) {
					Cell cell0 = row.getCell(0);
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if (cell0.getStringCellValue() != null) {
						m = mentService.getById(row.getCell(0).getStringCellValue());
						if (m == null) {
							Retirement met=new Retirement();
							if (row.getCell(0) != null) {
								row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
								met.setSfzh(row.getCell(0).getStringCellValue());
							}
							if (row.getCell(1) != null) {
								row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
								met.setXm(row.getCell(1).getStringCellValue());
							}
							if (row.getCell(3) != null) {
								row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
								met.setCsrq(row.getCell(3).getStringCellValue());
							}
							met.setSfsc(Constants.HASNO);
							mentService.save(met);
						}else{
							if (row.getCell(1) != null) {
								row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
								m.setXm(row.getCell(1).getStringCellValue());
							}
							if (row.getCell(3) != null) {
								row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
								m.setCsrq(row.getCell(3).getStringCellValue());
							}
							mentService.update(m);
						}
					}
				}
			}
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "导入成功！");
		} catch (Exception e) {
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "导入失败");
		}
		return new ModelAndView(LIST_ACTION);
	}

	/*
	 * 跳转导入
	 */
	@RequestMapping(value = "/importexecl")
	public ModelAndView importexecl(String xzmob, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView("retire/person/upload");
		mav.addObject("jumpc", ImportPage.imaps.get(xzmob));// 自动跳转到哪个controller中去执行导入方法
		return mav;
	}

	/**
	 * 导入
	 * 
	 * @param uploadFile
	 *            文件名称
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dcExcel")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView uploadxsl(@RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redAttr) throws Exception {
		try {
			Map<String, CodeDwb> dmap = new HashMap<String, CodeDwb>();
			List<CodeDwb> dl = dwbService.getAll();
			for (CodeDwb d : dl) {
				dmap.put(d.getCode(), d);
				dmap.put(d.getName(), d);
			}
			Map<String, CodeMzb> mmap = new HashMap<String, CodeMzb>();
			List<CodeMzb> ml = mzbService.getAll();
			for (CodeMzb m : ml) {
				mmap.put(m.getCode(), m);
				mmap.put(m.getName(), m);
			}
			Map<String, CodeLxb> lmap = new HashMap<String, CodeLxb>();
			List<CodeLxb> ll = lxbService.getAll();
			for (CodeLxb l : ll) {
				lmap.put(l.getCode(), l);
				lmap.put(l.getName(), l);
			}
			Map<String, CodeSydb> smap = new HashMap<String, CodeSydb>();
			List<CodeSydb> sl = sydService.getAll();
			for (CodeSydb s : sl) {
				smap.put(s.getCode(), s);
				smap.put(s.getName(), s);
			}
			Map<String, CodeZwb> wmap = new HashMap<String, CodeZwb>();
			List<CodeZwb> wl = zwbService.getAll();
			for (CodeZwb z : wl) {
				wmap.put(z.getCode(), z);
				wmap.put(z.getName(), z);
			}
			Map<String, CodeZjb> jmap = new HashMap<String, CodeZjb>();
			List<CodeZjb> jl = zjbService.getAll();
			for (CodeZjb z : jl) {
				jmap.put(z.getCode(), z);
				jmap.put(z.getName(), z);
			}
			Map<String, CodeZzmmb> zmap = new HashMap<String, CodeZzmmb>();
			List<CodeZzmmb> zl = zzmmService.getAll();
			for (CodeZzmmb z : zl) {
				zmap.put(z.getCode(), z);
				zmap.put(z.getName(), z);
			}
			Workbook workbook = WorkbookFactory.create(uploadFile.getInputStream());
			Sheet sheet = workbook.getSheetAt(0);
			List<Role> l = new ArrayList<Role>();
			l.add(rSerivce.queryByScope(Constants.INFOGR));
			for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
				Row row = sheet.getRow(i);
				Retirement m = new Retirement();
				if (row != null) {
					Cell cell0 = row.getCell(0);
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if (cell0.getStringCellValue() != null) {
						m.setSfzh(cell0.getStringCellValue());
						row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						m.setXm(row.getCell(1).getStringCellValue());
						if (row.getCell(2) != null) {
							row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
							m.setGzzh(row.getCell(2).getStringCellValue());
						}
						if (row.getCell(3) != null) {
							row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
							m.setLxdh(row.getCell(3).getStringCellValue());
						}
						if (row.getCell(4) != null) {
							row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
							m.setXb(row.getCell(4).getStringCellValue());
						}
						if (row.getCell(5) != null) {
							row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
							m.setDwb(dmap.get(row.getCell(5).getStringCellValue()));
						}
						if (row.getCell(6) != null) {
							row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
							m.setMzb(mmap.get(row.getCell(6).getStringCellValue()));
						}
						if (row.getCell(7) != null) {
							row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
							m.setZwb(wmap.get(row.getCell(7).getStringCellValue()));
						}
						if (row.getCell(8) != null) {
							row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
							m.setZjb(jmap.get(row.getCell(8).getStringCellValue()));
						}
						if (row.getCell(9) != null) {
							row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
							m.setLxb(lmap.get(row.getCell(9).getStringCellValue()));
						}
						if (row.getCell(10) != null) {
							row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
							m.setZzmm(zmap.get(row.getCell(10).getStringCellValue()));
						}
						if (row.getCell(11) != null) {
							row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
							m.setCsrq((row.getCell(11).getStringCellValue()));
						}
						if (row.getCell(12) != null) {
							row.getCell(12).setCellType(Cell.CELL_TYPE_STRING);
							m.setJg(row.getCell(12).getStringCellValue());
						}
						if (row.getCell(13) != null) {
							row.getCell(13).setCellType(Cell.CELL_TYPE_STRING);
							m.setFyzk(row.getCell(13).getStringCellValue());
						} // 婚姻状况
						if (row.getCell(14) != null) {
							row.getCell(14).setCellType(Cell.CELL_TYPE_STRING);
							m.setGrxl(row.getCell(14).getStringCellValue());
						}
						if (row.getCell(15) != null) {
							row.getCell(15).setCellType(Cell.CELL_TYPE_STRING);
							m.setGrxw(row.getCell(15).getStringCellValue());
						}
						if (row.getCell(16) != null) {
							row.getCell(16).setCellType(Cell.CELL_TYPE_STRING);
							m.setSfdj(row.getCell(16).getStringCellValue());
						}
						if (row.getCell(17) != null) {
							row.getCell(17).setCellType(Cell.CELL_TYPE_STRING);
							m.setSfgg(row.getCell(17).getStringCellValue());
						}
						if (row.getCell(18) != null) {
							row.getCell(18).setCellType(Cell.CELL_TYPE_STRING);
							m.setSssn(row.getCell(18).getStringCellValue());
						}
						if (row.getCell(19) != null) {
							row.getCell(19).setCellType(Cell.CELL_TYPE_STRING);
							m.setSfyfz(row.getCell(19).getStringCellValue());
						}
						if (row.getCell(20) != null) {
							row.getCell(20).setCellType(Cell.CELL_TYPE_STRING);
							m.setFzhm(row.getCell(20).getStringCellValue());
						}
						if (row.getCell(21) != null) {
							row.getCell(21).setCellType(Cell.CELL_TYPE_STRING);
							m.setEmail(row.getCell(21).getStringCellValue());
						}
						if (row.getCell(22) != null) {
							row.getCell(22).setCellType(Cell.CELL_TYPE_STRING);
							m.setQq(row.getCell(22).getStringCellValue());
						}
						if (row.getCell(23) != null) {
							row.getCell(23).setCellType(Cell.CELL_TYPE_STRING);
							m.setWeix(row.getCell(23).getStringCellValue());
						}
						if (row.getCell(24) != null) {
							row.getCell(24).setCellType(Cell.CELL_TYPE_STRING);
							m.setGzsj(row.getCell(24).getStringCellValue());
						}
						if (row.getCell(25) != null) {
							row.getCell(25).setCellType(Cell.CELL_TYPE_STRING);
							m.setLxsj(row.getCell(25).getStringCellValue());
						}
						m.setSfsc(Constants.HASNO);
						mentService.save(m);
						Account ac = acService.queryByLoginName(m.getSfzh());
						if (ac == null) {
							ac = new Account();
							ac.setGzzh(m.getGzzh());
							ac.setUsername(m.getSfzh());
							ac.setRealname(m.getXm());
							ac.setStatus(Constants.ENABLE);
							ac.setStyleColor(Constants.DEFAULTCOLOR);
							ac.setLxdh(m.getLxdh());
							ac.setPassword(new Md5Hash(m.getSfzh().substring(m.getSfzh().length() - 6)).toHex());
							ac.setRoles(l);
							acService.save(ac);
						}
					}
				}
			}
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "导入成功！");
		} catch (Exception e) {
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "导入失败");
		}
		return new ModelAndView(LIST_ACTION);
	}

	/**
	 * 下载模板(通用的方法，通过页面传需下载的文件名称过来就行。)
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "download", method = RequestMethod.POST)
	public void downLoad(String xzmob, HttpServletRequest request, HttpServletResponse response) {
		try {// retment
			String file = request.getSession().getServletContext().getRealPath("/") + "model/" + xzmob + ".xls";
			response.reset();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename=" + xzmob + ".xls");
			ExcelUtils.export(file, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 自定义列的导出----第一步
	 * 
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxRetirementExport;*.?}")
	public ModelAndView beforexp() {
		return new ModelAndView("/retire/person/_export");
	}

	// 自定义列
	public class Accounts {
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

	/**
	 * 自由选择列导出到excel---第二步
	 * 
	 * @param m
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("{export:export;*.?}")
	public void exportExcel(@ModelAttribute("accounts") Accounts accoutns, Retirement m, HttpServletResponse response)
			throws IOException {
		OutputStream out = response.getOutputStream();
		Workbook wb = new HSSFWorkbook();// 创建工作表

		CellStyle titleStyle = wb.createCellStyle(); // 标题样式
		Font ztFont = wb.createFont();// 创建字体对象
		ztFont.setFontHeightInPoints((short) 14); // 将字体大小设置为18px
		// ztFont.setStrikeout(true);
		titleStyle.setFont(ztFont);
		titleStyle.setFillForegroundColor(IndexedColors.RED.getIndex()); // 前景色
		titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 居中对齐
		titleStyle.setBorderLeft(CellStyle.BORDER_THIN);
		titleStyle.setBorderRight(CellStyle.BORDER_THIN);
		titleStyle.setBorderBottom(CellStyle.BORDER_THIN);
		titleStyle.setBorderTop(CellStyle.BORDER_THIN);
		CellStyle contentStyle = wb.createCellStyle();// 内容样式

		contentStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 居中对齐
		contentStyle.setBorderLeft(CellStyle.BORDER_THIN);
		contentStyle.setBorderRight(CellStyle.BORDER_THIN);
		contentStyle.setBorderBottom(CellStyle.BORDER_THIN);
		contentStyle.setBorderTop(CellStyle.BORDER_THIN);

		Font contentFont = wb.createFont();// 创建字体对象
		contentFont.setFontHeightInPoints((short) 11); // 将字体大小设置为18px
		contentStyle.setFont(contentFont);
		Sheet createSheet = wb.createSheet("sheet1");// 创建sheet
		Row row = createSheet.createRow(0);// 创建标题
		row.setHeightInPoints(22);// 设置高
		try {
			List<Account> accountList = accoutns.getList();
			if (accountList == null) {
				throw new Exception();
			}
			int f = 0, l = 0, listSize = accountList.size();

			int tempI = 0;
			// 开写入标题
			for (int i = 0; i < listSize; i++) {
				if (StringUtils.isNotEmpty(accountList.get(i).getGzzh())) {// 判断是否为空,过虑非选中的列
					Cell cell = row.createCell(f);
					cell.setCellStyle(titleStyle);// 加样式
					String temp = accountList.get(i).getLxdh();
					cell.setCellValue(temp);// 写入
					tempI++;
					createSheet.setColumnWidth(tempI, temp.length() * 800);// 设置宽
					f++;
				}
			}
			createSheet.setColumnWidth(0, 7000);
			// 标题写入完成

			List<Retirement> list = mentService.queryByVo(m);// 得到所有用户

			String v = null;
			for (int i = 0, size = list.size(); i < size; i++)// 循环遍历完查询到的数据
			{
				Row dataRow = createSheet.createRow((short) i + 1);// 新建第n行
				dataRow.setHeightInPoints(15);// 设置高
				l = 0;// 第l列
				for (int j = 0; j < listSize; j++) {
					if (StringUtils.isNotEmpty(accountList.get(j).getGzzh())) {// 判断是否为空,过虑非选中的列
						Cell dataCell = dataRow.createCell(l);// 创建表格
						dataCell.setCellStyle(contentStyle);
						try {
							v = BeanUtils.getProperty(list.get(i), accountList.get(j).getGzzh());// 通过反射得到值
							dataCell.setCellValue(v == null ? "" : v);// 写入表格
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println(
									"身份证号为" + list.get(i).getSfzh() + "的" + accountList.get(j).getLxdh() + "的值为null");
						}
						l++;
					}
				}
			}

			Date d = new Date(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			response.setHeader("Content-Disposition", "attachment;filename=" + sdf.format(d) + ".xls");// 设定输出文件头
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");// 定义输出类型
			wb.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	/**
	 * 根据用户名
	 * 
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "autoCompleteUser", method = RequestMethod.POST)
	public @ResponseBody Object[] getAllUser(@RequestParam String query) {
		Object[] obj = null;
		Object[] autoComplete = null;
		try {
			StringBuffer strBuf = new StringBuffer();
			strBuf.append("select t.sfzh,t.xm from uf_ltx_info t where 1=1 ");
			strBuf.append("and  ( t.sfzh like '" + query + "%' or t.xm like '" + query + "%') ");// and
																									// rownum
																									// <9
																									// ");
			if (hasRoleScope().equals(Constants.INFOYX)) {
				Long did = getUser() != null ? getUser().getCodedwb().getId() : null;
				if (did != null)
					strBuf.append(" and t.dwb_id = " + did);
			}
			List data = mentService.queryBySql(strBuf.toString());
			autoComplete = new Object[data.size()];
			for (int i = 0; i < data.size(); i++) {
				obj = (Object[]) data.get(i);
				autoComplete[i] = obj[0].toString() + "-" + obj[1];
			}
			return autoComplete;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "autoComplete", method = RequestMethod.POST)
	public @ResponseBody Object[] getUser(@RequestParam String query, String type) {
		Object obj = null;
		Object[] autoComplete = null;
		try {
			StringBuffer strBuf = new StringBuffer();
			strBuf.append("select " + type + " from Retirement t where 1=1 and t.sfsc='否'");
			strBuf.append("and  ( t." + type + " like '" + query + "%') ");
			if (hasRoleScope().equals(Constants.INFOYX)) {
				Long did = getUser() != null ? getUser().getCodedwb().getId() : null;
				if (did != null)
					strBuf.append(" and t.dwb_id = " + did);
			}
			List data = mentService.queryByHql(strBuf.toString());
			autoComplete = new Object[data.size()];
			for (int i = 0; i < data.size(); i++) {
				obj = (Object) data.get(i);
				autoComplete[i] = obj.toString();
			}
			return autoComplete;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "selUnit", method = RequestMethod.POST)
	public @ResponseBody String preUnit(HttpServletRequest request, HttpServletResponse response) {
		String dwId = request.getParameter("id");
		if (dwId != null && dwId.matches("^[0-9]*$")) {
			try {
				if (hasRoleScope().equals(Constants.INFOYX)) {
					dwId = getUser() != null ? getUser().getCodedwb().getId() + "" : null;
				}
				String hql = "select sfzh,xm from Retirement where sfsc='否' and dwb_id=" + dwId;
				List ments = mentService.queryByHql(hql);
				List<Retirement> res = new ArrayList<Retirement>();
				Retirement data = null;
				for (int i = 0; i < ments.size(); i++) {
					data = new Retirement();
					Object[] obj = (Object[]) ments.get(i);
					data.setSfzh((String) obj[0]);
					data.setXm((String) obj[1]);
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

	@RequestMapping(value = "selUnit2", method = RequestMethod.POST)
	public @ResponseBody String preUnit2(HttpServletRequest request, HttpServletResponse response) {
		String dzbId = request.getParameter("id");
		if (dzbId != null && dzbId.matches("^[0-9]*$")) {
			try {
				String hql = "select sfzh,xm from Retirement where sfsc='否' and party_id=" + dzbId;
				List ments = mentService.queryByHql(hql);
				List<Retirement> res = new ArrayList<Retirement>();
				Retirement data = null;
				for (int i = 0; i < ments.size(); i++) {
					data = new Retirement();
					Object[] obj = (Object[]) ments.get(i);
					data.setSfzh((String) obj[0]);
					data.setXm((String) obj[1]);
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

	// 高级查询页面
	@RequestMapping("/advancedSearch")
	public ModelAndView ajaxAdvancedSearch() {
		ModelAndView model = new ModelAndView("retire/person/advancedSearch");
		Account account = getCurrentUser();
		CodeTjb codeTjb = gjcxbService.getUniqueEntity("tjbywm", "ryxxb");
		List<CodeZdytjb> zdytjbList = zdytjbService.queryUniqueTable(codeTjb);
		CodeSaveZdytjb saveZdytjb = new CodeSaveZdytjb();
		saveZdytjb.setUsername(account.getUsername());
		List<CodeSaveZdytjb> saveZdytjblist = saveZdytjbService.queryList(saveZdytjb);
		saveZdytjbService.getCount(saveZdytjb);
		model.addObject("zdytjbList", zdytjbList);
		model.addObject("saveZdytjblist", saveZdytjblist);
		return model;
	}

	// 保存高级查询填入的信息
	@RequestMapping(value = "saveFatties", method = RequestMethod.POST)
	public @ResponseBody String save(@Valid CodeSaveZdytjb savezdytjb) throws Exception {
		try {
			// 将当前登录的用户加入到对象当中,以区分是哪个账号定义的查询条件
			savezdytjb.setUsername(getCurrentUser().getUsername());
			CodeSaveZdytjb temp = new CodeSaveZdytjb();
			temp.setUsername(getCurrentUser().getUsername());
			Long count = saveZdytjbService.getCount(temp);
			if (count < 3) {
				saveZdytjbService.save(savezdytjb);
			} else {
				return "maxCount";
			}
		} catch (Exception e) {
			return "fail";
		}
		return "success";
	}

	// 删除快速查询信息
	@RequestMapping(value = "deleteFatties", method = RequestMethod.POST)
	public @ResponseBody String delete(@Param Long id) throws Exception {
		try {
			// 将当前登录的用户加入到对象当中,以区分是哪个账号定义的查询条件
			saveZdytjbService.delete(id);
		} catch (Exception e) {
			return "fail";
		}
		return "success";
	}
}
