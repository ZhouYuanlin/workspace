package cn.uuf.stu.ltx.wages.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.type.StringType;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retirement;
import cn.uuf.domain.Retirewages;
import cn.uuf.stu.framework.common.HiParameter;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.service.impl.BaseServiceImpl;
import cn.uuf.stu.ltx.wages.dao.IWagesDao;
import cn.uuf.stu.ltx.wages.service.IWagesService;;

@Service(value="wagesService")
public class WagesServiceImpl extends BaseServiceImpl<Retirewages, Long> implements IWagesService{
	
	@Resource(name="wagesDao")
	private IWagesDao wagesDao;
	
	@Resource(name="wagesDao")
	public void setBaseDao(IWagesDao baseDao) {
		super.setBaseDao(wagesDao);
	}
	
	/**
	 * 查询所有
	 */
	@Override
	public List<Retirewages> getAll() {
		return wagesDao.getAll();
	}

	@Override
	public Page<Retirewages> queryList(String kssj,String jzsj,Retirewages wages,Retirement retirement, Pageable pageable) {
		StringBuffer sb = new StringBuffer();
		sb.append(" from Retirewages a where 1=1");
		List<HiParameter> parameters = new ArrayList<HiParameter>();
		
		if(retirement.getSfzh()!=null && retirement.getSfzh().length()>0){
			sb.append(" and a.sfzh=:sfzh");
			parameters.add(new HiParameter("sfzh", retirement.getSfzh(),StringType.INSTANCE));
		}else{
			sb.append(" and a.sfzh=:sfzh");
			parameters.add(new HiParameter("sfzh", "",StringType.INSTANCE));
		}
		if(wages!=null){
			if(kssj!=null && kssj.length()>0){
				sb.append(" and yf>=:kssj");
				parameters.add(new HiParameter("kssj", kssj,StringType.INSTANCE));
			}
			if(jzsj!=null && jzsj.length()>0){
				sb.append(" and yf<=:jzsj");
				parameters.add(new HiParameter("jzsj", jzsj,StringType.INSTANCE));
			}
		}
		sb.append(" order by yf desc");
		pageable.setParams(parameters);
		pageable.setQueryListStr("select a"+sb.toString());
		pageable.setQueryCountStr("select count(*) "+sb.toString());
		Page<Retirewages> page = wagesDao.getHqlPage(pageable);
		return page;
	}
	
	@Override
	public Retirewages getlastMonth(Retirewages retirewages){
		StringBuffer sb = new StringBuffer();
		sb.append(" from Retirewages a where 1=1");
		List<HiParameter> parameters = new ArrayList<HiParameter>();
		String yf = retirewages.getYf();
		if(yf!=null){
			sb.append(" and a.yf<:yf");
			parameters.add(new HiParameter("yf",yf,StringType.INSTANCE));
		}
		if(retirewages!=null){
			if(retirewages.getSfzh()!=null && retirewages.getSfzh().length()>0){
				sb.append(" and a.sfzh=:sfzh");
				parameters.add(new HiParameter("sfzh", retirewages.getSfzh(), StringType.INSTANCE));
			}
		}
		sb.append(" order by yf desc");
		String sql = "select a" + sb.toString();
		List<Retirewages> wages = wagesDao.getHqlList(sql, parameters); 
		if(wages.size()>0){
			return wages.get(0);
		}
		return null;
	}
	
	@Override
	public Retirewages getnextMonth(Retirewages retirewages){
		StringBuffer sb = new StringBuffer();
		sb.append(" from Retirewages a where 1=1");
		List<HiParameter> parameters = new ArrayList<HiParameter>();
		String yf = retirewages.getYf();
		if(yf!=null){
			sb.append(" and a.yf>:yf");
			parameters.add(new HiParameter("yf",yf,StringType.INSTANCE));
		}
		if(retirewages!=null){
			if(retirewages.getSfzh()!=null && retirewages.getSfzh().length()>0){
				sb.append(" and a.sfzh=:sfzh");
				parameters.add(new HiParameter("sfzh", retirewages.getSfzh(), StringType.INSTANCE));
			}
		}
		sb.append(" order by yf asc");
		String sql = "select a" + sb.toString(); 
		List<Retirewages> wages = wagesDao.getHqlList(sql, parameters); 
		if(wages.size()>0){
			return wages.get(0);
		}
		return null;
	}
}