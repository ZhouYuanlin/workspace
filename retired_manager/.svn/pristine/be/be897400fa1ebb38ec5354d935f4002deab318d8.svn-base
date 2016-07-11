package cn.uuf.ltxxt.meetingRoom.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.meetingroom.MeetingApply;
import cn.uuf.domain.meetingroom.MeetingRoom;
import cn.uuf.ltxxt.meetingRoom.service.MeetingApplyService;
import cn.uuf.ltxxt.meetingRoom.service.MeetingRoomService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.Paginate;
@Controller
@RequestMapping("{meetingApply:meetingApply;*.?}")
public class meetingApplyController extends BaseController{
	/**
	 * 会议室申请
	 */
    private final String LIST_ACTION = "redirect:/meetingApply";
	
	@Resource 
	private MeetingApplyService meetingApplyService;
	
	@Resource
	private MeetingRoomService meetingRoomService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1") Integer page,MeetingApply m){
		ModelAndView mav = new ModelAndView("meeting/meetingApply/list");
		try{
			page = page == null || page < 0 ? 1 : page;
			int startnum =(page - 1) * size;
			List<MeetingApply> list = meetingApplyService.queryList(m, startnum, size);
			Long count = meetingApplyService.getCount(m);
			paginate = new Paginate(list,count,size,page);//获取页面page对象
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("meeting", m);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
		}
		return mav;
	}

	@RequestMapping("{create:create;*.?}")
    public ModelAndView create(){
		 ModelAndView mav = new ModelAndView("meeting/meetingApply/create");
			List<MeetingRoom> list = meetingRoomService.find();
			mav.addObject("roomlist",list);
			getCodeInf(mav);
			return mav;
    }
	@RequestMapping("{save:save;*.?}")
	 public ModelAndView save(HttpServletRequest request, @Valid MeetingApply m, BindingResult result,RedirectAttributes redAttr) {
			try{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String time =df.format(new Date());
			m.setAddTime(time);
			Long applicaantId=this.getCurrentUser().getId();
			String applicaantName=this.getCurrentUser().getRealname();
			m.setApplicantId(applicaantId);
			m.setApplicantName(applicaantName);
			m.setStatus(0);//0表示待审核
			meetingApplyService.save(m);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
	       }catch(Exception e){
				e.printStackTrace();
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
			}
			return new ModelAndView(LIST_ACTION);
		}
	
		@RequestMapping("/{id}/audit")
		public ModelAndView audit(@PathVariable Long id){
			ModelAndView mav = new ModelAndView("meeting/meetingApply/audit");
			try{
				List<MeetingRoom> list = meetingRoomService.find();
				mav.addObject("roomlist",list);
				mav.addObject("meeting",meetingApplyService.getById(id));
			}catch(Exception e){
			}
				return mav;
		}
			
		@RequestMapping(value="/auditSuccess")
		public ModelAndView auditSuccess(HttpServletRequest request,@Valid MeetingApply mm,BindingResult res,RedirectAttributes red){
			try{
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
				String time =df.format(new Date());
				mm.setApplyTime(time);
				MeetingApply mApply=meetingApplyService.getById(mm.getId());
				mm.setAddTime(mApply.getAddTime());
				mm.setUseTime(mApply.getUseTime());
				mm.setApplicantId(mApply.getApplicantId());
				mm.setApplicantName(mApply.getApplicantName());
				meetingApplyService.update(mm);
				red.addFlashAttribute(Constants.MESSAGE_NAME,"审核成功");
			}catch(Exception e){
				e.printStackTrace();
				red.addFlashAttribute(Constants.MESSAGE_NAME,"审核失败");
			}
				return new ModelAndView(LIST_ACTION);
			}
		@RequestMapping("/{id}/edit")
		public ModelAndView edit(@PathVariable Long id){
			ModelAndView mav = new ModelAndView("meeting/meetingApply/update");
			try{
				List<MeetingRoom> list = meetingRoomService.find();
				mav.addObject("roomlist",list);
				mav.addObject("meeting",meetingApplyService.getById(id));
			}catch(Exception e){
			}
				return mav;
		}
			
		@RequestMapping(value="/update")
		public ModelAndView update(HttpServletRequest request,@Valid MeetingApply mm,BindingResult res,RedirectAttributes red){
			try{
				MeetingApply mApply=meetingApplyService.getById(mm.getId());
				mm.setApplicantId(mApply.getApplicantId());
				mm.setApplicantName(mApply.getApplicantName());
				mm.setAddTime(mApply.getAddTime());
				mm.setUseTime(mApply.getUseTime());
				mm.setStatus(mApply.getStatus());
				mm.setOpinion(mApply.getOpinion());
				mm.setApplyTime(mApply.getApplyTime());
				meetingApplyService.update(mm);
				red.addFlashAttribute(Constants.MESSAGE_NAME,"修改成功");
			}catch(Exception e){
				e.printStackTrace();
				red.addFlashAttribute(Constants.MESSAGE_NAME,"修改失败");
			}
				return new ModelAndView(LIST_ACTION);
			}
		 @RequestMapping("/delete")
		 public ModelAndView delete(HttpServletRequest request,RedirectAttributes redAttr,Long... id){
				try{
				    meetingApplyService.delete(id);
					redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
				}catch(Exception e){
					e.printStackTrace();
					redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
				}
				return new ModelAndView(LIST_ACTION);
			}

}
