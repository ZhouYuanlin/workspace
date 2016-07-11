package cn.uuf.ltxxt.system.code.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.CodeSaveZdytjb;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.code.service.CodeGjtjbService;
import cn.uuf.ltxxt.system.code.service.CodeSaveZdytjbService;
import cn.uuf.ltxxt.system.code.service.CodeZdytjbService;
import cn.uuf.ltxxt.system.permission.service.AccountService;
import cn.uuf.util.Paginate;

/**
 * 快速查询保存自定义条件表
 * @author Suntingwen
 *
 */
@Controller
@RequestMapping("{codesavezdytjb:codesavezdytjb;*.?}")
public class CodeSaveZdytjbController extends BaseController{

	@Resource
	private CodeZdytjbService zdytjbService;
	@Resource
	private CodeGjtjbService gjcxService;
	@Resource
	private CodeSaveZdytjbService saveZdytjbService;
	@Resource
	private AccountService accountService;
	
	
	@RequestMapping
	public ModelAndView index(Integer page,CodeSaveZdytjb savezdytjb,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("code/savezdytjb/index");
		try{
			page = page == null || page < 0 ? 1 : page;
			int start = (page - 1) * size;
			Long count = saveZdytjbService.getCount(savezdytjb);
			List<CodeSaveZdytjb> list = saveZdytjbService.queryList(savezdytjb, start, size);
			paginate = new Paginate(list, count, size, page);
			List<CodeSaveZdytjb> lists = new ArrayList<CodeSaveZdytjb>();
			for (CodeSaveZdytjb codeSaveZdytjb : list) {
				Account byUserName = accountService.getByUserName(codeSaveZdytjb.getUsername());
				if(codeSaveZdytjb.getUsername().equals(byUserName.getUsername())){
					codeSaveZdytjb.setUsername(byUserName.getRealname());
				}
				lists.add(codeSaveZdytjb);
			}
			mav.addObject("savezdytjb", savezdytjb);
			mav.addObject("list",lists);
			mav.addObject("paginate",paginate);
		}catch(Exception e){
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
			e.printStackTrace();
		}
		mav.addObject("url","/codesavezdytjb");
		return mav;
	}
}

