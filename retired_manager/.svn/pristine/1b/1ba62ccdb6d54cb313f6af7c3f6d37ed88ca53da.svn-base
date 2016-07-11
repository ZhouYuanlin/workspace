package cn.uuf.ltxxt.asset.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
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
import cn.uuf.ltxxt.asset.service.AssetRecordService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.Paginate;

/**
 * 资产领用归还记录
 * @author zkxp
 *
 */
@Controller
@RequestMapping("{assetRecord:assetRecord;*.?}")
public class AssetRecordController extends BaseController{
	private final String LIST_ACTION = "redirect:/assetRecord";
	@Resource
	private AssetRecordService assetRecordService;
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1") Integer page,AssetRecord ar){
		ModelAndView mav = new ModelAndView("asset/assetRecord/index");
		int s = (page - 1) * size;
		Long count = assetRecordService.getCount(ar);
		List<AssetRecord> list = assetRecordService.queryList(ar, s, size);
		paginate = new Paginate(list, count, size, page);
		mav.addObject("paginate", paginate);
		mav.addObject("list", list);
		mav.addObject("asset",ar);
		getCodeInf(mav);
		return mav;
	}
	 /**
     * 查看资产记录详情
     * @param id
     * @param redirectAttributes
     * @return
     */
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView detail(Long fid,RedirectAttributes redirectAttributes){
		ModelAndView mav = new ModelAndView("asset/assetRecord/detail");
		try{
			AssetFushu fu=assetFushuService.getById(fid);
			AssetRecord record = new AssetRecord();
			record.setFushu(fu);
			List<AssetRecord> list=assetRecordService.findByFushuId(record);
			mav.addObject("list", list);
			mav.addObject("fushu", fu);
		}catch(Exception e){
			e.printStackTrace();
			redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME,"未查询到资产记录信息");
			return new ModelAndView(LIST_ACTION);
		}
		return mav;
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
