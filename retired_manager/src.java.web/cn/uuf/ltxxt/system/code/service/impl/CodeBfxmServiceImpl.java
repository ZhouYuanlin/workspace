package cn.uuf.ltxxt.system.code.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeBfxm;
import cn.uuf.ltxxt.system.code.service.CodeBfxmService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 帮扶项目
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Service
public class CodeBfxmServiceImpl extends HibernateDaoSupport<CodeBfxm,Long> implements CodeBfxmService{

	@Override
	public List<CodeBfxm> getAll() {
		Criteria c = getSession().createCriteria(CodeBfxm.class);
		c.setCacheable(true);
		c.addOrder(Order.asc("code"));
		return c.list();
	}

	@Override
	public Long getCount(CodeBfxm l) {
		Criteria c = buildCondition(l);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<CodeBfxm> queryList(CodeBfxm l, int s, int size) {
		Criteria c = buildCondition(l);
		c.setFirstResult(s).setMaxResults(size);
		return this.queryByPage(c);
	}
	
	private Criteria buildCondition(CodeBfxm m){
		Criteria c = getSession().createCriteria(CodeBfxm.class);
		if(m != null){
			if(m.getCode() != null && m.getCode().length() > 0)
				c.add(Restrictions.eq("code",m.getCode()));
			if(m.getName() != null && m.getName().length() > 0)
				c.add(Restrictions.like("name",m.getName()));
		}
		c.setCacheable(true);
		c.addOrder(Order.asc("code"));
		return c;
	}

}

