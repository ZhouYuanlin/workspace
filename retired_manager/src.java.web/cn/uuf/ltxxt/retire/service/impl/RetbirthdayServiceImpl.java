package cn.uuf.ltxxt.retire.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirement;
import cn.uuf.ltxxt.retire.service.RetbirthdayService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 生日提醒，为了不影响别的信息查人，所以单独写个服务出来
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-28
 */
@Service
public class RetbirthdayServiceImpl extends HibernateDaoSupport<Retirement,String> implements RetbirthdayService{

	@Override
	public Long getCount(Retirement r, String ks, String js,String eq,String type) {
		Criteria criteria = buildCondition(r,ks,js,eq,type);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("sfzh"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retirement> queryList(Retirement r, int s, int size, String ks,String js,String eq,String type) {
		Criteria c = buildCondition(r,ks,js,eq,type);
		c.setFirstResult(s).setMaxResults(size);
		return queryByPage(c);
	}
	
	private Criteria buildCondition(Retirement r,String ks,String js,String eq,String type){
		Criteria c = getSession().createCriteria(Retirement.class);
		if(r != null){
			if(r.getSfsc() != null && r.getSfsc().length() > 0)
				c.add(Restrictions.eq("sfsc",r.getSfsc()));
			else
				c.add(Restrictions.eq("sfsc", Constants.HASNO));
			if(r.getSfzh() != null && r.getSfzh().length() > 0)
				c.add(Restrictions.eq("sfzh",r.getSfzh()));
			if(r.getXm() != null && r.getXm().length() > 0)
				c.add(Restrictions.like("xm",r.getXm(),MatchMode.ANYWHERE));
			if(r.getGzzh() != null && r.getGzzh().length() > 0)
				c.add(Restrictions.eq("gzzh",r.getGzzh()));
			if(r.getXb() != null && r.getXb().length() > 0)
				c.add(Restrictions.eq("xb",r.getXb()));
			if(r.getDwb() != null && r.getDwb().getId() != null)
				c.add(Restrictions.eq("dwb",r.getDwb()));
			if(r.getLxb() != null && r.getLxb().getId() != null)
				c.add(Restrictions.eq("lxb",r.getLxb()));
			if(r.getZjb() != null && r.getZjb().getId() != null)
				c.add(Restrictions.eq("zjb",r.getZjb()));
			if(r.getZwb() != null && r.getZwb().getId() != null)
				c.add(Restrictions.eq("zwb",r.getZwb())); 
			if(r.getMzb() != null && r.getMzb().getId() != null)
				c.add(Restrictions.eq("mzb",r.getMzb()));
			if(r.getZzmm() != null && r.getZzmm().getId() != null)
				c.add(Restrictions.eq("zzmm",r.getZzmm()));
			if(r.getJg() != null && r.getJg().length() > 0)
				c.add(Restrictions.eq("jg",r.getJg()));
			
			if(r.getCsrq() != null && r.getCsrq().length() > 0)
				c.add(Restrictions.eq("csrq",r.getCsrq()));//类型为空表是查出生日期，不为空是查是否为党员
			
			if(StringUtils.isNotEmpty(ks) || StringUtils.isNotBlank(js)){
				if(StringUtils.isNotEmpty(ks) && StringUtils.isNotBlank(js)){
					c.add(Restrictions.and(Restrictions.gt("csrq", js), Restrictions.lt("csrq",ks)));
				}
				if(StringUtils.isNotEmpty(ks)){
					c.add(Restrictions.lt("csrq", ks));
				}
				if(StringUtils.isNotEmpty(js)){
					c.add(Restrictions.gt("csrq", js));
				}
			}
			if(StringUtils.isNotBlank(eq)){
				c.add(Restrictions.like("csrq","%"+eq+"%"));
			}
			
			
			if(r.getParty() != null && r.getParty().getId() != null)
				c.add(Restrictions.eq("party",r.getParty()));
		}
		c.addOrder(Order.asc("sfzh")).addOrder(Order.desc("csrq"));
		return c;
	}

}

