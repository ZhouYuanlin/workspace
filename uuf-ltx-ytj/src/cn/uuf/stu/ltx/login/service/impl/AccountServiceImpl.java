package cn.uuf.stu.ltx.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.uuf.domain.Account;
import cn.uuf.stu.framework.service.impl.BaseServiceImpl;
import cn.uuf.stu.ltx.login.dao.IAccountDao;
import cn.uuf.stu.ltx.login.service.IAccountService;

@Service(value="accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account, Long> implements IAccountService{

	@Resource(name="accountDao")
	public void setBaseDao(IAccountDao baseDao) {
		super.setBaseDao(baseDao);
	}
	
	
}
