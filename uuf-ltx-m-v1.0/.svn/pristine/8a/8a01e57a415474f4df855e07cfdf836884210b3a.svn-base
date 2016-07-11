package cn.uuf.wechat.personal.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.uuf.domain.ret.Retireparty;
import cn.uuf.stu.framework.service.impl.BaseServiceImpl;
import cn.uuf.wechat.personal.dao.IPartyDao;
import cn.uuf.wechat.personal.service.IPartyService;

@Service(value="partyService")
public class PartyServiceImpl extends BaseServiceImpl<Retireparty, Long> implements IPartyService {

	@Resource(name="partyDao")
	private IPartyDao partyDao;
	
	@Resource(name="partyDao")
	private void setBaseDao(IPartyDao baseDao) {
		super.setBaseDao(partyDao);
	}

	
}
