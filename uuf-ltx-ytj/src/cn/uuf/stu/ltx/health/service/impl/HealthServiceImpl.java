package cn.uuf.stu.ltx.health.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.type.StringType;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retirement;
import cn.uuf.domain.health.Rethealth;
import cn.uuf.stu.framework.common.HiParameter;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.service.impl.BaseServiceImpl;
import cn.uuf.stu.ltx.health.dao.IHealthDao;
import cn.uuf.stu.ltx.health.service.IHealthService;

@Service(value="healthService")
public class HealthServiceImpl extends BaseServiceImpl<Rethealth, Long> implements IHealthService{
	
	@Resource(name="healthDao")
	private IHealthDao healthDao;
	
	@Resource(name="healthDao")
	public void setBaseDao(IHealthDao baseDao) {
		super.setBaseDao(healthDao);
	}

	/**
	 * 查询体检健康
	 */
	@Override
	public Page<Rethealth> queryList(String kssj,String jzsj,Rethealth rethealth,Retirement retirement,Pageable pageable) {
		
		StringBuffer sb = new StringBuffer();
		sb.append(" from Rethealth r where 1=1 ");
		
		List<HiParameter> parameters = new ArrayList<HiParameter>();
		if(kssj!=null && kssj.length()>0){
			sb.append(" and tjsj>=:kssj");
			parameters.add(new HiParameter("kssj", kssj,StringType.INSTANCE));
		}
		if(jzsj!=null && jzsj.length()>0){
			sb.append(" and tjsj<=:jzsj");
			parameters.add(new HiParameter("jzsj", jzsj,StringType.INSTANCE));
		}
		if(retirement!=null){
			if(retirement.getSfzh()!=null && retirement.getSfzh().length()>0){
				sb.append(" and r.ret=:ret");
				parameters.add(new HiParameter("ret", retirement.getSfzh(),StringType.INSTANCE));
			}
		}
		sb.append(" order by tjsj desc");
		pageable.setParams(parameters);
		pageable.setQueryListStr("select r"+sb.toString());
		pageable.setQueryCountStr("select count(*) "+sb.toString());
		Page<Rethealth> page = healthDao.getHqlPage(pageable);
		return page;
	}
	

}
