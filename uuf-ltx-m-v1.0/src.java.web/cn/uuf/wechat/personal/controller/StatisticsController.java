package cn.uuf.wechat.personal.controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.uuf.wechat.common.controller.WxBaseController;
import cn.uuf.wechat.personal.service.IPersonalService;

@Controller
@RequestMapping(value="/wechat/statistics")
public class StatisticsController extends WxBaseController{
	@Resource(name="personalService")
	private IPersonalService personalService;
	/**
	 * 离退休人员统计分析
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(String openId, ModelMap model){
		try{
			getRetirementcount(model);
			getLtxInfo(model);
		}catch(Exception e){
			e.printStackTrace();
		}
			return "/wechat/statistics/index";
	}
	/**
	 * 获取离退休人员的统计信息
	 * @param mav
	 */
	private void getRetirementcount(ModelMap model){
		Map<String,List> typeMaps = new LinkedHashMap<String,List>();
		Map<String,List> ageMaps = new LinkedHashMap<String,List>();
		Map<String,List> sexMaps = new LinkedHashMap<String,List>();
		Map<String,List> postionMaps = new LinkedHashMap<String,List>();
		Map<String,List> ltxTotalMaps = new LinkedHashMap<String,List>();
		try{
			//年龄分布
		    String ages="select sum(one),sum(two),sum(three),sum(four),sum(five) from (select sfzh, case when nl between 0 and 59 then 1 else 0 end one, case when nl between 60 and 69 then 1 else 0 end two, case when nl between 70 and 79 then 1 else 0 end three,case when nl between 80 and 89 then 1 else  0 end four, case when nl >= 90 then 1 else 0 end five from (select sfzh,to_number(to_char(sysdate, 'yyyy')) - to_number(substr(csrq, 1, 4)) nl from uf_ltx_info a ,uf_code_option b where a.sfsc='否' and b.type='lxb' and a.lxb_id=b.id and b.name is  not null))";
			List list = personalService.queryBySql(ages);
			System.out.println(ages);
			String[] s = {"60以下","60-69","70-79","80-89","90以上"};
			List res = new ArrayList();
			for(int i = 0;i<list.size();i++){
				Object[] o = (Object[]) list.get(i);
				for(int j=0;j<5;j++){
					Object[] ob = new Object[2];
					ob[0] = s[j];
					ob[1] = o[j];
					res.add(ob);
				}
			}
	        //职级分布
			ageMaps.put("listAge",res);
		    String possql="select a.name,a.count1,b.count2,round((a.count1/b.count2),4)*100||'%' as 百分比 from(select count(*) count2 from uf_ltx_info a, uf_code_option b, uf_code_option c，uf_code_option d where b.type = 'zjb' and a.zjb_id = b.id and b.zid = c.id and a.sfsc='否' and d.type='lxb' and a.lxb_id=d.id and d.name is not null group by a.sfsc) b,(select c.name as name, count(*) count1,c.code from uf_ltx_info a, uf_code_option b, uf_code_option c，uf_code_option d where b.type = 'zjb' and a.zjb_id = b.id and b.zid = c.id and a.sfsc='否' and d.type='lxb' and a.lxb_id=d.id and d.name is not NULL group by c.name,c.code) a";
			postionMaps.put("listPosition",personalService.queryBySql(possql));
			//离退休人数总记录
			List  totalList=personalService.queryBySql("select b.name, count(*)  rs from uf_ltx_info a, uf_code_option b where b.type='lxb' and a.lxb_id=b.id and a.sfsc='否' and b.name is not null group by b.name");
			ltxTotalMaps.put("totalList", totalList);
			//性别记录
			List  sexList=personalService.queryBySql("select xb,count(*) from uf_ltx_info where sfsc='否' group by xb");
			model.put("typeMaps",typeMaps);
			model.put("ageMaps",ageMaps);
			model.put("sexMaps",sexMaps);
			model.put("postionMaps",postionMaps);
			model.put("totalList",totalList);
			model.put("sexList",sexList);
			model.put("ltxTotalMaps", ltxTotalMaps);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 得到离休，退休记录信息
	 * @param model
	 */
	public void getLtxInfo(ModelMap model){
		String sql="select  xb ,COUNT(*) from uf_ltx_info a, uf_code_option b where b.type='lxb' and a.lxb_id=b.id and b.name is not null and a.sfsc='否' GROUP BY XB";
		//离休情况
		String lxql="select sum(one),sum(two),sum(three),sum(four),sum(five) from (select sfzh, case when nl between 0 and 59 then 1 else 0 end one, case when nl between 60 and 69 then 1 else 0 end two, case when nl between 70 and 79 then 1 else 0 end three,case when nl between 80 and 89 then 1 else  0 end four, case when nl >= 90 then 1 else 0 end five from (select sfzh,to_number(to_char(sysdate, 'yyyy')) - to_number(substr(csrq, 1, 4)) nl from uf_ltx_info a ,uf_code_option b where a.sfsc='否' and b.type='lxb' and a.lxb_id=b.id and b.name='离休'))";
		//退休情况
		String txql="select sum(one),sum(two),sum(three),sum(four),sum(five) from (select sfzh, case when nl between 0 and 59 then 1 else 0 end one, case when nl between 60 and 69 then 1 else 0 end two, case when nl between 70 and 79 then 1 else 0 end three,case when nl between 80 and 89 then 1 else  0 end four, case when nl >= 90 then 1 else 0 end five from (select sfzh,to_number(to_char(sysdate, 'yyyy')) - to_number(substr(csrq, 1, 4)) nl from uf_ltx_info a ,uf_code_option b where a.sfsc='否' and b.type='lxb' and a.lxb_id=b.id and b.name='退休'))";
		Map<String,List> lxageMaps = new LinkedHashMap<String,List>();
		Map<String,List> txageMaps = new LinkedHashMap<String,List>();
		Map<String,List> lxpositionMaps = new LinkedHashMap<String,List>();
		Map<String,List> txpositionMaps = new LinkedHashMap<String,List>();
		Map<String,List> timepositionMaps = new LinkedHashMap<String,List>();
		Map<String,List> totalDeathMaps = new LinkedHashMap<String,List>();
		Map<String,List> lxDeathMaps = new LinkedHashMap<String,List>();
		Map<String,List> txDeathMaps = new LinkedHashMap<String,List>();
		Map<String,List> lxMaps = new LinkedHashMap<String,List>();
		Map<String,List> ltxMaps = new LinkedHashMap<String,List>();
		Map<String,List> ltxAgeMaps = new LinkedHashMap<String,List>();
		Map<String,List> lxAgeMaps = new LinkedHashMap<String,List>();
		Map<String,List> txAgeMaps = new LinkedHashMap<String,List>();
		Map<String,List> sexLtxMaps = new LinkedHashMap<String,List>();
		Map<String,List> sexLxMaps = new LinkedHashMap<String,List>();
		Map<String,List> sextxMaps = new LinkedHashMap<String,List>();
		try {
			//离退休下的性别性别人数
			List sexLtxList=personalService.queryBySql(sql);
			sexLtxMaps.put("sexLtxList", sexLtxList);
			//离休下的性别性别人数
			String lxsexsql="select  xb ,COUNT(*) from uf_ltx_info a, uf_code_option b where b.type='lxb' and a.lxb_id=b.id and b.name='离休'  and a.sfsc='否' GROUP BY XB";
			List sexLxList=personalService.queryBySql(lxsexsql);
			sexLxMaps.put("sexLxList", sexLxList);
			//退休下的性别性别人数
			String txsexsql="select  xb ,COUNT(*) from uf_ltx_info a, uf_code_option b where b.type='lxb' and a.lxb_id=b.id and b.name='退休'  and a.sfsc='否' GROUP BY XB";
			List sextxList=personalService.queryBySql(sql);
			sextxMaps.put("sextxList", sextxList);
			
			//离休情况下的年龄
			List lxageList=personalService.queryBySql(lxql);
			//退休情况下的年龄
			List txageList=personalService.queryBySql(txql);
			String[] s = {"60以下","60-69","70-79","80-89","90以上"};
			List res = new ArrayList();
			for(int i = 0;i<lxageList.size();i++){
				Object[] o = (Object[]) lxageList.get(i);
				for(int j=0;j<5;j++){
					Object[] ob = new Object[2];
					ob[0] = s[j];
					ob[1] = o[j];
					res.add(ob);
				}
			}
			List res1 = new ArrayList();
			for(int i = 0;i<txageList.size();i++){
				Object[] o = (Object[]) txageList.get(i);
				for(int j=0;j<5;j++){
					Object[] ob = new Object[2];
					ob[0] = s[j];
					ob[1] = o[j];
					res1.add(ob);
				}
			}
            //离休人员的职级记录
			String lxpSql="select a.name,a.count1,b.count2,round((a.count1/b.count2),4)*100||'%' as 百分比 from(select count(*) count2 from uf_ltx_info a, uf_code_option b, uf_code_option c，uf_code_option d where b.type = 'zjb' and a.zjb_id = b.id and b.zid = c.id and a.sfsc='否' and d.type='lxb' and a.lxb_id=d.id and d.name='离休' group by d.name) b,(select c.name as name, count(*) count1,c.code from uf_ltx_info a, uf_code_option b, uf_code_option c，uf_code_option d where b.type = 'zjb' and a.zjb_id = b.id and b.zid = c.id and a.sfsc='否' and d.type='lxb' and a.lxb_id=d.id and d.name='离休' group by c.name,c.code) a";
			List lxpList=personalService.queryBySql(lxpSql);
			System.out.println(lxpList);
			//退休人员的职级记录
			String txpSql="select a.name,a.count1,b.count2,round((a.count1/b.count2),4)*100||'%' as 百分比 from(select count(*) count2 from uf_ltx_info a, uf_code_option b, uf_code_option c，uf_code_option d where b.type = 'zjb' and a.zjb_id = b.id and b.zid = c.id and a.sfsc='否' and d.type='lxb' and a.lxb_id=d.id and d.name='退休' group by d.name) b,(select c.name as name, count(*) count1,c.code from uf_ltx_info a, uf_code_option b, uf_code_option c，uf_code_option d where b.type = 'zjb' and a.zjb_id = b.id and b.zid = c.id and a.sfsc='否' and d.type='lxb' and a.lxb_id=d.id and d.name='退休' group by c.name,c.code) a";
			List txpList=personalService.queryBySql(txpSql);
			lxageMaps.put("lxageList", res);
			txageMaps.put("txageList", res1);
			
			Format f = new SimpleDateFormat("yyyy");
	        Calendar c = Calendar.getInstance();
	        //当前年份：2016
	        String time1=f.format(c.getTime());
	        int t1=Integer.parseInt(time1);
			
			//离退休的离世分布
	        for(int i=t1;i>=1900 && i<=t1;i--){
	        	String lspdSql="select count(*) as num1 from uf_ltx_death a, uf_code_option b where b.type='lxb' and SUBSTR(lssj, 1, 4)="+"'"+i+"'"+" and a.lxb_id=b.id and b.name is not null group by SUBSTR(lssj, 1, 4) ORDER BY SUBSTR(lssj, 1, 4)";
	            List lspdList=personalService.queryBySql(lspdSql);
	            if(lspdList.size()!=0){
	            	String dSql="SELECT ASS.DUALDATE,NVL(aa2.NUM1, '0') FROM(select SUBSTR(lssj, 1, 4) as totalTime,count(*) as num1 from uf_ltx_death a, uf_code_option b where b.type='lxb' and a.lxb_id=b.id group by SUBSTR(lssj, 1, 4) ORDER BY SUBSTR(lssj, 1, 4))aa2 RIGHT JOIN(SELECT ASS1.dualDate FROM(SELECT TO_CHAR(TO_DATE("+"'"+(i-4)+"'"+", 'yyyy')+ ROWNUM - 1,'yyyy')dualDate FROM dual CONNECT BY ROWNUM < TO_DATE("+"'"+i+"'"+", 'yyyy')- TO_DATE("+"'"+(i-4)+"'"+", 'yyyy')+ 2)ass1 GROUP BY ASS1.dualDate)ass ON ASS.DUALDATE = AA2.TOTALTIME order by ASS.DUALDATE";
	    			List totalDeathList=personalService.queryBySql(dSql);
	    			totalDeathMaps.put("totalDeathList", totalDeathList);
	    			break;
	            }
	        }

			//离休的离世分布
	        for (int i=t1;i>=1900 && i<=t1;i--) {
				String lxlspdSql="select count(*) as num1 from uf_ltx_death a, uf_code_option b where b.type='lxb' and b.name='离休'  and SUBSTR(lssj, 1, 4)="+"'"+i+"'"+"and a.lxb_id=b.id group by SUBSTR(lssj, 1, 4) ORDER BY SUBSTR(lssj, 1, 4)";
				List lxlspdList=personalService.queryBySql(lxlspdSql);
				if(lxlspdList.size()!=0){
					String lxdSql="SELECT ASS.DUALDATE,NVL(aa2.NUM1, '0') FROM(select SUBSTR(lssj, 1, 4) as totalTime,count(*) as num1 from uf_ltx_death a, uf_code_option b where b.type='lxb' and a.lxb_id=b.id and b.name='离休' group by SUBSTR(lssj, 1, 4) ORDER BY SUBSTR(lssj, 1, 4))aa2 RIGHT JOIN(SELECT ASS1.dualDate FROM(SELECT TO_CHAR(TO_DATE("+"'"+(i-4)+"'"+", 'yyyy')+ ROWNUM - 1,'yyyy')dualDate FROM dual CONNECT BY ROWNUM < TO_DATE("+"'"+i+"'"+", 'yyyy')- TO_DATE("+"'"+(i-4)+"'"+", 'yyyy')+ 2)ass1 GROUP BY ASS1.dualDate)ass ON ASS.DUALDATE = AA2.TOTALTIME order by ASS.DUALDATE";
					List lxDeathList=personalService.queryBySql(lxdSql);
					lxDeathMaps.put("lxDeathList", lxDeathList);
					break;
				}
			}
			//退休的离世分布
	        for (int i=t1;i>=1900 && i<=t1;i--) {
	        	String txlspdSql="select count(*) as num1 from uf_ltx_death a, uf_code_option b where b.type='lxb' and b.name='退休'  and SUBSTR(lssj, 1, 4)="+"'"+i+"'"+" and a.lxb_id=b.id group by SUBSTR(lssj, 1, 4) ORDER BY SUBSTR(lssj, 1, 4)";
				List txlspdList=personalService.queryBySql(txlspdSql);
				if(txlspdList.size()!=0){
					String txdSql="SELECT ASS.DUALDATE,NVL(aa2.NUM1, '0') FROM(select SUBSTR(lssj, 1, 4) as totalTime,count(*) as num1 from uf_ltx_death a, uf_code_option b where b.type='lxb' and a.lxb_id=b.id and b.name='退休' group by SUBSTR(lssj, 1, 4) ORDER BY SUBSTR(lssj, 1, 4))aa2 RIGHT JOIN(SELECT ASS1.dualDate FROM(SELECT TO_CHAR(TO_DATE("+"'"+(i-4)+"'"+", 'yyyy')+ ROWNUM - 1,'yyyy')dualDate FROM dual CONNECT BY ROWNUM < TO_DATE("+"'"+i+"'"+", 'yyyy')- TO_DATE("+"'"+(i-4)+"'"+", 'yyyy')+ 2)ass1 GROUP BY ASS1.dualDate)ass ON ASS.DUALDATE = AA2.TOTALTIME order by ASS.DUALDATE";
					List txDeathList=personalService.queryBySql(txdSql);
					txDeathMaps.put("txDeathList", txDeathList);
					break;
				}
			}
			
	        //离退休总人数按时间分布
			for(int i=t1;i>=1900 && i<=t1;i--){
				String pdltxsql="SELECT COUNT(*)AS num FROM uf_ltx_info A,uf_code_option b WHERE b. TYPE = 'lxb' AND A .lxb_id = b. ID and b.name is not null AND A .sfsc = '否' AND SUBSTR(lxsj, 1, 4)="+"'"+i+"'"+" GROUP BY SUBSTR(lxsj, 1, 4) ORDER BY TO_DATE(SUBSTR(lxsj, 1, 4), 'yyyy')ASC";
				List ltxpdList=personalService.queryBySql(pdltxsql);
				if(ltxpdList.size()!=0){
					String totaltimeSql="SELECT ASS.DUALDATE,NVL(aa2.NUM, '0') FROM(SELECT SUBSTR(lxsj, 1, 4)AS timet,COUNT(*)AS num FROM uf_ltx_info A,uf_code_option b WHERE b. TYPE = 'lxb' AND A .lxb_id = b. ID AND A .sfsc = '否' AND SUBSTR(lxsj, 1, 4)IS NOT NULL  GROUP BY SUBSTR(lxsj, 1, 4) ORDER BY TO_DATE(SUBSTR(lxsj, 1, 4), 'yyyy')ASC )aa2 RIGHT JOIN(SELECT ASS1.dualDate FROM(SELECT TO_CHAR(TO_DATE("+"'"+(i-4)+"'"+", 'yyyy')+ ROWNUM - 1,'yyyy')dualDate FROM dual CONNECT BY ROWNUM < TO_DATE("+"'"+i+"'"+", 'yyyy')- TO_DATE("+"'"+(i-4)+"'"+", 'yyyy')+ 2)ass1 GROUP BY ASS1.dualDate)ass ON ASS.DUALDATE = AA2.TIMET order by ASS.DUALDATE";
					List totalList=personalService.queryBySql(totaltimeSql);
					ltxMaps.put("totalList", totalList);
					break;
				}
				
			}
			//退休按退休时间分布
			for (int i=t1;i>=1900 && i<=t1;i--) {
				String pdSql="SELECT SUBSTR(lxsj, 1, 4)AS timet,COUNT(*)AS num FROM uf_ltx_info A,uf_code_option b WHERE b. TYPE = 'lxb' AND A .lxb_id = b. ID AND A .sfsc = '否' AND SUBSTR(lxsj, 1, 4)="+"'"+i+"'"+" and b. NAME = '退休' GROUP BY SUBSTR(lxsj, 1, 4) ORDER BY TO_DATE(SUBSTR(lxsj, 1, 4), 'yyyy')ASC ";
				List txpdList=personalService.queryBySql(pdSql);
				if(txageList.size()!=0){
					String txtimeSql="SELECT ASS.DUALDATE,NVL(aa2.NUM, '0') FROM(SELECT SUBSTR(lxsj, 1, 4)AS timet,COUNT(*)AS num FROM uf_ltx_info A,uf_code_option b WHERE b. TYPE = 'lxb' AND A .lxb_id = b. ID AND A .sfsc = '否' AND SUBSTR(lxsj, 1, 4)IS NOT NULL AND b. NAME = '退休' GROUP BY SUBSTR(lxsj, 1, 4) ORDER BY TO_DATE(SUBSTR(lxsj, 1, 4), 'yyyy')ASC )aa2 RIGHT JOIN(SELECT ASS1.dualDate FROM(SELECT TO_CHAR(TO_DATE("+"'"+(i-4)+"'"+", 'yyyy')+ ROWNUM - 1,'yyyy')dualDate FROM dual CONNECT BY ROWNUM < TO_DATE("+"'"+i+"'"+", 'yyyy')- TO_DATE("+"'"+(i-4)+"'"+", 'yyyy')+ 2)ass1 GROUP BY ASS1.dualDate)ass ON ASS.DUALDATE = AA2.TIMET order by ASS.DUALDATE";
					List txtimeList=personalService.queryBySql(txtimeSql);
					timepositionMaps.put("txtimeList", txtimeList);
					break;
				}
			}
			//离休按退休时间分布
			for (int i=t1;i>=1900 && i<=t1;i--) {
				String ffql="SELECT COUNT(*)AS num FROM uf_ltx_info A,uf_code_option b WHERE b. TYPE = 'lxb' AND A .lxb_id = b. ID AND A .sfsc = '否' AND SUBSTR(lxsj, 1, 4)="+"'"+i+"'"+" AND b. NAME = '离休' GROUP BY SUBSTR(lxsj, 1, 4) ORDER BY TO_DATE(SUBSTR(lxsj, 1, 4), 'yyyy')ASC";
				List fllist=personalService.queryBySql(ffql);
				if(fllist.size()!=0){
					String lxtimeSql="SELECT ASS.DUALDATE,NVL(aa2.NUM, '0') FROM(SELECT SUBSTR(lxsj, 1, 4)AS timet,COUNT(*)AS num FROM uf_ltx_info A,uf_code_option b WHERE b. TYPE = 'lxb' AND A .lxb_id = b. ID AND A .sfsc = '否' AND SUBSTR(lxsj, 1, 4)IS NOT NULL AND b. NAME = '离休' GROUP BY SUBSTR(lxsj, 1, 4) ORDER BY TO_DATE(SUBSTR(lxsj, 1, 4), 'yyyy')ASC )aa2 RIGHT JOIN(SELECT ASS1.dualDate FROM(SELECT TO_CHAR(TO_DATE("+"'"+(i-4)+"'"+", 'yyyy')+ ROWNUM - 1,'yyyy')dualDate FROM dual CONNECT BY ROWNUM < TO_DATE("+"'"+(i)+"'"+", 'yyyy')- TO_DATE("+"'"+(i-4)+"'"+", 'yyyy')+ 2)ass1 GROUP BY ASS1.dualDate)ass ON ASS.DUALDATE = AA2.TIMET order by ASS.DUALDATE";
					List lxtimeList=personalService.queryBySql(lxtimeSql);
					lxMaps.put("lxtimeList", lxtimeList);
					break;
				}
			}
			//离退休总人数的平均年龄，最大年龄，最小年龄	
			String ltxAgeSql="select min(to_number(to_char(sysdate, 'yyyy')) - to_number(substr(csrq, 1, 4))) minCount,avg(to_number(to_char(sysdate, 'yyyy')) - to_number(substr(csrq, 1, 4))) avgCount,max(to_number(to_char(sysdate, 'yyyy')) - to_number(substr(csrq, 1, 4))) maxCount  from uf_ltx_info a ,uf_code_option b where a.sfsc='否' and b.type='lxb' and a.lxb_id=b.id and b.name is  not null group by a.SFSC";
			List ltxAgeList=personalService.queryBySql(ltxAgeSql);
			String[] s1 = {"最大值","平均值","最小值"};
			List  ltx= new ArrayList();
			for(int i = 0;i<ltxAgeList.size();i++){
				Object[] o = (Object[]) ltxAgeList.get(i);
				for(int j=0;j<3;j++){
					Object[] ob = new Object[2];
					ob[0] = s1[j];
					ob[1] = o[j];
					ltx.add(ob);
				}
			}
			ltxAgeMaps.put("ltxAgeList", ltx);
			//离休人数的平均年龄，最大年龄，最小值年龄
			String lxAgeSql="select min(to_number(to_char(sysdate, 'yyyy')) - to_number(substr(csrq, 1, 4))) minCount,avg(to_number(to_char(sysdate, 'yyyy')) - to_number(substr(csrq, 1, 4))) avgCount,max(to_number(to_char(sysdate, 'yyyy')) - to_number(substr(csrq, 1, 4))) maxCount  from uf_ltx_info a ,uf_code_option b where a.sfsc='否' and b.type='lxb' and a.lxb_id=b.id and b.name='离休' group by  b.name";
			List lxAgeList=personalService.queryBySql(lxAgeSql);
			List  lx= new ArrayList();
			for(int i = 0;i<lxAgeList.size();i++){
				Object[] o = (Object[]) lxAgeList.get(i);
				for(int j=0;j<3;j++){
					Object[] ob = new Object[2];
					ob[0] = s1[j];
					ob[1] = o[j];
					lx.add(ob);
				}
			}
			lxAgeMaps.put("lxAgeList", lx);
			//退休人数的平均年龄，最大年龄，最小值年龄
			String txAgeSql="select min(to_number(to_char(sysdate, 'yyyy')) - to_number(substr(csrq, 1, 4))) minCount,avg(to_number(to_char(sysdate, 'yyyy')) - to_number(substr(csrq, 1, 4))) avgCount,max(to_number(to_char(sysdate, 'yyyy')) - to_number(substr(csrq, 1, 4))) maxCount  from uf_ltx_info a ,uf_code_option b where a.sfsc='否' and b.type='lxb' and a.lxb_id=b.id and b.name='退休' group by  b.name";
			List txAgeList=personalService.queryBySql(txAgeSql);
			List  tx= new ArrayList();
			for(int i = 0;i<txAgeList.size();i++){
				Object[] o = (Object[]) txAgeList.get(i);
				for(int j=0;j<3;j++){
					Object[] ob = new Object[2];
					ob[0] = s1[j];
					ob[1] = o[j];
					tx.add(ob);
				}
			}
			txAgeMaps.put("txAgeList", tx);
			
			lxpositionMaps.put("lxpList", lxpList);
			txpositionMaps.put("txpList", txpList);
			model.put("sexLxList",sexLxList);
			model.put("lxageMaps",lxageMaps);
			model.put("txageMaps",txageMaps);
			model.put("lxpositionMaps",lxpositionMaps);
			model.put("txpositionMaps",txpositionMaps);
			model.put("timepositionMaps",timepositionMaps);
			model.put("lxMaps",lxMaps);
			model.put("totalDeathMaps",totalDeathMaps);
			model.put("lxDeathMaps",lxDeathMaps);
			model.put("txDeathMaps",txDeathMaps);
			model.put("ltxMaps",ltxMaps);
			model.put("ltxAgeMaps",ltxAgeMaps);
			model.put("lxAgeMaps",lxAgeMaps);
			model.put("txAgeMaps",txAgeMaps);
			model.put("sexLtxMaps",sexLtxMaps);
			model.put("sexLxMaps",sexLxMaps);
			model.put("sextxMaps",sextxMaps);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}