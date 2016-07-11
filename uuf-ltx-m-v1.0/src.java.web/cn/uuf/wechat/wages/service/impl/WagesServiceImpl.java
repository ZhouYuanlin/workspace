package cn.uuf.wechat.wages.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.type.StringType;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retirewages;
import cn.uuf.stu.framework.common.HiParameter;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.service.impl.BaseServiceImpl;
import cn.uuf.wechat.wages.dao.IWagesDao;
import cn.uuf.wechat.wages.service.IWagesService;

@Service(value="wagesService")
public class WagesServiceImpl extends BaseServiceImpl<Retirewages, Long> implements IWagesService{
	
	@Resource(name="wagesDao")
	private IWagesDao wagesDao;
	
	@Resource(name="wagesDao")
	public void setBaseDao(IWagesDao baseDao) {
		super.setBaseDao(wagesDao);
	}
	
	/**
	 * 查询所有
	 */
	@Override
	public List<Retirewages> getAll() {
		return wagesDao.getAll();
	}

	@Override
	public Page<Retirewages> queryList(Retirewages wages, Pageable pageable) {
		StringBuffer sb = new StringBuffer();
		sb.append(" from Retirewages a where 1=1");
		List<HiParameter> parameters = new ArrayList<HiParameter>();
		if(wages!=null){
			if(wages.getSfzh()!=null && wages.getSfzh().length()>0){
				sb.append(" and a.sfzh=:sfzh");
				parameters.add(new HiParameter("sfzh", wages.getSfzh(), StringType.INSTANCE));
			}
		}
		sb.append(" order by yf desc");
		pageable.setParams(parameters);
		pageable.setQueryListStr("select a"+sb.toString());
		pageable.setQueryCountStr("select count(*) "+sb.toString());
		Page<Retirewages> page = wagesDao.getHqlPage(pageable);
		return page;
	}
}
