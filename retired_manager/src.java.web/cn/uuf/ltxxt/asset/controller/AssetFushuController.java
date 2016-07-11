package cn.uuf.ltxxt.asset.controller;
import java.util.Date;
import java.util.List;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.asset.AssetFushu;
import cn.uuf.domain.asset.AssetManage;
import cn.uuf.domain.asset.AssetRecord;
import cn.uuf.domain.record.Retrecord;
import cn.uuf.ltxxt.asset.service.AssetFushuService;
import cn.uuf.ltxxt.asset.service.AssetManageService;
import cn.uuf.ltxxt.asset.service.AssetRecordService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.record.service.RetrecordService;
import cn.uuf.util.DateUtil;
import cn.uuf.util.Paginate;

/**
 * 资产附属表管理
 * @author zkxp
 *
 */
@Controller
@RequestMapping("{assetSub:assetSub;*.?}")
public class AssetFushuController extends BaseController{
	private final String LIST_ACTION = "redirect:/assetSub";
	@Resource
	private AssetFushuService assetFushuService;
	@Resource
	private AssetRecordService assetRecordService;
	@Resource
	private RetrecordService retrecordService;
	@Resource
	private AssetManageService assetManageService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1") Integer page,AssetFushu af){
		ModelAndView mav = new ModelAndView("asset/assetSub/index");
		int s = (page - 1) * size;
		Long count = assetFushuService.getCount(af);
		List<AssetFushu> list = assetFushuService.queryList(af, s, size);
		paginate = new Paginate(list, count, size, page);
		mav.addObject("paginate", paginate);
		mav.addObject("list", list);
		mav.addObject("asset",af);
		getCodeInf(mav);
		return mav;
	}
	/**
	 * 领用登记
	 * @return
	 */
	@RequestMapping("/{id}/use")
	 @Transactional(rollbackFor=Exception.class)
	public ModelAndView use(@PathVariable Long id,RedirectAttributes red) {
		ModelAndView mav = new ModelAndView("asset/assetSub/use");
			List<Retrecord> recordList=retrecordService.find();
			AssetFushu af=assetFushuService.getById(id);
			String usePerson=af.getUsePerson();
			int useState=af.getUseState();
			if(useState==1){
				red.addFlashAttribute(Constants.MESSAGE_NAME,"该资产已被"+"<span style='color:red'>"+usePerson+"</span>"+"领用！");
				return new ModelAndView(LIST_ACTION);
			}
			    Date date=new Date();
			    String useDate=DateUtil.getDatesTime(date, "yyyy-MM-dd");
			    af.setUseDate(useDate);
				mav.addObject("assetSub",af);
				mav.addObject("recordList",recordList);
				return mav;
	}
	 @RequestMapping("{useSuccess:useSuccess;*.?}")
	 @Transactional(rollbackFor=Exception.class)
		public ModelAndView update(HttpServletRequest request,@Valid AssetFushu am,BindingResult res,RedirectAttributes red){
			try{
				AssetRecord record=new AssetRecord();
				Long id=am.getId();
				String userTime=am.getUseDate();
				String user=am.getUsePerson();
				//得到当前时间
				Date date=new Date();
				//登记时间
				String registerDate=DateUtil.getDatesTime(date, "yyyy-MM-dd");
				//登记人
				String registerName=this.getCurrentUser().getRealname();
				//修改资产附属表
				AssetFushu afu=assetFushuService.getById(id);
				afu.setUseDate(userTime);
				afu.setUsePerson(user);
				afu.setUseState(1);
			    assetFushuService.update(afu);
			  //修改资产记录表
				record.setRegister(registerName);
				record.setRegisterDate(registerDate);
				record.setReturnState(0);
				record.setUsePerson(user);
				record.setUseDate(userTime);
				record.setFushu(afu);
				assetRecordService.save(record);
				red.addFlashAttribute(Constants.MESSAGE_NAME,"领用登记成功");
			}catch(Exception e){
				red.addFlashAttribute(Constants.MESSAGE_NAME,"领用登记失败");
			}
			return new ModelAndView(LIST_ACTION);
		} 
	   /**
		 * 归还登记
		 * @return
		 */
		@RequestMapping("/{id}/return")
		 @Transactional(rollbackFor=Exception.class)
		public ModelAndView sendBack(@PathVariable Long id,RedirectAttributes red) {
			ModelAndView mav = new ModelAndView("asset/assetSub/return");
			AssetFushu af=assetFushuService.getById(id);
		    int useState=af.getUseState();
			if(useState==0){
			    red.addFlashAttribute(Constants.MESSAGE_NAME,"该资产没有人领用！");
				return new ModelAndView(LIST_ACTION);
			}
			Date date=new Date();
			String returnDate=DateUtil.getDatesTime(date, "yyyy-MM-dd");
			af.setReturnTime(returnDate);
			mav.addObject("assetSub",af);
			return mav;
		}
		 @RequestMapping("{returnSuccess:returnSuccess;*.?}")
		 @Transactional(rollbackFor=Exception.class)
			public ModelAndView returnSuccess(HttpServletRequest request,@Valid AssetFushu am,BindingResult res,RedirectAttributes red){
				try{
					String returnTime=am.getReturnTime();
					long id=am.getId();
					AssetFushu fu=assetFushuService.getById(id);
					//得到当前时间
					Date date=new Date();
					//归还登记时间
					String registerDate=DateUtil.getDatesTime(date, "yyyy-MM-dd");
					//归还登记人
					String registerName=this.getCurrentUser().getRealname();
					AssetRecord re=new AssetRecord();
					re.setFushu(am);
					List<AssetRecord> recordList=assetRecordService.findByCriteria(re);
					if(recordList.size()>0){
						for (int i = 0; i < recordList.size(); i++) {
							AssetRecord record=recordList.get(i);
							record.setReturnRegister(registerName);
							record.setReturnRegisterTime(registerDate);
							record.setReturnTime(returnTime);
							record.setReturnState(1);
							record.setFushu(fu);
							assetRecordService.update(record);
						}
					}
					fu.setUseDate(null);
					fu.setUsePerson(null);
					fu.setUseState(0);
					assetFushuService.update(fu);
					red.addFlashAttribute(Constants.MESSAGE_NAME,"归还登记成功");
				}catch(Exception e){
					red.addFlashAttribute(Constants.MESSAGE_NAME,"归还登记失败");
				}
				return new ModelAndView(LIST_ACTION);
			} 
		    /**
			 * 根据资产编号
			 * @param query
			 * @return
			 */
			@RequestMapping(value = "autoCompleteAsset", method = RequestMethod.POST)
			public @ResponseBody Object[] getAllAsset(@RequestParam String query) {
				Object[] obj = null;
				Object[] autoComplete = null;
				try {
					StringBuffer strBuf=new StringBuffer();
					strBuf.append("select t.fushu.assetId ,t.fushu.assetManage.name,t.usePerson,t.returnTime from AssetRecord t where 1=1 ");
					strBuf.append("and  ( t.fushu.assetId like '"+query+"%') ");//and rownum <9 ")
					List data =  assetRecordService.queryByHql(strBuf.toString());
					autoComplete = new Object[data.size()];
					for(int i = 0 ;i < data.size(); i++){
						obj = (Object[]) data.get(i);
						if(obj[3]==null){
							autoComplete[i] = obj[0]+"-"+obj[1]+"-"+obj[2]+"<span style='color:red'>(正在使用！)</span>";
						}else{
							autoComplete[i] = obj[0]+"-"+obj[1]+"-"+obj[2]+"<span style='color:blue'>(曾经使用！)</span>";
						}
					}
					return autoComplete;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
}
