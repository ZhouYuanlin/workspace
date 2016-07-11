package cn.uuf.stu.ltx.grxx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.uuf.domain.Retirement;
import cn.uuf.stu.framework.service.impl.BaseServiceImpl;
import cn.uuf.stu.ltx.grxx.dao.IGrxxDao;
import cn.uuf.stu.ltx.grxx.service.IGrxxService;

@Service(value="grxxService")
public class GrxxServiceImpl extends BaseServiceImpl<Retirement, String> implements IGrxxService{
	
	@Resource(name="grxxDao")
	private IGrxxDao grxxDao;
	
	@Resource(name="grxxDao")
	public void setBaseDao(IGrxxDao baseDao) {
		super.setBaseDao(grxxDao);
	}
	
}
