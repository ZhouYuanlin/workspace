package cn.uuf.ltxxt.survey.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.party.service.RetirepartyService;
import cn.uuf.ltxxt.party.service.RetirepayService;

@Controller
@RequestMapping("{retirepay:retirepay;*.?}")
public class QuestiontenController extends BaseController{
	
	private final String LIST_ACTION = "redirect:/retirepay";
	@Resource
	private RetirepayService pService;
	@Resource
	private RetirepartyService ptService;
	
}
