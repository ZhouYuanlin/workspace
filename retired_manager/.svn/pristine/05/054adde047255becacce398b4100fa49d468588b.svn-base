package cn.uuf.ltxxt.system.permission.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.Resource;
import cn.uuf.domain.Role;
import cn.uuf.ltxxt.system.permission.service.AccountService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
@Service("accountService")
public class AccountServiceImpl extends HibernateDaoSupport<Account,Long> implements AccountService{

	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Override
	public List<Account> getAll() throws Exception {
		return this.find();
	}

	@Override
	public Account getById(Long id) {
		Account acc = (Account) this.getSession().get(this.getEntityClass(), id);
		lazzObj(acc);
		return acc;
	}

	@Override
	public Account getByUserName(String username) throws Exception {
		Criteria critera = this.getSession().createCriteria(Account.class);
		critera.add(Restrictions.eq("username", username));
		Account acc = (Account) critera.uniqueResult();
		lazzObj(acc);
		return acc;
	}


	@Override
	public List<Account> queryList(Account acc, int start, int size) {
		return this.queryByPage(buildCriteria(acc,start,size));
	}

	@Override
	public Long getCount(Account acc) {
		Criteria criteria =decoration(acc);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Account> queryByLoginName1(String username) throws Exception {
		Criteria critera = this.getSession().createCriteria(Account.class);
		critera.add(Restrictions.or(Restrictions.eq("username", username),
				Restrictions.or(Restrictions.eq("lxdh",username),Restrictions.eq("gzzh", username))));
		critera.add(Restrictions.eq("status", Constants.ENABLE));//只有启用的用户才可登录
		List<Account> acc = critera.list();
		for (Account account : acc) {
			lazzObj(account);
		}
		return acc;
	}
	@Override
	public Account queryByLoginName(String username) throws Exception {
		Criteria critera = this.getSession().createCriteria(Account.class);
		critera.add(Restrictions.or(Restrictions.eq("username", username),
				Restrictions.or(Restrictions.eq("lxdh",username),Restrictions.eq("gzzh", username))));
		critera.add(Restrictions.eq("status", Constants.ENABLE));//只有启用的用户才可登录
		Account acc = (Account) critera.uniqueResult();
		lazzObj(acc);
		return acc;
	}
	
	private Criteria buildCriteria(Account acc,int start,int size){
		Criteria criteria =decoration(acc);
		criteria.setFirstResult(start).setMaxResults(size);
		criteria.addOrder(Order.asc("id"));
		return criteria;
	}
	
	/**
	 * 参数装饰
	 * @param acc
	 * @return
	 */
	private Criteria decoration(Account acc){
		Criteria criteria = getSession().createCriteria(acc.getClass());
		if(acc != null){
			if(acc.getUsername() != null && acc.getUsername().length() > 0)
				criteria.add(Restrictions.eq("username", acc.getUsername()));
			if(acc.getLxdh() != null && acc.getLxdh().length() > 0)
				criteria.add(Restrictions.eq("lxdh",acc.getLxdh()));
			if(acc.getGzzh() != null && acc.getGzzh().length() > 0)
				criteria.add(Restrictions.eq("gzzh",acc.getGzzh()));
			if(acc.getRealname() != null && acc.getRealname().length() > 0)
				criteria.add(Restrictions.like("realname",acc.getRealname(),MatchMode.ANYWHERE));
			if(acc.getStatus() != null && acc.getStatus().length() > 0)
				criteria.add(Restrictions.eq("status", acc.getStatus()));
			if (acc.getRoles()!=null && acc.getRoles().size()>0) {
				criteria.createAlias("roles","role");
				Long[] ids=new Long[acc.getRoles().size()];
				for (int i = 0; i <acc.getRoles().size(); i++) {
					if (acc.getRoles().get(i)!=null) {
						ids[i]=acc.getRoles().get(i).getId();
					}
					
				}
				criteria.add(Restrictions.in("role.id", ids));
				
			}
		}
		return criteria;
	}
	
	private void lazzObj(Account acc){
		if(acc != null){
			Hibernate.initialize(acc.getRoles());
			for(Role r : acc.getRoles()){
				Hibernate.initialize(r.getResources());
				for(Resource re : r.getResources()){
					Hibernate.initialize(re.getParent());
					Hibernate.initialize(re.getChildren());
					Hibernate.initialize(re.getRoles());
					for(Resource s : re.getChildren()){
						Hibernate.initialize(s);
						Hibernate.initialize(s.getParent());
						Hibernate.initialize(s.getChildren());
						Hibernate.initialize(s.getRoles());
					}
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see cn.uuf.ltxxt.system.permission.service.AccountService#getByRealName(java.lang.String)
	 */
	@Override
	public Account getByRealName(String username) throws Exception {
		Criteria critera = this.getSession().createCriteria(Account.class);
		critera.add(Restrictions.eq("realname", username));
		Account acc = (Account) critera.uniqueResult();
		lazzObj(acc);
		return acc;
	}

}

