package cn.uuf.ltxxt.honor.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.honor.Retirehonor;
import cn.uuf.ltxxt.honor.service.RetirehonorService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 表彰服务
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
@Service
public class RetirehonorServiceImpl extends HibernateDaoSupport<Retirehonor,Long> implements RetirehonorService{

	@Override
	public Long getCount(Retirehonor h,String kssj,String jssj) {
		Criteria c = buildCondition(h,kssj,jssj);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<Retirehonor> queryList(Retirehonor h, int s, int size,String kssj,String jssj) {
		Criteria c = buildCondition(h,kssj,jssj);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}

	@Override
	public List<Retirehonor> queryByVo(Retirehonor h) {
		Criteria c = buildCondition(h,null,null);
		return c.list();
	}
	
	private Criteria buildCondition(Retirehonor h,String kssj,String jssj){
		Criteria c = getSession().createCriteria(Retirehonor.class);
		if(h != null){
			if((kssj != null && kssj.length() > 0) && (jssj == null || jssj.equals("")))
				c.add(Restrictions.ge("bzsj",kssj));
			if((kssj == null || kssj.equals("")) && (jssj != null && jssj.length() > 0))
				c.add(Restrictions.le("bzsj",jssj));
			if((kssj != null && kssj.length() > 0) && (jssj != null && jssj.length() > 0))
				c.add(Restrictions.between("bzsj",kssj,jssj));
			if(h.getBzmc() != null && h.getBzmc().length() > 0)
				c.add(Restrictions.like("bzmc",h.getBzmc(),MatchMode.ANYWHERE));
			if(h.getBzjb() != null && h.getBzjb().length() > 0)
				c.add(Restrictions.eq("bzjb",h.getBzjb()));
			if(h.getBzdw() != null && h.getBzdw().length() > 0)
				c.add(Restrictions.like("bzdw",h.getBzdw(),MatchMode.ANYWHERE));
			if(h.getCyhs() != null && h.getCyhs().length() > 0)
				c.add(Restrictions.like("cyhs",h.getCyhs(),MatchMode.ANYWHERE));
		}
		c.addOrder(Order.desc("bzsj"));
		return c;
	}

}

