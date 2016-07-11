package cn.uuf.stu.framework.shiro;

import java.io.Serializable;

/**
* 身份信息 
* @ClassName: Principal 
* @author tangpeng
* @date 2015年8月4日 下午10:12:36 
*
*/
public class Principal implements Serializable {
	private static final long serialVersionUID = -5666466140689437403L;
	
	/** ID */
	private Long id;

	/** 用户名 */
	private String username;
	
	private String xm;

	/**
	 * @param id
	 *            ID
	 * @param username
	 *            用户名
	 */
	public Principal(Long id, String username,String xm) {
		this.id = id;
		this.username = username;
		this.xm = xm;
	}

	/**
	 * 获取ID
	 * 
	 * @return ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置ID
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取用户名
	 * 
	 * @return 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置用户名
	 * 
	 * @param username
	 *            用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return username;
	}

	/**
	 * @return the xm
	 */
	public String getXm() {
		return xm;
	}

	/**
	 * @param xm the xm to set
	 */
	public void setXm(String xm) {
		this.xm = xm;
	}

}
