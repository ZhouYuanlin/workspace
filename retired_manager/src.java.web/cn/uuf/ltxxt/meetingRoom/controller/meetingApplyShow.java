package cn.uuf.ltxxt.meetingRoom.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.meetingRoom.service.MeetingApplyService;
import cn.uuf.ltxxt.meetingRoom.service.MeetingApplyShow;
import cn.uuf.ltxxt.meetingRoom.service.MeetingRoomService;
import cn.uuf.util.Paginate;
@Controller
@RequestMapping("{meetingApplyShow:meetingApplyShow;*.?}")
public class meetingApplyShow extends BaseController{
	/**
	 * 会议室图形化界面
	 */
    private final String LIST_ACTION = "redirect:/meetingApplyShow";
	
	@Resource 
	private MeetingApplyService meetingApplyService;
	
	@Resource
	private MeetingRoomService meetingRoomService;
	
	@Autowired
	private MeetingApplyShow meetingApplyShow;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1") Integer page,MeetingApply m,MeetingRoom mr,String carNumber,String carDriver,String times,String onclickState){
		ModelAndView mav = new ModelAndView("meeting/meetingApply/index");
		try{
			if(carNumber!=null&&!"".equals(carNumber)){
				mr.setName(carNumber);
			}
			MeetingApply ms = new MeetingApply();
			List<Map<String,List<MeetingApply>>> ls=new ArrayList<Map<String,List<MeetingApply>>>();
			page = page == null || page < 0 ? 1 : page;
			int startnum =(page - 1) * size;
			List<MeetingApply> list = meetingApplyService.queryList(m, startnum, size);
			List<MeetingRoom> listroom = meetingRoomService.queryList(mr, startnum, size);//获取会议室列表
			String day="";
			String carTime="";
			String oneDay="";
			String twoDay="";
			String threeDay="";
			String fourDay="";
			String fiveDay="";
			String sixDay="";
			String sevenDay="";
			for(int i=0;i<listroom.size();i++){
				ms.setMeetingRoom(listroom.get(i));			
				
				List<MeetingApply> listapply = meetingApplyShow.queryList(ms, startnum, size ,times, onclickState);
				Map<String,List<MeetingApply>> map=new TreeMap<String, List<MeetingApply>>();
				List<MeetingApply> listOneDay= new ArrayList<MeetingApply>();
				List<MeetingApply> listTwoDay= new ArrayList<MeetingApply>();
				List<MeetingApply> listThrDay= new ArrayList<MeetingApply>();
				List<MeetingApply> listFourDay= new ArrayList<MeetingApply>();
				List<MeetingApply> listFiveDay= new ArrayList<MeetingApply>();
				List<MeetingApply> listSixDay= new ArrayList<MeetingApply>();
				List<MeetingApply> listSevDay= new ArrayList<MeetingApply>();
				List<MeetingApply> listDay= new ArrayList<MeetingApply>();
				
				MeetingApply cp8=new MeetingApply();
				cp8.setMeetingRoom(listroom.get(i));
				MeetingApply cp1=new MeetingApply();
				cp1.setMeetingRoom(listroom.get(i));
				MeetingApply cp2=new MeetingApply();
				cp2.setMeetingRoom(listroom.get(i));
				MeetingApply cp3=new MeetingApply();
				cp3.setMeetingRoom(listroom.get(i));
				MeetingApply cp4=new MeetingApply();
				cp4.setMeetingRoom(listroom.get(i));
				MeetingApply cp5=new MeetingApply();
				cp5.setMeetingRoom(listroom.get(i));
				MeetingApply cp6=new MeetingApply();
				cp6.setMeetingRoom(listroom.get(i));
				MeetingApply cp7=new MeetingApply();
				cp7.setMeetingRoom(listroom.get(i));
				
				if(times!=null){
					if(times.equals("1")){
						Calendar cal = Calendar.getInstance();
						SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");   
						cal.setTime(sd.parse(onclickState));  
						//n为推迟的周数，0本周，-1向前推迟一周，1下周，依次类推
						int n = Integer.parseInt("1");
						cal.add(Calendar.DATE, n*7);
						//想周几，这里就传几Calendar.MONDAY（TUESDAY...）
						cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY); 
						carTime = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
				        Calendar cd = Calendar.getInstance();   
				        cd.setTime(sdf.parse(carTime));   
				        oneDay=sdf.format(cd.getTime());   
				        cd.add(Calendar.DATE, +1); //增加一天   
				        twoDay=sdf.format(cd.getTime());  
				        cd.add(Calendar.DATE, +1);
				        threeDay=sdf.format(cd.getTime());  
				        cd.add(Calendar.DATE, +1);
				        fourDay=sdf.format(cd.getTime());  
				        cd.add(Calendar.DATE, +1);
				        fiveDay=sdf.format(cd.getTime());  
				        cd.add(Calendar.DATE, +1);
				        sixDay=sdf.format(cd.getTime());  
				        cd.add(Calendar.DATE, +1);
				        sevenDay=sdf.format(cd.getTime()); 
					}else if(times.equals("-1")){
						Calendar cal = Calendar.getInstance();
						SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");   
						cal.setTime(sd.parse(onclickState)); 
						//n为推迟的周数，0本周，-1向前推迟一周，1下周，依次类推
						int n = Integer.parseInt("-1");
						cal.add(Calendar.DATE, n*7);
						//想周几，这里就传几Calendar.MONDAY（TUESDAY...）
						cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY); 
						carTime = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
				        Calendar cd = Calendar.getInstance();   
				        cd.setTime(sdf.parse(carTime));   
				        oneDay=sdf.format(cd.getTime());   
				        cd.add(Calendar.DATE, +1);//增加一天   
				        twoDay=sdf.format(cd.getTime());  
				        cd.add(Calendar.DATE, +1);
				        threeDay=sdf.format(cd.getTime());  
				        cd.add(Calendar.DATE, +1);
				        fourDay=sdf.format(cd.getTime());  
				        cd.add(Calendar.DATE, +1);
				        fiveDay=sdf.format(cd.getTime());  
				        cd.add(Calendar.DATE, +1);
				        sixDay=sdf.format(cd.getTime());  
				        cd.add(Calendar.DATE, +1);
				        sevenDay=sdf.format(cd.getTime()); 
					}else{
						 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式  
						 Calendar cal = Calendar.getInstance(); 
						 cal.setTime(new Date());
						 //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
						 int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
						 if(1 == dayWeek) {  
							 cal.add(Calendar.DAY_OF_MONTH, -1);  
						 }
						 cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
						 int nowday = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
						 cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-nowday);//根据日历的规则，给当前日期减去星期几 与一个星期第一天的差值 
						 String imptimeBegin = sdf.format(cal.getTime());
						 cal.add(Calendar.DATE, 6);  
						 oneDay = imptimeBegin;
						 cal.setTime(sdf.parse(imptimeBegin));
						 cal.add(Calendar.DATE, +1);//增加一天   
					     twoDay=sdf.format(cal.getTime());  
					     cal.add(Calendar.DATE, +1);
					     threeDay=sdf.format(cal.getTime());  
					     cal.add(Calendar.DATE, +1);
					     fourDay=sdf.format(cal.getTime());  
					     cal.add(Calendar.DATE, +1);
					     fiveDay=sdf.format(cal.getTime());  
					     cal.add(Calendar.DATE, +1);
					     sixDay=sdf.format(cal.getTime());  
					     cal.add(Calendar.DATE, +1);
					     sevenDay=sdf.format(cal.getTime()); 
					}
				}else{
					 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式  
					 Calendar cal = Calendar.getInstance(); 
					 cal.setTime(new Date());
					 //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
					 int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
					 if(1 == dayWeek) {  
						 cal.add(Calendar.DAY_OF_MONTH, -1);  
					 }
					 cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
					 int nowday = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
					 cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-nowday);//根据日历的规则，给当前日期减去星期几 与一个星期第一天的差值 
					 String imptimeBegin = sdf.format(cal.getTime());
					 cal.add(Calendar.DATE, 6);  
					 oneDay = imptimeBegin;
					 cal.setTime(sdf.parse(imptimeBegin));
					 cal.add(Calendar.DATE, +1);//增加一天   
				     twoDay=sdf.format(cal.getTime());  
				     cal.add(Calendar.DATE, +1);
				     threeDay=sdf.format(cal.getTime());  
				     cal.add(Calendar.DATE, +1);
				     fourDay=sdf.format(cal.getTime());  
				     cal.add(Calendar.DATE, +1);
				     fiveDay=sdf.format(cal.getTime());  
				     cal.add(Calendar.DATE, +1);
				     sixDay=sdf.format(cal.getTime());  
				     cal.add(Calendar.DATE, +1);
				     sevenDay=sdf.format(cal.getTime()); 
				}
				
				listDay.add(cp8);
				map.put("day0", listOneDay);
				cp1.setUseTime(oneDay);
				listOneDay.add(cp1);
				map.put("day1", listOneDay);
				cp2.setUseTime(twoDay);
				listTwoDay.add(cp2);
				map.put("day2", listTwoDay);
				cp3.setUseTime(threeDay);
				listThrDay.add(cp3);
				map.put("day3", listThrDay);
				cp4.setUseTime(fourDay);
				listFourDay.add(cp4);
				map.put("day4", listFourDay);
				cp5.setUseTime(fiveDay);
				listFiveDay.add(cp5);
				map.put("day5", listFiveDay);
				cp6.setUseTime(sixDay);
				listSixDay.add(cp6);
				map.put("day6", listSixDay);
				cp7.setUseTime(sevenDay);
				listSevDay.add(cp7);
				map.put("day7", listSevDay);
				
				List<MeetingApply> listCarDay= new ArrayList<MeetingApply>();
				List<MeetingApply> listCarDay2= new ArrayList<MeetingApply>();
				List<MeetingApply> listCarDay3= new ArrayList<MeetingApply>();
				List<MeetingApply> listCarDay4= new ArrayList<MeetingApply>();
				List<MeetingApply> listCarDay5= new ArrayList<MeetingApply>();
				List<MeetingApply> listCarDay6= new ArrayList<MeetingApply>();
				List<MeetingApply> listCarDay7= new ArrayList<MeetingApply>();
				
				for(int l=0;l<listapply.size();l++){
					day=String.valueOf(meetingApplyShow.dayforwork(listapply.get(l).getUseTime()));
					if(day.equals("1")){
						listCarDay.add(listapply.get(l));
						map.put("day"+day,listCarDay);
					}else if(day.equals("2")){
						listCarDay2.add(listapply.get(l));
						map.put("day"+day,listCarDay2);
					}else if(day.equals("3")){
						listCarDay3.add(listapply.get(l));
						map.put("day"+day,listCarDay3);
					}else if(day.equals("4")){
						listCarDay4.add(listapply.get(l));
						map.put("day"+day,listCarDay4);
					}else if(day.equals("5")){
						listCarDay5.add(listapply.get(l));
						map.put("day"+day,listCarDay5);
					}else if(day.equals("6")){
						listCarDay6.add(listapply.get(l));
						map.put("day"+day,listCarDay6);
					}else{
						listCarDay7.add(listapply.get(l));
						map.put("day"+day,listCarDay7);
					}
				}
				ls.add(map);
			}
			if(onclickState==null){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				onclickState =df.format(new Date());
			}
			
			
			
			Long count = meetingApplyService.getCount(m);
			paginate = new Paginate(list,count,size,page);//获取页面page对象
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("ls", ls);
			mav.addObject("meeting", m);
			mav.addObject("carNumber", carNumber);
			mav.addObject("carDriver", carDriver);
			mav.addObject("state", times);
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
				meetingApplyService.update(mm);
				red.addFlashAttribute(Constants.MESSAGE_NAME,"审核成功");
			}catch(Exception e){
				e.printStackTrace();
				red.addFlashAttribute(Constants.MESSAGE_NAME,"审核失败");
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
		 
		 @RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
			public ModelAndView ajaxDetail(HttpServletResponse response,Long id,String useTime){
				ModelAndView mav = new ModelAndView("meeting/meetingApply/_work");
				//查询车辆信息下拉列表数据
				List<MeetingRoom> list = meetingRoomService.find();
				mav.addObject("carslist",list);
				if(!useTime.equals("12315")){
					 mav = new ModelAndView("meeting/meetingApply/_works");
					 List<MeetingRoom> list1 = meetingRoomService.find();
					 mav.addObject("carslist",list1);
					 MeetingRoom car =meetingRoomService.getById(id);
					 mav.addObject("r",car);
					 mav.addObject("useTime",useTime);
				}else{
					MeetingApply carp =meetingApplyService.getById(id);
					mav.addObject("r",carp);
				}
				return mav;
			}
}
