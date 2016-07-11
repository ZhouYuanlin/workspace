package cn.uuf.ltxxt.survey.service.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.survey.Questionten;
import cn.uuf.domain.survey.Survey;
import cn.uuf.ltxxt.survey.service.SurveyService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

@Service
public class SurveyServiceImpl extends HibernateDaoSupport<Survey, Long> implements SurveyService {

	@Override
	public List<Survey> queryList(Survey s, int c, int size) {

		Criteria r = buildCondition(s);

		r.setFirstResult(c).setMaxResults(size);
		return r.list();
	}

	private Criteria buildCondition(Survey survey) {
		Criteria c = getSession().createCriteria(Survey.class);
		if (survey != null) {
			if (survey.getWjzt() != null && !"".equals(survey.getWjzt())) {
				c.add(Restrictions.like("wjzt", survey.getWjzt(), MatchMode.ANYWHERE));
			}
		}
		c.addOrder(Order.desc("fbrq"));
		return c;
	}

	@Override
	public Long getCount(Survey t) {
		Criteria c = buildCondition(t);
		ProjectionList proList = Projections.projectionList();// 设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<Survey> getAll() {
		return null;
	}

	@Override
	public List<Questionten> queryBySid(Questionten questionten) {
		Criteria c = buildCondition1(questionten);
		return c.list();
	}

	private Criteria buildCondition1(Questionten t) {
		Criteria c = getSession().createCriteria(Questionten.class);
		if (t.getSurvey() != null) {
			c.createAlias("questionten", "q");
			if (t.getSurvey().getId() != null) {
				c.add(Restrictions.eq("q.id", t.getSurvey().getId()));
			}
		}
		c.addOrder(Order.asc("xh"));
		return c;
	}

	@Override
	public List queryBySql(String sql) {
		List<Survey> list=getSession().createSQLQuery(sql).list();
		return list;
	}
}
