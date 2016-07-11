package cn.uuf.ltxxt.asset.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.contants.Constants;
import cn.uuf.domain.asset.AssetFushu;
import cn.uuf.domain.asset.AssetRecord;
import cn.uuf.ltxxt.asset.service.AssetRecordService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

@Service
public class AssetRecordServiceImpl extends HibernateDaoSupport<AssetRecord, Long> implements AssetRecordService{
	@Override
	public Long getCount(AssetRecord m) {
		Criteria criteria = buildCondition(m);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<AssetRecord> queryList(AssetRecord m, int s, int size) {
		Criteria c = buildCondition(m);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	private Criteria buildCondition(AssetRecord m){
		Criteria c = getSession().createCriteria(AssetRecord.class);
		if(m!= null && m.getUsePerson() != null && m.getUsePerson().length() > 0)
			c.add(Restrictions.like("usePerson",m.getUsePerson(),MatchMode.ANYWHERE));
		if(m!= null && m.getUseDate() != null && m.getUseDate().length() > 0)
			c.add(Restrictions.like("useDate",m.getUseDate(),MatchMode.ANYWHERE));
		if(m.getFushu()!=null){
			c.createAlias("fushu","f");
			if(m.getFushu()!= null && m.getFushu().getAssetId() != null && m.getFushu().getAssetId().length() > 0)
			c.add(Restrictions.like("f.assetId",m.getFushu().getAssetId(),MatchMode.ANYWHERE));
			c.addOrder(Order.asc("f.assetId"));
		}
		return c;
	}

	@Override
	public List<AssetRecord> getAll() {
		AssetRecord p = new AssetRecord();
		p.setSfsc(Constants.HASNO);
		Criteria c = buildCondition(p);
		List<AssetRecord> list = c.list();
		for(AssetRecord t : list){
			Hibernate.initialize(t.getFushu());
		}
		return list;
	}

	@Override
	public String fmtLong(Long val, int size){
	        StringBuilder sb = new StringBuilder("");
	        sb.append(val);
	        if (sb.length() < size){
	            int cnt = size - sb.length();
	            for (int i = 0; i < cnt; i++){
	                sb.insert(0, "0");
	            }
	            return sb.toString();
	        }else if (sb.length() > size){
	            return sb.substring(sb.length() - size, size);
	        }else{
	            return sb.toString();
	        }
	}


	public List queryBySql(String sql) throws Exception {
		List list = getSession().createSQLQuery(sql).list();
		return list;
	}
	
	@Override
	public List queryByHql(String hql) throws Exception {
		List list = this.getSession().createQuery(hql).list();
		return list;
	}
	@Override
	public void updateHQL(String sql) {
		getSession().createSQLQuery(sql).executeUpdate();
		
	}
	@Override
	 public List<AssetRecord> findByCriteria(AssetRecord am)throws Exception{
		  Session session = getSession();
		  DetachedCriteria dc = DetachedCriteria.forClass(AssetRecord.class);
		  if(am.getFushu() != null){
			  dc.createAlias("fushu","a");
			  if(am!= null &&  am.getFushu()!=null && am.getFushu().getId() != null)
				  dc.add(Restrictions.eq("a.id",am.getFushu().getId()));
			  if(am!= null &&  am.getReturnState()!=1)
				  dc.add(Restrictions.eq("returnState",am.getReturnState()));
		  }
		  Criteria cri = dc.getExecutableCriteria(session);
		  List<AssetRecord> list = cri.list();
		  return list;
		 }
	@Override
	 public List<AssetRecord> findByFushuId(AssetRecord am)throws Exception{
		  Session session = getSession();
		  DetachedCriteria dc = DetachedCriteria.forClass(AssetRecord.class);
		  if(am.getFushu() != null){
			  dc.createAlias("fushu","a");
			  if(am!= null &&  am.getFushu()!=null && am.getFushu().getId() != null)
				  dc.add(Restrictions.eq("a.id",am.getFushu().getId()));
			  dc.addOrder(Order.asc("a.assetId"));
		  }
		  Criteria cri = dc.getExecutableCriteria(session);
		  List<AssetRecord> list = cri.list();
		  return list;
		 }
}
