/**
 * 
 */
package cn.uuf.ltxxt.retire.service;

import java.util.List;

import cn.uuf.domain.Retirewages;

/**
* @author 作者 :蒋朋
* @version 创建时间：2016年3月22日 上午10:24:02
* 类说明：省略
*/
public interface RetirewagesService {
	public void save(Retirewages r);
	public void update(Retirewages r);
	public void delete(Long... id);
	public List<Retirewages> find();
	public Retirewages getById(Long id);
	/**
	 * 根据月份和姓名查询
	 * @param r
	 * @return
	 */
	public Retirewages getByMonth(Retirewages r);
	/**
	 * 更具传入的参数查询行数
	 * @param gzjs
	 * @param jbtjs
	 * @param r
	 * @param ffjbt
	 * @return
	 */
	public Long getCount(String gzjs,String jbtjs,Retirewages r,String ffjbt,String ttgzygZ,String jbtyfZ);
	/**
	 * 根据传入参数查询数据集
	 * @param s
	 * @param size
	 * @param gzjs
	 * @param jbtjs
	 * @param r
	 * @param ffjbt
	 * @return
	 */
	public List<Retirewages> queryList(int s,int size,String gzjs,String jbtjs,Retirewages r,String ffjbt,String ttgzygZ,String jbtyfZ);
}
