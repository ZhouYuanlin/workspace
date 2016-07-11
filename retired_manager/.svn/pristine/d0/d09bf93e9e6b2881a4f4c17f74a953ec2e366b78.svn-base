package cn.uuf.ltxxt.retire.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retiresaluterecord;
import cn.uuf.ltxxt.retire.service.RetiresaluterecordService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 人员慰问记录表
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-7
 */
@Service
public class RetiresaluterecordServiceImpl extends HibernateDaoSupport<Retiresaluterecord, Long> implements RetiresaluterecordService{

	@Override
	public List<Retiresaluterecord> queryByVo(Retiresaluterecord r) {
		Criteria c = buildCondition(r);
		return c.list();
	}
	
	private Criteria buildCondition(Retiresaluterecord r){
		Criteria c = getSession().createCriteria(Retiresaluterecord.class);
		if(r != null){
			if(r.getSfzh() != null && r.getSfzh().length() > 0)
				c.add(Restrictions.eq("sfzh",r.getSfzh()));
			if(r.getSid() != null)
				c.add(Restrictions.eq("sid",r.getSid()));
		}
		c.addOrder(Order.asc("id"));
		return c;
	}

}

