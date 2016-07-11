package cn.uuf.ltxxt.system.code.service;


/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @param <T>
 * @date 10 20, 2015
 */
public interface CommonService<T> {
	
	/**
	 * 码表中根据名称或code查询
	 * @param s
	 * @return
	 */
	public T queryString(String s);
}

