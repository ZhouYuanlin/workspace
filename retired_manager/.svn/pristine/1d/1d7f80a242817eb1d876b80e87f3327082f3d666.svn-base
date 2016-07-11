package cn.uuf.ltxxt.retire.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirefamily;
import cn.uuf.domain.Retirement;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.retire.service.RetirefamilyService;
import cn.uuf.util.CleanStringUtil;
import cn.uuf.util.Paginate;

/**
 * 家庭成员
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-22
 */
@Controller
@RequestMapping("{retmember:retmember;*.?}")
public class RetmemberController extends BaseController{

	private final String LIST_ACTION = "redirect:/retmember";
	@Resource
	private RetirefamilyService familyService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retirefamily f){
		ModelAndView mav = new ModelAndView();
		try{
			int s = (page -1)*size;
			Long count = familyService.getCount(f);
			List<Retirefamily> list = familyService.queryList(f, s, size);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("ret",f);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	@RequestMapping(value="{save:save;*.?}",method=RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request,String sfzh,@Valid Retirefamily f,BindingResult res,RedirectAttributes red){
		try{
			if(sfzh != null){
				Retirement m = mentService.getById(sfzh);
				f.setRet(m);
				familyService.save((Retirefamily) CleanStringUtil.CleanObj(m, new Retirefamily()));
				m.addFamily(f);
				mentService.update(m);
				red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
				this.writer(this.getCurrentUser().getRealname()+"添加【" +f.getRet().getXm()+ "】的家庭成员",request.getRemoteAddr(),this.getCurrentUser().getUsername());
			}else{
				red.addFlashAttribute(Constants.MESSAGE_NAME,"退休人员未选择，请选择再添加");
			}
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
}

