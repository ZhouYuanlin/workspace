package cn.uuf.ltxxt.retire.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retirework;
import cn.uuf.ltxxt.retire.service.RetireworkService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 离退休人员工作经历
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Service
public class RetireworkServiceImpl extends HibernateDaoSupport<Retirework,Long> implements RetireworkService{

	@Override
	public Long getCount(Retirework w,String gksj,String gjsj,String lksj,String ljsj,String column,String sort) {
		Criteria criteria = buildCondition(w,gksj,gjsj,lksj,ljsj,column,sort);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retirework> queryList(Retirework w, int s, int size,String gksj,String gjsj,String lksj,String ljsj,String column,String sort) {
		Criteria c = buildCondition(w,gksj,gjsj,lksj,ljsj,column,sort);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Retirework w,String gksj,String gjsj,String lksj,String ljsj,String column,String sort){
		Criteria c = getSession().createCriteria(Retirework.class);
		if(w != null){
			if(w.getRet() != null){
				c.createAlias("ret","r");
				if((gksj != null && gksj.length() > 0) && (gjsj == null || gjsj.equals("")))
					c.add(Restrictions.gt("r.gzsj",gksj));//参加工作时间开始于xxxx-xx-xx
				if((gksj == null || gksj.equals("")) && (gjsj != null && gjsj.length() > 0))
					c.add(Restrictions.lt("r.lxsj",gjsj));//参加工作时间结束于xxxx-xx-xx
				if((gksj != null && gksj.length() > 0) && (gjsj != null && gjsj.length() > 0))
					c.add(Restrictions.between("r.gzsj",gksj,gjsj));//参加工作时间开始xxxx-xx-xx,结束于xxxx-xx-xx
				if((lksj != null && lksj.length() > 0) && (ljsj == null || ljsj.equals("")))
					c.add(Restrictions.gt("r.lxsj",lksj));//离退休时间开始于xxxx-xx-xx
				if((lksj == null || lksj.equals("")) && (ljsj != null && ljsj.length() > 0))
					c.add(Restrictions.lt("r.lxsj",ljsj));//离退休时间结束于xxxx-xx-xx
				if((lksj != null && lksj.length() > 0) && (ljsj != null && ljsj.length() > 0))
					c.add(Restrictions.between("r.lxsj",lksj,ljsj));//离退休时间开始xxxx-xx-xx,结束于xxxx-xx-xx
				if(w.getRet() != null && w.getRet().getXm() != null && w.getRet().getXm().length() > 0)
					c.add(Restrictions.like("r.xm",w.getRet().getXm(),MatchMode.ANYWHERE));
				if(w.getRet() != null && w.getRet().getSfzh() != null && w.getRet().getSfzh().length() > 0)
					c.add(Restrictions.eq("r.sfzh",w.getRet().getSfzh()));
				if(w.getRet() != null && w.getRet().getXb() != null && w.getRet().getXb().length() > 0)
					c.add(Restrictions.eq("r.xb",w.getRet().getXb()));
				if(w.getRet() != null && w.getRet().getDwb() != null && w.getRet().getDwb().getId() != null)
					c.add(Restrictions.eq("r.dwb",w.getRet().getDwb()));
				if(w.getRet() != null && w.getRet().getZwb() != null && w.getRet().getZwb().getId() != null)
					c.add(Restrictions.eq("r.zwb",w.getRet().getZwb()));
				if(w.getRet() != null && w.getRet().getLxb() != null && w.getRet().getLxb().getId() != null)
					c.add(Restrictions.eq("r.lxb",w.getRet().getLxb()));
				/**
				 * 判断用那列为排序的一列
				 */
				if(column!=null&&column.length()>0)
				{
					if(sort!=null||!sort.equals(""))
					{
						if(sort.equals("desc"))
						{
							c.addOrder(Order.desc("r."+column));
						}
						else {
							c.addOrder(Order.asc("r."+column));
						}
					}
				}
				else
				{
					c.addOrder(Order.asc("ret"));
				}
			}
		}
		return c;
	}

}

