package cn.uuf.ltxxt.login.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.Role;
import cn.uuf.domain.User;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.permission.service.UserService;

/**
 * 统计语句
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-30
 */
public class TjUtil {
	@Resource
	protected UserService userService;

	public Map<String,String> map = new LinkedHashMap<String,String>();
	public TjUtil(Long dwbId){
		
		if(dwbId!=null){
			//是否孤寡
			String ggss = "select sfgg,count(*) from uf_ltx_info where dwb_id="+dwbId+" and sfsc='否' group by sfgg";
			map.put("性别;#ff7f50;#87cefa;#da70d6","select  xb ,COUNT(*) from uf_ltx_info a, uf_code_option b where dwb_id="+dwbId+" and b.type='lxb' and a.lxb_id=b.id and b.name is not null and a.sfsc='否' GROUP BY XB");
			map.put("类型;#32cd32;#6495ed;#ff69b4","select b.name, count(*)  rs from uf_ltx_info a, uf_code_option b where b.type='lxb' and a.dwb_id="+dwbId+" and a.sfsc='否' and a.lxb_id=b.id group by b.name");
			map.put("年龄;#ba55d3;#cd5c5c;#ffa500;#40e0d0;#1e90ff",ggss);
			map.put("职级;#ff6347;#7b68ee;#00fa9a;#ffa500;#ffd700","select name,rs from (select c.name as name, count(*) rs,c.code from uf_ltx_info a, uf_code_option b, uf_code_option c ,uf_code_option d where a.dwb_id="+dwbId+" and b.type = 'zjb' and a.zjb_id = b.id and b.zid = c.id and a.sfsc='否' and d.type='lxb' and a.lxb_id=d.id and d.name is not null group by c.name,c.code) order by code asc");
			map.put("是否失能;#6b8e23;#ff00ff;#3cb371","select sssn,count(*) from uf_ltx_info a, uf_code_option b where dwb_id="+dwbId+" AND b.type='lxb' and a.sfsc='否' and a.lxb_id=b.id and b.name is not NULL group by sssn");
			map.put("是否保健干部;#b8860b;#30e0e0;#ff69b4","select sfbjgb,count(*) from uf_ltx_info a, uf_code_option b where dwb_id="+dwbId+" and b.type='lxb' and a.sfsc='否' and a.lxb_id=b.id and b.name is not NULL group by sfbjgb");
		}else{
			map.put("性别;#ff7f50;#87cefa;#da70d6","select  xb ,COUNT(*) from uf_ltx_info a, uf_code_option b where b.type='lxb' and a.lxb_id=b.id and b.name is not null and a.sfsc='否' GROUP BY XB");
			map.put("类型;#32cd32;#6495ed;#ff69b4","select b.name, count(*)  rs from uf_ltx_info a, uf_code_option b where b.type='lxb' and a.lxb_id=b.id and a.sfsc='否' group by b.name");
			map.put("年龄;#ba55d3;#cd5c5c;#ffa500;#40e0d0;#1e90ff",this.ggs);
			map.put("职级;#ff6347;#7b68ee;#00fa9a;#ffa500;#ffd700","select name,rs from (select c.name as name, count(*) rs,c.code from uf_ltx_info a, uf_code_option b, uf_code_option c ,uf_code_option d where b.type = 'zjb' and a.zjb_id = b.id and b.zid = c.id and a.sfsc='否' and d.type='lxb' and a.lxb_id=d.id and d.name is not null group by c.name,c.code) order by code asc");
			map.put("是否失能;#6b8e23;#ff00ff;#3cb371","select sssn,count(*) from uf_ltx_info a, uf_code_option b where  b.type='lxb' and a.sfsc='否' and a.lxb_id=b.id and b.name is not NULL group by sssn");
			map.put("是否保健干部;#b8860b;#30e0e0;#ff69b4","select sfbjgb,count(*) from uf_ltx_info a, uf_code_option b where  b.type='lxb' and a.sfsc='否' and a.lxb_id=b.id and b.name is not NULL group by sfbjgb");
		}
	}
	
	//性别
	public String xbs = "select xb,count(*) from uf_ltx_info group by xb";
	//类型
	public String lxs = "select b.name, count(*)  rs from uf_ltx_info a, uf_code_option b where b.type='lxb' and a.lxb_id=b.id group by b.name";
	//是否独居
	public String djs = "select sfdj,count(*) from uf_ltx_info group by sfdj";
	//是否孤寡
	public String ggs = "select sfgg,count(*) from uf_ltx_info group by sfgg";
	
	//是否失能
	public String sns = "select sssn,count(*) from uf_ltx_info group by sssn";
	//年龄段统计60以下，60-69，70-79，80-89，90以上
	public static String ages = "select sum(one),sum(two),sum(three),sum(four),sum(five) from (select sfzh, case when nl between 0 and 59 then 1 else"+
          " 0 end one, case when nl between 60 and 69 then 1 else 0 end two, case when nl between 70 and 79 then 1 else 0 end three,"+
       		"case when nl between 80 and 89 then 1 else  0 end four, case when nl >= 90 then 1 else 0 end five from (select sfzh,to_number(to_char(sysdate, 'yyyy')) - to_number(substr(csrq, 1, 4)) nl from uf_ltx_info a ,uf_code_option b where a.sfsc='否' and b.type='lxb' and a.lxb_id=b.id and b.name is  not null))";
	
	
	/**
	 * 取得当前登录用户
	 * @return
	 */
	public Account getCurrentUser(){
		Subject subject = SecurityUtils.getSubject();
		return (Account)subject.getPrincipal();
	}
	
	public User getUser(){
		Account account = getCurrentUser();
		return userService.getById(account.getUsername());
	}
	/**
	 * 取得当前用户拥有的角色可访问的用户信息
	 * @return
	 */
	public String hasRoleScope(){
		Account account = getCurrentUser();
		try{
			if(account != null){
				List<Role> r = account.getRoles();
				return r.get(0).getScope();
			}
		}catch(Exception e){
			return null;
		}
		return null;
	}
}

