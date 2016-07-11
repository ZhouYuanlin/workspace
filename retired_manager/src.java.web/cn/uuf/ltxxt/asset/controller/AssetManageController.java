package cn.uuf.ltxxt.asset.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.CodeAsset;
import cn.uuf.domain.CodeAssetSource;
import cn.uuf.domain.CodeDwb;
import cn.uuf.domain.asset.AssetFushu;
import cn.uuf.domain.asset.AssetManage;
import cn.uuf.domain.asset.AssetRecord;
import cn.uuf.ltxxt.asset.service.AssetFushuService;
import cn.uuf.ltxxt.asset.service.AssetManageService;
import cn.uuf.ltxxt.asset.service.AssetRecordService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.AddSQLQuery;
import cn.uuf.util.DateUtil;
import cn.uuf.util.Paginate;

/**
 * 资产管理
 * @author zkxp
 *
 */
@Controller
@RequestMapping("{assetManage:assetManage;*.?}")
public class AssetManageController extends BaseController{
	private final String LIST_ACTION = "redirect:/assetManage";
	@Resource
	private AssetManageService assetManageService;
	@Resource
	private AssetFushuService assetFushuService;
	@Resource
	private AssetRecordService assetRecordService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1") Integer page,AssetManage am){
		ModelAndView mav = new ModelAndView("asset/assetManage/index");
		int s = (page - 1) * size;
		Long count = assetManageService.getCount(am);
		List<AssetManage> list = assetManageService.queryList(am, s, size);
		paginate = new Paginate(list, count, size, page);
		mav.addObject("paginate", paginate);
		mav.addObject("list", list);
		mav.addObject("asset",am);
		getCodeInf(mav);
		return mav;
	}
	 /**
     * 查看资产详情
     * @param id
     * @param redirectAttributes
     * @return
     */
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView detail(Long id,RedirectAttributes redirectAttributes){
		ModelAndView mav = new ModelAndView("asset/assetManage/detail");
		try{
			AssetManage am = assetManageService.getById(id);
			AssetFushu ams = new AssetFushu();
			ams.setAssetManage(am);
			List<AssetFushu> list=assetFushuService.findByCriteria(ams);
			mav.addObject("list", list);
		}catch(Exception e){
			e.printStackTrace();
			redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME,"未查询到资产信息");
			return new ModelAndView(LIST_ACTION);
		}
		return mav;
	}
	/**
	 * 增加
	 * @return
	 */
	@RequestMapping(value="{create:create;*.?}")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("asset/assetManage/create");
		this.getCodeInf(mav);
		if(hasRoleScope().equals(Constants.INFOYX)){
			List<CodeDwb> list = new ArrayList<CodeDwb>();
			list.add(getUser().getCodedwb());
			mav.addObject("dwblist",list);
		}
		Date date=new Date();
		String purchaseDate=DateUtil.getDatesTime(date, "yyyy-MM-dd");
		AssetManage as=new AssetManage();
		as.setPurchaseDate(purchaseDate);
		mav.addObject("asset",as);
		return mav;
	}

	@RequestMapping(value="{save:save;*.?}",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, @Valid AssetManage am, BindingResult result,RedirectAttributes redAttr) {
		try{
			
			if(am.getCa().getId()==null){
				am.setCa(null);
			}
			if(am.getCodeAs().getId()==null){
				am.setCodeAs(null);
			}
			assetManageService.save(am);
			//资产编号为：年月日+当日批次+四位流水号
			Date date=new Date();
			String currentDate=DateUtil.getDatesTime(date, "yyyy-MM-dd");
			am.setRegisterDate(currentDate);			
			String sql="select * from uf_ltx_asset where REGISTERDATE="+"'"+currentDate+"'";
			List list=assetManageService.queryBySql(sql);
			String s = DateUtil.getDatesTime(date, "yyyyMMdd");
			String assetId="";
			long aNum=am.getaNum();
				if(list.size()==0){
					for (int j = 1; j < (aNum+1);j++) {
						AssetFushu aff=new AssetFushu();
						String  pc=assetManageService.fmtLong(Long.valueOf(1),2);
						String lsh=assetManageService.fmtLong(Long.valueOf(j),4);
						assetId=s+pc+lsh;
						aff.setAssetId(assetId);
						aff.setUseState(0);
						aff.setAssetManage(am);
						assetFushuService.save(aff);
					}
				}else{
					for (int j = 1; j < (aNum+1);j++) {
						AssetFushu aff=new AssetFushu();
				    	String  pc=assetManageService.fmtLong(Long.valueOf(list.size()+1),2);
						String lsh=assetManageService.fmtLong(Long.valueOf(j),4);
						assetId=s+pc+lsh;
						aff.setAssetId(assetId);
						aff.setUseState(0);
						aff.setAssetManage(am);
						assetFushuService.save(aff);
					}
				}
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	/**
	 * 删除资产
	 * @param request
	 * @param redAttr
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	 public ModelAndView delete(HttpServletRequest request,RedirectAttributes redAttr,Long... id){
			try{
			    //删除记录表
				for (Long s:id) {
					AssetManage as=assetManageService.getById(s);
					AssetFushu aa=new AssetFushu();
					aa.setAssetManage(as);
					List<AssetFushu> affList=assetFushuService.findByCriteria(aa);
					for (int i = 0; i < affList.size(); i++) {
						AssetFushu afu=affList.get(i);
						Long fid=afu.getId();
						AssetRecord ar=new AssetRecord();
						ar.setFushu(afu);
						List<AssetRecord> recordList=assetRecordService.findByCriteria(ar);
						for (int j = 0; j < recordList.size(); j++) {
							AssetRecord record1=recordList.get(j);
							Long rid=record1.getId();
							assetRecordService.delete(rid);
						}
						assetFushuService.delete(fid);
					}
				}
			    assetManageService.delete(id);
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
			}catch(Exception e){
				e.printStackTrace();
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
			}
			return new ModelAndView(LIST_ACTION);
		}
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	 @RequestMapping("/{id}/edit")
		public ModelAndView modify(@PathVariable Long id){
			ModelAndView mav = new ModelAndView("asset/assetManage/update");
			try{
				mav.addObject("asset",assetManageService.getById(id));
				this.getCodeInf(mav);
			}catch(Exception e){
			}
			return mav;
		}
	 
	 @RequestMapping("{update:update;*.?}")
	 @Transactional(rollbackFor=Exception.class)
		public ModelAndView update(HttpServletRequest request,@Valid AssetManage am,BindingResult res,RedirectAttributes red){
			try{
				if(am.getCa().getId()==null){
					am.setCa(null);
				}
				if(am.getCodeAs().getId()==null){
					am.setCodeAs(null);
				}
				long acount=am.getaNum();//修改后的数量
				List<AssetManage> list=assetManageService.findByCriteria(am);
				if(list.size()>0){
					long aNum1=0;//修改前的数量
					for (int i = 0; i < list.size(); i++) {
						AssetManage asset=list.get(i);
						aNum1=asset.getaNum();
					}
					//若修改后数量等于修改前的数量
					if(aNum1==acount){
						am.setSfsc(Constants.HASNO);
						assetManageService.update(am);
					}
					//若修改后的数量大于修改前的数量
					if(acount>aNum1){
						AssetFushu fu=new AssetFushu();
						fu.setAssetManage(am);
						List<AssetFushu> afuList=assetFushuService.findByCriteria(fu);
						AssetFushu as=afuList.get(afuList.size()-1);
						String asId=as.getAssetId();
						long aid=Long.parseLong(asId);
						for (int i = 0; i < (acount-aNum1); i++) {
							fu.setAssetId(String.valueOf(++aid));
							fu.setAssetManage(am);
							fu.setUseState(0);
							assetFushuService.save(fu);
						}
						am.setSfsc(Constants.HASNO);
						assetManageService.update(am);
					}
					//若修改后的数量小于修改前的数量
					if(acount<aNum1){
						AssetFushu fu=new AssetFushu();
						fu.setAssetManage(am);
						List<AssetFushu> assetSublist=assetFushuService.findByCriteria(fu);
						for (int i = 0; i < (aNum1-acount); i++) {
							AssetFushu af=assetSublist.get(i);
							long fid=af.getId();
							assetFushuService.delete(fid);
						}
						am.setSfsc(Constants.HASNO);
						assetManageService.update(am);
					}
				}else{
					am.setSfsc(Constants.HASNO);
					assetManageService.update(am);
				}
				
				red.addFlashAttribute(Constants.MESSAGE_NAME,"修改成功");
			}catch(Exception e){
				red.addFlashAttribute(Constants.MESSAGE_NAME,"修改失败");
			}
			return new ModelAndView(LIST_ACTION);
		} 

}
