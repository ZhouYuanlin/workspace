package cn.uuf.ltxxt.car.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.car.Carapply;
import cn.uuf.domain.car.Carinfo;
import cn.uuf.ltxxt.car.service.CarApplyService;
import cn.uuf.ltxxt.car.service.CarApplyShowService;
import cn.uuf.ltxxt.car.service.CarInfoService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.Paginate;

/**
 * 车辆使用管理
 * @author fc
 * @version 1.0
 * @date 2016-5-12 11:34:22
 */
@Controller
@RequestMapping("{carApplyShow:carApplyShow;*.?}")
public class CarApplyShowAction extends BaseController{
	
	private final String LIST_ACTION = "redirect:/carApplyShow";
	
	@Autowired
	private CarApplyService carService;
	
	@Autowired
	private CarInfoService carInfoService;
	
	@Autowired
	private CarApplyShowService carApplyShowService;
	
	@SuppressWarnings("null")
	@RequestMapping
	public ModelAndView index(Integer page,Carapply cp,Carinfo ci,String carNumber,String carDriver,String times,String onclickState){
		ModelAndView mav = new ModelAndView("car/carshow/index");
		try{
			//获取车辆申请信息分页list
			page = page == null || page < 0 ? 1 : page;
			int startnum =(page - 1) * size;
			if(carNumber!=null&&!"".equals(carNumber)){
				ci.setCarNumber(carNumber);
			}
			if(carDriver!=null&&!"".equals(carDriver)){
				ci.setCarDriver(carDriver);
			}
			List<Carinfo> listcar = carInfoService.queryList(ci, startnum, size);
			List<Carapply> list = carApplyShowService.queryList(cp, startnum, size,times,onclickState);
			Carapply cps = new Carapply();
			String day="";
			String carTime="";
			String oneDay="";
			String twoDay="";
			String threeDay="";
			String fourDay="";
			String fiveDay="";
			String sixDay="";
			String sevenDay="";
			List<Map<String,List<Carapply>>> ls=new ArrayList<Map<String,List<Carapply>>>();
			for(int i=0;i<listcar.size();i++){
				cps.setCarinfo(listcar.get(i));
				List<Carapply> lists = carApplyShowService.queryList(cps, startnum, size,times,onclickState);
				Map<String,List<Carapply>> map=new TreeMap<String, List<Carapply>>();
				List<Carapply> listOneDay= new ArrayList<Carapply>();
				List<Carapply> listTwoDay= new ArrayList<Carapply>();
				List<Carapply> listThrDay= new ArrayList<Carapply>();
				List<Carapply> listFourDay= new ArrayList<Carapply>();
				List<Carapply> listFiveDay= new ArrayList<Carapply>();
				List<Carapply> listSixDay= new ArrayList<Carapply>();
				List<Carapply> listSevDay= new ArrayList<Carapply>();
				List<Carapply> listDay= new ArrayList<Carapply>();
			
				Carapply cp8=new Carapply();
				cp8.setCarinfo(listcar.get(i));
				Carapply cp1=new Carapply();
				cp1.setCarinfo(listcar.get(i));
				Carapply cp2=new Carapply();
				cp2.setCarinfo(listcar.get(i));
				Carapply cp3=new Carapply();
				cp3.setCarinfo(listcar.get(i));
				Carapply cp4=new Carapply();
				cp4.setCarinfo(listcar.get(i));
				Carapply cp5=new Carapply();
				cp5.setCarinfo(listcar.get(i));
				Carapply cp6=new Carapply();
				cp6.setCarinfo(listcar.get(i));
				Carapply cp7=new Carapply();
				cp7.setCarinfo(listcar.get(i));
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
				List<Carapply> listCarDay= new ArrayList<Carapply>();
				List<Carapply> listCarDay2= new ArrayList<Carapply>();
				List<Carapply> listCarDay3= new ArrayList<Carapply>();
				List<Carapply> listCarDay4= new ArrayList<Carapply>();
				List<Carapply> listCarDay5= new ArrayList<Carapply>();
				List<Carapply> listCarDay6= new ArrayList<Carapply>();
				List<Carapply> listCarDay7= new ArrayList<Carapply>();
				for(int l=0;l<lists.size();l++){
						day=String.valueOf(carService.dayforwork(lists.get(l).getUseTime()));
						if(day.equals("1")){
							listCarDay.add(lists.get(l));
							map.put("day"+day,listCarDay);
						}else if(day.equals("2")){
							listCarDay2.add(lists.get(l));
							map.put("day"+day,listCarDay2);
						}else if(day.equals("3")){
							listCarDay3.add(lists.get(l));
							map.put("day"+day,listCarDay3);
						}else if(day.equals("4")){
							listCarDay4.add(lists.get(l));
							map.put("day"+day,listCarDay4);
						}else if(day.equals("5")){
							listCarDay5.add(lists.get(l));
							map.put("day"+day,listCarDay5);
						}else if(day.equals("6")){
							listCarDay6.add(lists.get(l));
							map.put("day"+day,listCarDay6);
						}else{
							listCarDay7.add(lists.get(l));
							map.put("day"+day,listCarDay7);
						}
				}
				ls.add(map);
			}
			if(onclickState==null){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				onclickState =df.format(new Date());
			}
			//获取车辆申请信息总数量
			Long count = carApplyShowService.getCount(cp,times,onclickState);
			paginate = new Paginate(list,count,size,page);//获取页面page对象
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("ls", ls);
			mav.addObject("cp", cp);
			mav.addObject("carNumber", carNumber);
			mav.addObject("carDriver", carDriver);
			mav.addObject("state", times);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
		}
		return mav;
	}
	
	
	//车辆sava方法
	@RequestMapping(value="/save")
	public ModelAndView save(HttpServletRequest request,String sfzh,@Valid Carapply ci,BindingResult res,RedirectAttributes red){
		//添加车辆信息
		try{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String time =df.format(new Date());
			ci.setAddTime(time);
			ci.setApplyId(this.getCurrentUser().getId());
			ci.setApplyName(this.getCurrentUser().getRealname());
			ci.setState("待审核");
			carService.save(ci);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	//审核车辆信息保存
	@RequestMapping(value="/applyState")
	public ModelAndView applyState(HttpServletRequest request,@Valid Carapply ci,BindingResult res,RedirectAttributes red){
		try{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String time =df.format(new Date());
			Carapply carp=carService.getById(ci.getId());
			ci.setApplyId(carp.getApplyId());
			ci.setAddTime(carp.getAddTime());
			ci.setUseTime(carp.getUseTime());
			ci.setApplyName(carp.getApplyName());
			ci.setApplyTime(time);
			carService.update(ci);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"审核成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"审核失败");
		}
			return new ModelAndView(LIST_ACTION);
		}
	
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxDetail(HttpServletResponse response,Long id,String useTime){
		ModelAndView mav = new ModelAndView("car/carshow/_work");
		//查询车辆信息下拉列表数据
		List<Carinfo> list = carInfoService.find();
		mav.addObject("carslist",list);
		if(!useTime.equals("12315")){
			 mav = new ModelAndView("car/carshow/_works");
			 List<Carinfo> list1 = carInfoService.find();
			 mav.addObject("carslist",list1);
			 Carinfo car =carInfoService.getById(id);
			 mav.addObject("r",car);
			 mav.addObject("useTime",useTime);
		}else{
			Carapply carp =carService.getById(id);
			mav.addObject("r",carp);
		}
		return mav;
	}
}

