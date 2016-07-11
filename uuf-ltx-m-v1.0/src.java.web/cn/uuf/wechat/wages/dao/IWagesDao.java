package cn.uuf.wechat.wages.dao;

import java.util.List;

import cn.uuf.domain.Retirewages;
import cn.uuf.stu.framework.dao.IBaseDao;

public interface IWagesDao extends IBaseDao<Retirewages, Long> {
	/**
	* 查找所有
	* @return    
	* List<T>
	*/
	List<Retirewages> getAll();
}
