package cn.uuf.stu.framework.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Service;


import cn.uuf.stu.entity.framework.WAccount;
import cn.uuf.stu.entity.framework.WRole;
import cn.uuf.stu.framework.common.HiParameter;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.dao.IAccountDao;
import cn.uuf.stu.framework.service.IAccountService;
import cn.uuf.stu.framework.shiro.Principal;



/**
* 账号  service
* @ClassName: AccountServiceImpl 
* @author tangpeng
* @date 2015年8月4日 下午3:04:48 
*
*/
@Service(value="accountService")
public class AccountServiceImpl extends BaseServiceImpl<WAccount, Long> implements IAccountService {
	
	@Resource(name="accountDao")
	private IAccountDao accountDao;
	
	@Resource(name="accountDao")
	public void setBaseDao(IAccountDao baseDao) {
		super.setBaseDao(baseDao);
	}
	
	

	@Override
	public String getCurrentUsername() {
		Subject subject = SecurityUtils.getSubject();
		if(subject!=null){
			Principal principal = (Principal) subject.getPrincipal();
			if(principal!=null){
				return principal.getUsername();
			}
		}
		return null;
	}

	@Override
	public Page<WAccount> getList(WAccount account, Pageable pageable,WRole role) {
		StringBuffer sb = new StringBuffer();
		sb.append(" from WAccount as a left join a.roles as s where 1=1 ");
		List<HiParameter> params = new ArrayList<HiParameter>();
		if(account!=null&&StringUtils.isNotEmpty(account.getUsername())){
			sb.append(" and a.username=:username");
			params.add(new HiParameter("username", account.getUsername(), org.hibernate.type.StringType.INSTANCE));
		}
		if(account!=null&&StringUtils.isNotEmpty(account.getXm())){
			sb.append(" and a.xm=:xm");
			params.add(new HiParameter("xm", "%"+account.getXm()+"%", StringType.INSTANCE));
		}
		if(role!=null&&role.getId()!=null){
			sb.append(" and s.id=:id");
			params.add(new HiParameter("id", role.getId(),LongType.INSTANCE));
		}
		
		pageable.setParams(params);
		pageable.setQueryCountStr("select count(*) "+sb.toString());
		pageable.setQueryListStr("select a "+sb.toString() );
		return accountDao.getHqlPage(pageable);
	}

	
	
}
