package cn.uuf.wechat.personal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.type.StringType;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retirement;
import cn.uuf.stu.framework.common.HiParameter;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.service.impl.BaseServiceImpl;
import cn.uuf.wechat.personal.dao.IPersonalDao;
import cn.uuf.wechat.personal.service.IPersonalService;

@Service(value="personalService")
public class PersonalServiceImpl extends BaseServiceImpl<Retirement, String> implements IPersonalService{
	
	@Resource(name="personalDao")
	private IPersonalDao personalDao;
	
	@Resource(name="personalDao")
	public void setBaseDao(IPersonalDao baseDao) {
		super.setBaseDao(personalDao);
	}

//	/**
//	 * 分页查询方法实现
//	 */
//	@SuppressWarnings(value="all")
//	@Override
//	public List<Retirement> queryList(Retirement retirement) {
//		Criteria criteria = this.buildCondition(retirement);
//		return criteria.list();
//	}
//
//	private Criteria buildCondition(Retirement retirement) {
//		 Criteria criteria = personalDao.queryList(retirement);
//		 if(retirement!=null){
//			 if(retirement.getSfzh()!=null && retirement.getSfzh().length()>0){
//				 criteria.add(Restrictions.eq("sfzh", retirement.getSfzh()));
//			 }
//			 if(retirement.getXm()!=null && retirement.getXm().length()>0){
//				 criteria.add(Restrictions.like("xm", retirement.getXm(),MatchMode.START));
//			 }
//			 if(retirement.getDwb()!=null){
//				 if(retirement.getDwb().getName()!=null && retirement.getDwb().getName().length()>0){
//					 criteria.add(Restrictions.eq("dwb", retirement.getDwb()));
//				 }
//			 }
//			 if(retirement.getParty()!=null){
//				 if(retirement.getParty().getDzbmc()!=null && retirement.getParty().getDzbmc().length()>0){
//					 criteria.add(Restrictions.eq("party.dzbmc", retirement.getParty().getDzbmc()));
//				 }
//			 }
//		 }
//		 return criteria;
//	}

	@Override
	public Page<Retirement> queryList(Retirement retirement, Pageable pageable) {
		
		StringBuffer sb = new StringBuffer();
		sb.append(" from Retirement a left join a.dwb b left join a.party c where a.sfsc='否' ");
		List<HiParameter> parameters = new ArrayList<HiParameter>();
		if(retirement!=null){
			 if(retirement.getSfzh()!=null && retirement.getSfzh().length()>0){
				 sb.append(" and a.sfzh=:sfzh");
				 parameters.add(new HiParameter("sfzh", retirement.getSfzh()+"", StringType.INSTANCE));
			 }
			 if(retirement.getXm()!=null && retirement.getXm().length()>0){
				 sb.append(" and a.xm like:xm");
				 parameters.add(new HiParameter("xm", retirement.getXm()+"%", StringType.INSTANCE));
			 }
			 if(retirement.getDwb()!=null){
				 if(retirement.getDwb().getName()!=null && retirement.getDwb().getName().length()>0){
					 sb.append(" and b.name=:dwname");
					 parameters.add(new HiParameter("dwname", retirement.getDwb().getName(), StringType.INSTANCE));
				 }
			 }
			 if(retirement.getParty()!=null){
				 if(retirement.getParty().getDzbmc()!=null && retirement.getParty().getDzbmc().length()>0){
					 sb.append(" and c.dzbmc=:dzbmc");
					 parameters.add(new HiParameter("dzbmc", retirement.getParty().getDzbmc(), StringType.INSTANCE));
				 }
			 }
		 }
		pageable.setParams(parameters);
		pageable.setQueryListStr("select a"+sb.toString());
		pageable.setQueryCountStr("select count(*) "+sb.toString());
		Page<Retirement> page = personalDao.getHqlPage(pageable);
		return page;
	}
	@Override
	public List queryBySql(String sql) throws Exception {
		List list =personalDao.queryBySql(sql);
		return list;
	}
	
}
