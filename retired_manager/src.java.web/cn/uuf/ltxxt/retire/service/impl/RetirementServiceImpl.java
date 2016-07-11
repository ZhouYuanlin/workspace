package cn.uuf.ltxxt.retire.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirement;
import cn.uuf.ltxxt.retire.service.RetirementService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 离退休人员
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Service
public class RetirementServiceImpl extends HibernateDaoSupport<Retirement,String> implements RetirementService{

	@Override
	public Long getCount(Retirement r,String csrqst,String csrqend,String csrqSeq,String xsdy) {
		Criteria criteria = buildCondition(r,null,null,null,csrqst,csrqend,csrqSeq,xsdy,null,null,null);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("sfzh"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}
	
	@Override
	public Long getCount(Retirement r, String ks, String js,String type,String rdsjSt,String rdsjEnd,String rdsjEq) {
		Criteria criteria = buildCondition(r,ks,js,type,null,null,null,null,rdsjSt,rdsjEnd,rdsjEq);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("sfzh"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retirement> queryList(Retirement r, int s, int size, String ks,String js,String type,String rdsjSt,String rdsjEnd,String rdsjEq) {
		Criteria c = buildCondition(r,ks,js,type,null,null,null,null,rdsjSt,rdsjEnd,rdsjEq);
		c.setFirstResult(s).setMaxResults(size);
		return queryByPage(c);
	}
	@Override
	public List<Retirement> queryList(Retirement r, int s, int size,String csrqSt,String csrqend,String csrqSeq,String xsdy) {
		Criteria c = buildCondition(r,null,null,null,csrqSt,csrqend,csrqSeq,xsdy,null,null,null);
		c.setFirstResult(s).setMaxResults(size);
		return queryByPage(c);
	}
	
	private Criteria buildCondition(Retirement r,String ks,String js,String type,String csrqst,String csrqend,String csrqSeq,String xsdy,String rdsjSt,String rdsjEnd,String rdsjEq){
		Criteria c = getSession().createCriteria(Retirement.class);
		
		//引用变量,将生日转换成年龄
		if(r != null){
			if(r.getDfjs() != null && r.getDfjs().length() > 0)
				c.add(Restrictions.isNotNull("dfjs"));//查出党费基数不为空的人员
			if(r.getQq() != null && r.getQq().length() > 0){
				String s = "";//临时用QQ字段代替职级的多条件查询
				for (int i = 0; i < r.getQq().split(",").length; i++) {
					if(i==0)s += " (";
					if(!r.getQq().split(",")[i].equals(""))
						s += " zjb_id ="+r.getQq().split(",")[i];
					if(!r.getQq().split(",")[i].equals("") && i < r.getQq().split(",").length - 1)
						s += " or ";
					if(i == r.getQq().split(",").length - 1)s+=")";
				}
				c.add(Restrictions.sqlRestriction(s));
			}
			if(r.getSfyfz() != null && r.getSfyfz().length() > 0){
				String s = "";//临时用sfyfz字段代替职务的多条件查询
				for (int i = 0; i < r.getSfyfz().split(",").length; i++) {
					if(i==0)s += " (";
					if(!r.getSfyfz().split(",")[i].equals(""))
						s += " zwb_id ="+r.getSfyfz().split(",")[i];
					if(!r.getSfyfz().split(",")[i].equals("") && i < r.getSfyfz().split(",").length - 1)
						s += " or ";
					if(i == r.getSfyfz().split(",").length - 1)s+=")";
				}
				c.add(Restrictions.sqlRestriction(s));
			}
			if(r.getBz() != null && r.getBz().length() > 0){
				String s = "";//临时用bz字段代替原工单位的多条件查询
				for (int i = 0; i < r.getBz().split(",").length; i++) {
					if(i==0)s += " (";
					if(!r.getBz().split(",")[i].equals(""))
						s += " dwb_id ="+r.getBz().split(",")[i];
					if(!r.getBz().split(",")[i].equals("") && i < r.getBz().split(",").length - 1)
						s += " or ";
					if(i == r.getBz().split(",").length - 1)s+=")";
				}
				c.add(Restrictions.sqlRestriction(s));
			}
			if(r.getSfsc() != null && r.getSfsc().length() > 0)
				c.add(Restrictions.eq("sfsc",r.getSfsc()));
			else
				c.add(Restrictions.eq("sfsc", Constants.HASNO));
			if(r.getSfzh() != null && r.getSfzh().length() > 0)
				c.add(Restrictions.eq("sfzh",r.getSfzh()));
			if(r.getXm() != null && r.getXm().length() > 0)
				c.add(Restrictions.like("xm",r.getXm(),MatchMode.ANYWHERE));
			if(r.getGzzh() != null && r.getGzzh().length() > 0)
				c.add(Restrictions.eq("gzzh",r.getGzzh()));
			if(r.getXb() != null && r.getXb().length() > 0)
				c.add(Restrictions.eq("xb",r.getXb()));
			if(r.getDwb() != null && r.getDwb().getId() != null)
				c.add(Restrictions.eq("dwb",r.getDwb()));
			if(r.getLxb() != null && r.getLxb().getId() != null)
				c.add(Restrictions.eq("lxb",r.getLxb()));
			if(r.getZjb() != null && r.getZjb().getId() != null)
				c.add(Restrictions.eq("zjb",r.getZjb()));
			if(r.getZwb() != null && r.getZwb().getId() != null)
				c.add(Restrictions.eq("zwb",r.getZwb())); 
			if(r.getMzb() != null && r.getMzb().getId() != null)
				c.add(Restrictions.eq("mzb",r.getMzb()));
			if(r.getZzmm() != null && r.getZzmm().getId() != null)
				c.add(Restrictions.eq("zzmm",r.getZzmm()));
			if(r.getJg() != null && r.getJg().length() > 0)
				c.add(Restrictions.eq("jg",r.getJg()));
			if(r.getCsrq() != null && r.getCsrq().length() > 0)
				c.add(Restrictions.eq(type == null ? "csrq" : "rdsj",r.getCsrq()));//类型为空表是查出生日期，不为空是查是否为党员
			
			if(StringUtils.isNotEmpty(ks))
				c.add(Restrictions.ge(type == null ? "csrq" : "rdsj",ks));
			if(StringUtils.isNotEmpty(js))
				c.add(Restrictions.le(type == null ? "csrq" : "rdsj",js));
			//添加根据年龄查询条件
			if(StringUtils.isNotEmpty(csrqst) && StringUtils.isNotBlank(csrqend)){
				c.add(Restrictions.and(Restrictions.lt("csrq", csrqst),Restrictions.gt("csrq",csrqend)));
			}
			if(StringUtils.isNotBlank(csrqSeq)){
				c.add(Restrictions.like("csrq","%"+csrqSeq+"%"));
			}
			
			//添加根据党龄查询条件
			if(StringUtils.isNotEmpty(rdsjEnd) && StringUtils.isNotEmpty(rdsjSt)){
				c.add(Restrictions.and(Restrictions.lt("rdsj",rdsjSt),Restrictions.gt("rdsj", rdsjEnd)));
			}
			if(StringUtils.isNotBlank(rdsjEq)){
				c.add(Restrictions.like("rdsj","%"+rdsjEq+"%"));
			}
			
			//添加根据享受待遇查询
			if(StringUtils.isNotEmpty(xsdy)){
				c.add(Restrictions.like("xsdy", "%"+xsdy+"%"));
			}
			
			
			if(r.getParty() != null && r.getParty().getId() != null)
				c.add(Restrictions.eq("party",r.getParty()));
			else if(type != null)
				c.add(Restrictions.isNotNull("party"));
			if(r.getWsjfs() != null && r.getWsjfs().length() > 0)
				c.add(Restrictions.eq("wsjfs",r.getWsjfs()));
			if(r.getJjyjt() != null && r.getJjyjt().length() > 0)
				c.add(Restrictions.eq("jjyjt",r.getJjyjt()));
			if(r.getGgywx() != null && r.getGgywx().length() > 0)
				c.add(Restrictions.eq("ggywx",r.getGgywx()));
			
			if(StringUtils.isNotEmpty(r.getAdvancedSearch())){
				c.add(Restrictions.sqlRestriction(r.getAdvancedSearch()));
			}
		}
		c.addOrder(Order.asc("sfzh")).addOrder(Order.desc("csrq"));
		c.addOrder(Order.desc("rdsj"));
		return c;
	}

	@Override
	public List<Retirement> queryByVo(Retirement r) {
		Criteria c = buildCondition(r,null,null,null,null,null,null,null,null,null,null);
		return c.list();
	}
	/**
	 * 异步调用提取人员信息方法
	 */
	@Override
	public String getBaseInfo(String sfzh) {
		Retirement m = this.getById(sfzh);
		if(m != null){
			String[] col = {"sfzh","xm","xb","gzzh","lxdh","jg","csrq","dfjs","dwb#name","mzb#name","zwb#name","lxb#name","party#dzbmc","zzmm#name"};
			Map<String,String> map = new HashMap<String,String>();
			try{
				for(int i=0;i<col.length;i++){
					map.put(col[i].contains("#") ? col[i].split("#")[0] : col[i],BeanUtils.getProperty(m,col[i].replace("#",".")));
				}
			}catch(Exception e){e.printStackTrace();};
			return JSONArray.fromObject(map).toString();
		}else
			return null;
	}
	/**
	 * 异步调用提取人员信息方法,带id传输
	 */
	@Override
	public String getBaseInfos(String sfzh) {
		Retirement m = this.getById(sfzh);
		if(m != null){
			String[] col = {"sfzh","xm","xb","gzzh","lxdh","jg","csrq","dfjs","dwb#id","mzb#id","zwb#id","lxb#id","party#id","zzmm#id"};
			Map<String,String> map = new HashMap<String,String>();
			try{
				for(int i=0;i<col.length;i++){
					map.put(col[i].contains("#") ? col[i].split("#")[0] : col[i],BeanUtils.getProperty(m,col[i].replace("#",".")));
				}
			}catch(Exception e){e.printStackTrace();};
			return JSONArray.fromObject(map).toString();
		}else
			return null;
	}

	@Override
	public void updateHQL(String sql) {
		getSession().createSQLQuery(sql).executeUpdate();
		
	}
	@Override
	public List queryByHql(String hql) throws Exception {
		List list = this.getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List queryBySql(String sql) throws Exception {
		List list = getSession().createSQLQuery(sql).list();
		return list;
	}

	/* (non-Javadoc)
	 * @see cn.uuf.ltxxt.retire.service.RetirementService#queryByXm(java.lang.String)
	 */
	@Override
	public Retirement queryByXm(String xm) {
		// TODO Auto-generated method stub
		Criteria critera = this.getSession().createCriteria(Retirement.class);
		critera.add(Restrictions.eq("xm", xm));
		Retirement retirement = (Retirement) critera.uniqueResult();
		return retirement;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Retirement> findBySex(String sex) {
		return (List<Retirement>)getSession().get(this.getEntityClass(),sex);
	}

}

