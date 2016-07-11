package cn.uuf.ltxxt.mess.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.message.Notice;
import cn.uuf.ltxxt.mess.service.NoticeService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 通知公告
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-21
 */
@Service
public class NoticeServiceImpl extends HibernateDaoSupport<Notice,Long> implements NoticeService{

	@Override
	public Long getCount(Notice n) {
		Criteria criteria = buildCondition(n);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Notice> queryList(Notice n, int s, int size) {
		Criteria c = buildCondition(n);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Notice n){
		Criteria c = getSession().createCriteria(Notice.class);
		if(n != null){
			if(n.getTitle() != null && n.getTitle().length() > 0)
				c.add(Restrictions.like("title",n.getTitle(),MatchMode.ANYWHERE));
			if(n.getDwbs() != null && n.getDwbs().length() > 0)
//				c.add(Restrictions.or(Restrictions.like("dwbs",n.getDwbs(),MatchMode.ANYWHERE),Restrictions.isNull("dwbs")));
				c.add(Restrictions.like("dwbs",n.getDwbs(),MatchMode.ANYWHERE));
			if(n.getContent() != null && n.getTitle().length() > 0)
				c.add(Restrictions.like("content",n.getContent()));
			if(n.getFbz() != null && n.getFbz().length() > 0)
				c.add(Restrictions.eq("fzb",n.getFbz()));
			if(n.getCreateDate() != null)
				c.add(Restrictions.ge("createDate",n.getCreateDate()));
		}
		c.addOrder(Order.desc("createDate"));
		return c;
	}

}

