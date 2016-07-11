package cn.uuf.ltxxt.survey.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.survey.Questionten;
import cn.uuf.domain.survey.Survey;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.survey.service.Questiontenservice;
import cn.uuf.ltxxt.survey.service.SurveyService;
import cn.uuf.util.Paginate;

/**
 * 问卷管理
 * 
 * @author home
 *
 */
@Controller
@RequestMapping("{pollQuestionnaire:pollQuestionnaire;*.?}")
public class SurveyController extends BaseController {

	private final String LIST_ACTION = "redirect:/pollQuestionnaire";

	@Resource
	private SurveyService surveyService;

	@Resource
	private Questiontenservice questiontenservice;

	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue = "1") Integer page, Survey s) {
		ModelAndView mav = new ModelAndView("pollQuestionnaire/survey/index");
		try {
			// 获取分页list
			page = page == null || page < 0 ? 1 : page;
			int startnum = (page - 1) * size;
			List<Survey> list = surveyService.queryList(s, startnum, size);
			Long count = surveyService.getCount(s);
			paginate = new Paginate(list, count, size, page);// 获取页面page对象
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("w", s);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
		}
		return mav;
	}

	/**
	 * 查看问卷详情
	 * 
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView detail(Long id, RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("pollQuestionnaire/survey/detail");
		try {
			// 获取试卷信息
			mav.addObject("r", surveyService.getById(id));
			mav.addObject("q", questiontenservice.getById(id));
			/*
			 * // Survey survey =new Survey(); Questionten questionten =new
			 * Questionten(); survey.setId(id); questionten.setSurvey(survey);
			 * List<Questionten> list =surveyService.queryBySid(questionten);
			 * 
			 * mav.addObject("peo",list); if(list.size()==0){
			 * mav.addObject("nums","0"); }else{
			 * mav.addObject("nums",list.size()); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME, "未查询到活动信息");
			return new ModelAndView(LIST_ACTION);
		}
		return mav;
	}

	/**
	 * 执行新增试卷页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/create")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("pollQuestionnaire/survey/nomination");

		return mav;
	}

	/**
	 * 保存试卷名称、填写人到关联表中
	 */
	@RequestMapping(value = "{save:save;*.?}", method = RequestMethod.POST)
	public ModelAndView savenomination(HttpServletRequest request, @Valid Survey survey, BindingResult result,
			RedirectAttributes redAttr) {
		try {
			SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			survey.setFbrq(matter1.format(new Date()));
			System.out.println("状态==="+survey.getStatus());
			surveyService.save(survey);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加失败");
		}
		ModelAndView mav = new ModelAndView("pollQuestionnaire/survey/create");
		return mav;
	}

	/**
	 * 新增一套试卷，需要把题存到题库表里， 同时需要把题名存到问卷表里的
	 * 
	 * @return
	 */
	@RequestMapping(value = "{creat:creat;*.?}", method = RequestMethod.POST)
	public ModelAndView creat() {

		
		return new ModelAndView(LIST_ACTION);

	}

	// 修改问卷信息页面加载
	@RequestMapping(value="/{id}/edit")
	public ModelAndView edit(@PathVariable Long id, RedirectAttributes red) {
		System.out.println("竟来了");
		ModelAndView mav = new ModelAndView("pollQuestionnaire/survey/edit");
		try {
			Object[] obj = null;
			List<Survey> list = new ArrayList<Survey>();
			// Survey survey;
			Questionten questionten = new Questionten();
			// String sql = "SELECT * from uuf_ltx_survey where ID=" +
			// survey.getId();
			String sql2 = "SELECT * from UUF_LTX_SURVEY_QUESTIONTEN where CUID=" + questionten.getSurvey().getId();
			// List surveyList = surveyService.queryBySql(sql);
			List questiontenList = questiontenservice.queryBySql(sql2);
			for (int i = 0; i < questiontenList.size(); i++) {
				obj = (Object[]) questiontenList.get(i);
				String aid = obj[0].toString();
				Long ll = Long.valueOf(aid);
				Survey sur = surveyService.getById(ll);
				list.add(sur);
			}
			mav.addObject("survey", list);
			mav.addObject("s", surveyService.getById(id));
			red.addFlashAttribute(Constants.MESSAGE_NAME, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME, "添加失败");
		}
		return mav;
	}
	/**
	 * 保存修改的问卷内容
	 * @param request
	 * @param survey
	 * @param questionten
	 * @param res
	 * @param red
	 * @return
	 */
	@RequestMapping(value = "/update")
	public ModelAndView update(HttpServletRequest request, @Valid Survey survey, @Valid Questionten questionten,
			BindingResult res, RedirectAttributes red) {

		ModelAndView mav = new ModelAndView("asset/assetManage/update");
		try {
			SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			survey.setFbrq(matter1.format(new Date()));
			surveyService.update(survey);
			questiontenservice.update(questionten);
			red.addFlashAttribute(Constants.MESSAGE_NAME, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME, "添加失败");
		}

		return new ModelAndView(LIST_ACTION);

	}

}
