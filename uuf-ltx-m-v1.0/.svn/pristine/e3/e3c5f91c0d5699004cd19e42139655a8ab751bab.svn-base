package cn.uuf.wechat.personal.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeDwb;
import cn.uuf.stu.framework.service.impl.BaseServiceImpl;
import cn.uuf.wechat.personal.dao.ICodeDwbDao;
import cn.uuf.wechat.personal.service.ICodeDwbService;

@Service(value="dwbService")
public class CodeDwbServiceImpl extends BaseServiceImpl<CodeDwb, Long> implements ICodeDwbService {
	
	@Resource(name="dwbDao")
	private ICodeDwbDao dwbDao;
	
	@Resource(name="dwbDao")
	public void setBaseDao(ICodeDwbDao baseDao) {
		super.setBaseDao(dwbDao);
	}
}
