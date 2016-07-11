package cn.uuf.wechat.connect.dao.impl;

import org.springframework.stereotype.Repository;

import cn.uuf.domain.Account;
import cn.uuf.stu.framework.dao.impl.BaseDaoImpl;
import cn.uuf.wechat.connect.dao.ILtxAccountDao;

@Repository(value="ltxaccountDao")
public class LtxAccountDaoImpl extends BaseDaoImpl<Account, Long> implements ILtxAccountDao{

}
