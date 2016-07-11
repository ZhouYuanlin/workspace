/**
 * 
 */
package cn.uuf.ltxxt.retire.service.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retirewages;
import cn.uuf.ltxxt.retire.service.RetirewagesService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
* @author 作者 :蒋朋
* @version 创建时间：2016年3月22日 上午10:25:34
* 类说明：工资实现service
*/
@Service
public class RetirewagesServiceImpl extends HibernateDaoSupport<Retirewages,Long> implements RetirewagesService {

	
	@Override
	public Long getCount(String gzjs,  String jbtjs, Retirewages r,String ffjbt,String ttgzygZ,String jbtyfZ) {
		// TODO Auto-generated method stub
		Criteria criteria = buildCondition(gzjs, jbtjs, r, ffjbt, ttgzygZ, jbtyfZ);
		ProjectionList proList = Projections.projectionList();// 设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}
	
	
	private Criteria buildCondition(String gzjs,  String jbtjs, Retirewages r,String ffjbt,String ttgzygZ,String jbtyfZ)
	{
		Criteria c = getSession().createCriteria(Retirewages.class);
		c.addOrder(Order.desc("cjsj"));
		if(r != null){
			if (r.getXm() != null && r.getXm().trim().length() > 0) {
				c.add(Restrictions.like("xm", "%" + r.getXm() + "%", MatchMode.START));
			}
			if (r.getSfzh() != null && r.getSfzh().trim().length() > 0) {
				c.add(Restrictions.eq("sfzh", r.getSfzh()));
			}
			if (r.getFfsj() != null && r.getFfsj().trim().length() > 0 && (gzjs == null || gzjs.trim().length() < 1))// 月份起于
			{
				c.add(Restrictions.ge("ffsj", r.getFfsj()));// 大于等于
			}
			if (gzjs != null && gzjs.trim().length() > 0 && "".equals(r.getFfsj()) ) {
				c.add(Restrictions.le("ffsj", gzjs));
			}
			if (r.getFfsj() != null && r.getFfsj().trim().length() > 0 && gzjs != null && gzjs.trim().length() > 0) {
				c.add(Restrictions.between("ffsj", r.getYf(), gzjs));
			}
			
			if (r.getYf() != null && r.getYf().trim().length() > 0 && (ttgzygZ == null || "".equals(ttgzygZ)))// 财统工资发放月份大于等于
			{
				c.add(Restrictions.ge("yf", r.getYf()));
			}
			if (ttgzygZ != null && !"".equals(ttgzygZ) && (r.getYf() == null || "".equals(r.getYf())))// 财统工资发放月份小于等于
			{
				c.add(Restrictions.le("yf", ttgzygZ));
			}
			if (ttgzygZ != null && !"".equals(ttgzygZ) && r.getYf() != null && !"".equals(r.getYf()))// 在xxxx-xx和xxxx-xx之间
			{
				c.add(Restrictions.between("yf", r.getYf(), ttgzygZ));
			}
			
			c.createAlias("bjjbt", "b");
			if (ffjbt != null && ffjbt.trim().length() > 0)//排除ffjbt本身为空
			{
				if (Boolean.parseBoolean(ffjbt)) {
					c.add(Restrictions.isNotNull("b.sfgz"));// 不为空
				} else {
					c.add(Restrictions.isNull("b.sfgz"));// 为空
					return c;
				}
			}
			
			if (r.getBjjbt().getFfyf() != null && !"".equals(r.getBjjbt().getFfyf())
					&& (jbtyfZ == null || "".equals(jbtyfZ)))// 本津贴发放月份
			{
				c.add(Restrictions.ge("b.ffyf", r.getBjjbt().getFfyf()));
			}
			if (jbtyfZ != null && !"".equals(jbtyfZ)
					&& (r.getBjjbt().getFfyf() == null || "".equals(r.getBjjbt().getFfyf()))) {
				c.add(Restrictions.le("b.ffyf", jbtyfZ));
			}
			if (jbtyfZ != null && !"".equals(jbtyfZ) && r.getBjjbt().getFfyf() != null
					&& !"".equals(r.getBjjbt().getFfyf())) {
				c.add(Restrictions.between("b.ffyf", r.getBjjbt().getFfyf(), jbtyfZ));
			}
			
			if ((r.getBjjbt().getFfsj() != null && r.getBjjbt().getFfsj().trim().length() > 0)
					&& (jbtjs == null || jbtjs.trim().length() < 1)) {
				c.add(Restrictions.ge("b.ffsj", r.getBjjbt().getFfsj()));
			}
			if ((jbtjs != null && jbtjs.trim().length() > 0)
					&& "".equals(r.getBjjbt().getFfsj())) {
				c.add(Restrictions.le("b.ffsj", jbtjs));
			}
			if (r.getBjjbt() != null && r.getBjjbt().getFfsj() != null && r.getBjjbt().getFfsj().trim().length() > 0
					&& jbtjs != null && jbtjs.trim().length() > 0) {
				c.add(Restrictions.between("b.ffsj", r.getBjjbt().getFfsj(), jbtjs));
			}
		}
		return c;
	}


	
	@Override
	public List<Retirewages> queryList(int s, int size, String gzjs, String jbtjs, Retirewages r, String ffjbt,String ttgzygZ,String jbtyfZ) {
		// TODO Auto-generated method stub
		Criteria c = buildCondition(gzjs, jbtjs, r, ffjbt,ttgzygZ,jbtyfZ);
		c.setFirstResult(s).setMaxResults(size);
		return queryByPage(c);
	}


	/* (non-Javadoc)
	 * @see cn.uuf.ltxxt.retire.service.RetirewagesService#getByMonth(cn.uuf.domain.Retirewages)
	 */
	@Override
	public Retirewages getByMonth(Retirewages r) {
		// TODO Auto-generated method stub
		Criteria c = getSession().createCriteria(Retirewages.class);
		if(r!=null)
		{
			if(r.getXm()!=null&&r.getXm().length()>0)
			{
				c.add(Restrictions.eq("xm", r.getXm()));//锁定姓名
			}
			if(r.getSfzh()!=null&&r.getSfzh().length()>0)
			{
				c.add(Restrictions.eq("sfzh", r.getSfzh()));//锁定身份证号
			}
			c.createAlias("bjjbt","b");
			if (r.getYf() != null && r.getYf().length() > 0 && ("".equals(r.getBjjbt().getFfyf())||r.getBjjbt().getFfyf()==null)) {//
				c.add(Restrictions.eq("b.ffyf", r.getYf()));
			}
			if (r.getBjjbt().getFfyf() != null && r.getBjjbt().getFfyf().length() > 0 && ("".equals(r.getYf())||r.getYf()==null)) {
				c.add(Restrictions.eq("yf", r.getBjjbt().getFfyf()));
			}
			if (r.getYf() != null && r.getYf().length() > 0 && r.getBjjbt().getFfyf() != null
					&& r.getBjjbt().getFfyf().length() > 0) {
				c.add(Restrictions.eq("yf", r.getYf()));
				c.add(Restrictions.eq("b.ffyf", r.getBjjbt().getFfyf()));
			}
		}
		List<Retirewages> list=super.queryByPage(c);
		if(list.size()<1)
		{
			return null;
		}
		return list.get(0);
	}
	
}
