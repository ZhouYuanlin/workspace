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
import cn.uuf.domain.asset.AssetManage;
import cn.uuf.ltxxt.asset.service.AssetFushuService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

@Service
public class AssetFushuServiceImpl extends HibernateDaoSupport<AssetFushu, Long> implements AssetFushuService{
	@Override
	public Long getCount(AssetFushu m) {
		Criteria criteria = buildCondition(m);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<AssetFushu> queryList(AssetFushu m, int s, int size) {
		Criteria c = buildCondition(m);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	private Criteria buildCondition(AssetFushu m){
		Criteria c = getSession().createCriteria(AssetFushu.class);
		if(m != null){
			if(m.getAssetId() != null && m.getAssetId().length() > 0)
				c.add(Restrictions.like("assetId",m.getAssetId(),MatchMode.ANYWHERE));
			if(m.getAssetManage()!=null){
				c.createAlias("assetManage","a");
				if(m.getAssetManage() != null && m.getAssetManage().getName() != null && m.getAssetManage().getName().length() > 0)
					c.add(Restrictions.like("a.name",m.getAssetManage().getName(),MatchMode.ANYWHERE));
				if(m.getAssetManage() != null && m.getAssetManage().getVersion() != null && m.getAssetManage().getVersion().length() > 0)
					c.add(Restrictions.like("a.version",m.getAssetManage().getVersion(),MatchMode.ANYWHERE));
			}
		}
		c.addOrder(Order.desc("assetId"));
		return c;
	}

	@Override
	public List<AssetFushu> getAll() {
		AssetFushu p = new AssetFushu();
		p.setSfsc(Constants.HASNO);
		Criteria c = buildCondition(p);
		List<AssetFushu> list = c.list();
		for(AssetFushu t : list){
			Hibernate.initialize(t.getAssetId());
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
	public void updateHQL(String sql) {
		getSession().createSQLQuery(sql).executeUpdate();
		
	}
	@Override
	 public List<AssetFushu> findByCriteria(AssetFushu am)throws Exception{
		  Session session = getSession();
		  DetachedCriteria dc = DetachedCriteria.forClass(AssetFushu.class);
		  if(am.getAssetManage() != null){
			  dc.createAlias("assetManage","a");
			  if(am!= null &&  am.getAssetManage()!=null && am.getAssetManage().getId() != null)
				  dc.add(Restrictions.eq("a.id",am.getAssetManage().getId()));
		  }
		  dc.addOrder(Order.desc("assetId"));
		  Criteria cri = dc.getExecutableCriteria(session);
		  List<AssetFushu> list = cri.list();
		  return list;
		 }
	

	@Override
	 public List<AssetFushu> findByTj(AssetFushu am)throws Exception{
		  Session session = getSession();
		  DetachedCriteria dc = DetachedCriteria.forClass(AssetFushu.class);
		  dc.add(Restrictions.eq("assetId",am.getAssetId()));
		  Criteria cri = dc.getExecutableCriteria(session);
		  List<AssetFushu> list = cri.list();
		  return list;
		 }
}
