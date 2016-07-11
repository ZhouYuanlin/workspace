package cn.uuf.wechat.connect.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.type.StringType;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Account;
import cn.uuf.stu.framework.common.HiParameter;
import cn.uuf.stu.framework.service.impl.BaseServiceImpl;
import cn.uuf.wechat.connect.dao.ILtxAccountDao;
import cn.uuf.wechat.connect.service.ILtxAccountService;

@Service
public class LtxAccountServiceImpl extends BaseServiceImpl<Account, Long> implements ILtxAccountService{
	
	@Resource(name="ltxaccountDao")
	private ILtxAccountDao accountDao;
	
	@Resource(name="ltxaccountDao")
	private void setBaseDao(ILtxAccountDao baseDao) {
		super.setBaseDao(accountDao);
	}

	@Override
	public List<Account> getAccount(Account account) {
		StringBuffer sb = new StringBuffer();
		sb.append("select a from Account a where a.username=:yhm or a.lxdh=:lxdh or a.gzzh=:gzzh");
		List<HiParameter> list = new ArrayList<HiParameter>();
		list.add(new HiParameter("yhm", account.getUsername(), StringType.INSTANCE));
		list.add(new HiParameter("lxdh", account.getUsername(), StringType.INSTANCE));
		list.add(new HiParameter("gzzh", account.getUsername(), StringType.INSTANCE));
		List<Account> hqlList = accountDao.getHqlList(sb.toString(), list);
		return hqlList;
	}

	
	
}
