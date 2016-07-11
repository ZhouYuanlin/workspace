package cn.uuf.ltxxt.retire.service;

import java.util.List;

import cn.uuf.domain.Retirement;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
public interface RetirementService {

	public List<Retirement> find();
	public void save(Retirement r);
	public void update(Retirement r);
	public void delete(String... sfzh);
	public Retirement getById(String s);
	public Long getCount(Retirement r, String csrqSst, String csrqSend,String csrqSeq,String xsdy);
	public List<Retirement> queryList(Retirement r,int s,int size, String csrqSst, String csrqSend,String csrqSeq,String xsdy);
	public List<Retirement> queryByVo(Retirement r);
	public String getBaseInfo(String sfzh);
	public String getBaseInfos(String sfzh);
	public void updateHQL(String sql);
	public List queryByHql(String hql)throws Exception;
	public List queryBySql(String sql)throws Exception;
	public Long getCount(Retirement r,String ks,String js,String type,String rdsjSt,String rdsjEnd,String rdsjEq);
	public List<Retirement> queryList(Retirement r,int s,int size,String ks,String js,String type,String rdsjSt,String rdsjEnd,String rdsjEq);
	/**
	 * 根据姓名查询
	 * @param xm
	 * @return
	 */
	public Retirement queryByXm(String xm);
	
	public List<Retirement> findBySex(String sex);
}

