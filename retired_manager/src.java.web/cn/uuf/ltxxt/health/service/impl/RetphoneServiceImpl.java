package cn.uuf.ltxxt.health.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retirement;
import cn.uuf.domain.Retiresalute;
import cn.uuf.domain.health.Rethospital;
import cn.uuf.domain.health.Retphone;
import cn.uuf.ltxxt.health.service.RethospitalService;
import cn.uuf.ltxxt.health.service.RetphoneService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 电话联系
 * @author Suntingwen
 *
 */
@Service
public class RetphoneServiceImpl extends HibernateDaoSupport<Retphone,Long> implements RetphoneService{

	@Override
	public Long getCount(Retphone retphone) {
		Session session = this.getSession();
		StringBuffer sb = new StringBuffer();
		sb.append("select count(a.id) from Retphone a,Retirement b where a.sfzh=b.sfzh and 1=1 ");
		buildConditionRetphone(retphone, sb);
		Query query = session.createQuery(sb.toString());
		return Long.parseLong(query.uniqueResult()!=null?query.uniqueResult().toString():"0");
	}

	@Override
	public List<Retphone> queryList(Retphone retphone, int s, int size) {
		Session session = this.getSession();
		StringBuffer sb = new StringBuffer();
		sb.append("select a from Retphone a,Retirement b where a.sfzh=b.sfzh and 1=1");
		buildConditionRetphone(retphone, sb);
		Query query = session.createQuery(sb.toString());
		query.setFirstResult(s).setMaxResults(size);
		return query.list();
	}
	@Override
	public List<Retphone> queryByVo(Retphone phone) {
		Criteria c = buildCondition(phone);
		return c.list();
	}
	@Override
	public List<Retphone> queryBySql(String sql) {
		Query query = getSession().createQuery(sql);
		return query.list();
	}
	private void buildConditionRetphone(Retphone retphone, StringBuffer sb) {
		if(retphone != null){
			if(StringUtils.isNotEmpty(retphone.getLxr())){
				sb.append(" and a.lxr like '%"+retphone.getLxr()+"%'");
			}
			if(retphone!=null&&retphone.getRetirement()!=null&&StringUtils.isNotEmpty(retphone.getRetirement().getXm())){
				sb.append(" and b.xm like '%"+retphone.getRetirement().getXm()+"%'");
			}
			if(StringUtils.isNotEmpty(retphone.getSfzh())){
				sb.append(" and a.sfzh='"+retphone.getSfzh()+"'");
			}
			sb.append(" order by lxrq desc");
		}
	}
	
	
	
	
	
	
	private Criteria buildCondition(Retphone retphone){
		Criteria c = getSession().createCriteria(Retphone.class);
		
		if(retphone != null){
			c.add(Restrictions.eq("lxr", retphone.getLxr()));
			if(retphone.getRetirement() != null){
				//姓名
				if(retphone.getRetirement() != null && retphone.getRetirement().getXm() != null && retphone.getRetirement().getXm().length() > 0)
					c.add(Restrictions.like("ret.xm",retphone.getRetirement().getXm(),MatchMode.ANYWHERE));
				//身份证号
				if(retphone.getRetirement() != null && retphone.getRetirement().getSfzh() != null && retphone.getRetirement().getSfzh().length() > 0)
					c.add(Restrictions.eq("ret.sfzh",retphone.getRetirement().getSfzh()));
				//性别
				if(retphone.getRetirement() != null && retphone.getRetirement().getXb() != null && retphone.getRetirement().getXb().length() > 0)
					c.add(Restrictions.eq("ret.xb",retphone.getRetirement().getXb()));
				//原工作单位
				if(retphone.getRetirement() != null && retphone.getRetirement().getDwb() != null && retphone.getRetirement().getDwb().getId() != null)
					c.add(Restrictions.eq("ret.dwb",retphone.getRetirement().getDwb()));
				//民族
				if(retphone.getRetirement() != null && retphone.getRetirement().getMzb() != null && retphone.getRetirement().getMzb().getId() != null)
					c.add(Restrictions.eq("ret.zwb",retphone.getRetirement().getMzb()));
				//类型
				if(retphone.getRetirement() != null && retphone.getRetirement().getLxb() != null && retphone.getRetirement().getLxb().getId() != null)
					c.add(Restrictions.eq("ret.lxb",retphone.getRetirement().getLxb()));
				//联系日期
				if(retphone.getLxrq()!=null && !retphone.getLxrq().equals("")){
					c.add(Restrictions.eq("lxrq", retphone.getLxrq()));
				}
				//联系人
				if(retphone.getLxr()!=null && retphone.getLxr().length()>0){
					c.add(Restrictions.eq("lxr", retphone.getLxr()));
				}
				//联系详情
				if(retphone.getLxxq()!=null && retphone.getLxxq().length()>0){
					c.add(Restrictions.like("lxxq", "%"+retphone.getLxxq()+"%"));
				}
				//登记人
				if(retphone.getDjr()!=null && retphone.getDjr().length()>0){
					c.add(Restrictions.eq("djr", retphone.getDjr()));
				}
				//登记日期
				if(retphone.getDjrq()!=null && !retphone.getDjrq().equals("")){
					c.add(Restrictions.eq("djrq", retphone.getDjrq()));
				}
			}
		}
		c.addOrder(Order.desc("ret.sfzh"));
		return c;
	}

	

}

