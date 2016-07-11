package cn.uuf.ltxxt.health.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.health.Retlabel;
import cn.uuf.ltxxt.health.service.RetlabelService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 保健标记
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-2
 */
@Service
public class RetlabelServiceImpl extends HibernateDaoSupport<Retlabel,Long> implements RetlabelService{

	@Override
	public Long getCount(Retlabel l) {
		Criteria criteria = buildContion(l);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retlabel> queryList(Retlabel l, int s, int size) {
		Criteria c = buildContion(l);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildContion(Retlabel w){
		Criteria c = getSession().createCriteria(Retlabel.class);
		if(w != null){
			if(w.getBjbj() != null && w.getBjbj().length() > 0){
				String s = "";
				for (int i = 0; i < w.getBjbj().split(",").length; i++) {
					if(!w.getBjbj().split(",")[i].equals(""))
						s += " bjbj like '%"+w.getBjbj().split(",")[i] + "%'";
					if(!w.getBjbj().split(",")[i].equals("") && i < w.getBjbj().split(",").length - 1)
						s += " and ";
				}
				c.add(Restrictions.sqlRestriction(s));
			}
			if(w.getRet() != null){
				c.createAlias("ret","r");
				if(w.getRet() != null && w.getRet().getXm() != null && w.getRet().getXm().length() > 0)
					c.add(Restrictions.eq("r.xm",w.getRet().getXm()));
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
			}
		}
		return c;
	}

}

